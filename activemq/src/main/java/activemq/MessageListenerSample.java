package activemq;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("messageListenerSample")
public class MessageListenerSample implements MessageListener {

    private static final Logger logger = Logger.getLogger(MessageListenerSample.class);

    @Autowired
    private final AtomicInteger counter = null;

    /**
     * On message
     */
    public void onMessage(final Message message) {
	try {
	    final int messageCount = message.getIntProperty(MessageProducer.MESSAGE_COUNT);

	    if (message instanceof TextMessage) {
		final TextMessage tm = (TextMessage) message;
		logger.info("Processed message '{" + tm.getText() + "} value={" + messageCount + "}");
		counter.incrementAndGet();
	    }
	} catch (final JMSException e) {
	    logger.error(e.getMessage(), e);
	}
    }

}