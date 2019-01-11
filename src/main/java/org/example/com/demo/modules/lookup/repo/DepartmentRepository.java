package org.example.com.demo.modules.lookup.repo;

import org.example.com.demo.modules.lookup.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * @author :Amr Abdeldayem
 */


@Repository
public interface DepartmentRepository extends JpaSpecificationExecutor<Department>, JpaRepository<Department, Long> {
    public Optional<Department> findByName(String name);
}
