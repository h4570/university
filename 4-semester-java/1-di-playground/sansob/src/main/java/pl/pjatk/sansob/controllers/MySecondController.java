package pl.pjatk.sansob.controllers;

import org.springframework.stereotype.Component;
import pl.pjatk.sansob.classes.Class1;

@Component
public class MySecondController {

    public MySecondController(){
        System.out.println("Hello from MySecondController constructor");
    }

    public void helloFromMethod(){
        System.out.println("Hello from MySecondController.helloFromMethod");
    }

}
