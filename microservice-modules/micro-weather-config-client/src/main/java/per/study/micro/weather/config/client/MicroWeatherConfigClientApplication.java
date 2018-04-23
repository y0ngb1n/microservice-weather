package per.study.micro.weather.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroWeatherConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherConfigClientApplication.class, args);
    }
}
