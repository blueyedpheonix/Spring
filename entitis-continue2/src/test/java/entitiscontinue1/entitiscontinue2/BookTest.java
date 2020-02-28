package entitiscontinue1.entitiscontinue2;

import entitiscontinue1.entitiscontinue2.beans.Book;
import entitiscontinue1.entitiscontinue2.repository.BookReposiroty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;


@SpringBootTest
@ActiveProfiles(profiles = "dev")
class BookTest {

    @Autowired
    private BookReposiroty bookReposiroty;

    @Test
    void contextLoads() {
    }

    @Test
    void createBook(){
    Book book = bookReposiroty.saveBook(new Book(2L,"Dylan the God"));
        System.out.println(book);
    }

    @Test
    void findBookById(){
        Book book = bookReposiroty.findById(1L);
        System.out.println(book);
    }

    @Test
    void findBookByName(){
        Book book = bookReposiroty.findByName("Dylan the God");
        System.out.println(book);
    }

    @Test
    void findAllBooks(){
        List<Book> allBooks = bookReposiroty.getAllBooks();
        allBooks.forEach(System.out::println);
    }

    @Test
    void findBookByName2(){
        Book book = bookReposiroty.findByName2("lord of the rings");
        System.out.println(book);
    }

    @Test
    void findBookUsingNamedQuary(){
        System.out.println(bookReposiroty.findBookByNamedQuary());
    }
    @Test
    void findAllBooksByNamedQuary(){
        bookReposiroty.findAllBookByNamedQuary().forEach(System.out::println);
    }


}
