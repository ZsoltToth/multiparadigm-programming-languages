package hu.uni.eszterhazy.multiparadigm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExamEvaluationApp {

    /**
     * Read the exam_results.data file from the data directory.
     * Decide whether a student passed on the exam or failed.
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        if(args.length != 2){
            return;
        }
        final String RAW_DATA_FILE_PATH = args[0];
        final Integer EXAM_PASS_THRESHOLD = Integer.parseInt(args[1]);
        Files.lines(Path.of(RAW_DATA_FILE_PATH))
                .map(line -> {
                    String name = line.split(",")[0];
                    Integer score = Integer.parseInt(line.split(",")[1]);
                    String examResult = score >= EXAM_PASS_THRESHOLD ? "PASSED" : "FAILED";
                    return String.format("%s, %s", name, examResult);
                })
                .forEach(System.out::println);
    }
}
