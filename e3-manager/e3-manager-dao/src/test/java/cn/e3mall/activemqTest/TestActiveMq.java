package cn.e3mall.activemqTest;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

public class TestActiveMq {
	//发送消息者:只管发送不管你接不接收
	
	public void Testmq() throws JMSException {
	
	//第一步：创建ConnectionFactory对象，需要指定服务端ip及端口号。
	 ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("tcp://192.168.25.128:61616");
//	第二步：使用ConnectionFactory对象创建一个Connection对象。
	 Connection createConnection = connectionFactory.createConnection();
	 
	//第三步：开启连接，调用Connection对象的start方法。
	 createConnection.start();
	//第四步：使用Connection对象创建一个Session对象。
	//第一个参数：是否开启事务。true：开启事务，第二个参数忽略。
 //第二个参数：当第一个参数为false时，才有意义。消息的应答模式。1、自动应答2、手动应答。一般是自动应答。

	 Session createSession = createConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//	第五步：使用Session对象创建一个Destination对象（topic、queue），此处创建一个Queue对象。
	 Queue createQueue = createSession.createQueue("testqueue");
	//第六步：使用Session对象创建一个Producer对象。
	 MessageProducer createProducer = createSession.createProducer(createQueue);
	//第七步：创建一个Message对象，创建一个TextMessage对象。
	 TextMessage createTextMessage = createSession.createTextMessage("哈哈哈啊哈");
//	第八步：使用Producer对象发送消息。
	 createProducer.send(createTextMessage);
	//第九步：关闭资源。
	 createProducer.close();
	 createSession.close();
	 createConnection.close();

	
	}
	//消息接收者
	
