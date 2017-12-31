package com.rjbank.internal.resumeapp.controller;

import com.rjbank.internal.resumeapp.manager.IdentityManager;
import com.rjbank.internal.resumeapp.model.LoginReponse;
import com.rjbank.internal.resumeapp.model.ModifyMembershipRequest;
import com.rjbank.internal.resumeapp.model.UserInformation;
import com.rjbank.internal.resumeapp.model.Membership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by pjoshi1 on 11/23/2017.
 */
@CrossOrigin//(origins = "*")
@RestController
@RequestMapping("/resumeapp")
public class LoginController {

    @Autowired
    private IdentityManager identityManager;

    @RequestMapping(value ="/login",method= RequestMethod.GET,produces = "application/json",consumes = "application/json")
    public ResponseEntity<LoginReponse> login(){
        System.out.println("**********************************________________***************************");
        ResponseEntity<LoginReponse> response=new ResponseEntity<>(identityManager.login(),HttpStatus.OK);
        return response;
    }

    @RequestMapping(value ="/register",method= RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public ResponseEntity register(@RequestBody UserInformation userInformation){
        identityManager.register(userInformation);
        ResponseEntity response=new ResponseEntity(HttpStatus.OK);
        return response;
    }

    @RequestMapping(value ="/membership/modify",method= RequestMethod.PUT,produces = "application/json",consumes = "application/json")
    public ResponseEntity modifyMembership(@RequestBody ModifyMembershipRequest membership){
        System.out.println(membership);
        identityManager.modifyMembership(membership);
        ResponseEntity response=new ResponseEntity( HttpStatus.OK);
        return response;
    }

    @RequestMapping(value ="/membership/modify",method= RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public ResponseEntity<String> addMembership(@RequestBody Membership membership){
        identityManager.addMembership(membership);
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
