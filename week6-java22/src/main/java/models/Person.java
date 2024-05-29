package models;

import enums.Role;

public class Person {
    private String name;
    private Role role;
    private int ID;

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public int getID() {
        return ID;
    }

    public Person(String name, Role role, int ID) {
        this.name = name;
        this.role = role;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", role=" + role +
                ", ID=" + ID +
                '}';
    }
}
