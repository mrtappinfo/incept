/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  javax.ws.rs.Consumes
 *  javax.ws.rs.OPTIONS
 *  javax.ws.rs.POST
 *  javax.ws.rs.Path
 *  javax.ws.rs.Produces
 *  javax.ws.rs.core.GenericEntity
 *  javax.ws.rs.core.Response
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 */
package com.snaplync.controller;

import com.snaplync.dao.RecruiterActionsDAOImpl;
import com.snaplync.entity.Recruiter;
import com.snaplync.json.RecruiterObject;
import com.snaplync.objects.ResponseInfo;
import com.snaplync.repository.RecruiterActionsRepository;
import com.snaplync.util.ObjectUtil;
import com.snaplync.util.WebserviceResponseUtil;
import javax.ws.rs.Consumes;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Path(value="/recruiterform")
@Controller
public class RecruiterActionsController {
    Logger logger = LoggerFactory.getLogger(RecruiterActionsController.class);
    @Autowired
    RecruiterActionsRepository recruiterActionsRepository;

    @OPTIONS
    public Response myResource() {
        return Response.ok().build();
    }

    @POST
    @Path(value="/Create")
    @Consumes(value={"application/json"})
    @Produces(value={"application/json"})
    public Response createRecruiterProfile(RecruiterObject recjsonObject) {
        this.logger.info("Inside createRecruiterProfile");
        ResponseInfo jsonObject = null;
        try {
            RecruiterActionsDAOImpl dao = new RecruiterActionsDAOImpl();
            Recruiter recruiterEntityObject = new Recruiter();
            ObjectUtil.convertJsonEntityObject(recjsonObject, recruiterEntityObject);
            dao.saveObject(recruiterEntityObject);
            this.logger.info("Recruiter Profiles Saved Successfully");
            jsonObject = WebserviceResponseUtil.getResponseObject("success", "Recruiter Profiles Saved Successfully");
            this.logger.info("jsonObject  \n" + jsonObject);
        }
        catch (Exception e) {
            e.printStackTrace();
            jsonObject = WebserviceResponseUtil.generateErrorResponse(e);
            this.logger.info("createRecruiterProfile :: Exception ::", new Object[]{e.getMessage(), e});
        }
        GenericEntity<ResponseInfo> response = new GenericEntity<ResponseInfo>(jsonObject){};
        return Response.ok((Object)response).build();
    }

}
