package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class ProductManagerTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductManager productManager;

    private Book firstBook = new Book(1, "Rich brother, rich sister", 500, "Robert Kiyosaki");
    private Book secondBook = new Book(2, "Diamond Wisdom", 700, "Michael Roach");
    private Book thirdBook = new Book(3, "Rich father, poor father", 800, "Robert Kiyosaki");
    private Smartphone firstPhone = new Smartphone(4, "IPhone 11", 52000, "Apple");
    private Smartphone secondPhone = new Smartphone(5, "Samsung Galaxy", 58000, "Samsung");
    private Smartphone thirdPhone = new Smartphone(6, "IPhone 7", 25000, "Apple");


    @Test
    public void shouldFindBookByAuthorWithIgnoreCase() {

        String searchText = "ROBERT Kiyosaki";
        Product[] returned = new Product[]{firstBook, secondBook, thirdBook, firstPhone, secondPhone, thirdPhone};

        doReturn(returned).when(repository).getAllProducts();


        Product[] expected = new Product[]{firstBook, thirdBook};
        Product[] actual = productManager.searchBy(searchText);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookByNameWithIgnoreCase() {
        String searchText = "diamond WISdom";
        Product[] returned = new Product[]{firstBook, secondBook, thirdBook, firstPhone, secondPhone, thirdPhone};

        doReturn(returned).when(repository).getAllProducts();

        Product[] expected = new Product[]{secondBook};
        Product[] actual = productManager.searchBy(searchText);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindBookByNameWithIgnoreCase2() {
        String searchText = "rich";
        Product[] returned = new Product[]{firstBook, secondBook, thirdBook, firstPhone, secondPhone, thirdPhone};

        doReturn(returned).when(repository).getAllProducts();

        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy(searchText);

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindSmartphoneByNameWithIgnoreCase() {
        String searchText = "iphonE 7";
        Product[] returned = new Product[]{firstBook, secondBook, thirdBook, firstPhone, secondPhone, thirdPhone};

        doReturn(returned).when(repository).getAllProducts();

        Product[] expected = new Product[]{thirdPhone};
        Product[] actual = productManager.searchBy(searchText);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllSmartphonesWithIgnoreCase2() {
        String searchText = "apple";
        Product[] returned = new Product[]{firstBook, secondBook, thirdBook, firstPhone, secondPhone, thirdPhone};

        doReturn(returned).when(repository).getAllProducts();

        Product[] expected = new Product[]{firstPhone, thirdPhone};
        Product[] actual = productManager.searchBy(searchText);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByManufacturerWithIgnoreCase() {
        String searchText = "SaMsUnG";
        Product[] returned = new Product[]{firstBook, secondBook, thirdBook, firstPhone, secondPhone, thirdPhone};

        doReturn(returned).when(repository).getAllProducts();

        Product[] expected = new Product[]{secondPhone};
        Product[] actual = productManager.searchBy(searchText);

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldNotFindProductWithIgnoreCase() {
        String searchText = "Michael";
        Product[] returned = new Product[]{firstBook, secondBook, thirdBook, firstPhone, secondPhone, thirdPhone};

        doReturn(returned).when(repository).getAllProducts();

        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy(searchText);

        assertArrayEquals(expected, actual);
    }
}