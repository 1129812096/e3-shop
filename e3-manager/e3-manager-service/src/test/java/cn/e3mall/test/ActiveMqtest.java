package cn.e3mall.test;

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

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

public class ActiveMqtest {

	@Test
	public void testActiveMqQuene() throws JMSException {

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.129:61616");
		Connection connection = connectionFactory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		connection.start();
		/**
		 * Destination
		 */
		Queue queue = session.createQueue("test_quene");
		TextMessage message = session.createTextMessage("hello jet");
		MessageProducer producer = session.createProducer(queue);
		producer.send(message);
		producer.close();
		session.close();
		connection.close();

	}

	@Test
	public void testActiveMqQueneRecv() throws JMSException, IOException {

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.129:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	
		Queue queue = session.createQueue("test_quene");
		MessageConsumer consumer = session.createConsumer(queue);
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				// TODO Auto-generated method stub
				TextMessage textmessage = (TextMessage) message;
				String text = "";
				try {
					text = textmessage.getText();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(text);
			}
		});
		System.in.read();
		consumer.close();
		session.close();
		connection.close();

	}

}
