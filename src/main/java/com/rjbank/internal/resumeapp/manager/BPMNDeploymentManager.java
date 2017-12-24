package com.rjbank.internal.resumeapp.manager;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by pjoshi1 on 11/25/2017.
 */
@Service
public class BPMNDeploymentManager {
    @Autowired
    private RepositoryService repositoryService;


    public String deployProcess(){
        Deployment deployment=null;
        try{
            DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
            deploymentBuilder=deploymentBuilder.addClasspathResource("resumeApprovalWorkFlow.bpmn20.xml");
            deployment=deploymentBuilder.deploy();
        }catch(Exception e){
            e.printStackTrace();
        }
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId()).singleResult();
        System.out.println("Found process definition ["
                + processDefinition.getName() + "] with id ["
                + processDefinition.getId() + "]");


        return processDefinition.getId();
    }
}
