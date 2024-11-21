package edu.icet.controller;

import edu.icet.dto.Orders;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    final OrderService service;

    @GetMapping("/get-order")
    public List<Orders> getOrder(){
        return service.getAll();
    }

    @PostMapping("/add-order")
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrder(@RequestBody Orders order){
        System.out.println(order);
        service.addOrder(order);
    }

    @GetMapping("/search-by-id/{Id}")
    public Orders getOrderById(@PathVariable Integer id){
        return service.searchOrderById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteOrderById(@PathVariable Integer id){
        service.deleteOrderById(id);
    }

    @PutMapping("/update-order")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateOrder(@RequestBody Orders order){
        service.updateOrderById(order);
    }
}
