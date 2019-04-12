package com.company.demo.service;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.UserSessionSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;


@Service(NewService.NAME)
public class NewServiceBean implements NewService {
    @Inject
    private UserSessionSource userSessionSource;

    @Override
    public String get()
    {
        String lang = userSessionSource.getLocale().getLanguage();
        return lang;
    }
}