package per.study.micro.weather.report.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroWeatherReportServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherReportServerApplication.class, args);
    }
}
