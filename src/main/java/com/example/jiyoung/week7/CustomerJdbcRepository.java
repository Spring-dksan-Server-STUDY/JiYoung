package com.example.jiyoung.week7;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.nio.ByteBuffer;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class CustomerJdbcRepository implements CustomerRepository{
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CustomerJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Customer insert(Customer customer) {
        String INSERT_SQL = "INSERT INTO customers (customer_id, name, age, email, created_at) VALUES (UUID_TO_BIN(:customerId), :name, :age, :email, :createdAt)";
        int update=jdbcTemplate.update(INSERT_SQL, toCustomerParamMap(customer));
        if(update!=-1){
            throw new RuntimeException("noting inserted");
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        String FIND_SQL="SELECT * FROM customers";
        return jdbcTemplate.query(FIND_SQL,customerRowMapper);
    }

    @Override
    public Optional<Customer> findById(UUID customerId) {
        return Optional.empty();
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public void deleteAll() {

    }
    private Map<String, Object> toCustomerParamMap(Customer customer) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("customerId", customer.getCustomerId().toString().getBytes());
        paramMap.put("name", customer.getName());
        paramMap.put("age", customer.getAge());
        paramMap.put("email", customer.getEmail());
        paramMap.put("createdAt", customer.getCreateAt());
        return paramMap;
    }

    public static UUID toUUID(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        return new UUID(byteBuffer.getLong(), byteBuffer.getLong());
    }

    public static LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }

    private static final RowMapper<Customer> customerRowMapper = (resultSet, i) -> {
        UUID customerId = toUUID(resultSet.getBytes("customer_id"));
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String email = resultSet.getString("email");
        LocalDateTime createdAt = toLocalDateTime(resultSet.getTimestamp("created_at"));
        return new Customer(customerId, name, age, email, createdAt);
    };


}
