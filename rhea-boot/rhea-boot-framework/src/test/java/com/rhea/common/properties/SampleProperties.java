package com.rhea.common.properties;

import com.rhea.common.annotation.ConfigChangeListener;
import com.rhea.common.api.ConfigChangeObject;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "redis.cache")
public class SampleProperties {
    private int expireSeconds;
    private String clusterNodes;
    private int commandTimeout;

    @ConfigChangeListener
    public void onChange(ConfigChangeObject changeEvent) {
        for (String changedKey : changeEvent.changedKeys()) {
            if (changedKey.startsWith("redis.cache.commandTimeout")) {
                String newValue = changeEvent.getChange(changedKey).getNewValue();
                this.commandTimeout = Integer.valueOf(newValue);
                System.out.println("ApolloConfigChangeListener" + this.hashCode());
                System.out.println(newValue);
                break;
            }
        }
    }
}