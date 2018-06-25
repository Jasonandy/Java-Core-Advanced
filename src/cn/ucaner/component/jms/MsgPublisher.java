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
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**     
* @Package：cn.ucaner.component.jms   
* @ClassName：MsgPublisher   
* @Description：   <p> jms  publiser </p>
* <url> https://blog.csdn.net/zhangzikui/article/details/24837999 </url>
* @Author： - Jason   
* @CreatTime：2018年6月12日 下午4:00:58   
* @Modify By：   
* @ModifyTime：  2018年6月12日
* @Modify marker：   
* @version    V1.0
*/
public class MsgPublisher {
	
	/**
	 * JMS连接，属于Pub/Sub方式的连接
	 */
	TopicConnection topicConnection;

	/**
	 * JMS会话，属于Pub/Sub方式的会话
	 */
    TopicSession topicSession; 

    /**
     * 消息发布者
     */
    TopicPublisher topicPublisher;

    /**
     * 主题
     */
    Topic topic; 
    
    
    
    public MsgPublisher(String factoryJNDI, String topicJNDI)throws JMSException, NamingException {
        Hashtable<String, String> env = new Hashtable<String, String>();

        /**
         * 设置好连接JMS容器的属性，不同的容器需要的属性可能不同，需要查阅相关文档
         */
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        env.put(Context.PROVIDER_URL, "localhost:1088");
        env.put("java.naming.rmi.security.manager", "yes");
        env.put(Context.URL_PKG_PREFIXES, "org.jboss.naming");

        /**
         * 创建连接JMS容器的上下文(context)
         */
        Context context = new InitialContext(env);

        /**
         * 通过连接工厂的JNDI名查找ConnectionFactory
         */
        TopicConnectionFactory topicFactory = (TopicConnectionFactory) context.lookup(factoryJNDI);

        /**
         * 用连接工厂创建一个JMS连接
         */
        topicConnection = topicFactory.createTopicConnection();

        /**
         * 通过JMS连接创建一个Session
         */
        topicSession = topicConnection.createTopicSession(false,Session.AUTO_ACKNOWLEDGE);

        /**
         * 通过上下文查找到一个主题(topic)
         */
        topic = (Topic) context.lookup(topicJNDI);

        /**
         * 用session来创建一个特定主题的消息发送者
         */
        topicPublisher = topicSession.createPublisher(topic);

     }

     /**
      * @Description:   发布一条文本消息 
      * @param msg		待发布的消息
      * @throws JMSException void
      * @Autor: Jason - jasonandy@hotmail.com
      */
     public void publish(String msg) throws JMSException {
    	/**
    	 * 用session来创建一个文本类型的消息
    	 */
        TextMessage message = topicSession.createTextMessage();
        /**
         * 设置消息内容
         */
        message.setText(msg);
        /**
         * 消息发送，发送到特定主题
         */
        topicPublisher.publish(topic, message);
     }

  
     public void close() throws JMSException {
        topicSession.close();//关闭session
        topicConnection.close();//关闭连接

     }
     public static void main(String[] args)throws JMSException, NamingException {

        MsgPublisher publisher = new MsgPublisher("ConnectionFactory", "topic/testTopic");

        try {
            for (int i = 1; i < 11; i++) {
               String msg = "Hello World no. " + i;
               System.out.println("Publishing message: " + msg);
               publisher.publish(msg);
            }
            /**
             * session和connection用完之后一定记得关闭
             */
            publisher.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

     }

}
