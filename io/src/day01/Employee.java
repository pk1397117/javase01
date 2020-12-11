package day01;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 6944187850785615121L;
    private String name;
    private int age;
    private double galaxy;

    public Employee() {
    }

    public Employee(String name, int age, double galaxy) {
        this.name = name;
        this.age = age;
        this.galaxy = galaxy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(double galaxy) {
        this.galaxy = galaxy;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", galaxy='" + galaxy + '\'' +
                '}';
    }
}
class Manager extends Employee implements Serializable{
    private static final long serialVersionUID = -8287020466990745823L;
    private Employee secretary;

    public Employee getSecretary() {
        return secretary;
    }

    public void setSecretary(Employee secretary) {
        this.secretary = secretary;
    }

    public Manager(){

    }
    public Manager(Employee e){
        setSecretary(e);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "secretary=" + secretary +
                '}';
    }
}
