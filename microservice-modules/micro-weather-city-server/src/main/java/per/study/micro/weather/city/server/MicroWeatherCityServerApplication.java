package per.study.micro.weather.city.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroWeatherCityServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherCityServerApplication.class, args);
    }
}
