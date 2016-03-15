package com.payitezy;

public enum DBSequences {

    SUBCATEGORY("SCAT"),
    ITEM("ITEM"),
    USERS("USER"),
    ADMINUSER("AUSER"),
    CATEGORY("CATG"),
    OFFER("OFFER"),
    ORDER("ORDR"),
    SELLER("SLLR"),
    CUSTOMER("CUST"),
    SUBORDER("SUBORDER"),
    PREORDERCARTITEMS("CART"),
    PREORDERQCARTITEMS("QCART"),
    ORDERITEM("ORDRITM");

    private String sequenceName;

    DBSequences(final String sequenceCode) {
        sequenceName = sequenceCode;
    }

    public String getSequenceName() {
        return sequenceName;
    }

}
