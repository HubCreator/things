package thigns.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NotionService {
    @Value("${notion.key}")
    private String notionKey;

    @Value("${notion.databaseId}")
    private String notionDatabaseId;

    private final WebClient webClient;

    public NotionService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.notion.com/v1").build();
    }

    public String addItem(String text) {

        return webClient.get()
                .uri("/blocks/{id}/children", notionDatabaseId)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + notionKey)
                .header("Notion-Version", "2022-06-28")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
