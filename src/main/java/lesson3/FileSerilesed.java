package lesson3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;


public class FileSerilesed {

    //    1. принимает объекты, имплементирующие интерфейс serializable, и сохраняющие их в файл.
//    Название файл - class.getName() + "_" + UUID.randomUUID().toString()
    public <T extends Serializable> void objectWriter(T write) {
        Path myfile = Path.of(write.getClass().getSimpleName() + "_" + UUID.randomUUID().toString() + ".txt");
        try {
            Files.createFile(myfile);
//            Files.writeString(myfile, write);

            OutputStream outputStream = Files.newOutputStream(myfile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(write);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("Не могу создать файл " + e.getMessage());
        }
        System.out.println("Создан файл: " + myfile);

    }

    //     2. принимает строку вида class.getName() + "_" + UUID.randomUUID().toString()
//     и загружает объект из файла и удаляет этот файл.
    public void objectReader(String read) {
        Path myfile = Path.of(read);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(myfile));
            Object obj = objectInputStream.readObject();
            System.out.println(obj);
            objectInputStream.close();
            Files.delete(myfile);
        } catch (IOException e) {
            System.out.println("Такого файла нет в директории " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
