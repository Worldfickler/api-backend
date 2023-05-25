package com.fickler.apiclientsdk;

import com.fickler.apiclientsdk.client.ApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author dell
 * @date 2023/5/22 17:02
 */

@Data
@Configuration
@ConfigurationProperties("api.client")
@ComponentScan
public class ApiClientConfig {

    private String accessKey;
    private String secretKey;

    @Bean
    public ApiClient apiClient() {
        return new  ApiClient(accessKey, secretKey);
    }

}
