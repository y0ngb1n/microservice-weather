package per.study.micro.weather.config.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroWeatherConfigClientApplicationTests {

    @Value("${author}")
    private String author;

    @Test
    public void contextLoads() {
        assert "yangbin".equals(author);
    }

}
