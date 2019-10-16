package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.JhipsterUaaKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jhipster-uaa-kafka")
public class JhipsterUaaKafkaResource {

    private final Logger log = LoggerFactory.getLogger(JhipsterUaaKafkaResource.class);

    private JhipsterUaaKafkaProducer kafkaProducer;

    public JhipsterUaaKafkaResource(JhipsterUaaKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
