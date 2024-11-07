package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Orders {
    private Integer ordersId;
    private LocalDate date;
    private Integer qty;
    private double total;

//    public enum orderStatus{
//        PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELLED
//
//    }


}
