package com.example.demo.producer;

import com.example.demo.config.PubSubOptions;
import io.dapr.client.DaprClient;
import io.dapr.client.domain.PublishEventRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DaprProducerNew {

    @Autowired
    @Qualifier("daprClientMessageConnect")
    private DaprClient daprClient;

    public Mono<Void> publishEvent(PubSubOptions pubSubOptions) {
        PublishEventRequest eventRequest= new PublishEventRequest(pubSubOptions.getPubsubName(),pubSubOptions.getTopic(),pubSubOptions.getRequestData());
        eventRequest.setMetadata(pubSubOptions.getMetadata());
//        Context context = getOpenTelemetryContext();
//        Mono<Void> response=  daprClient.publishEvent(eventRequest)
//                .contextWrite(OpenTelemetryConfig.getReactorContext(context));

        return daprClient.publishEvent(eventRequest);
    }
}
