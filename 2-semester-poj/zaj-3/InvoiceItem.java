/* Author: Sandro Sobczyński */

package com.company;

import java.util.Locale;

public class InvoiceItem {

    private String id;
    private String desc;
    private int qty;
    private double unitPrice;

    public InvoiceItem(String id, String desc, int qty, double unitPrice) {
        this.id = id;
        this.desc = desc;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return this.id;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int value) {
        this.qty = value;
    }

    public double getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(double value) {
        this.unitPrice = value;
    }

    public double getTotal() {
        return this.unitPrice * this.qty;
    }

    public String toString() {
        return String.format(Locale.US, "InvoiceItem[id=%s,desc=%s,qty=%d,unitPrice=%.2f]", this.getId(),
                this.getDesc(), this.getQty(), this.getUnitPrice());
    }

}