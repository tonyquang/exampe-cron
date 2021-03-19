package com.cronemail.demo.utils;

public interface Constant {
    String HOST_NAME = "facebook.com";
    int MAX_TIME_ACCESS_FB = 20;

    String EMAIL_SUBJECT = "[WARNING ACCESS FACEBOOK]";
    String EMAIL_CONTENT = "You had access to Facebook over allow time, please stop and let back to your work. Regard!";

    // start at 12h, and cron job with run every 4 hours
    String CRONJOB_EXPRESSION = "0/30 0/1 * 1/1 * ? *";
}
