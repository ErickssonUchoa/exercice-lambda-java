package entities;

public class Employee {

    private String name;
    private String email;
    private Double wage;

    public Employee(String name, String email, Double wage) {
        this.name = name;
        this.email = email;
        this.wage = wage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }


}
