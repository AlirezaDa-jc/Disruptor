package alireza.da.disruptor.producers;

import alireza.da.disruptor.events.ExampleEvent;
import com.lmax.disruptor.RingBuffer;

/**
 * Created By Alireza Dolatabadi
 * Date: 3/10/2023
 * Time: 6:44 PM
 */

public class SingleEventProducer {

    public void startProducing(RingBuffer<ExampleEvent> ringBuffer, int count) {
        final Runnable producer = () -> produce(ringBuffer, count);
        new Thread(producer).start();
    }

    private void produce(final RingBuffer<ExampleEvent> ringBuffer, final int count) {
        for (int i = 0; i < count; i++) {
            final long seq = ringBuffer.next();
            final ExampleEvent valueEvent = ringBuffer.get(seq);
            valueEvent.setValue(i);
            ringBuffer.publish(seq);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
