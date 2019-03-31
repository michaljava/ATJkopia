package atj;

import javax.jms.JMSException;

public class Main {

	public static void main(String[] args) throws JMSException, InterruptedException {
		Consumer consument=new Consumer("localhost:7676/jms", "ATJQueue");
		consument.receiveQueueMessage();

	}

}
