package com.sww.bank_book;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BankPaymentApplication.class)
class BankPaymentApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("------测试断点--------");
    }

}
