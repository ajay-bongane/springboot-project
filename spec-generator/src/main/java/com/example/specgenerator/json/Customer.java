package com.example.specgenerator.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private int age;
    private String[] projects;
    private Address address;
    private List<String>  paymentMethods;
    private Map<String, Object> profileInfo;
}
