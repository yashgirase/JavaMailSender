package com.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailManagement {

    void sendMail()
    {
        Properties SProperties = System.getProperties(); //this gives me a hash-map/ hash-table

        System.out.println(SProperties);

        SProperties.put("mail.smtp.host",MailDeta.HostServer);
        SProperties.put("mail.smtp.port",MailDeta.portNo);
        SProperties.put(MailDeta.sslProperty,"true");
        SProperties.put(MailDeta.authPerm,"true");



        Authenticator mailAuthenticator = new MailAuthentication();
        Session mailSession = Session.getInstance(SProperties,mailAuthenticator);



        MimeMessage mailMessage = new MimeMessage(mailSession);

        try {
            mailMessage.setFrom(MailDeta.SenderMail);
            mailMessage.setSubject("Mail sended by java code");
            mailMessage.setText("Hi , I am praful and I am sending this mail from my java code for testing purpose");



            Address receiverEmail = new InternetAddress(MailDeta.receiverMail);
            mailMessage.setRecipient(Message.RecipientType.TO, receiverEmail);

            Transport.send(mailMessage);
        }
        catch(Exception mailException)
        {
            System.out.println(mailException.toString());
        }


    }
}
