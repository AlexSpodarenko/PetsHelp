package mail;
/*
Some SMTP servers require a username and password authentication before you
can use their Server for Sending mail. This is most common with couple
of ISP's who provide SMTP Address to Send Mail.

This Program gives any example on how to do SMTP Authentication
(User and Password verification)

This is a free source code and is provided as it is without any warranties and
it can be used in any your code for free.

Author : Sudhir Ancha
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMailUsingAuthentication
{

  private static final String SMTP_HOST_NAME = "smtp.mail.ru";
  private static final String SMTP_AUTH_USER = "spodarenkoAlex";
  private static final String SMTP_AUTH_PWD  = "Satareal";

  /**
   * 
   * @param recipients
   * коллекция получателей email-а
   * @param subject
   * тема сообщения
   * @param message
   * текст сообщения
   * @param from
   * email отправителя
   * @throws MessagingException
   * Метод отправляет email по всем адресам переданым в коллекции адресантов с указаной темой и текстом
   */

  public void postMail( Collection<String> recipients, String subject,
                            String message , String from) throws MessagingException
  {
    boolean debug = false;

    ArrayList<String> recip = (ArrayList<String>)recipients;
    
     //Set the host smtp address
     Properties props = new Properties();
     props.put("mail.smtp.host", SMTP_HOST_NAME);
     props.put("mail.smtp.auth", "true");

    Authenticator auth = new SMTPAuthenticator();
    Session session = Session.getDefaultInstance(props, auth);

    session.setDebug(debug);

    // create a message
    Message msg = new MimeMessage(session);

    // set the from and to address
    InternetAddress addressFrom = new InternetAddress(from);
    msg.setFrom(addressFrom);

    InternetAddress[] addressTo = new InternetAddress[recip.size()];
    for (int i = 0; i < recip.size(); i++)
    {
        addressTo[i] = new InternetAddress(recip.get(i));
    }
    msg.setRecipients(Message.RecipientType.TO, addressTo);


    // Setting the Subject and Content Type
    msg.setSubject(subject);
    msg.setContent(message, "text/plain");
    javax.mail.Transport transport = session.getTransport("smtp");
    transport.connect(SMTP_HOST_NAME, SMTP_AUTH_USER, SMTP_AUTH_PWD);
    

    transport.sendMessage(msg, msg.getAllRecipients());
    transport.close(); 
 }


private class SMTPAuthenticator extends javax.mail.Authenticator
{

    public PasswordAuthentication getPasswordAuthentication()
    {
        String username = SMTP_AUTH_USER;
        String password = SMTP_AUTH_PWD;
        return new PasswordAuthentication(username, password);
    }
}

}

