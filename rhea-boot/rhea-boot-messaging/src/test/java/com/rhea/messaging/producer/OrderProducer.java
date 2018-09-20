package com.rhea.messaging.producer;

import com.rhea.messaging.annotation.Producer;
import com.rhea.messaging.api.MQProducer;
import com.rhea.messaging.model.Order;

@Producer(topic = "TopicTest")
public interface OrderProducer extends MQProducer<Order> {

}
