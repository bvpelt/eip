package nl.bsoft.eip;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.soap.Text;

@Component
public class MyBean  {
    private static final Logger logger = LoggerFactory.getLogger(MyBean.class);

    public MyBean() {}

    public void someMethodName() {

        logger.debug("Called");
    }

}
