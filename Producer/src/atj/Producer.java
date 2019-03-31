package atj;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Queue;

public class Producer {
	private JMSContext jmsContext;
	private JMSProducer jmsProducer;
	private Queue queue;

	Producer(String url, String queueName) throws JMSException {
		ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
		// [hostName][:portNumber][/serviceName]
		// 7676 numer portu, na którym JMS Service nasłuchuje połączeń
		// "localhost:7676/ jms "

		jmsContext = connectionFactory.createContext();
		((com.sun.messaging.ConnectionFactory) connectionFactory)
				.setProperty(com.sun.messaging.ConnectionConfiguration.imqAddressList, url);
		jmsProducer = jmsContext.createProducer();
		queue = new com.sun.messaging.Queue(queueName); // "ATJQueue"
				
	}
	

	public void sendQueueMessage(String msg) {
		jmsProducer.send(queue, msg);
	}

	protected void finalize() {
		if (jmsContext != null)
			jmsContext.close();
	}
}