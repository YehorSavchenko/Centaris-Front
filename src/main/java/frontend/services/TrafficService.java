package frontend.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import model.test.TestRequest;
import model.test.TestResponse;

@Service
public class TrafficService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrafficService.class);
    private final WebClient webClient;
    @Value("${connections.proxy}")
    private String proxyUrl;

    public TrafficService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Object sendRequest(String uri, Object request, Class<?> response) {
        LOGGER.info("Sending request to {}", proxyUrl);
        return webClient.method(HttpMethod.GET)
                .uri(proxyUrl + uri)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(response)
                .block();
    }

    public Object sendEmptyRequest(String uri, Class<?> response) {
        LOGGER.info("Sending request to {}", proxyUrl);
        return webClient.method(HttpMethod.GET)
                .uri(proxyUrl + uri)
                .retrieve()
                .bodyToMono(response)
                .block();
    }
}