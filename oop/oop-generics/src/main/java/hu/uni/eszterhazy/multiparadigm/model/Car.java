package hu.uni.eszterhazy.multiparadigm.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Car {

    private final String palteNo;
    private final String color;
    private final String manufacturer;
    private final String model;

}
