package service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class ScoreEventListener {

    private static final Logger log = LoggerFactory.getLogger(ScoreEventListener.class);

    @KafkaListener(topics = "score-events", groupId = "notification-group")
    public void listen(String message){
        log.info("🔔 New Score Update Received: {}", message);
        System.out.println("📧 sending notification: " + message);
    }


    @KafkaListener(topics = "score-events", groupId = "notification-group")
    public void consumeScoreEvent(String message) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(message);

            String output = String.format(
                    "Match: %s | Over: %d.%d | %s scored %d run(s) off %s%s",
                    node.get("matchId").asText(),
                    node.get("over").asInt(),
                    node.get("ball").asInt(),
                    node.get("batsman").asText(),
                    node.get("runs").asInt(),
                    node.get("bowler").asText(),
                    node.get("wicket").asBoolean() ? " [WICKET]" : ""
            );

            System.out.println("📢 NOTIFICATION: " + output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
