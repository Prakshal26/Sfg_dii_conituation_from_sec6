package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

//We also have to specify that this is a service. This will be checked By autowired that we have given
//in COntroller. We have created the object of Gretting Servoce there and mentioned autowired i.e specifyng
//that this is a service. But here we are explicitly saying yes this is a service.
@Service
public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {

        return "HelloWorld Constructor";
    }
}
