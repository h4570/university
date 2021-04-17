package pl.pjatk.sansob.controllers;

import org.springframework.stereotype.Component;

@Component
public class MyFirstController {

    public MyFirstController(MySecondController controller) {
        System.out.println("Hello from MyFirstController");
        controller.helloFromMethod();
    }

}
