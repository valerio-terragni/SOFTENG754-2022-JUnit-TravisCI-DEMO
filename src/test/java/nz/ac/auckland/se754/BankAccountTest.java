package nz.ac.auckland.se754;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    BankAccount bankAccount;
    @BeforeEach
    public void setup(){
        bankAccount = new BankAccount();
        bankAccount.deposit(100);
    }

    @Test
    public void test_deposit(){

        double actual = bankAccount.getBalance();
        assertEquals(100,actual,0.00000001);
    }

    @Test
    public void test_deposit2(){
        bankAccount.deposit(10);
        double actual = bankAccount.getBalance();
        assertEquals(110,actual,0.00000001);
    }

    @Test
    public void test_withdraw(){
        bankAccount.withdraw(10);
        double actual = bankAccount.getBalance();
        assertEquals(90,actual,0.00000001);
    }

    @Test
    public void test_withdraw_exception_not(){
        try {
            bankAccount.withdraw(1);
        }catch(BalanceNotEnoughException e){
            fail();
        }

    }
    @Test
    public void test_withdraw_exception(){

        assertThrows(BalanceNotEnoughException.class,  () -> {bankAccount.withdraw(1000);});

    }

}