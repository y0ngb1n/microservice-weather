package per.study.micro.weather.gateway.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class MicroWeatherGatewayZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherGatewayZuulApplication.class, args);
    }
}
