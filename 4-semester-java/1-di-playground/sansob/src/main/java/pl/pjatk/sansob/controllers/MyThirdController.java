package pl.pjatk.sansob.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pl.pjatk.sansob.classes.Class1;

import java.util.List;

@Component
public class MyThirdController {

// DI option 1
//    public MyThirdController(ApplicationContext context){
//        var myFirstController = context.getBean("", MyFirstController.class);
//        var mySecondController = context.getBean("", MySecondController.class);
//        mySecondController.helloFromMethod();
//
//        System.out.println("Hello from MyThirdComponent");
//
//        Class2 myFirstSimpleClass = context.getBean("mySimpleClass", Class2.class);
//        Class2 mySecondSimpleClass = context.getBean("mySecondSimpleClass", Class2.class);
//
//        System.out.println(myFirstSimpleClass.getName());
//        System.out.println(mySecondSimpleClass.getName());
//    }

// DI option 2
//    public MyThirdController(
//            MyFirstController firstController,
//            MySecondController secondController,
//            Class2 class2,
//            Class2 mySecondSimpleClass
//    ){
//        secondController.helloFromMethod();
//        System.out.println("Hello from MyThirdComponent");
//        System.out.println(class2.getName());
//        System.out.println(mySecondSimpleClass.getName());
//    }

// DI - XML
//    public MyThirdController(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        System.out.println("Hello from MyThirdComponent");
//        Class2 myFirstSimpleClass = context.getBean("mySimpleClass", Class2.class);
//        Class2 mySecondSimpleClass = context.getBean("mySecondSimpleClass", Class2.class);
//
//        System.out.println(myFirstSimpleClass.getName());
//        System.out.println(mySecondSimpleClass.getName());
//    }

    // DI - Playground
    public MyThirdController(ApplicationContext context) {
        var class1 = context.getBean(Class1.class);
        class1.setMember1("Hello there.");
        System.out.println(class1.getMember1());
    }

}
