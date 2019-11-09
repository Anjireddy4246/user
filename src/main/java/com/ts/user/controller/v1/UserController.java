package com.ts.user.controller.v1;


import com.ts.user.entity.User;
import com.ts.user.model.v1.HelloWorldModel;
import com.ts.user.service.v1.UserService;
import com.ts.user.kafka.event.v1.MessageReceivedEvent;
import com.ts.user.kafka.producer.HelloWorldEventSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController("UserControllerV1")
@CrossOrigin
@RequestMapping(value = "/v1/users")
public class UserController {

    private static  final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private HelloWorldEventSender helloWorldEventSender;

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
        //create();
        LOGGER.info("information message");
        //helloWorldEventSender.send("messageReceivedEvent", getMessageReceivedEvent());
        if (userOpt.isPresent()) {
            return ResponseEntity.ok(userOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void create(){
        User user=new User();
        user.setEmail("anjireddy.kata@gmail.com");
        user.setLoginId("technosoft");
        user.setFirstName("William");
        user.setLastName("Ferguson");
        user.setPassword("technosoft");
        user.setCreatedBy(1L);
        user.setCreatedDate(new Date());
        userService.create(user);

    }

//    private MessageReceivedEvent getMessageReceivedEvent() {
//        MessageReceivedEvent mre = new MessageReceivedEvent();
//        HelloWorldModel hwm = new HelloWorldModel();
//        hwm.setId(1L);
//        hwm.setGuid(UUID.randomUUID().toString());
//        mre.setHelloWorldModel(hwm);
//        return mre;
//    }
}
