package org.example.com.demo.modules.employee.repo;

import org.example.com.demo.modules.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * @author :Amr Abdeldayem
 */


@Repository
public interface EmployeeRepository extends JpaSpecificationExecutor<Employee>, JpaRepository<Employee, Long> {

    public List<Employee> findByNameIgnoreCaseContaining(String name);
    public Optional<Employee> findByEmail(String email);
    public Optional<Employee> findById(Long id);

   }
