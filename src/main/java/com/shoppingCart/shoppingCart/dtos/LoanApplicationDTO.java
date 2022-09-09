package com.shoppingCart.shoppingCart.dtos;

public class LoanApplicationDTO {

    private Long LoanId;
    private Double amount;
    private int payments;
    private String toAccountNumber;


    public LoanApplicationDTO() {
    }

    public LoanApplicationDTO(Long loanId, Double amount, int payments, String toAccountNumber) {
        LoanId = loanId;
        this.amount = amount;
        this.payments = payments;
        this.toAccountNumber = toAccountNumber;
    }

    public Long getLoanId() {
        return LoanId;
    }

    public void setLoanId(Long loanId) {
        LoanId = loanId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public int getPayments() {
        return payments;
    }

    public void setPayments(int payments) {
        this.payments = payments;
    }

    public String getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(String toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }
}
