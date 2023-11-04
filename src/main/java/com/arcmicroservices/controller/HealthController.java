package com.arcmicroservices.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author Asus 25.10.2023
 */
@RestController
@Slf4j
public class HealthController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public ResponseEntity ping() {
        log.info("health chek pong");
        return ResponseEntity.ok().body("Status: OK");
    }
}
