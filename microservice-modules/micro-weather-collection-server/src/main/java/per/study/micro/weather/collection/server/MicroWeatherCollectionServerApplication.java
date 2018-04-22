package per.study.micro.weather.collection.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroWeatherCollectionServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherCollectionServerApplication.class, args);
    }
}
