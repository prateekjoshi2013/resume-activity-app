package com.rjbank.internal.resumeapp.config;

import org.activiti.engine.*;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by pjoshi1 on 11/26/2017.
 */

@Configuration
@EnableWebMvc
@ComponentScan({"com.rjbank.internal.resumeapp"})
@Import({ResumeAppConfig.class})
public class ActivitiConfig {
    @Autowired
    private DataSourceTransactionManager transactionManager;
    @Autowired
    private SimpleDriverDataSource dataSource;
    @Bean(name="processEngine")
    public  ProcessEngine getProcessEngine() {
        SpringProcessEngineConfiguration springProcessEngineConfiguration;
        springProcessEngineConfiguration = new SpringProcessEngineConfiguration();
        springProcessEngineConfiguration.setDataSource(dataSource).setAsyncExecutorActivate(false);
        springProcessEngineConfiguration.setDatabaseSchemaUpdate("true");
        springProcessEngineConfiguration.setDatabaseType("h2");
        springProcessEngineConfiguration.setTransactionManager(transactionManager);
        ProcessEngine processEngine=springProcessEngineConfiguration.buildProcessEngine();
        return processEngine;
    }


    @Bean(name="formService")
    public FormService getFormService(){
        return getProcessEngine().getFormService();
    }

    @Bean(name="historyService")
    public HistoryService getHistoryServiceEngine(){
        return  getProcessEngine().getHistoryService();
    }

    @Bean(name="identityService")
    public IdentityService getIdentityServiceEngine(){
        IdentityService identityService= getProcessEngine().getIdentityService();
        User user=identityService.newUser("admin");
        user.setPassword("admin");
        identityService.saveUser(user);
        Group group=identityService.newGroup("admin");
        identityService.saveGroup(group);
        return identityService ;
    }

    @Bean(name="managementService")
    public ManagementService getManagementServiceEngine(){
        return getProcessEngine().getManagementService();
    }

    @Bean(name="repositoryService")
    public RepositoryService getRepositoryServiceEngine(){return  getProcessEngine().getRepositoryService();}

    @Bean(name="runtimeService")
    public RuntimeService getRuntimeServiceEngine(){
        return  getProcessEngine().getRuntimeService();
    }

    @Bean(name="taskService")
    public TaskService getTaskServiceEngine(){
        return getProcessEngine().getTaskService();
    }
}
