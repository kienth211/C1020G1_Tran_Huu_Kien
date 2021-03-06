package e1.book;

import e1.book.aop.Logger;
import org.springframework.context.annotation.Bean;

public class AOP_config {
    @Bean
    public Logger logger(){
        return new Logger();
    }
}
