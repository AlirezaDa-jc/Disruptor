package alireza.da.disruptor.service.impl;

import alireza.da.disruptor.consumers.SingleEventConsumer;
import alireza.da.disruptor.events.ExampleEvent;
import alireza.da.disruptor.producers.SingleEventProducer;
import alireza.da.disruptor.service.OrderService;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import org.springframework.stereotype.Service;

/**
 * Created By Alireza Dolatabadi
 * Date: 3/10/2023
 * Time: 7:02 PM
 */
@Service
public class OrderServiceImpl implements OrderService {
    private final Disruptor disruptor;

    public OrderServiceImpl(Disruptor disruptor) {
        this.disruptor = disruptor;
    }

    @Override
    public void test() {
        SingleEventConsumer singleEventConsumer = new SingleEventConsumer();
        disruptor.handleEventsWith(singleEventConsumer.getEventHandler());
        final RingBuffer<ExampleEvent> ringBuffer = disruptor.start();
        SingleEventProducer singleEventProducer = new SingleEventProducer();
        singleEventProducer.startProducing(ringBuffer, 10);
    }
}
