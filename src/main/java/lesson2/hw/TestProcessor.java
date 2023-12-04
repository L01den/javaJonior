package lesson2.hw;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestProcessor {

    /**
     * Данный метод находит все void методы без аргументов в классе, и запускеет их.
     * <p>
     * Для запуска создается тестовый объект с помощью конструткора без аргументов.
     */
    public static void runTest(Class<?> testClass) {
        final Constructor<?> declaredConstructor;
        try {
            declaredConstructor = testClass.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Для класса \"" + testClass.getName() + "\" не найден конструктор без аргументов");
        }

        final Object testObj;
        try {
            testObj = declaredConstructor.newInstance();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Не удалось создать объект класса \"" + testClass.getName() + "\"");
        }


        List<Method> methodsTest = new ArrayList<>();
        List<Method> methodsBeforeEach = new ArrayList<>();
        List<Method> methodsAfterEach = new ArrayList<>();
        for (Method method : testClass.getDeclaredMethods()) {

        }


        for (Method method : testClass.getDeclaredMethods()) {
//         Проверка на Test
            if (method.isAnnotationPresent(Test.class) && !method.isAnnotationPresent(Skip.class)) {
                checkTestMethod(method);
                methodsTest.add(method);
            }
//          Проверка на BeforeEach
            if (method.isAnnotationPresent(BeforeEach.class) && !method.isAnnotationPresent(Skip.class)) {
                checkTestMethod(method);
                methodsBeforeEach.add(method);
            }
//          Проверка на AfterEach
            if (method.isAnnotationPresent(AfterEach.class) && !method.isAnnotationPresent(Skip.class)) {
                checkTestMethod(method);
                methodsAfterEach.add(method);
            }

        }

        methodsTest.sort(Comparator.comparing(m -> m.getAnnotation(Test.class).order()));

        methodsBeforeEach.forEach(it -> runTest(it, testObj));
        methodsTest.forEach(it -> runTest(it, testObj));
        methodsAfterEach.forEach(it -> runTest(it, testObj));
    }


    private static void checkTestMethod(Method method) {
        if (!method.getReturnType().isAssignableFrom(void.class) || method.getParameterCount() != 0) {
            throw new IllegalArgumentException("Метод \"" + method.getName() + "\" должен быть void и не иметь аргументов");
        }
    }

    private static void runTest(Method testMethod, Object testObj) {
        try {
            testMethod.invoke(testObj);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException("Не удалось запустить тестовый метод \"" + testMethod.getName() + "\"");
        } catch (AssertionError e) {

        }
    }

//  private static List<Method> testSorting(List<Method> methodList){
//    List<Method> sortedMethods = new ArrayList<>();
//    for (Method method : methodList) {
//      if (method.isAnnotationPresent(BeforeEach.class)){
//        sortedMethods.add(method);
//      }
//      if (method.isAnnotationPresent(Test.class)) {
//        method.getAnnotation(Test.class).order();
//
//      }
//      if (method.isAnnotationPresent(AfterEach.class)){
//        sortedMethods.add(method);
//      }
//
//    }
//    return sortedMethods;
//  }

}
