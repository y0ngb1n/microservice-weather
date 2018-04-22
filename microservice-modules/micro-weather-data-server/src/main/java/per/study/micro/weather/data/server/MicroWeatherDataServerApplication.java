package per.study.micro.weather.data.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroWeatherDataServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherDataServerApplication.class, args);
    }
}
