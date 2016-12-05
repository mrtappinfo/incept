package com.snaplync.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.snaplync.dao.RecruiterActionsDAOImpl;
import com.snaplync.dto.HikeDto;
import com.snaplync.dto.JobSeekerDto;
import com.snaplync.dto.UserDto;
import com.snaplync.entity.City;
import com.snaplync.entity.Currency;
import com.snaplync.entity.Industry;
import com.snaplync.entity.JobSeeker;
import com.snaplync.entity.Recruiter;
import com.snaplync.entity.Role;
import com.snaplync.entity.Session;
import com.snaplync.entity.Skill;
import com.snaplync.entity.State;
import com.snaplync.entity.TimeUnit;
import com.snaplync.entity.User;
import com.snaplync.json.RecruiterObject;
import com.snaplync.repository.CityRepository;
import com.snaplync.repository.CurrencyRepository;
import com.snaplync.repository.IndustryRepository;
import com.snaplync.repository.JobSeekerRepository;
import com.snaplync.repository.RoleRepository;
import com.snaplync.repository.SessionRepository;
import com.snaplync.repository.SkillRepository;
import com.snaplync.repository.StateRepository;
import com.snaplync.repository.TimeUnitRepository;
import com.snaplync.repository.UserRepository;
import com.snaplync.util.CookieUtil;
import com.snaplync.util.ObjectUtil;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Controller
public class JobseekerController {
    private final Logger log;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private TimeUnitRepository timeUnitRepository;
    @Autowired
    private IndustryRepository industryRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private JobSeekerRepository jobSeekerRepository;
    @Autowired
    public SessionRepository sessionRepository;

    public JobseekerController() {
        this.log = LoggerFactory.getLogger(this.getClass());
    }

