package lesson4;

/**
 * Задания необходимо выполнять на ЛЮБОЙ СУБД (postgres, mysql, sqllite, h2, ...)
 * <p>
 * 1. С помощью JDBC выполнить:
 * 1.1 Создать таблицу book с колонками id bigint, name varchar, author varchar, ...
 * 1.2 Добавить в таблицу 10 книг
 * 1.3 Сделать запрос select from book where author = 'какое-то имя' и прочитать его с помощью ResultSet
 */


import java.sql.*;

public class JDBC {
    private static String URL = "jdbc:postgresql://localhost:5432/sample_database";
    private static String USERNAME = "postgres";
    private static String PASSWORD = "111";
    private static int count = 1;

    public static void main(String[] args) throws SQLException {


        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

//        createTable(connection);
//        insertBook(connection, "Освобождение Света", "Искра Лиолла");
//        insertBook(connection, "Поднятие уровня в одиночку", "Чхугон");
//        insertBook(connection, "Доказательная Психосоматика", "Тимофей Кармацкий");
//        insertBook(connection, "Нэйцзин том 6", "Денис Аланов");
//        insertBook(connection, "Жить Жизнь", "Анна Богинская");
//        insertBook(connection, "Хроники Хорьков", "Ричард Бах");
//        insertBook(connection, "Стальной Алхимик", "Хирому Аракава");
//        insertBook(connection, "Уход", "Alan Wake");
//        insertBook(connection, "Грех прощения", "Анна Богинская");



        selectWhereAuthor(connection, "Alan Wake");

        connection.close();

    }

    //  1.1 Создать таблицу book с колонками id bigint, name varchar, author varchar, ...
    private static void createTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("""
                    CREATE TABLE IF NOT EXISTS book (
                      id bigint,
                      name varchar(255),
                      author varchar(255)
                    )
                    """);
        }
    }

    // 1.2 Добавить в таблицу 10 книг (вариант 1)
    private static void insertBook(Connection connection, String title, String author) {

        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO book VAlUES(" + count++ + ", ?, ?)")) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    1.3 Сделать запрос select from book where author = 'какое-то имя' и прочитать его с помощью ResultSet

    private static void selectWhereAuthor(Connection connection, String author) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("select id, name, author from book where author = ?")) {
            preparedStatement.setString(1, author);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String authorPrint = resultSet.getString("author");

                System.out.println("id = " + id + ", name = " + name + ": author = " + authorPrint);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
