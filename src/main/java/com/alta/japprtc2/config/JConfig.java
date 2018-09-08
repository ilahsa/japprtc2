package com.alta.japprtc2.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by baiba on 2018-09-08.
 */
@Component
@Configuration
@Data
public class JConfig {
    @Getter
    @Value("${alta.version}")
    public String Version;
}
