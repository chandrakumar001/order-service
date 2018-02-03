package com.demo.order.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.yml")
public class RabbitMQdConfig {

    @Value("${rabbit.connection-url}")
    private String  url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "RabbitMQdConfig [url=" + url + "]";
	}
}