/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.component.mail.test;

import cn.ucaner.component.mail.base.MailSenderInfo;
import cn.ucaner.component.mail.send.SimpleMailSender;

/**
* @Package：cn.ucaner.mail.test   
* @ClassName：SendMailTest   
* @Description：   <p> 邮件发送测试 </p>
* @Author： - Jason 
* @CreatTime：2017年10月14日 下午4:11:29   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class SendMailTest {
	
	public static void main(String[] args) {
		// 这个类主要是设置邮件
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.163.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName("jason2andy@163.com"); // 实际发送者
        mailInfo.setPassword("163mail");// 您的邮箱密码
        mailInfo.setFromAddress("jason2andy@163.com"); // 设置发送人邮箱地址
        mailInfo.setToAddress("603043194@qq.com"); // 设置接受者邮箱地址
        mailInfo.setSubject("Test for Jason");
        mailInfo.setContent("You are what you want to be.");
        // 这个类主要来发送邮件

        SimpleMailSender sms = new SimpleMailSender();
        //sms.sendTextMail(mailInfo);// 发送 text格式
        //sms.sendHtmlMail(mailInfo); // 发送html格式
        if (sms.sendHtmlMail(mailInfo)) { //发送文体格式
			System.out.println("发送成功！");
		}else{
			System.out.println("发送失败！");
		}
	}

}
