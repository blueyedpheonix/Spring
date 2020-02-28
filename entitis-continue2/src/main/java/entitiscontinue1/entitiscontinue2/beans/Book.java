package entitiscontinue1.entitiscontinue2.beans;

import javax.persistence.*;

@Entity
@Table(name = "Book")
@NamedQueries({
        @NamedQuery( name = "find_rings",
                query = "select b from Book b where b.name = 'lord of the rings'"),
        @NamedQuery(name = "find_all", query = "select b from Book b")
})
public class Book {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    public Book(){}

    public Book(String name) {
        this.name = name;
    }

    public Book(Long id,String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
