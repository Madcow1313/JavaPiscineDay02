import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class DictionaryCreator {
    HashMap<String, Integer> firstFileContent;
    HashMap<String, Integer> secondFileContent;
    HashSet<String> dictionary;

    DictionaryCreator(HashMap<String, Integer> firstFileContent, HashMap<String, Integer> secondFileContent){
        this.firstFileContent = firstFileContent;
        this.secondFileContent = secondFileContent;
    }

    public HashSet<String> makeDictionary(){
        dictionary = new HashSet<>();
        dictionary.addAll(firstFileContent.keySet());
        dictionary.addAll(secondFileContent.keySet());
        try{
            FileWriter fileWriter = new FileWriter("dictionary.txt");
            for (String key : dictionary){
                fileWriter.write(key);
                fileWriter.write("\n");
            }
            fileWriter.close();
        }
        catch (IOException e){
            System.err.println("Something went wrong with creating file");
            System.exit(-1);
        }
        return dictionary;
    }

    public HashSet<String> getDictionary() {
        return dictionary;
    }
}
