package nl.bsoft.eip;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EipAutowiredRoutes extends RouteBuilder {
    private static final Logger logger = LoggerFactory.getLogger(EipAutowiredRoutes.class);

    @Autowired MyBean mybean;

    @Override
    public void configure() throws Exception {
        logger.info("Configure routes - start");

        from("activemq:queue:MyQueue")
                .setHeader("Discriminator01", simple("${random(20)}") )
                .to("log:sample?showHeaders=true");

        from("timer:bar?fixedRate=true&period=1000")
                .setHeader("Discriminator", simple("${random(20)}") )
                .setBody(constant("Hello from Camel"))
                .to("activemq:queue:MyQueue");

        from("timer://foo?fixedRate=true&period=5000")
                .to("bean:myBean?method=someMethodName");

        logger.info("Configure routes - end");
    }

}
