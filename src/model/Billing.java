package model;

import java.io.Serializable;

public class Billing implements Serializable {
    private static final long serialVersionUID = 1L;

    private String invoiceNo;
    private String date;
    private String petId;
    private String service;
    private double amount;
    private String status; // Paid / Unpaid

    public Billing(String invoiceNo, String date, String petId, String service, double amount, String status) {
        this.invoiceNo = invoiceNo;
        this.date = date;
        this.petId = petId;
        this.service = service;
        this.amount = amount;
        this.status = status;
    }

    public String getInvoiceNo() { return invoiceNo; }
    public void setInvoiceNo(String invoiceNo) { this.invoiceNo = invoiceNo; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getPetId() { return petId; }
    public void setPetId(String petId) { this.petId = petId; }
    public String getService() { return service; }
    public void setService(String service) { this.service = service; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
