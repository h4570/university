package pl.pjatk.sansob.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pl.pjatk.sansob.classes.Class1;

import java.util.List;

@Component
public class MyFourthController {


    public MyFourthController(ApplicationContext context){
        var list = (List<String>) context.getBean("defaultData");
//        System.out.println(list);
    }

}
