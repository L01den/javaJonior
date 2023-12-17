package lesson4.JPA;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
// 2.1 Описать сущность Book из пункта 1.1
@ToString
@Data
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
}
