package frontend.generator;
import frontend.services.TrafficService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TrafficGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrafficGenerator.class);
    private final TrafficService trafficService;

    public TrafficGenerator(TrafficService trafficService) {
        this.trafficService = trafficService;
    }

    @Scheduled(fixedRate = 1000)
    void sendRequest() {
        LOGGER.info("Creating request");
        trafficService.sendRequest();
    }
}