package e1.book;

import e1.book.aop.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AopConfig {
    @Bean
    public Logger logger(){
        return new Logger();
    }
}
