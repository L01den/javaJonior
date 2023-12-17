package lesson4.OneToMany;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "owner")
    private List<Books> books;

    public Author(String name) {
        this.name = name;
    }

    public void setBook(Books book) {
        this.books.add(book);
    }

    @Override
    public String toString() {
        return "Author " +
                "id - " + id +
                ", name - " + name;
    }
}
