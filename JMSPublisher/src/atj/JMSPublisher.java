package atj;

import javax.jms.JMSContext;
import javax.jms.JMSProducer;

import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.Topic;
import com.sun.messaging.jms.JMSException;

public class JMSPublisher {
	public void publishTopicMessages() throws javax.jms.JMSException {
		ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
		JMSContext jmsContext = connectionFactory.createContext();
		JMSProducer jmsProducer = jmsContext.createProducer();
		try {
			Topic topic = new com.sun.messaging.Topic("ATJTopic");
			for (int i = 0; i < 10; i++) {
				String msg = "Message_" + i;
				jmsProducer.send(topic, msg);
				System.out.printf("Wiadomość '%s' została opublikowana.	\n", msg);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
		jmsContext.close();
	}

}
