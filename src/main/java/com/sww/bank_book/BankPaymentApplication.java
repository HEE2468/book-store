package com.sww.bank_book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class BankPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankPaymentApplication.class, args);
    }

}
