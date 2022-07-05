package com.eebookhouse.entity;

import lombok.Data;

@Data
public class User {

    public static final int POWER_USER = 0;
    public static final int POWER_ADMIN= 1;

    Integer id;
    String username;
    String userpass;
    String email;
    String address;
    String postcode;
    Integer level;
    Integer power;
}
