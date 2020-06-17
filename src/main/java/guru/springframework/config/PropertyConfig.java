package guru.springframework.config;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
public class PropertyConfig {
/*
In application.properties file we have given the keyword username. From there it will take the value and
in start of the class we have mentioned the classpath i.e the location of application.properties file.
 */
    @Value("${guru.username}")
    String user;

    @Value("${guru.password}")
    String password;

    @Value("${guru.dburl}")
    String url;
/*
One more Property file i have addded in resouce folder. Let's get value from it.
 */
    @Value("${guru.jms.username}")
    String jmsUserName;

    @Value("${guru.jms.password}")
    String jmsPassowrd;

    @Value("${guru.jms.url}")
    String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        /*
        We have created a class in examplebeans folder called FakeDataSource there we are storing this data
        which we are getting from application.properties file.
         */
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }
    /*
    To store data of jms.properties
     */
    @Bean
    public FakeJmsBroker fakeJmsBroker () {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUsername(jmsUserName);
        fakeJmsBroker.setPassword(jmsPassowrd);
        fakeJmsBroker.setUrl(jmsUrl);

        return fakeJmsBroker;
    }
/*
It will scan all the Property files that we have mentioned
 */
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
