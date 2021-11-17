package hu.uni.ekcu.java;

import hu.uni.ekcu.java.service.Notifier;
import hu.uni.ekcu.java.service.NotifierStdErrImpl;
import hu.uni.ekcu.java.service.NotifierStdOutImpl;
import hu.uni.ekcu.java.service.PrimeService;
import hu.uni.ekcu.java.service.QuadraticSolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");
        PrimeService service = context.getBean(PrimeService.class);
        QuadraticSolver solver = context.getBean(QuadraticSolver.class);
        System.out.println(service.isPrime(5));

        Arrays.stream(solver.solve(1, -1, -6)).forEach(System.out::println);

        QuadraticSolver.Equation equation = new QuadraticSolver.Equation(1, -1, -6);
        QuadraticSolver.Solution solution = solver.solve(equation);
        System.out.println(String.format("%f, %f", solution.getX1(), solution.getX2()));

        Notifier notifier = new NotifierStdOutImpl();
        notifier.notify("Hello World");
    }
}
