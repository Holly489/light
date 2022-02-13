package qwer.qwq.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

/**
 * 发邮件工具类
 */
public final class MailUtils {
    private static final String USER ="1031652416@qq.com"; // 发件人称号，同邮箱地址
    private static final String PASSWORD ="goxqyhgcodehbbjb"; // 如果是qq邮箱可以使户端授权码，或者登录密码

    /**
     *
     * @param to 收件人邮箱
     * @param text 邮件正文
     * @param title 标题
     */
    /* 发送验证信息的邮件 */
    public static boolean sendMail(String to, String text, String title){
        try {
            final Properties props = new Properties();
            props.setProperty("mail.smtp.auth", "true");// 开启认证
            props.setProperty("mail.smtp.socketFactory.port", "587");// 设置ssl端口
            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.qq.com");

            // 发件人的账号
            props.put("mail.user", USER);
            //发件人的密码
            props.put("mail.password", PASSWORD);

            // 构建授权信息，用于进行SMTP进行身份验证
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            // 使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getInstance(props, authenticator);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);
            // 设置发件人
            String username = props.getProperty("mail.user");
            InternetAddress form = new InternetAddress(username);
            message.setFrom(form);

            // 设置收件人
            InternetAddress toAddress = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAddress);
            
            // 设置邮件标题
            message.setSubject(title);
            // 设置邮件的内容体
            message.setContent(text, "text/html;charset=UTF-8");
            
            // 发送邮件
            Transport.send(message);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args) throws Exception { // 做测试用
    	String content="<!DOCTYPE html>\r\n" + 
    			"<html lang=\"en\">\r\n" + 
    			"\r\n" + 
    			"<head>\r\n" + 
    			"<meta charset=\"UTF-8\">\r\n" + 
    			"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
    			"<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n" + 
    			"<title>LIGHT</title>\r\n" + 
    			"<style>\r\n" + 
    			"body {\r\n" + 
    			"background-color: rgb(240, 238, 231);\r\n" + 
    			"}\r\n" + 
    			"\r\n" + 
    			".main {\r\n" + 
    			"width: 544px;\r\n" + 
    			"padding: 28px;\r\n" + 
    			"margin: 0 auto;\r\n" + 
    			"background: #fff;\r\n" + 
    			"}\r\n" + 
    			"\r\n" + 
    			".title {\r\n" + 
    			"display: block;\r\n" + 
    			"width: 95px;\r\n" + 
    			"padding: 10px;\r\n" + 
    			"margin: 0 auto;\r\n" + 
    			"margin-bottom: 16px;\r\n" + 
    			"background-color: #1e262d;\r\n" + 
    			"color: white;\r\n" + 
    			"font-size: 24px;\r\n" + 
    			"text-align: center;\r\n" + 
    			"}\r\n" + 
    			"\r\n" + 
    			".con {\r\n" + 
    			"margin-bottom: 20px;\r\n" + 
    			"font-size: 26px;\r\n" + 
    			"line-height: 34px;\r\n" + 
    			"font-family: roboto, tahoma, sans-serif;\r\n" + 
    			"text-align: left;\r\n" + 
    			"}\r\n" + 
    			"\r\n" + 
    			"img {\r\n" + 
    			"width: 100%;\r\n" + 
    			"}\r\n" + 
    			"</style>\r\n" + 
    			"</head>\r\n" + 
    			"\r\n" + 
    			"<body>\r\n" + 
    			"<div class=\"main\">\r\n" + 
    			"<div class=\"con\">网页版和手机客户端接近准备就绪，微信小程序也快了</div>\r\n" + 
    			"< img src=\"https://gitee.com/l1031652416wo/img-bed/raw/master/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20201028004138.png\"\r\n" + 
    			"alt=\"\">\r\n" + 
    			"< a href=' \"+user.getCode()+\"'>\r\n" + 
    			"<div class=\"title\">LIGHT</div>\r\n" + 
    			"</ a>\r\n" + 
    			"<div style=\"text-align: center\">点击LIGHT即可激活</div>\r\n" + 
    			"< img src=\"cid:a\">"+
    			"</div>"+
    			"</body>\r\n" + 
    			"\r\n" + 
    			"</html>";
        MimeBodyPart img = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("C:\\QWERR\\qwer\\WebContent\\img\\LIGHT1.jpg"));//图片路径
        img.setDataHandler(dh);
        img.setContentID("a");
        MailUtils.sendMail("2300537026@qq.com",content,"Light激活邮件");
    }

}