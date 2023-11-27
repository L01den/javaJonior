package lesson1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/**
 *  Создать список из 1_000 рандомных чисел от 1 до 1_000_000
 *            1.1 Найти максимальное
 *            1.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
 *            1.3 Найти количество чисел, квадрат которых меньше, чем 100_000
 */



public class task1 {
    public static void main(String[] args) {
//        1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
        List<Integer> listNumber = Stream.generate(() -> ThreadLocalRandom.current().nextInt(1_000_000)).limit(1_000).toList();
//        listNumber.stream().forEach(System.out::println);

//         1.1 Найти максимальное
        int max = listNumber.stream().max(Integer::compare).get();
        System.out.println(max);

//        1.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
        int sum = listNumber.stream().filter(n -> n > 500_000).map(n -> (n * 5) - 150).reduce(Integer::sum).get();
        System.out.println(sum);


//        1.3 Найти количество чисел, квадрат которых меньше, чем 100_000

        long count = listNumber.stream().filter(n -> n < Math.sqrt(100_000)).count();
        System.out.println(count);
    }
}
