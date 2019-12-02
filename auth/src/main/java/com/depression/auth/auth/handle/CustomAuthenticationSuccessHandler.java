package com.depression.auth.auth.handle;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
        System.out.println("CustomAuthenticationSuccessHandler");
        HttpSession session = request.getSession();
        SavedRequest savedReq = (SavedRequest) session.getAttribute(WebAttributes.ACCESS_DENIED_403);
        if (savedReq == null) {
            response.sendRedirect(request.getContextPath() + "/spring/home");
        }
        else {
            response.sendRedirect(savedReq.getRedirectUrl());
        }
    }

}