	public void Testqueueconsumer() throws JMSException {
		//消费者：接收消息。
		
		//第一步：创建一个ConnectionFactory对象。
		ConnectionFactory connetcionFactory=new ActiveMQConnectionFactory("tcp://192.168.25.128:61616");
		//第二步：从ConnectionFactory对象中获得一个Connection对象。
		Connection createConnection = connetcionFactory.createConnection();
		//第三步：开启连接。调用Connection对象的start方法。
		createConnection.start();
		//第四步：使用Connection对象创建一个Session对象。
	   Session createSession = createConnection.createSession(false, Session.AUTO_ACKNOWLEDGE) ;
		//第五步：使用Session对象创建一个Destination对象。和发送端保持一致queue，并且队列的名称一致。
	   Queue createQueue = createSession.createQueue("testqueue");
		//第六步：使用Session对象创建一个Consumer对象。
	   MessageConsumer createConsumer = createSession.createConsumer(createQueue);
		//第七步：接收消息。
	   createConsumer.setMessageListener(new MessageListener() {
		
		@Override
		public void onMessage(Message message) {
			// TODO Auto-generated method stub
			TextMessage textmessage=(TextMessage) message;
			try {
				String text=textmessage.getText();
				System.out.println(text);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
		//第八步：打印消息。
		//第九步：关闭资源
	 //等待键盘输入
	 		try {
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		// 第九步：关闭资源
	 		createConsumer.close();
	 		createSession.close();
	 		createConnection.close();

		
	}
	//测试topic方式发送消息

	public void testTopicProducer() throws JMSException {
		//使用步骤：
		//第一步：创建ConnectionFactory对象，需要指定服务端ip及端口号。
		ConnectionFactory connetcionFactory=new ActiveMQConnectionFactory("tcp://192.168.25.128:61616");
		//第二步：使用ConnectionFactory对象创建一个Connection对象。
		Connection createConnection = connetcionFactory.createConnection();
		//第三步：开启连接，调用Connection对象的start方法。
		createConnection.start();
		//第四步：使用Connection对象创建一个Session对象。
		Session createSession = createConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//第五步：使用Session对象创建一个Destination对象（topic、queue），此处创建一个Topic对象。
		Topic createTopic = createSession.createTopic("test-topic");
		//第六步：使用Session对象创建一个Producer对象。
		MessageProducer createProducer = createSession.createProducer(createTopic);
		//第七步：创建一个Message对象，创建一个TextMessage对象。
		TextMessage createTextMessage = createSession.createTextMessage("这个一个topic测试");
		//第八步：使用Producer对象发送消息。
		createProducer.send(createTextMessage);
		//第九步：关闭资源。
		createConnection.close();
		createSession.close();
		createConnection.close();


		
		
		
	}

	public void testTopicConsumer() throws Exception {
		// 第一步：创建一个ConnectionFactory对象。
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.128:61616");
		// 第二步：从ConnectionFactory对象中获得一个Connection对象。
		Connection connection = connectionFactory.createConnection();
		// 第三步：开启连接。调用Connection对象的start方法。
		connection.start();
		// 第四步：使用Connection对象创建一个Session对象。
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 第五步：使用Session对象创建一个Destination对象。和发送端保持一致topic，并且话题的名称一致。
		Topic topic = session.createTopic("test-topic");
		// 第六步：使用Session对象创建一个Consumer对象。
		MessageConsumer consumer = session.createConsumer(topic);
		// 第七步：接收消息。
		consumer.setMessageListener(new MessageListener() {

			@Override
			public void onMessage(Message message) {
				try {
					TextMessage textMessage = (TextMessage) message;
					String text = null;
					// 取消息的内容
					text = textMessage.getText();
					// 第八步：打印消息。
					System.out.println(text);
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("topic的消费端01。。。。。");
		// 等待键盘输入
	
		// 第九步：关闭资源
		consumer.close();
		session.close();
		connection.close();
	}

	public void testTopicConsumer2() throws Exception {
		// 第一步：创建一个ConnectionFactory对象。
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.128:61616");
		// 第二步：从ConnectionFactory对象中获得一个Connection对象。
		Connection connection = connectionFactory.createConnection();
		// 第三步：开启连接。调用Connection对象的start方法。
		connection.start();
		// 第四步：使用Connection对象创建一个Session对象。
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 第五步：使用Session对象创建一个Destination对象。和发送端保持一致topic，并且话题的名称一致。
		Topic topic = session.createTopic("test-topic");
		// 第六步：使用Session对象创建一个Consumer对象。
		MessageConsumer consumer = session.createConsumer(topic);
		// 第七步：接收消息。
		consumer.setMessageListener(new MessageListener() {

			@Override
			public void onMessage(Message message) {
				try {
					TextMessage textMessage = (TextMessage) message;
					String text = null;
					// 取消息的内容
					text = textMessage.getText();
					// 第八步：打印消息。
					System.out.println(text);
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("topic的消费端02。。。。。");
		// 等待键盘输入
		
		// 第九步：关闭资源
		consumer.close();
		session.close();
		connection.close();
	}
	
	public void testTopicConsumer3() throws Exception {
		// 第一步：创建一个ConnectionFactory对象。
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.128:61616");
		// 第二步：从ConnectionFactory对象中获得一个Connection对象。
		Connection connection = connectionFactory.createConnection();
		// 第三步：开启连接。调用Connection对象的start方法。
		connection.start();
		// 第四步：使用Connection对象创建一个Session对象。
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 第五步：使用Session对象创建一个Destination对象。和发送端保持一致topic，并且话题的名称一致。
		Topic topic = session.createTopic("test-topic");
		// 第六步：使用Session对象创建一个Consumer对象。
		MessageConsumer consumer = session.createConsumer(topic);
		// 第七步：接收消息。
		consumer.setMessageListener(new MessageListener() {

			@Override
			public void onMessage(Message message) {
				try {
					TextMessage textMessage = (TextMessage) message;
					String text = null;
					// 取消息的内容
					text = textMessage.getText();
					// 第八步：打印消息。
					System.out.println(text);
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("topic的消费端03。。。。。");
		// 等待键盘输入
	
		// 第九步：关闭资源
		consumer.close();
		session.close();
		connection.close();
	}

}
