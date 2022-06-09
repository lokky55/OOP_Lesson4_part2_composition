package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
// создадим класс который описывает 1 строку (1 товар) в корзине покупок
// репозиторий должен будет уметь работать с этими объектами
public class PurchaseItem {
    private int id;             // уникальный номер строки
    private int productId;      // уникальный номер товара
    private String productName; // название товара
    private int productPrice;   // цена товара
    private int count;          // кол-во товара

}
