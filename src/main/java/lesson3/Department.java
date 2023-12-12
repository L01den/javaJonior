package lesson3;

import java.io.Serializable;

public class Department implements Serializable {

    public final String name;

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}
