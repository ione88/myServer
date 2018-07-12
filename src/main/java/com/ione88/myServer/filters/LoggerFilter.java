package com.ione88.myServer.filters;


import com.google.gson.Gson;
import com.ione88.myServer.entities.Logger;
import com.ione88.myServer.services.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class LoggerFilter implements Filter {

    @Autowired
    private LoggerService loggerService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // добавить в базу сообщение, что пришёл новый запрос на сервер.
        loggerService.createLogger(new Logger("INFO","getParameterMap: " + new Gson().toJson(request.getParameterMap())));
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {}

    @Override
    public void init(FilterConfig arg0) throws ServletException {}
}