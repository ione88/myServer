package com.ione88.myServer.services.impl;

import com.ione88.myServer.entities.Logger;
import com.ione88.myServer.repositories.LoggerRepository;
import com.ione88.myServer.services.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService {

    @Autowired
    private LoggerRepository loggerRepository;

    @Override
    public String createLogger(Logger logger) {
        loggerRepository.save(logger);
        return "Saved";
    }
}
