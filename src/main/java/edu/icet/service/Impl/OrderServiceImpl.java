package edu.icet.service.Impl;
import edu.icet.dto.Orders;
import edu.icet.entity.OrdersEntity;
import edu.icet.repository.OrderRepository;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<Orders> getAll() {
        List<Orders> orderList = new ArrayList<>();

        List<OrdersEntity> orderEntities = repository.findAll();

        for(OrdersEntity orderEntity : orderEntities){
            orderList.add(mapper.map(orderEntity, Orders.class));
        }
        return orderList;
    }

    @Override
    public void addOrder(Orders order) {
        repository.save(mapper.map(order, OrdersEntity.class));

    }

    @Override
    public void deleteOrderById(Integer id) {
        repository.deleteById(id);

    }

    @Override
    public Orders searchOrderById(Integer id) {
        return mapper.map(repository.findById(id), Orders.class);
    }

    @Override
    public void updateOrderById(Orders order) {
        repository.save(mapper.map(order, OrdersEntity.class));

    }
}
