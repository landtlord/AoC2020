package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day2Puzzle1 {
    private List<String> input = new ArrayList<>();
    private int counter = 0;
    private int counter2 = 0;

    public void getResult() {
        try {
            File inputFile = new File("C:\\Devenv\\AoC2020\\src\\main\\resources\\input\\day2puzzle1.txt");
            Scanner inputReader = new Scanner(inputFile);
            while (inputReader.hasNextLine()) {
                String inputString = inputReader.nextLine();
                input.add(inputString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        input.forEach(this::isvalid);
        input.forEach(this::isvalid2);
        System.out.println("The answer for puzzle 1 is " + counter);
        System.out.println("The answer for puzzle 2 is " + counter2);
    }

    private void isvalid(String input) {
        //0 - numbers (xx-xx)
        //1 - char (x:)
        //2 - password
        String[] inputs = input.split(" ");

        Integer[] numbers = Arrays.stream(inputs[0].split("-"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Character character = inputs[1].charAt(0);

        int count = 0;
        for (int i = 0; i < inputs[2].length(); i++) {
            if (inputs[2].charAt(i) == character) {
                count++;
            }
        }

        if (numbers[0] <= count && numbers[1] >= count) {
            counter++;
        }
        ;
    }

    private void isvalid2(String input) {
        //0 - numbers (xx-xx)
        //1 - char (x:)
        //2 - password
        String[] inputs = input.split(" ");

        Integer[] numbers = Arrays.stream(inputs[0].split("-"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Character character = inputs[1].charAt(0);

        char char1 = inputs[2].charAt(numbers[0]-1);
        char char2 = inputs[2].charAt(numbers[1]-1);

        if ((char1 == character) ^ (char2 == character)){
            counter2++;
        }
    }

    public static void main(String[] args) {
        new Day2Puzzle1().getResult();
    }
}
