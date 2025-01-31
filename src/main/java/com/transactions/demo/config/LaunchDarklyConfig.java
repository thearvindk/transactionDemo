package com.transactions.demo.config;

import com.launchdarkly.sdk.server.LDClient;
import com.launchdarkly.sdk.server.LDConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LaunchDarklyConfig {

    private static final String SDK_KEY = "sdk-41e297dc-c696-45dd-9803-154f0019d297"; // Replace with your actual SDK Key

    @Bean
    LDClient ldClient() {
        LDConfig config = new LDConfig.Builder().build();

        return new LDClient(SDK_KEY, config);
    }
}
