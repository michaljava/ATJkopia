package atj;

import java.util.Enumeration;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.TextMessage;

public class Consumer {
	private JMSContext jmsContext;
	private JMSConsumer jmsConsumer;
	private Queue queue;

	Consumer(String url, String queueName) throws JMSException, InterruptedException {
		ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
		// [hostName][:portNumber][/serviceName]
		// 7676 numer portu, na którym JMS Service nasłuchuje połączeń
		// "localhost:7676/ jms "

		jmsContext = connectionFactory.createContext();
		((com.sun.messaging.ConnectionFactory) connectionFactory)
				.setProperty(com.sun.messaging.ConnectionConfiguration.imqAddressList, url);
		queue = new com.sun.messaging.Queue(queueName); // "ATJQueue"
		jmsConsumer = jmsContext.createConsumer(queue);

		receiveQueueMessageAsync();
	}

	public String receiveQueueMessage() throws JMSException {
		Message msg = jmsConsumer.receive(10); // 10 ms
		if (msg instanceof TextMessage)
			return ((TextMessage) msg).getText();
		return null;
	}

	public void receiveQueueMessageAsync() throws InterruptedException {
		jmsConsumer.setMessageListener(new AsynchConsumer());
		for (int i = 0; i < 30; ++i) { // 30 sekund
			System.out.println("Konsument wykonuje zadanie");
			Thread.sleep(1000);
		}
	}

	public void browseQueue() throws JMSException {
		QueueBrowser queueBrowser = jmsContext.createBrowser(queue);
		@SuppressWarnings("rawtypes")
		Enumeration messageEnumeration = queueBrowser.getEnumeration();
		while (messageEnumeration.hasMoreElements()) {
			TextMessage txtMsg = (TextMessage) messageEnumeration.nextElement();
			System.out.println(txtMsg.getText());
		}
	}

	protected void finalize() {
		if (jmsConsumer != null)
			jmsConsumer.close();
		if (jmsContext != null)
			jmsContext.close();
	}

}