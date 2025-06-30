package service;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ScoreKafkaProducer {

    private static final String TOPIC = "score-events";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostConstruct
    public void testKafkaTemplate() {
        System.out.println("KafkaTemplate is injected: " + (kafkaTemplate != null));
    }

    public void sendScoreEvent(String message){
        kafkaTemplate.send(TOPIC,message);
        System.out.println("Message sent to Kafka topic: " + message);
    }

}
