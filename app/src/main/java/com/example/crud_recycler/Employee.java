package com.example.crud_recycler;

public class Employee {
   private String Name, Designation, loc;

    public Employee(String name, String designation, String loc) {
        Name = name;
        Designation = designation;
        this.loc = loc;
    }


    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
