/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.Cookie
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package com.snaplync.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static final String _ERR_MESSAGE = "ERR_MESSAGE";
    public static final String _INFO_MESSAGE = "INFO_MESSAGE";
    public static final String _ST_MSG_STATUS = "ST_MSG_STATUS";
    public static final String _ST_MSG_MESSAGE = "ST_MSG_MESSAGE";
    public static final String SESS_COOKIE = "sess_id";
    public static final String _ADMIN_STATUS = "admin_status";

    public static void setCookie(HttpServletResponse response, String name, String value) {
        Cookie c = new Cookie(name, value);
        c.setPath("/");
        response.addCookie(c);
    }

    public static String getCookie(String name, HttpServletRequest request) {
        String localval = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; ++i) {
                if (!cookies[i].getName().equals(name)) continue;
                localval = cookies[i].getValue();
            }
        }
        return localval;
    }

    public static void addStatusMessage(HttpServletRequest request, HttpServletResponse response, String message, Boolean sticky) {
        Cookie c = new Cookie("ST_MSG_MESSAGE", CookieUtil.encodeUrl(message));
        Cookie c3 = new Cookie("ST_MSG_STATUS", CookieUtil.encodeUrl("notreadA" + (sticky != false ? "true" : "false")));
        c.setPath("/");
        c3.setPath("/");
        response.addCookie(c);
        response.addCookie(c3);
    }

    public static void addErrorMessage(HttpServletRequest request, HttpServletResponse response, String message) {
        Cookie c = new Cookie("ERR_MESSAGE", CookieUtil.encodeUrl(message));
        c.setPath("/");
        response.addCookie(c);
    }

    public static void addInfoMessage(HttpServletRequest request, HttpServletResponse response, String message) {
        Cookie c = new Cookie("INFO_MESSAGE", CookieUtil.encodeUrl(message));
        c.setPath("/");
        response.addCookie(c);
    }

    private static String encodeUrl(String message) {
        try {
            return URLEncoder.encode(message, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