    @RequestMapping(value={"/save"})
    public String saveJobSeekerEmail(String email, HttpServletRequest request, HttpSession session, HttpServletResponse response, Map<String, Object> model) {
        Integer salary = -1;
        Object actualHike = null;
        Integer hike = -1;
        User user = null;
        try {
            if (session.getAttribute("jobseeker_salary") != null) {
                salary = (Integer)request.getSession().getAttribute("jobseeker_salary");
                model.put("jobseeker_salary", salary);
            } else {
                model.put("jobseeker_salary", new String("120"));
            }
            if (session.getAttribute("jobseeker_hike") != null) {
                hike = (Integer)request.getSession().getAttribute("jobseeker_hike");
                model.put("jobseeker_hike", hike);
            } else {
                model.put("jobseeker_hike", 20);
            }
            if (email == "" || email == null) {
                user = (User)session.getAttribute("user");
                email = user.getEmail();
            } else {
                user = this.userRepository.findByEmail(email);
                if (user == null) {
                    user = new User();
                    user.setCreated(new Date());
                    user.setEmail(email);
                    user.setActive('Y');
                    user.setUpdated(new Date());
                    this.userRepository.save(user);
                }
                model.put("jobseeker", "\"" + user.getEmail() + "\"");
                session.setAttribute("user", user);
                String sessionId = UUID.randomUUID().toString();
                Session sess = new Session();
                sess.setToken(sessionId);
                sess.setCreatedTime(new Date());
                sess.setLastRequestTime(new Date());
                sess.setUser(user);
                sess.setActive('Y');
                sess.setCreatedTime(new Date());
                sess.setLastRequestTime(new Date());
                this.sessionRepository.save(sess);
                CookieUtil.setCookie(response, "sess_id", sessionId);
                session.setAttribute("session", sess);
            }
            String responseStr = this.getRecruiters(salary, hike, model);
            model.put("recruiters", responseStr);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return "profile";
    }

    @RequestMapping(value={"/saveRise"}, method={RequestMethod.POST}, consumes={"application/json;charset=UTF-8"}, produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> saveJobseekerRaise(@RequestBody HikeDto hikeDto, HttpServletRequest request, HttpSession session, HttpServletResponse response, Map<String, Object> model) {
        HashMap<String, Object> responseMap = new HashMap<String, Object>();
        ArrayList recruiterList = new ArrayList();
        try {
            Integer hike = new Integer(hikeDto.getHike());
            Integer salary = new Integer(hikeDto.getSalary());
            if (salary != null) {
                session.setAttribute("jobseeker_salary", (Object)salary);
                responseMap.put("jobseeker_salary", salary);
            }
            if (hike != null) {
                session.setAttribute("jobseeker_hike", (Object)hike);
                responseMap.put("jobseeker_hike", hike);
            }
            this.log.info("salary" + salary);
            this.log.info("hike" + hike);
            String responseStr = this.getRecruiters(salary, hike, responseMap);
            responseMap.put("recruiters", responseStr);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return responseMap;
    }

    public String getRecruiters(Integer salary, Integer hike, Map<String, Object> model) {
        RecruiterActionsDAOImpl recruiterDAO = new RecruiterActionsDAOImpl();
        Long actualSalary = (long) (salary + salary * hike / 100);
        Long expectedSalary = actualSalary * 1000;
        this.log.info("actualSalary" + expectedSalary);
        List<Recruiter> resultsList = recruiterDAO.findSalaryRange(expectedSalary);
        Iterator<Recruiter> recordsIterator = resultsList.iterator();
        ArrayList<RecruiterObject> recruiterList = new ArrayList<RecruiterObject>();
        while (recordsIterator.hasNext()) {
            Recruiter recruiter = recordsIterator.next();
            RecruiterObject recuiterJsonObj = new RecruiterObject();
            ObjectUtil.convertEntityJsonObject(recuiterJsonObj, recruiter, expectedSalary.intValue());
            recruiterList.add(recuiterJsonObj);
        }
        Iterator recruiterIterator = recruiterList.iterator();
        ArrayList<Integer> maxSalaryRaiseList = new ArrayList<Integer>();
        Long averageHikeCal = 0;
        while (recruiterIterator.hasNext()) {
            RecruiterObject recObject = (RecruiterObject)recruiterIterator.next();
            Long averageHike = recObject.getAverageHike();
            Integer recruiterRateMin = recObject.getRecruiterRateMin();
            maxSalaryRaiseList.add(recruiterRateMin);
            averageHikeCal = averageHikeCal + averageHike;
        }
        Collections.sort(maxSalaryRaiseList);
        Long averageExpectedHike = averageHikeCal / (long)recruiterList.size();
        Integer maxSalary = (Integer)maxSalaryRaiseList.get(maxSalaryRaiseList.size() - 1);
        model.put("maxSalaryPossible", maxSalary.toString());
        model.put("averageRaise", averageExpectedHike + (long)hike.intValue());
        return JobseekerController.getJsonString(recruiterList);
    }

    @RequestMapping(value={"/jobseeker"}, method={RequestMethod.POST}, consumes={"application/json;charset=UTF-8"}, produces={"application/json;charset=UTF-8"})
    @Transactional
    @ResponseBody
    public UserDto updateJobSeeker(@RequestBody JobSeekerDto seekerDto, HttpServletRequest request, HttpSession session) {
        User user = (User)session.getAttribute("user");
        user = this.userRepository.findOne(user.getId());
        user.setIsRecruiter('N');
        JobSeeker jobSeeker = new JobSeeker();
        if (user.getJobseeker() != null) {
            jobSeeker = user.getJobseeker();
        }
        jobSeeker.setExperienceYear(seekerDto.getExperience());
        jobSeeker.setExperienceMonth(0);
        if (request.getSession().getAttribute("jobseeker_salary") != null) {
            Integer salary = (Integer)request.getSession().getAttribute("jobseeker_salary");
            jobSeeker.setCompensation(salary * 1000);
        }
        if (request.getSession().getAttribute("jobseeker_hike") != null) {
            Integer hike = (Integer)request.getSession().getAttribute("jobseeker_hike");
            jobSeeker.setHike(new BigDecimal(hike).divide(new BigDecimal(100)));
        }
        Currency currency = this.currencyRepository.findByName("USD");
        TimeUnit timeUnit = this.timeUnitRepository.findByName("YEARLY");
        jobSeeker.setCurrency(currency);
        jobSeeker.setTimeUnit(timeUnit);
        HashSet<Industry> industries = new HashSet<Industry>();
        for (Long id : seekerDto.getIndustries()) {
            Industry industry = this.industryRepository.findOne(id);
            industries.add(industry);
        }
        HashSet<Role> roles = new HashSet<Role>();
        for (Long id : seekerDto.getRoles()) {
            Role role = this.roleRepository.findOne(id);
            roles.add(role);
        }
        HashSet<Skill> skills = new HashSet<Skill>();
        for (Long id : seekerDto.getSkills()) {
            Skill skill = this.skillRepository.findOne(id);
            skills.add(skill);
        }
        jobSeeker.setSkills(skills);
        jobSeeker.setIndustries(industries);
        jobSeeker.setRoles(roles);
        HashSet<City> cities = new HashSet<City>();
        for (Long id : seekerDto.getCity()) {
            City city = this.cityRepository.findOne(id);
            cities.add(city);
        }
        jobSeeker.setCities(cities);
        HashSet<State> states = new HashSet<State>();
        for (Long id : seekerDto.getState()) {
            State state = this.stateRepository.findOne(id);
            states.add(state);
        }
        jobSeeker.setState(states);
        jobSeeker.setCreatedDate(new Date());
        jobSeeker.setUpdatedDate(new Date());
        jobSeeker = (JobSeeker)this.jobSeekerRepository.save((Object)jobSeeker);
        user.setJobseeker(jobSeeker);
        user = (User)this.userRepository.save((Object)user);
        return UserDto.getDto(user);
    }

    public static String getJsonString(Object object) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(object);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
