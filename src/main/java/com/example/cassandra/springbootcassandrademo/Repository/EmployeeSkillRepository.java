package com.example.cassandra.springbootcassandrademo.Repository;

import com.example.cassandra.springbootcassandrademo.model.Employee_Skill;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface EmployeeSkillRepository extends CassandraRepository<Employee_Skill, Double> {
}
