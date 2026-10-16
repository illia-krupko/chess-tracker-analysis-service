package krupkoillia.chesstracker.analysisservice.config;

import com.google.genai.Client;
import com.google.genai.types.HttpOptions;
import com.google.genai.types.HttpRetryOptions;
import krupkoillia.chesstracker.analysisservice.GeminiProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GeminiConfig {

    private final GeminiProperties properties;

    @Bean
    public Client geminiClient() {
        HttpOptions httpOptions = HttpOptions.builder()
                .timeout(10_000)
                .retryOptions(
                    HttpRetryOptions.builder()
                        .attempts(3)
                        .build()
                )
                .build();

        return Client.builder()
                .apiKey(properties.apiKey())
                .httpOptions(httpOptions)
                .build();
    }

}
