package com.rjbank.internal.resumeapp.ActivityListener;

import com.rjbank.internal.resumeapp.model.Candidate;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

/**
 * Created by pjoshi1 on 11/16/2017.
 */
public class AcceptedEndActivityListener implements ExecutionListener{
    @Override
    public void notify(DelegateExecution delegateExecution) {
        System.out.println(((Candidate)delegateExecution.getVariable("candidate"))+"is set for the interview");
    }
}
