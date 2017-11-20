package nl.bsoft.eip;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.NotifyBuilder;
//import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/*
@RunWith(SpringRunner.class)
@SpringBootTest


*/
@RunWith(SpringRunner.class)


@SpringBootTest
public class EipDemoApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(EipDemoApplicationTests.class);

    @Test
    public void contextLoads() {
    }

    @Autowired
    private CamelContext camelContext;

    @Ignore("Requires a running activemq broker")
    public void shouldProduceMessages() throws Exception {
        logger.info("Start shouldProduceMessages 00");
        NotifyBuilder notify = new NotifyBuilder(camelContext).whenDone(1).create();

        assertTrue(notify.matches(10, TimeUnit.SECONDS));
    }
}
