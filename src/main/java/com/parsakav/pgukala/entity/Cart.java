package com.parsakav.pgukala.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data

public class Cart implements Serializable {
    private long token;
    private User u;



}
