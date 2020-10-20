package hu.uni.eszterhazy.multiparadigm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


/**
 *  Taks:
 *   - Read points from data/points.data
 *   - Calculate the distance of the points and find the closest points.
 *   - Use different Distance Metrics (Euclidean, Manhattan)
 */
public class DistanceApp {

    public static void main(String[] args) throws IOException {
//        Collection<List<Integer>> points  = generatePoints(100);
//        points.forEach(point -> System.out.println(String.format("%d,%d", point.get(0),point.get(1))));
//        savePoints("data/points.data",points);

    }

    private static Collection<List<Integer>> generatePoints(int numberOfPoints){
        Collection<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < numberOfPoints; i++){
            result.add(Arrays.asList(
                    (int) Math.floor(Math.random() * 100),
                    (int) Math.floor(Math.random() * 100)
            ));
        }
        return result;
    }

    private static void savePoints(String filePath, Collection<List<Integer>> points) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(filePath));
        points.forEach(point -> {
            try {
                fileWriter.write(String.format("%d,%d\n", point.get(0),point.get(1) ));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fileWriter.close();
    }
}
