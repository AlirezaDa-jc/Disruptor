package alireza.da.disruptor.consumers;

import alireza.da.disruptor.events.ExampleEvent;
import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * Created By Alireza Dolatabadi
 * Date: 3/10/2023
 * Time: 6:32 PM
 */
@Slf4j
public class SingleEventConsumer {

    public EventHandler<ExampleEvent>[] getEventHandler() {
        EventHandler<ExampleEvent> eventHandler
                = (event, sequence, endOfBatch)
                -> print(event.getValue(), sequence);
        return new EventHandler[] { eventHandler };
    }

    private void print(int id, long sequenceId) {
        log.info("Id is " + id
                + " sequence id that was used is " + sequenceId);
    }
}
