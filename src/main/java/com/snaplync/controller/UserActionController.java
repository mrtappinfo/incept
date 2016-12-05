/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestParam
 *  org.springframework.web.bind.annotation.ResponseBody
 */
package com.snaplync.controller;

import com.snaplync.entity.User;
import com.snaplync.objects.ResponseInfo;
import com.snaplync.repository.StateRepository;
import com.snaplync.service.SendEmail;
import com.snaplync.util.WebserviceResponseUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserActionController {
    private final Logger log;
    @Autowired
    StateRepository stateRepository;

    public UserActionController() {
        this.log = LoggerFactory.getLogger(this.getClass());
    }

    @RequestMapping(value={"/sendEmail"})
    @ResponseBody
    public ResponseInfo sendEmails(@RequestParam String action, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ResponseInfo returnObject = null;
        if (action.equalsIgnoreCase("Immediately")) {
            User user = (User)session.getAttribute("user");
            SendEmail emailClient = new SendEmail();
            String emailID = user.getEmail();
            try {
                emailClient.sendMessage(emailID);
                returnObject = WebserviceResponseUtil.getResponseObject("success", "Email Sent Successfully");
            }
            catch (Exception e) {
                e.printStackTrace();
                this.log.debug("Excpetion" + e);
            }
        }
        return returnObject;
    }
}
