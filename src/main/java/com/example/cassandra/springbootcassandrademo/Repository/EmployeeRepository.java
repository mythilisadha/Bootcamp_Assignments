package com.example.cassandra.springbootcassandrademo.Repository;

import com.example.cassandra.springbootcassandrademo.model.Empployee;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface EmployeeRepository extends CassandraRepository<Empployee, Integer> {
//    @Query("select * from emp where emp_id = :#{#req. emp_id}")
//    Optional<Emp> isEmployeeExists(@Param("req") Emp req);
}
