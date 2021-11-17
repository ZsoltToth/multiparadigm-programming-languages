package hu.uni.ekcu.java.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Player {

    private String name;

    @Setter
    private int score;
}
