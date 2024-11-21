package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private Integer bookId;
    private String title;
    private String category;
    private Integer qty;
    private double price;
    private String author;
    private String description;
    private String profileImagePath;
}
