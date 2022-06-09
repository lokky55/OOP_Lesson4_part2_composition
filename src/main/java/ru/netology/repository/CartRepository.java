package ru.netology.repository;

import ru.netology.domain.PurchaseItem;

public class CartRepository {
 // заведем поле items которое будет содержать в себе массив из items;
    private PurchaseItem[] items = new PurchaseItem[0];
//  реализуем все методы для репозитория:
//  методу save будет приходить параметр, который необходимо будет добавит в конец
    public void save(PurchaseItem item) {
        // создаем новый массив на еденицу больше
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
//         itar + tab
//         копируем поэлементно
//        for (int i = 0; i < items.length; i++) {
//            tmp[i] = items[i];
//        }
        // System.arraycopy принимает 5 параметров: откуда копируем, позиция начала, куда, сколько
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладем последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

// метод findAll просто отдает все что запомнено в поле
    public PurchaseItem[] findAll() {
        return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        int index = 0;
        for (PurchaseItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
