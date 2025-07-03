package com.ghulam.loan.gatewayapp.controller;

import com.ghulam.loan.gatewayapp.http.GET;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BaseController {

    @GET(path = "/fake")
    public ResponseEntity<?> fake() {
        String msg = "This is a fake request/response for only demonstration.";
        Map<String, String> data = Map.of("message", msg);
        return ResponseEntity.ok().body(data);
    }
}
