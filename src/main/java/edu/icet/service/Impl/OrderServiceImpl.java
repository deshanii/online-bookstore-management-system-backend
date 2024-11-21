package edu.icet.service.Impl;
import edu.icet.dto.Book;
import edu.icet.dto.Orders;
import edu.icet.entity.BookEntity;
import edu.icet.entity.OrdersEntity;
import edu.icet.repository.BookRepository;
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

    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;
    private final ModelMapper mapper;

    @Override
    public List<Orders> getAll() {
        List<Orders> orderList = new ArrayList<>();

        List<OrdersEntity> orderEntities = orderRepository.findAll();

        for(OrdersEntity orderEntity : orderEntities){
            orderList.add(mapper.map(orderEntity, Orders.class));
        }
        return orderList;
    }

    @Override
    public void addOrder(Orders order) {
        OrdersEntity ordersEntity = mapper.map(order, OrdersEntity.class);

        ordersEntity.getOrderItems().forEach(item -> {
            item.setOrder(ordersEntity);

            BookEntity book = item.getBook();

            book.setQty(book.getQty() - item.getQuantity());

            bookRepository.save(book);
        });

        orderRepository.save(ordersEntity);
    }


    @Override
    public void deleteOrderById(Integer id) {
        orderRepository.deleteById(id);

    }

    @Override
    public Orders searchOrderById(Integer id) {
        return mapper.map(orderRepository.findById(id), Orders.class);
    }

    @Override
    public void updateOrderById(Orders order) {
        orderRepository.save(mapper.map(order, OrdersEntity.class));

    }
}
