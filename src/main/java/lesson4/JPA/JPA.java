package lesson4.JPA;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Задания необходимо выполнять на ЛЮБОЙ СУБД (postgres, mysql, sqllite, h2, ...)
 * 2. С помощью JPA(Hibernate) выполнить:
 * 2.1 Описать сущность Book из пункта 1.1
 * 2.2 Создать Session и сохранить в таблицу 10 книг
 * 2.3 Выгрузить список книг какого-то автора
 */

public class JPA {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Book.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

//        saveData(sessionFactory, new Book("Токийский гуль", "Суи Исида"));
//        saveData(sessionFactory, books);

//        2.3 Выгрузить список книг какого-то автора
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            List<Book> books = session.createQuery("from Book where author = 'Анна Богинская'").getResultList();
            for(Book book: books){
                System.out.println(book);
            }
            session.getTransaction().commit();
        }


        sessionFactory.close();
    }
//    Сохранение 1 книги
    public static void saveData(SessionFactory sessionFactory, Book book){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            session.persist(book);

            session.getTransaction().commit();
            System.out.println("Всё ок!");
        }
    }

//      Сохранения коллекции книг
    public static void saveData(SessionFactory sessionFactory, List<Book> books){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            int count = 0;
            for (Book book: books) {
                session.persist(book);
                count++;
            }

            session.getTransaction().commit();
            System.out.println("Сохранено книг: " + count);
        }
    }


}
