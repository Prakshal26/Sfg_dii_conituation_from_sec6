package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//We have given name to our service and profile
@Profile("EN")
@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService  {

    @Override
    public String sayGreeting()
    {
        return "hello world English";
    }
}
