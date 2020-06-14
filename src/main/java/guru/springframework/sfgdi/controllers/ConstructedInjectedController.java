package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructedInjectedController {
    private final GreetingService greetingService;


    //For Constructor this is the way to give qualifier
    //constructorGreetingService is the name of service so yes this service to wire with this COntroller
    /*
    We need this because we have created the object of GreetingService Interface. Now That interface
    is extended by all 3 services.SO which service to call so thats why we need to give qualifier
    saying yes this controller is associated with that specific service
     */
    @Autowired
    public ConstructedInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
