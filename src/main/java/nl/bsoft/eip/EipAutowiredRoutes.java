package nl.bsoft.eip;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
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

        // configure to use restlet on localhost with the given port
        // and enable auto binding mode
        int portNum = 8888;
        restConfiguration().component("restlet").host("localhost").port(portNum).bindingMode(RestBindingMode.auto);

        /*
        from("timer:bar?fixedRate=true&period=1000")
                .setHeader("Discriminator", simple("${random(20)}") )
                .setBody(constant("Hello from Camel"))
                .to("activemq:queue:MyQueue");
        */

        from("timer:bar?fixedRate=true&period=1")
                .setHeader("Discriminator", simple("${random(20)}") )
                .setHeader("mydest", simple("activemq:queue:MyQueue,activemq:queue:MyLog,direct:database"))
                .setBody(constant("Hello from Camel"))
                .process(myprocessor)
                .recipientList(header("mydest"))
                .stopOnException();

        from("activemq:queue:MyQueue")
                .to("log:sample?showHeaders=true");

        from("activemq:queue:MyLog")
                .resequence(header("Discriminator")).batch().size(20).timeout(200)
                .to("log:resequenced?showHeaders=true");

        from("direct:database")
                .setBody(simple("insert into datatest (data) values('${in.body}')"))
                .to("jdbc:dataSource");


        /*
        from("activemq:queue:MyLog")
                .resequence(header("Discriminator")).stream().capacity(20).timeout(500).delay(200)
                .to("log:resequenced?showHeaders=true");
        */

        from("timer://foo?fixedRate=true&period=5000")
                .to("bean:myBean?method=someMethodName");

        rest("/users/")
                .get().to("direct:users");

        from("direct:users")
                .setBody(simple("select * from users"))
                .to("jdbc:dataSource");

        logger.info("Configure routes - end");
    }

}
