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

    @Autowired MyProcessor myprocessor;

    @Override
    public void configure() throws Exception {
        logger.info("Configure routes - start");

        /*
        from("timer:bar?fixedRate=true&period=1000")
                .setHeader("Discriminator", simple("${random(20)}") )
                .setBody(constant("Hello from Camel"))
                .to("activemq:queue:MyQueue");
        */

        from("timer:bar?fixedRate=true&period=10")
                .setHeader("Discriminator", simple("${random(20)}") )
                .setHeader("mydest", simple("activemq:queue:MyQueue,activemq:queue:MyLog"))
                .setBody(constant("Hello from Camel"))
                .process(myprocessor)
                .recipientList(header("mydest"))
                .stopOnException();

        from("activemq:queue:MyQueue")
                .to("log:sample?showHeaders=true");

        from("activemq:queue:MyLog")
                .resequence(header("Discriminator")).batch().size(20).timeout(200)
                .to("log:resequenced?showHeaders=true");

        /*
        from("activemq:queue:MyLog")
                .resequence(header("Discriminator")).stream().capacity(20).timeout(500).delay(200)
                .to("log:resequenced?showHeaders=true");
        */

        from("timer://foo?fixedRate=true&period=5000")
                .to("bean:myBean?method=someMethodName");

        logger.info("Configure routes - end");
    }

}
