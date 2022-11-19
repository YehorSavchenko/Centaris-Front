package frontend.generator;
import frontend.services.ItemsService;
import frontend.services.TrafficService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TrafficGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrafficGenerator.class);
    private final TrafficService trafficService;
    private final ItemsService itemsService;

    public TrafficGenerator(TrafficService trafficService, ItemsService itemsService) {
        this.trafficService = trafficService;
        this.itemsService = itemsService;
    }

    @Scheduled(fixedRate = 1000)
    void sendRequest() {
        LOGGER.info("Creating request");
        itemsService.sendGetAllItemsRequest();
    }
}