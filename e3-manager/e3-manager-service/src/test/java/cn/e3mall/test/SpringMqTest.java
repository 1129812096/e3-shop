package cn.e3mall.test;

import java.io.IOException;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SpringMqTest {

	@Test
	public void springMqTest() {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-mq.xml");
		JmsTemplate jmsTemplate= applicationContext.getBean(JmsTemplate.class);
		Destination quene=(Destination) applicationContext.getBean("destinct");
		jmsTemplate.send(quene,	new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage("nihao");
			}
		});
		
		
	}
	@Test
	public void springMqTest1() {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-mq.xml");
		JmsTemplate jmsTemplate= applicationContext.getBean(JmsTemplate.class);
		Topic topic=(Topic) applicationContext.getBean("topicDestination");
		jmsTemplate.send(topic,	new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage("nihao1");
			}
		});
		
		
	}
	@Test
	public void getMessage() throws IOException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-mq.xml");
		System.in.read();
	}
}
