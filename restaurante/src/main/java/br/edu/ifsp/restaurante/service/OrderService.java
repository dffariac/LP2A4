package br.edu.ifsp.restaurante.service;

import br.edu.ifsp.restaurante.dto.order.OrderRequest;
import br.edu.ifsp.restaurante.dto.order.OrderResponse;
import br.edu.ifsp.restaurante.mapper.order.OrderMapper;
import br.edu.ifsp.restaurante.model.Client;
import br.edu.ifsp.restaurante.model.Meal;
import br.edu.ifsp.restaurante.model.Order;
import br.edu.ifsp.restaurante.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderResponse> findAll(){
        return this.orderRepository.findAll().stream().map(OrderMapper::orderToResponse).toList();
    }

    public OrderResponse findById(Long id){
        return this.orderRepository.findById(id).map(OrderMapper::orderToResponse)
                .orElseThrow(() -> new RuntimeException("order #"+id+" not found"));
    }

    public OrderResponse save(OrderRequest request, Client client, List<Meal> meals){
        Order order = this.orderRepository.save(OrderMapper.requestToOrder(request, client, meals));
        return OrderMapper.orderToResponse(order);
    }

    public OrderResponse save(Order order){
        return OrderMapper.orderToResponse(this.orderRepository.save(order));
    }

    public void deleteById(Long id){
        this.orderRepository.deleteById(id);
    }
}
