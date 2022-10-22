import java.util.HashMap;
import java.util.HashSet;
import java.lang.Math;

public class FilesComparer {
    HashMap<String, Integer> firstFileContent;
    HashMap<String, Integer> secondFileContent;


    FilesComparer(HashMap<String, Integer> firstFileContent, HashMap<String, Integer> secondFileContent){
        this.firstFileContent = firstFileContent;
        this.secondFileContent = secondFileContent;
    }

    public double calculateSimilarity(HashSet<String> dictionary){
        double similarity = 0;
        int numerator = 0;
        int denominatorA = 0;
        int denominatorB = 0;
        int firstNumber;
        int secondNumber;

        for (String str: dictionary){
            firstNumber = firstFileContent.getOrDefault(str, 0);
            secondNumber = secondFileContent.getOrDefault(str, 0);
            numerator += firstNumber * secondNumber;
            denominatorA += firstNumber * firstNumber;
            denominatorB += secondNumber * secondNumber;
        }
        similarity = numerator / (roundToTwoDigits(Math.sqrt((double) denominatorA) *
                    Math.sqrt((double) denominatorB)));
        return similarity;
    }

    private double roundToTwoDigits(double number){
        return Math.round(number * 100) / 100.0;
    }
}
