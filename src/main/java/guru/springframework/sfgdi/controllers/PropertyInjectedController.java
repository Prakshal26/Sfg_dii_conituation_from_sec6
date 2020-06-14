package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Controller;

//We have to manually specify this as controller so that automatic Dependecy Injection is done
@Controller
public class PropertyInjectedController {

    //We have to give Qualifier as there are three services so to which service to use.
    //Class NAme: PropertyInjectedGreetingService Bean Name: propertyInjectedGreetingService
     @Qualifier("propertyInjectedGreetingService")
    //Autowired tells Spring that we want the injection of GrettingServices
    @Autowired
    public GreetingService greetingService;

    public String getGreeting(){

        return greetingService.sayGreeting();
    }
}
