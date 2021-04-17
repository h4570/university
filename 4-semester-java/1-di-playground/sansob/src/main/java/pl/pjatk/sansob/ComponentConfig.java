package pl.pjatk.sansob;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pjatk.sansob.classes.Class1;

import java.util.List;

@Configuration
public class ComponentConfig {

    @Bean
    public Class1 class1() {
        return new Class1();
    }

    @Bean
    public List<String> defaultData(@Value("${my.custom.property:}") String prop) {
        return List.of("1","2","3","4","5");
    }

    @Bean
    @ConditionalOnProperty(name = "my.custom.property2", havingValue = "true")
    public boolean defaultProp(@Value("${my.custom.property2}") boolean prop2) {
        System.out.println("Conditional Bean created!");
        return prop2;
    }

}
