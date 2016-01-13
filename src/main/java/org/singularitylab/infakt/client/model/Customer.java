package org.singularitylab.infakt.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Jakub Dzon
 */
@JsonRootName("client")
public class Customer {

    public static class Builder {

        private String city;
        private int id;
        private String companyName;
        private String street;
        private String country;
        private String postalCode;
        private String nip;
        private String phoneNumber;
        private String email;
        private Integer daysToPayment;
        private PaymentMethod paymentMethod;

        private Builder() {
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder withStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder withNip(String nip) {
            this.nip = nip;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withDaysToPayment(Integer daysToPayment) {
            this.daysToPayment = daysToPayment;
            return this;
        }

        public Builder withPaymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Customer build() {
            Customer customer = new Customer();
            customer.setCity(city);
            customer.setId(id);
            customer.setCompanyName(companyName);
            customer.setStreet(street);
            customer.setCountry(country);
            customer.setPostalCode(postalCode);
            customer.setNip(nip);
            customer.setPhoneNumber(phoneNumber);
            customer.setEmail(email);
            customer.setDaysToPayment(daysToPayment);
            customer.setPaymentMethod(paymentMethod);
            return customer;
        }
    }

    private int id;

    @JsonProperty("company_name")
    private String companyName;

    private String street;

    private String city;

    private String country;

    @JsonProperty("postal_code")
    private String postalCode;

    private String nip;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String email;

    @JsonProperty("days_to_payment")
    private Integer daysToPayment;

    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDaysToPayment() {
        return daysToPayment;
    }

    public void setDaysToPayment(Integer daysToPayment) {
        this.daysToPayment = daysToPayment;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id=").append(id);
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", postalCode='").append(postalCode).append('\'');
        sb.append(", nip='").append(nip).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", daysToPayment=").append(daysToPayment);
        sb.append(", paymentMethod=").append(paymentMethod);
        sb.append('}');
        return sb.toString();
    }
}
