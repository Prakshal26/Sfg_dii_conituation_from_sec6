/*
This is a new mechanism to store the data by using the property source. Check the folder
resources/datasource.properties. There we are giving our data i.e user name, password etc etc.
We have created Propertyconfig class under Config folder where we are controlling the data.
 */
/*
Earlier we had created to datasource and jms properties file but now we have remved them and put it's
content in application.properties which is inbuild property file supported by spring.
 */
/*
In video 91 we have started with Yaml so instead of putting data in jms.properties etc etc
we have created a common yaml file and there we can put our data easily.
To learn yaml syntax see example.yml file.
 */
package guru.springframework;

import guru.springframework.controllers.ConstructorInjectedController;
import guru.springframework.controllers.GetterInjectedController;
import guru.springframework.controllers.MyController;
import guru.springframework.controllers.PropertyInjectedController;
import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"guru.springframework.services", "guru.springframework"})
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");
/*
Printing the data that we got from application.properties file which is now stored in FakeDatasoruce
 */
		FakeDataSource fakeDataSource = (FakeDataSource)ctx.getBean(FakeDataSource.class);

		System.out.println(fakeDataSource.getUser());

		FakeJmsBroker fakeJmsBroker = (FakeJmsBroker)ctx.getBean(FakeJmsBroker.class);
		System.out.println(fakeJmsBroker.getUsername());
	}
}
