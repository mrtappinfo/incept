/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package com.snaplync.util;

import com.snaplync.objects.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebserviceResponseUtil {
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public static final String FAILURE = "failure";
    public static final String STATUS_CODE = "500";
    public static final String JSON_STATUSCODE_NODE = "statusCode";
    static Logger log = LoggerFactory.getLogger(WebserviceResponseUtil.class);

    public static ResponseInfo getResponseObject(String statusCode) throws Exception {
        return WebserviceResponseUtil.getResponseObject(null, statusCode, null, null);
    }

    public static ResponseInfo getResponseObject(String statusCode, String statusDetails) throws Exception {
        ResponseInfo response = new ResponseInfo();
        response.setStatus(statusCode);
        response.setStatusDetail(statusDetails);
        return response;
    }

    public static ResponseInfo getResponseObject(String successMessage, String errorCode, Object errorMessage, Object dataObject) throws Exception {
        ResponseInfo response = new ResponseInfo();
        response.setStatus(successMessage);
        response.setErrorCode(errorCode);
        response.setErrorMessage(errorMessage);
        response.setData(dataObject == null ? "" : dataObject);
        return response;
    }

    public static ResponseInfo generateErrorResponse(Exception e) {
        String errorMessage = "";
        ResponseInfo response = new ResponseInfo();
        response.setStatus("failure");
        response.setErrorCode("500");
        response.setErrorMessage(e.getMessage());
        response.setData("");
        return response;
    }

    public static ResponseInfo generateErrorResponse(String errorMessage) {
        ResponseInfo jsonObject = new ResponseInfo();
        jsonObject.setErrorCode("error");
        jsonObject.setErrorMessage(errorMessage);
        return jsonObject;
    }
}
