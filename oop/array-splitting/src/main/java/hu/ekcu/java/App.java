package hu.ekcu.java;

import hu.ekcu.java.service.ArraySlices;
import hu.ekcu.java.service.ArraySplitter;
import hu.ekcu.java.service.ArraySplitterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Collection;


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
        String[] input = new String[] {"Boy", "Girl", "Boy", "Boy", "Girl", "Girl", "Boy"};
        ArraySplitter splitter = context.getBean(ArraySplitter.class);
        Collection<ArraySlices> slices = splitter.split(input, 2);
        slices.stream().forEach(System.out::println);
    }
}
