package com.example.demo.producer;

import com.example.demo.config.PubSubOptions;
import io.dapr.client.DaprClient;
import io.dapr.client.domain.PublishEventRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class DaprProducerNew {

    @Autowired
    @Qualifier("daprClientMessageConnect")
    private DaprClient daprClient;

    public Mono<Void> publishEvent(PubSubOptions pubSubOptions) {
        PublishEventRequest eventRequest= new PublishEventRequest(pubSubOptions.getPubsubName(),pubSubOptions.getTopic(),pubSubOptions.getData());
        eventRequest.setMetadata(pubSubOptions.getMetadata());
//        Context context = getOpenTelemetryContext();
//        Mono<Void> response=  daprClient.publishEvent(eventRequest)
//                .contextWrite(OpenTelemetryConfig.getReactorContext(context));

        return daprClient.publishEvent(eventRequest)
                .doOnSuccess((s) -> log.info("success publishMessage {}", pubSubOptions))
                .doOnError(Exception.class, (s) -> log.error("error publishMessage {}", pubSubOptions));

        /*InvokeBindingRequest invokeBindingRequest = new InvokeBindingRequest("kafka-pubsub", "create");
        invokeBindingRequest.setData(pubSubOptions.getRequestData());
        invokeBindingRequest.setMetadata(pubSubOptions.getMetadata());

        return daprClient.invokeBinding(invokeBindingRequest, TypeRef.VOID)
                .doOnSuccess((s) -> log.info("success publishMessage {}", pubSubOptions))
                .doOnError(Exception.class, (s) -> log.error("error publishMessage {}", pubSubOptions));
*/
    }
}
