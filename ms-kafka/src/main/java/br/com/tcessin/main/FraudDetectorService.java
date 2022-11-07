package br.com.tcessin.main;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

public class FraudDetectorService {

	public static void main(String[] args) {

		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties());
		
		TopicPartition partition = new TopicPartition("ECOMMERCE_NEW_ORDER", 0);
		consumer.assign(Arrays.asList(partition));
        consumer.seek(partition, 7L);

		//consumer.subscribe(Collections.singletonList("ECOMMERCE_NEW_ORDER"));

		while (true) {
			
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(500));
			

			if (!records.isEmpty()) {

				System.out.println("Encontrei "+ records.count() + " Registros");
				for (ConsumerRecord<String, String> record : records) {

					System.out.println("Processsing new order");
					System.out.println(record.key());
					System.out.println(record.value());
					System.out.println(record.partition());
					System.out.println(record.offset());

					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					System.out.println("Order processed");
				}
			}
		}

	}

	private static Properties properties() {
		Properties properties = new Properties();
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, FraudDetectorService.class.getSimpleName());
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");


		return properties;
	}

}
