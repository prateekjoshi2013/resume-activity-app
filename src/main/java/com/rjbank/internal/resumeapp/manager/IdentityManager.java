package com.rjbank.internal.resumeapp.manager;

import com.rjbank.internal.resumeapp.model.LoginReponse;
import com.rjbank.internal.resumeapp.model.Membership;
import com.rjbank.internal.resumeapp.model.ModifyMembershipRequest;
import com.rjbank.internal.resumeapp.model.UserInformation;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by pjoshi1 on 12/8/2017.
 */
@Service
public class IdentityManager {
    @Autowired
    private IdentityService identityService;

    public LoginReponse login(){
        String userId =SecurityContextHolder.getContext().getAuthentication().getName();
        User user=identityService.createUserQuery().userId(userId).singleResult();
        LoginReponse loginResponse=new LoginReponse(user.getFirstName(),user.getLastName(),user.getEmail());
        return loginResponse;
    }

    public String register( UserInformation userInformation){
        User user=identityService.createUserQuery().userId(userInformation.getUserId()).singleResult();
        if(user==null){
            user=identityService.newUser(userInformation.getUserId());
            user.setEmail(userInformation.getEmail());
            user.setFirstName(userInformation.getFirstName());
            user.setLastName(userInformation.getLastName());
            user.setPassword(userInformation.getPassword());
            identityService.saveUser(user);
          return "user created";
        }else{
           return "user already exists";
        }
    }

    public void modifyMembership(ModifyMembershipRequest modifyMembershipRequest){
        Membership addMembership=new Membership();
        Membership deleteMembership=new Membership();
        addMembership.setMembership(new ArrayList<>());
        deleteMembership.setMembership(new ArrayList<>());
        addMembership.setUser(modifyMembershipRequest.getUser());
        deleteMembership.setUser(modifyMembershipRequest.getUser());
        if(modifyMembershipRequest.getGroups().isResumeUploadGroup()){
            addMembership.getMembership().add("resumeUploadGroup");
        }else{
            deleteMembership.getMembership().add("resumeUploadGroup");
        }
        if(modifyMembershipRequest.getGroups().isPrelimApprovalGroup()){
            addMembership.getMembership().add("prelimApprovalGroup");
        }else{
            deleteMembership.getMembership().add("prelimApprovalGroup");
        }
        if(modifyMembershipRequest.getGroups().isFinalApprovalGroup()){
            addMembership.getMembership().add("finalApprovalGroup");
        }else{
            deleteMembership.getMembership().add("finalApprovalGroup");
        }
        addMembership(addMembership);
        deleteMembership(deleteMembership);
    }

    public String addMembership(Membership membership) {
        Group grp = null;
        for (String group : membership.getMembership()) {
            grp = identityService.createGroupQuery().groupId(group).singleResult();
            if (grp == null) {
                grp = identityService.newGroup(group);
                grp.setName(group);
                grp.setId(group);
                identityService.saveGroup(grp);
            }

            boolean isMember = identityService.createUserQuery().memberOfGroup(group).list().stream().map(element -> element.getId()).collect(toList()).contains(membership.getUser());
            if (isMember) {
                continue;
            } else {
                identityService.createMembership(membership.getUser(), grp.getId());
            }
        }
        return "added to the group";
    }

    public List<Membership> getMemberShipDetails(){
        List<Membership>   membershipDetails=new ArrayList<>();
        List<String>users=identityService.createUserQuery().list().stream().map(user->{return user.getId();}).collect(toList());
       for(String user : users){
           System.out.println(user);
           System.out.println(identityService.createGroupQuery().groupMember(user).list());
           List<String> groupIds=identityService.createGroupQuery().groupMember(user).list().stream().map(group -> {return group.getName();}).collect(toList());
            membershipDetails.add(new Membership(user,groupIds)) ;
       }
     return membershipDetails;
    }

    public String deleteMembership(Membership membership) {
        for (String group : membership.getMembership()) {
            if (identityService.createUserQuery().memberOfGroup(group).list().stream().map(element -> element.getId()).collect(toList()).contains(membership.getUser()))
                identityService.deleteMembership(membership.getUser(), group);
        }
        return "deleted";
    }

    public List<String> getGroups() {
        return  identityService.createGroupQuery().list().stream().map(element->element.getId()).collect(toList());
    }
}
