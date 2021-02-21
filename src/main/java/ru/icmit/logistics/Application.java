package ru.icmit.logistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        String salt = BCrypt.gensalt();
        String password = BCrypt.hashpw("admin$2a$10$6Uk0S2.19RU1v9.tcQyaIu", salt);

        System.out.println("salt: " + salt + " , password: " + password);

        SpringApplication.run(Application.class, args);
    }
}