import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void shouldRemoveProduct() {
        Product book = new Product(5, "Книга", 1200);
        Product diskDVD = new Product(63, "ДВД-диск", 2000);
        Product vinylRecord = new Product(104, "Виниловая пластинка", 5000);

        ShopRepository repo = new ShopRepository();
        repo.add(book);
        repo.add(diskDVD);
        repo.add(vinylRecord);

        repo.removeById(63);

        Product[] expected = {book, vinylRecord};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldExceptionWhenIdNull() {
        Product book = new Product(5, "Книга", 1200);
        Product diskDVD = new Product(63, "ДВД-диск", 2000);
        Product vinylRecord = new Product(104, "Виниловая пластинка", 5000);

        ShopRepository repo = new ShopRepository();
        repo.add(book);
        repo.add(diskDVD);
        repo.add(vinylRecord);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(47);
        });
    }

}
