package com.rs.managment;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "accounts")
public class Account {

    @Id
    String account_id;
    String cust_id;
    String account_type;
}
