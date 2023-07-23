package com.example;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuthentication extends Authenticator {
    protected PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(MailDeta.SenderMail,MailDeta.appPassword);
    }

}
