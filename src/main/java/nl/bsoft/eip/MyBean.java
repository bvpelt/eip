package nl.bsoft.eip;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
    private static final Logger logger = LoggerFactory.getLogger(MyBean.class);

    public MyBean() {
    }

    public void someMethodName() {

        logger.debug("Called");
    }

}
