package pl.pjatk.sansob.controllers;

import org.springframework.stereotype.Component;
import pl.pjatk.sansob.classes.Class1;

@Component
public class MySecondController {

    public MySecondController(boolean defaultProp){
        System.out.println("Hello from MySecondController constructor");
        System.out.println("Is property2 included?: " + defaultProp);
    }

    public void helloFromMethod(){
        System.out.println("Hello from MySecondController.helloFromMethod");
    }

}
