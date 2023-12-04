package lesson2.hw;

public class Homework {

    /**
     * Расширить пример с запуском тестов следующими фичами:
     * 1. Добавить аннотации BeforeEach, AfterEach,
     * которые ставятся над методами void без аругментов и запускаются ДО и ПОСЛЕ всех тестов соответственно.
     * 2. В аннотацию Test добавить параметр order() со значением 0 по умолчанию.
     * Необходимо при запуске тестов фильтровать тесты по этому параметру (от меньшего к большему).
     * Т.е. если есть методы @Test(order = -2) void first, @Test void second, Test(order = 5) void third,
     * то порядок вызовов first -> second -> third
     * 3.* Добавить аннотацию @Skip, которую можно ставить над тест-методами. Если она стоит - то тест не запускается.
     * 4.* При наличии идей, реализовать их и написать об этом в комментарии при сдаче.
     */


    public static void main(String[] args) {
        TestProcessor.runTest(MyTest.class);
    }

    static class MyTest {

        @AfterEach
        void afterTest() {
            System.out.println("Последний тест");
        }

        @Test(order = 4)
        void firstTest() {
            System.out.println("4-firstTest запущен");
        }

        @Skip
        @Test
        void secondTest() {
            System.out.println("2-secondTest запущен");
        }

        @Test(order = -2)
        void thirdTest() {
            System.out.println("1-thirdTest запущен");
        }

        @Test(order = 10)
        void fourthTest() {
            System.out.println("6-fourthTest запущен");
        }

        @Test(order = 2)
        void fifthTest() {
            System.out.println("3-fifthTest запущен");
        }

        @Test(order = 8)
        void sixthTest() {
            System.out.println("5-sixthTest запущен");
        }

        @Skip
        @BeforeEach
        void beforeTest() {
            System.out.println("Самый первый тест");
        }

        @BeforeEach
        void beforeTestTwo() {
            System.out.println("Самый первый второй тест");
        }

    }

}
