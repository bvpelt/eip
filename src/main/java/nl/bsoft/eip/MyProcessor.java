package nl.bsoft.eip;


import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MyProcessor implements Processor {
    private static final Logger logger = LoggerFactory.getLogger(MyProcessor.class);

    public void process(Exchange exchange) throws Exception {
        /*
        Date created = exchange.getCreated();
        String exchangeId = exchange.getExchangeId();
        String exchangeRouteId = exchange.getFromRouteId();

        Endpoint endpoint = exchange.getFromEndpoint();
        String endpointKey = endpoint.getEndpointKey();
        String endpointUri = endpoint.getEndpointUri();

        showProperties(exchange);

        showComponents(exchange);

        showHeaders(exchange);

        showMessage(exchange);
*/
        String newBody = exchange.getIn().getBody() + " " + exchange.getIn().getHeader("Discriminator");
        exchange.getIn().setBody(newBody);
/*
        logger.info("created: {}, endpoint key: {}, endpoint uri: {}", created.toString(), endpointKey, endpointUri);
        logger.info("exchange-id: {}, route-id: {}", exchangeId, exchangeRouteId);
*/
    }

    private void showMessage(Exchange exchange) {
        Message message = exchange.getIn();
        String messageId = message.getMessageId();
        Object messageObject = message.getBody();
        boolean hasAttachments = message.hasAttachments();
        boolean hasHeaders = message.hasHeaders();
        boolean isFault = message.isFault();

        logger.info("message :: message-id: {}, message-isFault: {}, message-hasheaders: {}, message-hasattachments: {}, message-body: {}", messageId, isFault, hasHeaders, hasAttachments, messageObject.toString());
    }

    private void showHeaders(Exchange exchange) {
        Message message = exchange.getIn();
        Map<String, Object> headers = message.getHeaders();
        Set<String> keyset = headers.keySet();
        Iterator<String> keyIterator = keyset.iterator();

        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            Object object = headers.get(key);
            boolean logged = false;

            if (object instanceof String) {
                String value = (String) headers.get(key);
                logged = true;
                logger.info("headers :: key: {}, value: {}", key, value);
            }
            if (object instanceof Integer) {
                Integer value = (Integer) headers.get(key);
                logged = true;
                logger.info("headers :: key: {}, value: {}", key, value);
            }
            if (object instanceof Date) {
                Date value = (Date) headers.get(key);
                logged = true;
                logger.info("headers :: key: {}, value: {}", key, value.toString());
            }

            if (!logged) {
                logger.info("headers :: key: {}, object: {}", key, object.getClass().getCanonicalName());
            }

        }
    }

    private void showComponents(Exchange exchange) {
        CamelContext camelContext = exchange.getContext();
        List<String> camelComponents = camelContext.getComponentNames();
        int camelComponentsSize = camelComponents.size();
        int j = 0;
        while (j < camelComponentsSize) {
            logger.info("camelcomponent: {}", camelComponents.get(j));
            j++;
        }
    }

    private void showProperties(Exchange exchange) {
        Map<String, Object> properties = exchange.getProperties();
        Set<String> keySet = properties.keySet();
        Iterator<String> keyIterator = keySet.iterator();

        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            Object object = properties.get(key);
            boolean logged = false;
            if (object instanceof String) {
                String value = (String) properties.get(key);
                logged = true;
                logger.info("properties :: key: {}, value: {}", key, value);
            }
            if (object instanceof Integer) {
                Integer value = (Integer) properties.get(key);
                logged = true;
                logger.info("properties :: key: {}, value: {}", key, value);
            }
            if (object instanceof Boolean) {
                Boolean value = (Boolean) properties.get(key);
                logged = true;
                logger.info("properties :: key: {}, value: {}", key, value);
            }
            if (object instanceof Long) {
                Long value = (Long) properties.get(key);
                logged = true;
                logger.info("properties :: key: {}, value: {}", key, value);
            }
            if (object instanceof Date) {
                Date value = (Date) properties.get(key);
                logged = true;
                logger.info("properties :: key: {}, value: {}", key, value.toString());
            }

            if (!logged) {
                logger.info("properties :: key: {}, object: {}", key, object.getClass().getCanonicalName());
            }
        }
    }
}