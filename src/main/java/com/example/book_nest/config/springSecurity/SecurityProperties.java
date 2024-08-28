package com.example.book_nest.config.springSecurity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "spring.security")
@Getter
@Setter
public class SecurityProperties {
    private List<String> noAuthUrls;
}

