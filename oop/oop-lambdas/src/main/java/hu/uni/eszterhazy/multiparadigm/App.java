package hu.uni.eszterhazy.multiparadigm;

import javax.xml.parsers.DocumentBuilder;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Task: Given the quadraticEquations variable which stores the coefficients of Quadratic Equations (qudartic, linear, constatn).
 *
 *  - What is the Solution of these Equations ?
 *  - Which Equations has two/one/no solutions ?
 *  - Use Lambdas
 *
 *
 */
public class App 
{
    private static final Collection<List<Double>> quadraticEquations;

    static {
        quadraticEquations = Arrays.asList(
                Arrays.asList(1.0,4.0,4.0), // x1 = x2 = -2
                Arrays.asList(1.0,-4.0,4.0), // x1 = x2 = +2
                Arrays.asList(1.0,4.0,8.0), // No Solution
                Arrays.asList(1.0,3.2,4.0),
                Arrays.asList(8.2,12.0,-39.0),
                Arrays.asList(-21.12,42.0,29.0)
        );
    }

    public static void main( String[] args )
    {
        List<Double> numbers = Arrays.asList(2.0,4.0,-1.1,2.5, 9.1,12.0,-32.1);
/*
        numbers.sort(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o1.compareTo(o2);
            }
        });
        for (Double number : numbers){
            System.out.println(number);
        }
        System.out.println("--------------------");

 */
        List<Double> squares = numbers.stream()
                .filter(d -> d >= 0.0)
                .map( d -> Math.pow(d,2))
                .sorted((Double d1, Double d2)-> d2.compareTo(d1))
                .collect(Collectors.toList());
//        System.out.println("--------------------");
        squares.stream().forEach(System.out::println);
        System.out.println("--------------------");
        Double sum = squares.stream().reduce(0.0, (subtotal, current) -> subtotal + current);
        System.out.println(sum);
        System.out.println("--------------------");
        numbers.stream().forEach(System.out::println);
    }
}
