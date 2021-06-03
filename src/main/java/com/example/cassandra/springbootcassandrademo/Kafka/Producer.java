package com.example.cassandra.springbootcassandrademo.Kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {

    public static void main(String[] args){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String,String> first_producer = new KafkaProducer<String, String>(properties);
        ProducerRecord<String, String> record=new ProducerRecord<String, String>("my_first", "Hye Kafka");

        first_producer.send(record);
        first_producer.flush();
        first_producer.close();
    }
}
