package alireza.da.disruptor.events;

import com.lmax.disruptor.EventFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created By Alireza Dolatabadi
 * Date: 3/10/2023
 * Time: 6:30 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExampleEvent {
    private int value;
    public final static EventFactory EVENT_FACTORY
            = ExampleEvent::new;
}
