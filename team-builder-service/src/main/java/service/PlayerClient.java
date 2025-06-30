package service;



import dto.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlayerClient {

    @Autowired
    private RestTemplate restTemplate;

    public PlayerDTO getPlayerById(String playerId) {
        String url = "http://localhost:8082/players/" + playerId;
        return restTemplate.getForObject(url, PlayerDTO.class);
    }
}
