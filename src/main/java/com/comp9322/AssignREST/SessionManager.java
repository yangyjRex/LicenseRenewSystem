package com.comp9322.AssignREST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionManager implements HandlerInterceptor{

    // This method is called before the controller
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {

        String xHeader = request.getHeader("authentication");
        //boolean permission = true;
        if(xHeader.equals("123456")) {
            return true;
        }
        else {
            response.setStatus(401);
            response.getWriter().append("authentication required");
            return false;
            // Above code will send a 401 with no response body.
            // If you need a 401 view, do a redirect instead of
            // returning false.
            // response.sendRedirect("/401"); // assuming you have a handler mapping for 401

        }
        //return false;
    }

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}