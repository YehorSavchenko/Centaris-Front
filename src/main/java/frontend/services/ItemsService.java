package frontend.services;

import model.ItemList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemsService.class);
    private final TrafficService trafficService;

    @Value("${connections.proxy}")
    private String proxyUrl;

    public ItemsService(TrafficService trafficService) {
        this.trafficService = trafficService;
    }

    public ItemList sendGetAllItemsRequest() {
        LOGGER.info("Sending GetAllItemsRequest to {}", proxyUrl);
        ItemList itemListResponse = (ItemList) trafficService
                .sendEmptyRequest("/items/get/all", ItemList.class);
        LOGGER.info("Received {}", itemListResponse);

        return itemListResponse;
    }

    public void sendGetDistrictItemsRequest(String district) {
        LOGGER.info("Sending GetDistrictItemsRequest to {}", proxyUrl);
        ItemList itemListResponse = (ItemList) trafficService
                .sendEmptyRequest("/items/get/district/" + district, ItemList.class);
        LOGGER.info("Received {}", itemListResponse);
    }

    public void sendGetCategoryItemsRequest(String category) {
        LOGGER.info("Sending GetCategoryItemsRequest to {}", proxyUrl);
        ItemList itemListResponse = (ItemList) trafficService
                .sendEmptyRequest("/items/get/category/" + category, ItemList.class);
        LOGGER.info("Received {}", itemListResponse);
    }

    public void sendGetCategoryAndDistrictItemsRequest(String category, String district) {
        LOGGER.info("Sending CategoryAndDistrictItemsRequest to {}", proxyUrl);
        ItemList itemListResponse = (ItemList) trafficService
                .sendEmptyRequest("/items/get/categoryanddistrict/" + category + "&" + district, ItemList.class);
        LOGGER.info("Received {}", itemListResponse);
    }

}
