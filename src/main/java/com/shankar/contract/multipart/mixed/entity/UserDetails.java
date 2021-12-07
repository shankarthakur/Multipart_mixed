package com.shankar.contract.multipart.mixed.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserDetails {

    private int userId;
    private String name;
    private String contact;
}
