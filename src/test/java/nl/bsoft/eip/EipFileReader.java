package nl.bsoft.eip;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.NotifyBuilder;
// import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(CamelSpringBootRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EipDemoApplication.class)
public class EipFileReader {

    private static final Logger logger = LoggerFactory.getLogger(EipFileReader.class);

    @Autowired
    private CamelContext camelContext;

    @Ignore("Requires a running activemq broker")
    public void shouldProduceMessages() throws Exception {
        logger.info("Start shouldProduceMessages");
        NotifyBuilder notify = new NotifyBuilder(camelContext).whenDone(1).create();

        assertTrue(notify.matches(10, TimeUnit.SECONDS));
    }
}
