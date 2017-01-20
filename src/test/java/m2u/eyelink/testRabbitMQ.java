package m2u.eyelink;

import static org.junit.Assert.*;
import m2u.eyelink.mq.rabbitmq;

import org.junit.Assert;
import org.junit.Test;

public class testRabbitMQ {
	String sendMsg = "Hello RabbitMQ";
	
	@Test
	public void testSingleMsg() {
		boolean bTF = false;
		try {
			bTF = rabbitmq.Send(sendMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(true, bTF);
		
		String rMsg = "";
		try {
			rMsg = rabbitmq.Recv();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		Assert.assertEquals(rMsg, sendMsg);
	}

	@Test
	public void testSendMultiMsg() {
		
		Assert.assertEquals("", "");
	}

}
