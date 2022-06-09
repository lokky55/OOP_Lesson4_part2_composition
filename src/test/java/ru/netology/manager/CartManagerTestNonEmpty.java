package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.CartRepository;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class CartManagerTestNonEmpty {
    private CartRepository repository = Mockito.mock(CartRepository.class);  // создаем ячейку для репозитория и кладем туда лжерепозиторий на основе класса существующего
    private CartManager manager = new CartManager(repository);
    private PurchaseItem first = new PurchaseItem(101, 1, "first", 100, 2);
    private PurchaseItem second = new PurchaseItem(222, 2, "second", 10, 1);
    private PurchaseItem third = new PurchaseItem(30, 3, "third", 1, 2);

    @BeforeAll
    static void start() {
        System.out.println("Hello");
    }

    @Test
    public void ShouldCalculateSum() {
        // настройка заглушки
        PurchaseItem[] returned = {first, second, third};
        doReturn(returned).when(repository).findAll();

        int expected = 212;
        int actual = manager.sum();
        Assertions.assertEquals(expected, actual);

        // удовстоверимся что заглушка была вызвана
        // но это уже проверка внутренней реализации
        verify(repository).findAll();
    }
}