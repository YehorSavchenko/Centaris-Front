package frontend.services;

import model.ItemList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemsService.class);
    private TrafficService trafficService;

    @Value("${connections.proxy}")
    private String proxyUrl;

    public ItemsService(TrafficService trafficService) {
        this.trafficService = trafficService;
    }

    public void sendGetAllItemsRequest() {
        LOGGER.info("Sending request to {}", proxyUrl);
        ItemList itemListResponse = (ItemList) trafficService
                .sendEmptyRequest("/items/get/all", ItemList.class);
        LOGGER.info("Received {}", itemListResponse);
    }

}
