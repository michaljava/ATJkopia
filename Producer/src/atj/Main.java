package atj;

import javax.jms.JMSException;

public class Main {

	public static void main(String[] args) throws JMSException {
		Producer prod=new Producer("localhost:7676/jms", "ATJQueue");
		for(int i=0;i<10;i++){
			prod.sendQueueMessage("aaa"+i);
		}
		
	}

}
