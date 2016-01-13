package org.singularitylab.infakt.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * @author Jakub Dzon
 */
@JsonRootName("invoice")
public class Invoice {

    public static class Builder {

        private String bankAccount;
        private int id;
        private String number;
        private Currency currency;
        private int paidPrice;
        private String notes;
        private InvoiceKind kind;
        private PaymentMethod paymentMethod;
        private String sellerSignature;
        private String invoiceDate;
        private String saleDate;
        private String paymentDate;
        private int netPrice;
        private int taxPrice;
        private int grossPrice;
        private int clientId;
        private String clientCompanyName;
        private String bankName;
        private List<Service> services;
        private SaleType saleType;
        private String swift;

        private Builder() {
        }

        public Builder withBankAccount(String bankAccount) {
            this.bankAccount = bankAccount;
            return this;
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withNumber(String number) {
            this.number = number;
            return this;
        }

        public Builder withCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public Builder withPaidPrice(int paidPrice) {
            this.paidPrice = paidPrice;
            return this;
        }

        public Builder withNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public Builder withKind(InvoiceKind kind) {
            this.kind = kind;
            return this;
        }

        public Builder withPaymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder withSellerSignature(String sellerSignature) {
            this.sellerSignature = sellerSignature;
            return this;
        }

        public Builder withInvoiceDate(String invoiceDate) {
            this.invoiceDate = invoiceDate;
            return this;
        }

        public Builder withSaleDate(String saleDate) {
            this.saleDate = saleDate;
            return this;
        }

        public Builder withPaymentDate(String paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder withNetPrice(int netPrice) {
            this.netPrice = netPrice;
            return this;
        }

        public Builder withTaxPrice(int taxPrice) {
            this.taxPrice = taxPrice;
            return this;
        }

        public Builder withGrossPrice(int grossPrice) {
            this.grossPrice = grossPrice;
            return this;
        }

        public Builder withClientId(int clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder withClientCompanyName(String clientCompanyName) {
            this.clientCompanyName = clientCompanyName;
            return this;
        }

        public Builder withBankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public Builder withServices(List<Service> services) {
            this.services = services;
            return this;
        }

        public Builder withSaleType(SaleType saleType) {
            this.saleType = saleType;
            return this;
        }

        public Builder withSwift(String swift) {
            this.swift = swift;
            return this;
        }

        public Invoice build() {
            Invoice invoice = new Invoice();
            invoice.setBankAccount(bankAccount);
            invoice.setId(id);
            invoice.setNumber(number);
            invoice.setCurrency(currency);
            invoice.setPaidPrice(paidPrice);
            invoice.setNotes(notes);
            invoice.setKind(kind);
            invoice.setPaymentMethod(paymentMethod);
            invoice.setSellerSignature(sellerSignature);
            invoice.setInvoiceDate(invoiceDate);
            invoice.setSaleDate(saleDate);
            invoice.setPaymentDate(paymentDate);
            invoice.setNetPrice(netPrice);
            invoice.setTaxPrice(taxPrice);
            invoice.setGrossPrice(grossPrice);
            invoice.setClientId(clientId);
            invoice.setClientCompanyName(clientCompanyName);
            invoice.setBankName(bankName);
            invoice.setServices(services);
            invoice.setSaleType(saleType);
            invoice.setSwift(swift);
            return invoice;
        }
    }

    private int id;

    private String number;

    private Currency currency;

    @JsonProperty("paid_price")
    private int paidPrice;

    private String notes;

    private InvoiceKind kind;

    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;

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

    @JsonProperty("client_company_name")
    private String clientCompanyName;

    @JsonProperty("bank_name")
    private String bankName;

    @JsonProperty("bank_account")
    private String bankAccount;

    @JsonProperty("services")
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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
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

    public String getClientCompanyName() {
        return clientCompanyName;
    }

    public void setClientCompanyName(String clientCompanyName) {
        this.clientCompanyName = clientCompanyName;
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
        sb.append(", clientCompanyName=").append(clientCompanyName);
        sb.append(", bankName='").append(bankName).append('\'');
        sb.append(", bankAccount='").append(bankAccount).append('\'');
        sb.append(", services=").append(services);
        sb.append(", saleType='").append(saleType).append('\'');
        sb.append(", swift='").append(swift).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static Builder builder() {
        return new Builder();
    }
}
