package per.study.micro.weather.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroWeatherEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherEurekaServerApplication.class, args);
    }
}
