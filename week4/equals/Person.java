package com.example.withfhture;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // equals() 메서드 오버라이딩
    @Override
    public boolean equals(Object o) {
        // 자기 자신과 비교하는 경우 true 반환함
        if (this == o) return true;

        // 널 체크 및 클래스 비교함
        if (o == null || getClass() != o.getClass()) return false;

        // 객체를 Person으로 캐스팅함
        Person person = (Person) o;

        // 필드 값들을 비교하여 동등성 여부를 확인함
        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    // hashCode() 메서드 오버라이딩
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    public static void main(String[] args) {
        Person person1 = new Person("test", 30);
        Person person2 = new Person("Equals", 25);
        Person person3 = new Person("test", 30);

        // equals()를 사용하여 두 객체의 동등성 비교함
        System.out.println("person1.equals(person2): " + person1.equals(person2));
        System.out.println("person1.equals(person3): " + person1.equals(person3));

        // hashCode()를 사용하여 해시 코드 출력함
        System.out.println("person1.hashCode(): " + person1.hashCode());
        System.out.println("person2.hashCode(): " + person2.hashCode());
        System.out.println("person3.hashCode(): " + person3.hashCode());
    }
}
