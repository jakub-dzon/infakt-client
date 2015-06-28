package org.singularitylab.infakt.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jakub Dzon
 */
public class Service {

    private String name;

    @JsonProperty("tax_symbol")
    private String taxSymbol;

    private String unit;

    private int quantity;

    @JsonProperty("unit_net_price")
    private int unitNetPrice;

    @JsonProperty("net_price")
    private int netPrice;

    @JsonProperty("gross_price")
    private int grossPrice;

    @JsonProperty("tax_price")
    private int taxPrice;

    private String symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxSymbol() {
        return taxSymbol;
    }

    public void setTaxSymbol(String taxSymbol) {
        this.taxSymbol = taxSymbol;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitNetPrice() {
        return unitNetPrice;
    }

    public void setUnitNetPrice(int unitNetPrice) {
        this.unitNetPrice = unitNetPrice;
    }

    public int getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(int netPrice) {
        this.netPrice = netPrice;
    }

    public int getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(int grossPrice) {
        this.grossPrice = grossPrice;
    }

    public int getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(int taxPrice) {
        this.taxPrice = taxPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Service{");
        sb.append("name='").append(name).append('\'');
        sb.append(", taxSymbol='").append(taxSymbol).append('\'');
        sb.append(", unit='").append(unit).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", unitNetPrice=").append(unitNetPrice);
        sb.append(", netPrice=").append(netPrice);
        sb.append(", grossPrice=").append(grossPrice);
        sb.append(", taxPrice=").append(taxPrice);
        sb.append(", symbol='").append(symbol).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
