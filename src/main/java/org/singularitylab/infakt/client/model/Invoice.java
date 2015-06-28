package org.singularitylab.infakt.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Jakub Dzon
 */
public class Invoice {
    private int id;

    private String number;

    private Currency currency;

    @JsonProperty("paid_price")
    private int paidPrice;

    private String notes;

    private InvoiceKind kind;

    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("seller_signature")
    private String sellerSignature;

    @JsonProperty("invoice_date")
    private String invoiceDate;

    @JsonProperty("sale_date")
    private String saleDate;

    @JsonProperty("payment_date")
    private String paymentDate;

    @JsonProperty("net_price")
    private int netPrice;

    @JsonProperty("tax_price")
    private int taxPrice;

    @JsonProperty("gross_price")
    private int grossPrice;

    @JsonProperty("client_id")
    private int clientId;

    @JsonProperty("bank_name")
    private String bankName;

    @JsonProperty("bank_account")
    private String bankAccount;

    private List<Service> services;

    @JsonProperty("sale_type")
    private SaleType saleType;

    private String swift;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(int paidPrice) {
        this.paidPrice = paidPrice;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public InvoiceKind getKind() {
        return kind;
    }

    public void setKind(InvoiceKind kind) {
        this.kind = kind;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getSellerSignature() {
        return sellerSignature;
    }

    public void setSellerSignature(String sellerSignature) {
        this.sellerSignature = sellerSignature;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(int netPrice) {
        this.netPrice = netPrice;
    }

    public int getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(int taxPrice) {
        this.taxPrice = taxPrice;
    }

    public int getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(int grossPrice) {
        this.grossPrice = grossPrice;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public SaleType getSaleType() {
        return saleType;
    }

    public void setSaleType(SaleType saleType) {
        this.saleType = saleType;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Invoice{");
        sb.append("id=").append(id);
        sb.append(", number='").append(number).append('\'');
        sb.append(", currency=").append(currency);
        sb.append(", paidPrice=").append(paidPrice);
        sb.append(", notes='").append(notes).append('\'');
        sb.append(", kind='").append(kind).append('\'');
        sb.append(", paymentMethod='").append(paymentMethod).append('\'');
        sb.append(", sellerSignature='").append(sellerSignature).append('\'');
        sb.append(", invoiceDate='").append(invoiceDate).append('\'');
        sb.append(", saleDate='").append(saleDate).append('\'');
        sb.append(", paymentDate='").append(paymentDate).append('\'');
        sb.append(", netPrice=").append(netPrice);
        sb.append(", taxPrice=").append(taxPrice);
        sb.append(", grossPrice=").append(grossPrice);
        sb.append(", clientId=").append(clientId);
        sb.append(", bankName='").append(bankName).append('\'');
        sb.append(", bankAccount='").append(bankAccount).append('\'');
        sb.append(", services=").append(services);
        sb.append(", saleType='").append(saleType).append('\'');
        sb.append(", swift='").append(swift).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
