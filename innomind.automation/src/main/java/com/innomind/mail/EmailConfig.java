package com.innomind.mail;

import static com.innomind.constants.FrameworkConstants.REPORT_TITLE;

/**
 * Data for Sending email after execution
 */
public class EmailConfig {

    //Enable Override Report and Send mail in config file => src/test/resources/config/config.properties
    //OVERRIDE_REPORTS=yes
    //send_email_to_users=yes

    public static final String SERVER = "smtp.gmail.com";
    public static final String PORT = "587";

    public static final String FROM = "qaAutomation@innomind.com";
    public static final String PASSWORD = "******";

    public static final String[] TO = {"AIA@mailinator.com"};
    public static final String SUBJECT = REPORT_TITLE;
}