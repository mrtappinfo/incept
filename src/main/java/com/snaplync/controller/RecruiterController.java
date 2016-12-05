/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpSession
 *  javax.transaction.Transactional
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.ResponseBody
 */
package com.snaplync.controller;

import com.snaplync.dto.RecruiterDto;
import com.snaplync.dto.UserDto;
import com.snaplync.entity.City;
import com.snaplync.entity.Currency;
import com.snaplync.entity.Industry;
import com.snaplync.entity.RecruiterDetails;
import com.snaplync.entity.Role;
import com.snaplync.entity.Skill;
import com.snaplync.entity.State;
import com.snaplync.entity.TimeUnit;
import com.snaplync.entity.User;
import com.snaplync.repository.CityRepository;
import com.snaplync.repository.CurrencyRepository;
import com.snaplync.repository.IndustryRepository;
import com.snaplync.repository.JobSeekerRepository;
import com.snaplync.repository.RecruiterRepository;
import com.snaplync.repository.RoleRepository;
import com.snaplync.repository.SkillRepository;
import com.snaplync.repository.StateRepository;
import com.snaplync.repository.TimeUnitRepository;
import com.snaplync.repository.UserRepository;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RecruiterController {
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
    private RecruiterRepository recruiterRepository;

    @RequestMapping(value={"/recruiter"}, method={RequestMethod.POST}, consumes={"application/json;charset=UTF-8"}, produces={"application/json;charset=UTF-8"})
    @Transactional
    @ResponseBody
    public UserDto updateRecruiter(@RequestBody RecruiterDto recruiterDto, HttpServletRequest request, HttpSession session) {
        User user = (User)session.getAttribute("user");
        user = this.userRepository.findOne(user.getId());
        user.setIsRecruiter('Y');
        RecruiterDetails recruiter = new RecruiterDetails();
        if (user.getRecruiter() != null) {
            recruiter = user.getRecruiter();
        }
        Currency currency = this.currencyRepository.findByName("USD");
        TimeUnit timeUnit = this.timeUnitRepository.findByName("YEARLY");
        recruiter.setCurrency(currency);
        HashSet<Industry> industries = new HashSet<Industry>();
        for (Long id : recruiterDto.getIndustries()) {
            Industry industry = this.industryRepository.findOne(id);
            industries.add(industry);
        }
        HashSet<Role> roles = new HashSet<Role>();
        for (Long id : recruiterDto.getRoles()) {
            Role role = this.roleRepository.findOne(id);
            roles.add(role);
        }
        HashSet<Skill> skills = new HashSet<Skill>();
        for (Long id : recruiterDto.getSkills()) {
            Skill skill = this.skillRepository.findOne(id);
            skills.add(skill);
        }
        HashSet<City> cities = new HashSet<City>();
        for (Long id : recruiterDto.getCities()) {
            City city = this.cityRepository.findOne(id);
            cities.add(city);
        }
        HashSet<State> states = new HashSet<State>();
        for (Long id : recruiterDto.getStates()) {
            State state = this.stateRepository.findOne(id);
            states.add(state);
        }
        recruiter.setSkills(skills);
        recruiter.setIndustries(industries);
        recruiter.setRoles(roles);
        recruiter.setStates(states);
        recruiter.setCities(cities);
        recruiter.setMaxCompensationHourly(recruiterDto.getMaxCompensationHourly());
        recruiter.setMinCompensationHourly(recruiterDto.getMinCompensationHourly());
        recruiter.setMaxCompensationMonthly(recruiterDto.getMaxCompensationMonthly());
        recruiter.setMinCompensationMonthly(recruiterDto.getMinCompensationMonthly());
        recruiter.setMaxCompensationYearly(recruiterDto.getMaxCompensationYearly());
        recruiter.setMinCompensationYearly(recruiterDto.getMinCompensationYearly());
        recruiter.setCreatedDate(new Date());
        recruiter.setUpdatedDate(new Date());
        recruiter = (RecruiterDetails)this.recruiterRepository.save((Object)recruiter);
        user.setRecruiter(recruiter);
        user = (User)this.userRepository.save((Object)user);
        return UserDto.getDto(user);
    }
}
