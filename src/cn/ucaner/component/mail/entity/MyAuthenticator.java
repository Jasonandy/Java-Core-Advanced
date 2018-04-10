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
package cn.ucaner.component.mail.entity;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
* @Package：cn.ucaner.mail.entity   
* @ClassName：MyAuthenticator   
* @Description：   <p> 邮箱账号校验器 </p>
* @Author： - Jason 
* @CreatTime：2017年10月14日 下午4:01:57   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public class MyAuthenticator extends Authenticator{
	
	/**
	 * 邮箱用户名
	 */
	String userName = null;
	
	/**
	 * 邮箱密码
	 */
	String password = null;

    public MyAuthenticator() {
    	
    }
    
    /**
    * <p>MyAuthenticator: 含参构造</p> 
    * <p>Description:邮箱校验权限构造 </p> 
    * @param username 用户名
    * @param password 密码
     */
    public MyAuthenticator(String username, String password) {
        this.userName = username;
        this.password = password;
    }
    
    /**
    * 描述: 获取是否授权
    * @return
     */
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }

}
