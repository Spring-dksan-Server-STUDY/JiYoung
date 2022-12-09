package com.example.jiyoung.study4;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CustomerJdbcRepository implements CustomerRepository{
    private static final Logger logger= LoggerFactory.getLogger(CustomerJdbcRepository.class);
    private static final String url = "jdbc:mysql://localhost/anmuserver";
    private static final String user = "root";
    private static final String password = "root1234!";

    @Override
    public Customer insert(Customer customer) {
        String INSERT_SQL="insert into customers(customer_id, name,age,email,created_at)"+
                "values(UUID_TO_BIN(?), ?, ?, ?, ?)";
        try(
            Connection connection= DriverManager.getConnection(url,user, password);
            PreparedStatement statement=connection.prepareStatement(INSERT_SQL);
        ){
         statement.setBytes(1, customer.getCustomerId().toString().getBytes());
         statement.setString(2, customer.getName());
            statement.setInt(3, customer.getAge());
            statement.setString(4, customer.getEmail());
            statement.setTimestamp(5, Timestamp.valueOf(customer.getCreatedAt()));
            statement.executeUpdate();
        }catch(SQLException e){
            logger.error("[insert] sql exception e:"+e);
        }
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        String UPDATE_SQL="update customers set name=?, age=?, email=? where customer_id=UUID_TO_BIN(?)";
        try(
                Connection connection= DriverManager.getConnection(url,user, password);
                PreparedStatement statement=connection.prepareStatement(UPDATE_SQL);
        ){
            statement.setString(1, customer.getName());
            statement.setInt(2, customer.getAge());
            statement.setString(3, customer.getEmail());
            statement.setBytes(4, customer.getCustomerId().toString().getBytes());
            statement.executeUpdate();
        }catch(SQLException e){
            logger.error("[update] sql exception e:"+e);
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers=new ArrayList<>();
        String FIND_ALL_SQL="select * from customers";

        try(
                Connection connection= DriverManager.getConnection(url,user, password);
                PreparedStatement statement=connection.prepareStatement(FIND_ALL_SQL);
                ResultSet resultSet=statement.executeQuery();
        ){
           while(resultSet.next()){
               UUID customerId= toUUID(resultSet.getBytes("customer_id"));
               String customerName=resultSet.getString("name");
               int age=resultSet.getInt("age");
               String email=resultSet.getString("email");
               LocalDateTime createdAt=resultSet.getTimestamp("created_at").toLocalDateTime();
               customers.add(new Customer(customerId, customerName, age, email, createdAt));
           }
        }catch(SQLException e){
            logger.error("[select] sql exception e:"+e);
        }
        return customers;
    }

    static UUID toUUID(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        return new UUID(byteBuffer.getLong(), byteBuffer.getLong());
    }
    @Override
    public Optional<Customer> findById(UUID customerId) {
        List<Customer> customers=new ArrayList<>();
        String FIND_BY_ID="select * from customers where customer_id=UUID_TO_BIN(?)";
        try(
                Connection connection= DriverManager.getConnection(url,user, password);
                PreparedStatement statement=connection.prepareStatement(FIND_BY_ID);
        ){
            statement.setBytes(1, customerId.toString().getBytes());
            try(ResultSet resultSet= statement.executeQuery()){
                while (resultSet.next()){
                    UUID id= toUUID(resultSet.getBytes("customer_id"));
                    String customerName=resultSet.getString("name");
                    int age=resultSet.getInt("age");
                    String email=resultSet.getString("email");
                    LocalDateTime createdAt=resultSet.getTimestamp("created_at").toLocalDateTime();
                    customers.add(new Customer(id, customerName, age, email, createdAt));
                }
            }
        }catch(SQLException e){
            logger.error("[find by id] sql exception e:"+e);
        }
        if(customers.isEmpty())
            return Optional.empty();
        return Optional.of(customers.get(0));
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customers=new ArrayList<>();
        String FIND_BY_NAME="select * from customers where name=?";
        try(
                Connection connection= DriverManager.getConnection(url,user, password);
                PreparedStatement statement=connection.prepareStatement(FIND_BY_NAME);
        ){
            statement.setString(1, name);
            try(ResultSet resultSet= statement.executeQuery()){
                while (resultSet.next()){
                    UUID id= toUUID(resultSet.getBytes("customer_id"));
                    String customerName=resultSet.getString("name");
                    int age=resultSet.getInt("age");
                    String email=resultSet.getString("email");
                    LocalDateTime createdAt=resultSet.getTimestamp("created_at").toLocalDateTime();
                    customers.add(new Customer(id, customerName, age, email, createdAt));
                }
            }
        }catch(SQLException e){
            logger.error("[find by name] sql exception e:"+e);
        }
        return customers;
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void deleteAll() {

    }

    public static void main(String[] args){
        CustomerRepository repository=new CustomerJdbcRepository();

        Customer customer= new Customer(UUID.randomUUID(), "jiyoung",25, "0112jyoung@naver.com", LocalDateTime.now());

        List<Customer> all=repository.findAll();
        all.forEach(c -> System.out.println(c.toString()));

        repository.findById(customer.getCustomerId());

        repository.findByName("jiyoung");

        Customer newCustomer= new Customer(UUID.randomUUID(), "양지영",25, "0112jyoung@naver.com", LocalDateTime.now());

        repository.update(newCustomer);
    }
}
