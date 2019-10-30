package com.ts.user.controller.v1;


import com.ts.user.entity.User;
import com.ts.user.service.v1.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("UserControllerV1")
@CrossOrigin
@RequestMapping(value = "/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Get all the users
     *
     * @return
     */
    @GetMapping()
    public ResponseEntity<List<User>> allUsers() {
        List<User> users = userService.findAll();
        if (!CollectionUtils.isEmpty(users)) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Get User Info based on the Id
     *
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        Optional<User> userOpt = userService.getById();
        if (userOpt.isPresent()) {
            return ResponseEntity.ok(userOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
