package com.ymt.example.config;

import com.microsoft.azure.AzureEnvironment;
import com.microsoft.azure.spring.cloud.context.core.api.EnvironmentProvider;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ChinaEnvironmentProvider implements EnvironmentProvider {

    private AzureEnvironment environment = AzureEnvironment.AZURE_CHINA;

    @Override
    public AzureEnvironment getEnvironment() {
        return environment;
    }

    public void setEnvironment(@NonNull AzureEnvironment environment) {
        this.environment = environment;
    }
}
