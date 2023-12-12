package lesson3;

/**
 * Написать класс с двумя методами:
 * 1. принимает объекты, имплементирующие интерфейс serializable, и сохраняющие их в файл. Название файл - class.getName() + "_" + UUID.randomUUID().toString()
 * 2. принимает строку вида class.getName() + "_" + UUID.randomUUID().toString() и загружает объект из файла и удаляет этот файл.
 *
 * Что делать в ситуациях, когда файла нет или в нем лежит некорректные данные - подумать самостоятельно.
 */

public class Main {
    public static void main(String[] args) {
        Department department = new Department("Oleg opiat rabotaet za wseh");
        FileSerilesed f = new FileSerilesed();
        f.objectWriter(department);
        f.objectReader("Department_1c2ef359-5aaf-408e-a233-d6c5efadafc2.txt");
    }
}
