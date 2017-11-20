package nl.bsoft.eip;

import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyExpression implements Expression {
    private static final Logger logger = LoggerFactory.getLogger(MyExpression.class);

    public <String> String evaluate(Exchange exchange, Class<String> aClass) {
        logger.info("Received aClass: {} from exchange: {}", aClass, exchange.toString());

        return null;
    }
}
