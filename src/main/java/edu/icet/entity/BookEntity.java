package edu.icet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String title;
    private String category;
    private double price;
    private String author;
    private String description;

//    private int stock;
//
//    public boolean isInStock(int quantity){
//        return stock >= quantity;
//    }
//
//    public void reduceStock(int quantity){
//        this.stock -= quantity;
//    }
}
