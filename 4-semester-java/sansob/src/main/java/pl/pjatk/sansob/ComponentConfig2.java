package pl.pjatk.sansob;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pjatk.sansob.classes.Class1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class ComponentConfig2 {

    @Bean
    public Class1 class1() {
        return new Class1();
    }

    @Bean
    public List<String> defaultData(@Value("${my.custom.property:}") String prop) {
        System.out.println(prop);
        return List.of("1","2","3","4","5");
    }

}
