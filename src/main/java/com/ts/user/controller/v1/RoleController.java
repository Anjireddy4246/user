package com.ts.user.controller.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("RoleControllerV1")
@CrossOrigin
@RequestMapping(value = "/v1/roles")
public class RoleController {

    @GetMapping("")
    public ResponseEntity<String> getRoleName(){
        return ResponseEntity.ok("Admin");
    }
}
