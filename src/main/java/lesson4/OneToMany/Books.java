package lesson4.OneToMany;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 3.1 Описать сущность Book из пункта 1.1

@Data
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author owner;

    public Books(String name, Author owner) {
        this.name = name;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Books " +
                "id - " + id +
                ", name - " + name +
                ", author - " + owner.getName();
    }
}
