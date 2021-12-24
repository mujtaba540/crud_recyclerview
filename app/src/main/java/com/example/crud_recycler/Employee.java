package com.example.crud_recycler;

public class Employee {
   private String Name;
   private  int age;

    public Employee(int age,String name) {
        this.age = age;
        this.Name=name;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
