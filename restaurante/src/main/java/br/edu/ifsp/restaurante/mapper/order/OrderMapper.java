package br.edu.ifsp.restaurante.mapper.order;

import br.edu.ifsp.restaurante.dto.order.OrderRequest;
import br.edu.ifsp.restaurante.dto.order.OrderResponse;
import br.edu.ifsp.restaurante.mapper.meal.MealMapper;
import br.edu.ifsp.restaurante.model.Client;
import br.edu.ifsp.restaurante.model.Meal;
import br.edu.ifsp.restaurante.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static OrderResponse orderToResponse(Order order) {
        return new OrderResponse(order.getId(), order.getDescription(), order.getClient().getId(), order.getMeals().stream().map(MealMapper::mealToResponse).toList());
    }

    public static List<OrderResponse> ordersToResponse(List<Order> orders) {
        List<OrderResponse> response = new ArrayList<>();
        if (!orders.isEmpty()) {
            for (Order o : orders) {
                response.add(new OrderResponse(o.getId(), o.getDescription(), o.getClient().getId(), o.getMeals().stream().map(MealMapper::mealToResponse).toList()));
            }
        }
        return response;
    }

    public static Order requestToOrder(OrderRequest request, Client client, List<Meal> meals) {
        Order order = new Order();
        order.setDescription(request.description());
        order.setClient(client);
        order.setMeals(meals);
        return order;
    }

    public static Order responseToOrder(OrderResponse response) {
        Order order = new Order();
        order.setId(response.id());
        order.setDescription(response.description());
        return order;
    }
}
