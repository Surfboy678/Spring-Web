package com.crud.tasks.scheduler;


import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domian.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static String SUBJECT = "Tasks: Once a Day Email";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;


    @Scheduled(fixedRateString = "10000")
    public void sendInformationEmail(){
        long size = taskRepository.count();
        String mail = null;
        if(size == 1) {
            mail = "Currently in database you go" + size + "task";
        }else {
            mail = "Currently in database you go" + size + "tasks";

        }
        simpleEmailService.send(new Mail(adminConfig.getAdminMail(),
                SUBJECT, mail));

    }

}
