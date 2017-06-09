package hello;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.hellojd.jpetstore.domain.service")
@Lazy
public class JpetStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpetStoreApplication.class, args);
    }
}