package lesson4.OneToMany;

import lesson4.JPA.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 *  3.* Создать сущность Автор (id biging, name varchar), и в сущности Book сделать поле типа Author (OneToOne)
 *  3.1 * Выгрузить Список книг и убедиться, что поле author заполнено
 *  3.2 ** В классе Author создать поле List<Book>, которое описывает список всех книг этого автора. (OneToMany)
 */

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Books.class)
                .addAnnotatedClass(Author.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

            Author author = session.get(Author.class, 4);
            System.out.println(author);
            List<Books> books = author.getBooks();
            for (Books book : books) {
                System.out.println(book);
            }
            System.out.println();
            Books book = session.get(Books.class, 5);
            System.out.println(book);
            System.out.println(book.getOwner());


            session.getTransaction().commit();
        }


        sessionFactory.close();
    }
}
