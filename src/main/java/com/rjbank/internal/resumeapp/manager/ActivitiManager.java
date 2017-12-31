package com.rjbank.internal.resumeapp.manager;

import com.rjbank.internal.resumeapp.model.*;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by pjoshi1 on 11/26/2017.
 */
@Service
public class ActivitiManager {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private IdentityService identityService;


    public String startProcessInstance(Candidate candidate){
        Map<String,Object> processVariableMap=new HashMap<>();
        processVariableMap.put("candidate",candidate);
        ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey("resumeApproval",processVariableMap);
        return processInstance.getId();
    }

    public List<UserTask> getTasksForUser(String userId){
        List<Group>groups=identityService.createGroupQuery().groupMember(userId).list();
        List<String>groupIds=groups.stream().map(group -> { return group.getName();}).collect(Collectors.toList());
        System.out.println(groupIds);
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroupIn(groupIds).list();
        List<UserTask> userTaskList=tasks.stream().map(element->convertActivitiTaskToUserTask(element)).collect(Collectors.toList());
        System.out.println(" Tasks in queue:" + tasks);
        return userTaskList;
    }

   public  UserTask convertActivitiTaskToUserTask(Task task){
        return new UserTask(task.getId(),task.getName());
   }

    public String completeUserTask( TaskCompleteRequest taskCompleteRequest){
        System.out.println("-->"+taskCompleteRequest);
        taskService.claim(taskCompleteRequest.getTaskId(),taskCompleteRequest.getUserId());
        taskService.setVariable(taskCompleteRequest.getTaskId(),"candidate",taskCompleteRequest.getCandidate());
        taskService.complete(taskCompleteRequest.getTaskId());
        return taskService.createTaskQuery().taskId(taskCompleteRequest.getTaskId()).singleResult().getName()+" completed";
    }


    public String completeSortResumeTask(SortResumeRequest task){
        System.out.println("-->"+task);
        taskService.claim(task.getTaskId(),task.getUserId());
        Candidate candidate=(Candidate)taskService.getVariable(task.getTaskId(),"candidate");
        candidate.setCategory(task.getCategory());
        candidate.getComments().add(task.getComment());
        taskService.setVariable(task.getTaskId(),"candidate",candidate);
        taskService.complete(task.getTaskId());
        return task.getTaskId()+" completed";
    }

    public String completePrelimApprovalTask(PrelimApprovalRequest task ){
        System.out.println(task);
        taskService.claim(task.getTaskId(),task.getUserId());
        Candidate candidate=(Candidate)taskService.getVariable(task.getTaskId(),"candidate");
        candidate.setCategory(task.getCategory());
        candidate.setPrelimApproval(task.isPrelimApproval());
        candidate.getComments().add(task.getComment());
        System.out.println(candidate);
        taskService.setVariable(task.getTaskId(),"candidate",candidate);
        taskService.complete(task.getTaskId());
        return task.getTaskId()+" completed";
    }

    public String completeFinalApprovalTask(FinalApprovalRequest task){
        System.out.println(task);
        taskService.claim(task.getTaskId(),task.getUserId());
        Candidate candidate=(Candidate)taskService.getVariable(task.getTaskId(),"candidate");
        candidate.setCategory(task.getCategory());
        candidate.setFinalApproval(task.isFinalApproval());
        candidate.getComments().add(task.getComment());
        System.out.println(candidate);
        taskService.setVariable(task.getTaskId(),"candidate",candidate);
        taskService.complete(task.getTaskId());
        return task.getTaskId()+" completed";
    }

    public String getResume(String taskId){
        Candidate candidate=(Candidate) taskService.getVariable(taskId,"candidate");
        return candidate.getResume();
    }
}
