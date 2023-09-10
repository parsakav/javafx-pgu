package com.parsakav.pgukala.entity;

import java.io.Serializable;

public enum StuffType implements Serializable {
    MOBILE("Mobile"),CLOTHING("Clothing"),HOMEAPPLIANCES("Home Appliances")
    ,ELECTRICALAPPLIANCES("Electrical Applicances");
    private String name;

    StuffType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
