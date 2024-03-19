package ru.netology.Exception.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void deletingAnExistingElement() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Автомобиль", 650_000);
        Product product2 = new Product(2, "Наушники", 500);
        Product product3 = new Product(3, "Маска", 10_000);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(1);

        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void deletingANonExistingElement() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Автомобиль", 650_000);
        Product product2 = new Product(2, "Наушники", 500);
        Product product3 = new Product(3, "Маска", 10_000);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(5)
        );
    }
}
