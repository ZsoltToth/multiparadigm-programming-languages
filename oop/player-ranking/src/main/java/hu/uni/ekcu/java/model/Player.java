package hu.uni.ekcu.java.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class Player {

    private String name;

    @Setter
    @EqualsAndHashCode.Exclude
    private int score;
}
