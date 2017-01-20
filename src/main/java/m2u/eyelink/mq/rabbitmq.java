package m2u.eyelink.mq;

import java.io.IOException;

import com.rabbitmq.client.*;

public class rabbitmq {
	private final static String HOST_NAME = "localhost";
	private final static int PORT = 5672;
	private final static String QUEUE_NAME = "hello";

	public static boolean Send(String message) throws Exception {
		boolean bTF = false;
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST_NAME);
		factory.setPort(PORT);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		try {
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			channel.basicPublish("", QUEUE_NAME, null,
					message.getBytes("UTF-8"));
			System.out.println(" [x] Sent '" + message + "'");

			channel.close();
			connection.close();
			bTF = true;
		} catch (Exception e) {
			try {
				channel.close();
			} catch (Exception ex) {
			}
			try {
				connection.close();
			} catch (Exception ex) {
			}
		}
		return bTF;
	}

	public static String Recv() throws Exception {
		String rtnMsg = "";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST_NAME);
		factory.setPort(PORT);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		try {

			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			System.out
					.println(" [*] Waiting for messages. To exit press CTRL+C");

			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag,
						Envelope envelope, AMQP.BasicProperties properties,
						byte[] body) throws IOException {
					String rtnMsg = new String(body, "UTF-8");
					System.out.println(" [x] Received '" + rtnMsg + "'");
					processMessage(rtnMsg);
				}
			};
			channel.basicConsume(QUEUE_NAME, true,
					consumer);
		} catch (Exception e) {
		}
		return rtnMsg;
	}

	public static String processMessage(String rtnMsg) {
		System.out.println(rtnMsg);
		return "";
	}
}
