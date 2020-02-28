package entitiscontinue1.entitiscontinue2.repository;

import entitiscontinue1.entitiscontinue2.beans.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class BookReposiroty {

    private EntityManager entityManager;

    @Autowired
    public BookReposiroty(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Book saveBook(Book book){
        if (book.getId() == null){
            entityManager.persist(book);
        }else{
            entityManager.merge(book);
        }
        return book;
    }


    public Book findById(Long id){
       return entityManager.find(Book.class,id);
    }

    public Book findByName(String name){
        TypedQuery<Book> byName = entityManager
                .createQuery("SELECT b FROM Book b WHERE NAME = :name",Book.class);
                return byName.setParameter("name",name).getSingleResult();
    }

    public List<Book> getAllBooks(){
        TypedQuery<Book> all = entityManager.createQuery("SELECT B FROM Book B",Book.class);
        return all.getResultList();
    }

    public Book findByName2(String name){
        Query byName = entityManager.createNativeQuery("SELECT * FROM book WHERE NAME = :NAME",Book.class);
        return (Book) byName.setParameter("NAME",name).getSingleResult();
    }
    public Book findBookByNamedQuary(){
        return entityManager.createNamedQuery("find_rings",Book.class).getSingleResult();
    }
    public List<Book> findAllBookByNamedQuary(){
        return entityManager.createNamedQuery("find_all",Book.class).getResultList();
    }

}
