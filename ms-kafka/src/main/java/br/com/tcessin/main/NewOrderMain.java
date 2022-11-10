package br.com.tcessin.main;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class NewOrderMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		KafkaProducer<String, String> producer = new KafkaProducer<>(properties());

		String value = "12133,114324, new_MSG";
		ProducerRecord<String, String> producerRecord = new ProducerRecord<>("ECOMMERCE_NEW_ORDER", 0, value, value);
		
		Callback callBack = (data, ex) -> {

			if (ex != null) {
				ex.printStackTrace();

				return;
			}

			System.out.println("SUCESSO: Topic: " + data.topic() + ":::/partition" + data.partition() + "/offset"
					+ data.offset() + "/timestamp" + data.timestamp());
		};

		String email = "Welcome! we are processing your order";
		ProducerRecord<String, String> emailRecord = new ProducerRecord<>("ECOMMERCE_SEND_EMAIL", email,email);
		
		
		producer.send(producerRecord, callBack).get();
		producer.send(emailRecord, callBack).get();

	}

	private static Properties properties() {

		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		return properties;

	}

}
