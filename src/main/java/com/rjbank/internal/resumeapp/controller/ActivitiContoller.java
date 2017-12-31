package com.rjbank.internal.resumeapp.controller;

import com.rjbank.internal.resumeapp.manager.ActivitiManager;
import com.rjbank.internal.resumeapp.manager.BPMNDeploymentManager;
import com.rjbank.internal.resumeapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by pjoshi1 on 11/23/2017.
 */
@CrossOrigin
@RestController
@RequestMapping("/resumeapp")
public class ActivitiContoller {

     @Autowired
     BPMNDeploymentManager bpmnDeploymentManager;
     @Autowired
     ActivitiManager activitiManager;


    @RequestMapping(value = "/download/{taskId}",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<String>downloadResume(@PathVariable("taskId")  String taskId) throws IOException {
        return new ResponseEntity<String>(activitiManager.getResume(taskId), HttpStatus.ACCEPTED);
    }



    @RequestMapping(value = "/upload",method = RequestMethod.POST,consumes="application/json",produces="application/json")
    public ResponseEntity<String>uploadResume(@RequestBody Resume resume) throws IOException {
        byte [] bytes=Base64.getDecoder().decode(resume.getResume());
        try (FileOutputStream fileOuputStream = new FileOutputStream("C:\\Users\\pjoshi1\\Desktop\\resumeapp\\src\\tst\\resources"+resume.getName()+".pdf")) {
            fileOuputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bpmnDeploymentManager.deployProcess();
        ArrayList<Comment> comments=new ArrayList<>();
        Candidate candidate =new Candidate(resume.getName(),resume.getResume(),resume.getExp(),"UnCategorized",comments,false,false);
        String processInstanceId=activitiManager.startProcessInstance(candidate);
        return new ResponseEntity<String>("resume uploaded with id "+processInstanceId, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/tasks",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<List<UserTask>> getTasksForUserId(){
        return new ResponseEntity<>(activitiManager.getTasksForUser(SecurityContextHolder.getContext().getAuthentication().getName()), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/task/categorize",method = RequestMethod.POST,consumes="application/json",produces="application/json")
    public ResponseEntity<String> completeSortResumeTask(@RequestBody SortResumeRequest sortResumeRequest){
        System.out.println(sortResumeRequest);
        return new ResponseEntity<String>(activitiManager.completeSortResumeTask(sortResumeRequest),HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/task/prelimapproval",method = RequestMethod.POST,consumes="application/json",produces="application/json")
    public ResponseEntity<String> completePrelimApprovalTask(@RequestBody PrelimApprovalRequest prelimApprovalTaskRequest ){
        System.out.println(prelimApprovalTaskRequest);
        return new ResponseEntity<String>(activitiManager.completePrelimApprovalTask(prelimApprovalTaskRequest),HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/task/finalapproval",method = RequestMethod.POST,consumes="application/json",produces="application/json")
    public ResponseEntity<String> completePrelimApprovalTask(@RequestBody FinalApprovalRequest finalApprovalTaskRequest ){
        System.out.println(finalApprovalTaskRequest);
        return new ResponseEntity<String>(activitiManager.completeFinalApprovalTask(finalApprovalTaskRequest),HttpStatus.ACCEPTED);
    }
}
