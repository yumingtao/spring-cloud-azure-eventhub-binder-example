package com.ymt.example.worker;

import com.microsoft.azure.spring.integration.core.AzureHeaders;
import com.microsoft.azure.spring.integration.core.api.Checkpointer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.support.GenericMessage;


@EnableBinding(Sink.class)
@Slf4j
public class MessageListener {

    @StreamListener(value = Sink.INPUT)
    public void onEvent(GenericMessage<String> message, @Header(AzureHeaders.CHECKPOINTER) Checkpointer checkpointer) {
        log.info("Message received from EventHub: {}", message);

        checkpointer.success().handle((r, ex) -> {
            if (ex == null) {
                log.info("Message '{}' successfully checkpointed.", message);
            } else {
                log.info("Checkpoint message got exception : {}", ex.getMessage());
            }
            return null;
        });
    }
}