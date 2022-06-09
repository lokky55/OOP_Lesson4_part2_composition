package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.CartRepository;

// Напишем тесты на репозиторий (на менеджер будут точно такие же)
public class MultServiceTest {
    PurchaseItem first = new PurchaseItem(101, 1, "first", 100, 2);
    PurchaseItem second = new PurchaseItem(222, 2, "second", 10, 1);
    PurchaseItem third = new PurchaseItem(30, 3, "third", 1, 2);

    // протестируем удаление
    @Test
    public void shouldRemove() {
        CartRepository repo = new CartRepository();  // заводим репозиторий
        repo.save(first);     // добавляем в репозиторий 3 элемента
        repo.save(second);
        repo.save(third);

        repo.removeById(101); // удаляем второй элемент репорзитория
        // проассертим наборы! не длины не элементы а наборы
        PurchaseItem[] actual = repo.findAll();  // далее покажи что у тебя там сейчас есть, ФР
        PurchaseItem[] expected = {second, third}; // ОР не 2 а набор {} из первого и третьего элемента
        Assertions.assertArrayEquals(expected, actual);
    }
}
