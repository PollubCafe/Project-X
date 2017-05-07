package org.projectX.jwt.controller;

import org.projectX.jwt.model.AppUser;
import org.projectX.jwt.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    AppUserService appUserService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> home() {
        AppUser appUser = appUserService.get(1);
        return ResponseEntity.ok(appUser);
    }
}
