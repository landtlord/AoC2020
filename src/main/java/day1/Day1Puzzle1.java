package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1Puzzle1 {
    List<Integer> input = new ArrayList<>();

    public void getResult() {
        try {
            File inputFile = new File("C:\\Devenv\\AoC2020\\src\\main\\resources\\input\\day1puzzle1.txt");
            Scanner inputReader = new Scanner(inputFile);
            while (inputReader.hasNextInt()){
                input.add(inputReader.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        input.forEach(this::getResultOutput);
        input.forEach(this::getResultOutputPuzzle2);
    }

    private void getResultOutput(Integer x) {
        for (Integer y:input) {
            if( (x + y) == 2020){
                Integer output = x * y;
                System.out.println("Puzzle 1 answer = " + output);
            }
        }
    }

    private void getResultOutput(Integer x, Integer y) {
        for (Integer z:input) {
            if( (x + y + z) == 2020){
                Integer output = x * y * z;
                System.out.println("Puzzle 2 answer = " + output);
            }
        }
    }

    private void getResultOutputPuzzle2(Integer x){
        input.forEach(y -> getResultOutput( x, y));
    }

    public static void main(String[] args) {
        new Day1Puzzle1().getResult();
    }
}
