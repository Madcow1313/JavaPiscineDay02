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
        return dictionary;
    }

    public HashSet<String> getDictionary() {
        return dictionary;
    }
}
