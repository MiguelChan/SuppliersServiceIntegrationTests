package com.mgl.suppliersservice.integration.clients.models;

/**
 * Defines the Type of Contacts available.
 */
public enum ContactType {

    SALES_REP("SALES_REP"),
    RETURNS("RETURNS");

    /**
     * .
     */
    private String type;

    /**
     * .
     *
     * @param type .
     */
    ContactType(String type) {
        this.type = type;
    }

    /**
     * .
     *
     * @return .
     */
    public String getType() {
        return this.type;
    }

}
