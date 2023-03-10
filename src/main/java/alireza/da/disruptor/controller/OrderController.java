package alireza.da.disruptor.controller;

import alireza.da.disruptor.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Alireza Dolatabadi
 * Date: 3/10/2023
 * Time: 7:00 PM
 */
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> testDisruptor(){
        orderService.test();
        return ResponseEntity.ok("test");
    }
}
