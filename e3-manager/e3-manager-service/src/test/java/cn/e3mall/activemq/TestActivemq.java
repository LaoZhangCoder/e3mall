package cn.e3mall.activemq;

import java.io.IOException;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class TestActivemq {
	@SuppressWarnings("resource")
	
	public void Testmq()
	{
		//初始化spring容器
	ApplicationContext applicationContext = new  ClassPathXmlApplicationContext("classpath:spring/applicationContext-activemq.xml");
	//从spring容器中获得JmsTemplate对象
	JmsTemplate jmsTemplate = applicationContext.getBean(JmsTemplate.class);
	//从spring容器中取Destination对象
	Destination destination = (Destination) applicationContext.getBean("queueDestination");
	jmsTemplate.send(destination,new MessageCreator() {
		
		@Override
		public Message createMessage(Session session) throws JMSException {
			// TODO Auto-generated method stub
			//创建一个消息对象并返回
			TextMessage createTextMessage = session.createTextMessage("哈哈哈");
			return createTextMessage;
		}
	});
		
	}

	public void Testmq2()
	{
		//初始化spring容器
	ApplicationContext applicationContext = new  ClassPathXmlApplicationContext("classpath:spring/applicationContext-mq.xml");
	//从spring容器中获得JmsTemplate对象
	try {
		System.in.read();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
	}
}
