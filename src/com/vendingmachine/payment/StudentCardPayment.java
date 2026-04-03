package com.vendingmachine.payment;

public class StudentCardPayment implements PaymentStrategy {
    private String studentId;

    public StudentCardPayment(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean pay(double amount) {
        return studentId != null && !studentId.isBlank();
    }
}
