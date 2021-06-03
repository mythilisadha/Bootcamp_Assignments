package com.example.cassandra.springbootcassandrademo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
public class Employee_Skill {
    private int emp_id;
    @PrimaryKey
    private double java_exp;
    private double spring_exp;

    public Employee_Skill(){}

    public Employee_Skill(int emp_id, double java_exp, double spring_exp) {
        this.emp_id = emp_id;
        this.java_exp = java_exp;
        this.spring_exp = spring_exp;
    }
}
