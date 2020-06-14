
/*
Till now we had Seen manual dependency injection then automated injection using service and autowired
then we have seen qualifirs  then we have seen primary beans.
 */
/*
Now we have given a name to a service calling it as service profiler. Check i18nEnglishGreetingService
there we have given alias to service i.e i18nService
 */
/*
Now we can give it as a qualifier i.e directly in controller we will give that servie name and profile
HEre we have created to i18n services with same service alias so now we have given a profile to them
to distinguish between two services.
Now when we will run it will pick profile. We have to specify the active profile in resources/application.properties
there we have to mention one active profile and bean will run that.
 */

package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/*
Now Inteelij is looking for all the classes and package which are inside guru.springframework.sfgdi
as our SfgDiApplication is inside this folder. But what if some folder is outside sfgdi.
Inteelij will not compile that and will throw some error.
Suppose i copy my services folder outside the sfgdi directory then i have to explicitly tell
my springbootapplication to scan this folder.
This task is performed by @ComponentScan annotation
 */
/*
BElow is the syntax of ComponentScan
Assume we have copied services folder outside even though we have not. just assume
One thing to note is that once we have given component annotation we have to then explicitly tell
the path of all packages even the current one.
 */
//@ComponentScan(basePackages = "guru.springframework.services","guru.springframework.sfgdi")
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {




		//Run method here run any application context. We are creating a
		//application context ctx
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		//i18nService
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());




		//MyController is a class and we are creating a bean using the mycontroller objext
		MyController myController = (MyController) ctx.getBean("myController");


		System.out.println(myController.sayHello());

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		//Do Same for setter based

		SetterInjectedController setterInjectedController= (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		ConstructedInjectedController constructedInjectedController= (ConstructedInjectedController) ctx.getBean("constructedInjectedController");
		System.out.println(constructedInjectedController.getGreeting());

	}

}
