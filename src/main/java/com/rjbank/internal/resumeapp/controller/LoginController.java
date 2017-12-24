package com.rjbank.internal.resumeapp.controller;

import com.rjbank.internal.resumeapp.manager.IdentityManager;
import com.rjbank.internal.resumeapp.model.UserInformation;
import com.rjbank.internal.resumeapp.model.Membership;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pjoshi1 on 11/23/2017.
 */

@RestController
@RequestMapping("/resumeapp")
public class LoginController {

    @Autowired
    private IdentityManager identityManager;

    @RequestMapping(value ="/register",method= RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public ResponseEntity<String> login(@RequestBody UserInformation userInformation){
        ResponseEntity<String> response=new ResponseEntity<String>(identityManager.register(userInformation),HttpStatus.OK);
        return response;
    }

    @RequestMapping(value ="/membership/modify",method= RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public ResponseEntity<String> modifyMembership(@RequestBody Membership membership){
        identityManager.modifyMembership(membership);
        ResponseEntity<String> response=new ResponseEntity<String>("added to "+membership.getMembership(), HttpStatus.OK);
        return response;
    }

    @RequestMapping(value ="/membership",method=RequestMethod.GET,produces = "application/json",consumes = "application/json")
    public ResponseEntity<List<Membership>> modifyMembership(){
        ResponseEntity<List<Membership>> response=new ResponseEntity<>(identityManager.getMemberShipDetails(), HttpStatus.OK);
        return response;
    }

    @RequestMapping(value ="/membership",method=RequestMethod.PUT,produces = "application/json",consumes = "application/json")
    public ResponseEntity<String> deleteMembership(@RequestBody Membership membership){
        ResponseEntity<String> response=new ResponseEntity<>(identityManager.deleteMembership(membership), HttpStatus.OK);
        return response;
    }

    @RequestMapping(value ="/groups",method=RequestMethod.GET,produces = "application/json",consumes = "application/json")
    public ResponseEntity<List<String>> deleteMembership(){
        ResponseEntity<List<String>> response=new ResponseEntity<>(identityManager.getGroups(), HttpStatus.OK);
        return response;
    }

}
