package com.example.cassandra.springbootcassandrademo.Controller;


import com.example.cassandra.springbootcassandrademo.Repository.EmployeeRepository;
import com.example.cassandra.springbootcassandrademo.Repository.EmployeeSkillRepository;
import com.example.cassandra.springbootcassandrademo.ResouceNotFoundException;
import com.example.cassandra.springbootcassandrademo.model.Empployee;
import com.example.cassandra.springbootcassandrademo.model.Employee_Skill;
import com.example.cassandra.springbootcassandrademo.model.EmployeeInformation;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

//    @Autowired
//    ProductRepository productRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeSkillRepository employeeSkillRepository;

    @PostMapping("/createEmployee")
    public EmployeeInformation createEmployeeInfo(@RequestBody EmployeeInformation employeeInformation){
        Empployee empployee = new Empployee(employeeInformation.getEmp_id(),
                employeeInformation.getEmp_name(), employeeInformation.getEmp_city(),
                employeeInformation.getEmp_phone());
        Employee_Skill emp_skill = new Employee_Skill(employeeInformation.getEmp_id(),
                employeeInformation.getJava_exp(), employeeInformation.getSpring_exp());
        boolean empIsPresent =  employeeRepository.findById(employeeInformation.getEmp_id()).isPresent();
        if(empIsPresent){
            employeeInformation.setStatus("Already Exists");
        } else {
            employeeInformation.setStatus("Created");
        }
        employeeRepository.save(empployee);
        employeeSkillRepository.save(emp_skill);

//        KafkaProducer<String, String> first_producer = new

        return employeeInformation;

    }
//
//    @PostMapping("/products")
//    public Product addProduct(@RequestBody Product product){
//        productRepository.save(product);
//        return product;
//
//    }
//
//    @GetMapping("/products/{id}")
//    public ResponseEntity<Product> findById(@PathVariable("id") Integer productId){
//        Product product=productRepository.findById(productId).orElseThrow(
//                () -> new ResouceNotFoundException("Product not found" + productId));
//        return ResponseEntity.ok().body(product);
//    }
//
//
//
//    @GetMapping("/products")
//    public List<Product> getProducts(){
//
//        return productRepository.findAll();
//    }
//
//    @PutMapping("products/{id}")
//    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Integer productId,
//                                                  @RequestBody Product productDetails) {
//        Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new ResouceNotFoundException("Product not found for this id :: " + productId));
//        product.setName(productDetails.getName());
//        final Product updatedProduct = productRepository.save(product);
//        return ResponseEntity.ok(updatedProduct);
//
//    }
//
//    @DeleteMapping("products/{id}")
//    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") Integer productId) {
//        Product product = productRepository.findById(productId).orElseThrow(
//                () -> new ResouceNotFoundException("Product not found::: " + productId));
//        productRepository.delete(product);
//        return ResponseEntity.ok().build();
//    }

}


