package com.cronemail.demo.service;

import com.cronemail.demo.model.EmailModel;
import com.cronemail.demo.model.UserActivity;
import com.cronemail.demo.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class CronJobService implements Job {

    @Autowired
    IEmailService emailServices;

    @Autowired
    IUserService usersServices;

    @Autowired
    IUserActivityService userActivityServices;

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        String strCurrentDate = sdf.format(currentDate);
        log.info("execute time stamp: "+strCurrentDate);
        sendMail(strCurrentDate);
    }

    private void sendMail(String timeStamp) {
        log.info("sendMail time stamp: "+timeStamp);
//        List<UserActivity> usersActivity = userActivityServices
//                .selectUserActivityList(Constant.HOST_NAME,
//                        Constant.MAX_TIME_ACCESS_FB,
//                        timeStamp);
//        if (usersActivity.isEmpty())
//            return;
//
//        List<String> emails = new ArrayList<>();
//        for (UserActivity urAc : usersActivity) {
//            emails.add(usersServices.selectEmailFromUserID(urAc.getUserId()));
//        }
//
//        emailServices.sendMail(EmailModel.builder()
//                .email(emails)
//                .content(Constant.EMAIL_CONTENT)
//                .subject(Constant.EMAIL_SUBJECT)
//                .build());
    }

}
