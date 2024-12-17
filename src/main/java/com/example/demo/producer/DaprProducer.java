//package com.example.demo.producer;
//
//import com.example.demo.dto.PubSubOptions;
//import io.dapr.client.DaprClient;
//import io.dapr.client.domain.PublishEventRequest;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
////import org.springframework.web.context.request.RequestAttributes;
////import org.springframework.web.context.request.RequestContextHolder;
//import reactor.core.publisher.Mono;
//
//@Slf4j
//@Service
//public class DaprProducer implements DaprMessageClient {
//
//    @Autowired
//    @Qualifier("daprClientMessageConnect")
//    private DaprClient daprClient;
//
////    @Override
////    public <T> Mono<T> invokeDaprBinding(BindingOptions bindingOptions) {
////        Mono<T> response= (Mono<T>) daprClient.invokeBinding(bindingOptions.getBindingName(),
////                bindingOptions.getMethod(),
////                bindingOptions.getRequestData(),
////                bindingOptions.getMetadata(),
////                bindingOptions.getResponseType());
////        response.doOnSuccess(success -> {
////            log.info("Message Published successfully!!");
////        }).onErrorResume(throwable -> {
////            log.error("Error occurred while sending message to Kafka: {}", throwable);
////            var err=Mono.error(throwable);
////            return (Mono<T>) err;
////        });
////        return response;
////    }
//
//    @Override
//    public Mono<Void> invokeDaprPublishEvent(PubSubOptions pubSubOptions) {
//        PublishEventRequest eventRequest= new PublishEventRequest(pubSubOptions.getPubsubName(),pubSubOptions.getTopic(),pubSubOptions.getRequestData());
//        eventRequest.setMetadata(pubSubOptions.getMetadata());
////        Context context = getOpenTelemetryContext();
////        Mono<Void> response=  daprClient.publishEvent(eventRequest)
////                .contextWrite(OpenTelemetryConfig.getReactorContext(context));
//        Mono<Void> response=daprClient.publishEvent(pubSubOptions);
//        return response;
//    }
//
////    private io.opentelemetry.context.Context getOpenTelemetryContext() {
////        io.opentelemetry.context.Context context = null;
////        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
////        if (requestAttributes != null) {
////            context =
////                    (io.opentelemetry.context.Context)
////                            requestAttributes.getAttribute(
////                                    CommonConstants.TRACER_DATA, RequestAttributes.SCOPE_REQUEST);
////        }
////        return context;
////    }
//}
