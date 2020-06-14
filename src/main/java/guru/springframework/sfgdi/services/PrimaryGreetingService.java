package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//We have to specify this as a primary service
/*
Precedence will be given to qualifier and if qualifier is not found that it will take
it as prmary service.
 */
@Primary
@Service
public class PrimaryGreetingService  implements GreetingService{

    @Override
    public String sayGreeting() {
        return "hello world Primary Greeting from Primary Bean";
    }
}
