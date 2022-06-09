package ru.netology.manager;

import ru.netology.domain.PurchaseItem;
import ru.netology.repository.CartRepository;

public class CartManager {
    private CartRepository repository;  // менеджер хранит у себя внутри не массив а репозиторий

    public CartManager(CartRepository repository) {  // менеджеру приходит репозиторий в конструкторе и он его сохраняет
        this.repository = repository;
    }

    public void add(PurchaseItem item) {  // когда менеджера просят добавить елемент в репозиторий - он его добавляет
        repository.save(item);
    }

    public PurchaseItem[] getAll() {  // создадим метод который разворачивает массив задом наперед (зачем не ясно)
        PurchaseItem[] items = repository.findAll();
        PurchaseItem[] result = new PurchaseItem[items.length]; // менеджер создает массив что бы заполнить его в обратном порядке
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {  // когда менеждера попросили удалить по номеру id но репозиторий это умеет, используем метод репозитория
        repository.removeById(id);
    }

    public int sum() {  // метод для вычисления суммы покупок
        int result = 0;   // заводим счетчик
        for (PurchaseItem item : repository.findAll()) {      // проходим по всем элементам корзины
            result = result + item.getProductPrice() * item.getCount();  // для каждого элемента считаем item.getProductPrice() * item.getCount() и плюсуем result
        }
        return result;
    }
}
