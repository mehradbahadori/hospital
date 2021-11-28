package model;

public class Person {
    String name;
    String unit;
    int age;

    public Person(String name, String unit, int age) {
        this.name = name;
        this.unit = unit;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getAge() {
        return age;
    }
}
