package br.edu.ifsp.restaurante.controller;

import br.edu.ifsp.restaurante.dto.order.OrderRequest;
import br.edu.ifsp.restaurante.dto.order.OrderResponse;
import br.edu.ifsp.restaurante.mapper.client.ClientMapper;
import br.edu.ifsp.restaurante.mapper.order.OrderMapper;
import br.edu.ifsp.restaurante.model.Client;
import br.edu.ifsp.restaurante.model.Meal;
import br.edu.ifsp.restaurante.model.Order;
import br.edu.ifsp.restaurante.service.ClientService;
import br.edu.ifsp.restaurante.service.MealService;
import br.edu.ifsp.restaurante.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {


    private final OrderService orderService;
    private final ClientService clientService;
    private final MealService mealService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> showAll(){
        List<OrderResponse> response = this.orderService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        Client client = ClientMapper.responseToClient(this.clientService.findById(request.client()));
        List<Meal> meals = new ArrayList<>();
        for(Long m : request.meals()) {
            meals.add()
        }
        OrderResponse response = this.orderService.save(request, client);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderResponse> editOrder(@PathVariable Long orderId, @RequestBody OrderRequest request) {
        Order order = OrderMapper.responseToOrder(this.orderService.findById(orderId));
        order.setClient(ClientMapper.responseToClient(this.clientService.findById(request.client())));
        order.setDescription(request.description());
        OrderResponse response = this.orderService.save(order);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        this.orderService.deleteById(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
