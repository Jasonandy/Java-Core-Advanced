/**
 * <html>
 * <body>
 *  <P> https://github.com/Jasonandy </p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年6月12日 下午4:00:58</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.component.jms;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**     
* @Package：cn.ucaner.component.jms   
* @ClassName：MsgSubscriber   
* @Description：   <p> MsgSubscriber </p>
* <url> https://blog.csdn.net/zhangzikui/article/details/24837999 </url>
* @Author： -    
* @CreatTime：2018年6月12日 下午4:10:55   
* @Modify By：   
* @ModifyTime：  2018年6月12日
* @Modify marker：   
* @version    V1.0
*/
public class MsgSubscriber implements MessageListener{
	
	TopicConnection topicConnection;

    TopicSession topicSession;

    TopicSubscriber topicSubscriber;

    Topic topic;

	@Override
	public void onMessage(Message msg) {
		try {
	           if (msg instanceof TextMessage) {
	              //把Message 转型成 TextMessage 并提取消息内容
	              String msgTxt = ((TextMessage) msg).getText();
	              System.out.println("HelloSubscriber got message: " +msgTxt);
	           }
	       } catch (JMSException ex) {
	           System.err.println("Could not get text message: " + ex);
	           ex.printStackTrace();
	       }
	}
	
	
	public MsgSubscriber(String factoryJNDI, String topicJNDI)throws JMSException, NamingException {
		   Hashtable<String, String> env = new Hashtable<String, String>();
	       //设置好连接JMS容器的属性，不同的容器需要的属性可能不同，需要查阅相关文档
	       env.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
	       env.put(Context.PROVIDER_URL, "localhost:1088");
	       env.put("java.naming.rmi.security.manager", "yes");
	       env.put(Context.URL_PKG_PREFIXES, "org.jboss.naming");
	       Context context = new InitialContext();
	       TopicConnectionFactory topicFactory = (TopicConnectionFactory) context.lookup(factoryJNDI);
	       //创建连接
	       topicConnection = topicFactory.createTopicConnection();
	       topicSession = topicConnection.createTopicSession(false,Session.AUTO_ACKNOWLEDGE);//创建session
	       topic = (Topic) context.lookup(topicJNDI);//查找到主题
	       //用session创建一个特定queue的消息接收者
	       topicSubscriber = topicSession.createSubscriber(topic);
	       //注册监听，这里设置的监听是自己，因为本类已经实现了MessageListener接口，
	       //一旦queueReceiver接收到了消息，就会调用本类的onMessage方法
	       topicSubscriber.setMessageListener(this);
	       System.out.println("HelloSubscriber subscribed to topic: "+ topicJNDI);
	       topicConnection.start();//启动连接，这时监听器才真正生效
    }
	
	
	public void close() throws JMSException {
		topicSession.close();
		topicConnection.close();
	}

	public static void main(String[] args) {
	   try {
	       new MsgSubscriber("TopicConnectionFactory","topic/testTopic");
	   } catch (Exception ex) {
	       ex.printStackTrace();
	   }
	}
	

}
