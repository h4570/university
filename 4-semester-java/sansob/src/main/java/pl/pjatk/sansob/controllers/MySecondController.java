package pl.pjatk.sansob.controllers;

import org.springframework.stereotype.Component;

@Component
public class MySecondController {

    public MySecondController(){

    }

    public void helloFromMethod(){
        System.out.println("Hello from MySecondController.helloFromMethod");
    }

}
