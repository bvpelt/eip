package nl.bsoft.eip;

import org.apache.camel.CamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {
    private static final Logger logger = LoggerFactory.getLogger(MyAppConfig.class);

    @Autowired
    CamelContext camelContext;

    public void MyAppConfig() {
        logger.info("Started MyAppConfig");
    }

    /*
    @Bean
    MyService myService() {
        return new DefaultMyService(camelContext);
    }
*/
}