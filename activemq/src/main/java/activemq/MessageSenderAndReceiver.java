package activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageSenderAndReceiver {
    public static void main(final String[] args) throws JMSException {
	final ApplicationContext context = new ClassPathXmlApplicationContext("spring-context2.xml");
	final JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
	// sending the message to the "TestQueue"
	jmsTemplate.send(new MessageCreator() {
	    public ObjectMessage createMessage(final Session session) throws JMSException {
		final ObjectMessage message = session.createObjectMessage();
		message.setObject("Dummy Message to be sent");
		return message;
	    }
	});

	System.out.println("MESSAGE SENT TO TestQueue");
	// now receiving the message
	final Message receivedMessage = jmsTemplate.receive("TestQueue");
	final ObjectMessage msg = (ObjectMessage) receivedMessage;
	System.out.println("Message Received :" + msg.getObject().toString());
    }
}