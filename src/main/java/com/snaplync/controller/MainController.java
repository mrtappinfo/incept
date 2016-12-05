/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.core.JsonProcessingException
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.ObjectWriter
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 *  javax.transaction.Transactional
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.ui.ModelMap
 *  org.springframework.web.bind.annotation.ModelAttribute
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestParam
 */
package com.snaplync.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.snaplync.dto.IndustryDto;
import com.snaplync.dto.RoleDto;
import com.snaplync.dto.SessionDto;
import com.snaplync.dto.SkillDto;
import com.snaplync.dto.UserDto;
import com.snaplync.entity.Industry;
import com.snaplync.entity.Role;
import com.snaplync.entity.Session;
import com.snaplync.entity.Skill;
import com.snaplync.entity.User;
import com.snaplync.repository.IndustryRepository;
import com.snaplync.repository.RoleRepository;
import com.snaplync.repository.SkillRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Controller
public class MainController {
    private final Logger log;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private IndustryRepository industryRepository;
    private static Iterable<Role> roles;
    private static Iterable<Industry> industries;
    private static Iterable<Skill> skills;

    public MainController() {
        this.log = LoggerFactory.getLogger(this.getClass());
    }

    @RequestMapping(value={"/signup"})
    @Transactional
    public String signup(@RequestParam Integer hike, @RequestParam Integer salary, HttpSession session, @ModelAttribute(value="model") ModelMap model) {
        session.setAttribute("jobseeker_salary", (Object)salary);
        session.setAttribute("jobseeker_hike", (Object)hike);
        return "signup";
    }

    @RequestMapping(value={"/index"})
    @Transactional
    public String index(HttpSession session, Map<String, Object> model) {
        if (session.getAttribute("jobseeker_salary") != null) {
            model.put("jobseeker_salary", session.getAttribute("jobseeker_salary"));
        } else {
            model.put("jobseeker_salary", 120);
        }
        if (session.getAttribute("jobseeker_hike") != null) {
            model.put("jobseeker_hike", session.getAttribute("jobseeker_hike"));
        } else {
            model.put("jobseeker_hike", 20);
        }
        return "index";
    }

    @RequestMapping(value={"/dashboard/**"})
    @Transactional
    public String dashboard(HttpServletRequest request, HttpServletResponse response, HttpSession session, Map<String, Object> model) {
        User user = (User)session.getAttribute("user");
        user.setSessions(null);
        if (roles == null) {
            roles = this.roleRepository.findAll();
        }
        ArrayList<RoleDto> roleDtos = new ArrayList<RoleDto>();
        for (Role role : roles) {
            roleDtos.add(RoleDto.getDto(role));
        }
        if (industries == null) {
            industries = this.industryRepository.findAll();
        }
        ArrayList<IndustryDto> industryDtos = new ArrayList<IndustryDto>();
        for (Industry industry : industries) {
            industryDtos.add(IndustryDto.getDto(industry));
        }
        if (skills == null) {
            skills = this.skillRepository.findAll();
        }
        ArrayList<SkillDto> skillDtos = new ArrayList<SkillDto>();
        for (Skill skill : skills) {
            skillDtos.add(SkillDto.getDto(skill));
        }
        Session sess = (Session)session.getAttribute("session");
        if (user != null) {
            model.put("user", MainController.getJsonString(UserDto.getDto(user)));
        }
        if (sess != null) {
            model.put("session", MainController.getJsonString(SessionDto.getDto(sess)));
        }
        model.put("roles", MainController.getJsonString(roleDtos));
        model.put("industries", MainController.getJsonString(industryDtos));
        model.put("skills", MainController.getJsonString(skillDtos));
        return "dashboard";
    }

    @RequestMapping(value={"/public/jobseeker/data"})
    public String addData(@RequestParam Integer hike, @RequestParam Integer salary, HttpSession session, @ModelAttribute(value="model") ModelMap model) {
        session.setAttribute("jobseeker_salary", (Object)salary);
        session.setAttribute("jobseeker_hike", (Object)hike);
        return "redirect:/login?profile=jobseeker";
    }

    @RequestMapping(value={"/login"})
    @Transactional
    String login(@RequestParam String profile, HttpSession session, @ModelAttribute(value="model") ModelMap model) {
        model.addAttribute("profile", (Object)profile);
        session.setAttribute("user_type", (Object)profile);
        return "login";
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

    public static String getURL(HttpServletRequest req) {
        String scheme = req.getScheme();
        String serverName = req.getServerName();
        int serverPort = req.getServerPort();
        String contextPath = req.getContextPath();
        StringBuffer url = new StringBuffer();
        url.append(scheme).append("://").append(serverName);
        if (serverPort != 80 && serverPort != 443) {
            url.append(":").append(serverPort);
        }
        url.append(contextPath);
        return url.toString();
    }
}
