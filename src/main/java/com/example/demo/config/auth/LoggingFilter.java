package com.example.demo.config.auth;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.sql.Timestamp;

@Component
public class LoggingFilter implements ApplicationListener<AbstractAuthenticationEvent> {
    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent event) {
        Timestamp ts = new Timestamp(event.getTimestamp());
        Date date = ts;
        System.out.println("Date: " + date);
        System.out.println("Authentication" + event.getAuthentication());
    }

//    @Override
//    protected void beforeRequest(HttpServletRequest request, String msg)
//    {
//        System.out.println("Request URL: " + request.getRequestURL().toString());
//        System.out.println("Authentication: " + request.getAuthType());
//        System.out.println("Cookies: " + request.getCookies());
//        System.out.println("Session: " + request.getSession().getCreationTime());
//    }
//
//
//    @Override
//    protected void afterRequest(HttpServletRequest request, String message) {
//
//    }



}
