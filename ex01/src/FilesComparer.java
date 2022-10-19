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
            if (firstFileContent.containsKey(str)){
                firstNumber = firstFileContent.get(str);
            }
            else{
                firstNumber = 0;
            }
            if (secondFileContent.containsKey(str)){
                secondNumber =secondFileContent.get(str);
            }
            else{
                secondNumber = 0;
            }
            numerator += firstNumber * secondNumber;
            denominatorA += firstNumber * firstNumber;
            denominatorB += secondNumber * secondNumber;
        }
        similarity = numerator / (Math.sqrt((double) denominatorA) * Math.sqrt((double) denominatorB));
        return similarity;
    }
}
