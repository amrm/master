package org.example.com.demo.modules.employee.model;

import org.example.com.demo.modules.lookup.model.Department;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * @author :Amr Abdeldayem
 */


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	@NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    @ManyToOne
    private Department department;

    @NotNull
    private Double salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
