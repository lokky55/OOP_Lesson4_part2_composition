import ru.netology.domain.PurchaseItem;
import ru.netology.manager.CartManager;
import ru.netology.repository.CartRepository;

public class Main {

    public static void main(String[] args) {
        // создаем репозиторий "тупой" инструмент для 3х действий: добавить, удалить, показать что есть
        // создадим 3 обьекта(строки) для будущих покупок в корзине
        PurchaseItem first = new PurchaseItem(101, 1, "first", 100, 2);
        PurchaseItem second = new PurchaseItem(222,2,"second", 10, 1);
        PurchaseItem third = new PurchaseItem(30,3,"third", 1, 2);

        CartRepository repo = new CartRepository();

        // создадим методы сохранения строк
        // используется save вместо set птмч хотим НЕ ЗАМЕНИТЬ а ДОБАВИТЬ элемент
        repo.save(first);
        repo.save(second);
        repo.save(third);

        // метод удаления по номеру id
        repo.removeById(222);

        // метод который вернет набор из запомненых элементов
        PurchaseItem[] all = repo.findAll();

        // создадим "умного" менеджера который будет отвечать за корзину целиком


    }
}
