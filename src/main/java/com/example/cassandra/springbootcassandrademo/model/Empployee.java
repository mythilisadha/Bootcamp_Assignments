package com.example.cassandra.springbootcassandrademo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
public class Empployee {
    @PrimaryKey
    private int emp_id;
    private String emp_name;
    private String emp_city;
    private String emp_phone;

    public Empployee(){}

    public Empployee(int emp_id, String emp_name, String emp_city, String emp_phone) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_city = emp_city;
        this.emp_phone = emp_phone;
    }
}
