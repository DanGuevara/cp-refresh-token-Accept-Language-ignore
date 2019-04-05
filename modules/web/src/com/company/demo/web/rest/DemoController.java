package com.company.demo.web.rest;

import com.haulmont.cuba.core.global.UserSessionSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("demo-locale")
public class DemoController {
    @Inject
    private UserSessionSource userSessionSource;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity get()
    {
        String lang = userSessionSource.getLocale().getLanguage();
        return new ResponseEntity<>(lang, new HttpHeaders(), HttpStatus.OK);
    }
}
