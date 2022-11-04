package br.com.tcessin.main;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class NewOrderMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		KafkaProducer<String, String> producer = new KafkaProducer<>(properties());

		String value = "12133,114324, 234";
		ProducerRecord<String, String> producerRecord = new ProducerRecord<>("LOJA_NOVO_PEDIDO", 0, value, value);

		producer.send(producerRecord, (data, ex) -> {

			if (ex != null) {
				ex.printStackTrace();

				return;
			}

			System.out.println("SUCESSO: Topic: " + data.topic() + ":::/partition" + data.partition() + "/offset"
					+ data.offset() + "/timestamp" + data.timestamp());
		}).get();

	}

	private static Properties properties() {

		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		return properties;

	}

}
