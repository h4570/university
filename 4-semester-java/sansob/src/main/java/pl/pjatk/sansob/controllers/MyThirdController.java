package pl.pjatk.sansob.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import pl.pjatk.sansob.MySimpleClass;

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
//        MySimpleClass myFirstSimpleClass = context.getBean("mySimpleClass",MySimpleClass.class);
//        MySimpleClass mySecondSimpleClass = context.getBean("mySecondSimpleClass",MySimpleClass.class);
//
//        System.out.println(myFirstSimpleClass.getName());
//        System.out.println(mySecondSimpleClass.getName());
//    }

    // DI option 2
//    public MyThirdController(
//            MyFirstController firstController,
//            MySecondController secondController,
//            MySimpleClass mySimpleClass,
//            MySimpleClass mySecondSimpleClass
//    ){
//        secondController.helloFromMethod();
//        System.out.println("Hello from MyThirdComponent");
//        System.out.println(mySimpleClass.getName());
//        System.out.println(mySecondSimpleClass.getName());
//    }

    // DI - XML
    public MyThirdController(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("Hello from MyThirdComponent");
        MySimpleClass myFirstSimpleClass = context.getBean("mySimpleClass",MySimpleClass.class);
        MySimpleClass mySecondSimpleClass = context.getBean("mySecondSimpleClass",MySimpleClass.class);

        System.out.println(myFirstSimpleClass.getName());
        System.out.println(mySecondSimpleClass.getName());
    }

}
