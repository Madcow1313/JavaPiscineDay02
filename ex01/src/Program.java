import java.util.Formatter;
import java.util.HashMap;

public class Program {
    public static void main(String[] args){
        if (args.length < 2){
            System.err.println("Need at least 2 arguments");
            System.exit(-1);
        }
        MyFileReader myFileReader = new MyFileReader();
        HashMap<String, Integer> temp;
        DictionaryCreator dictionaryCreator;
        double answer;

        myFileReader.setFilePath(args[0]);
        myFileReader.readFile();
        temp = myFileReader.getFileContent();

        myFileReader.setFilePath(args[1]);
        myFileReader.readFile();

        dictionaryCreator = new DictionaryCreator(temp, myFileReader.getFileContent());
        dictionaryCreator.makeDictionary();

        FilesComparer filesComparer = new FilesComparer(temp, myFileReader.getFileContent());
        answer = filesComparer.calculateSimilarity(dictionaryCreator.getDictionary());
        System.out.println("Similarity = " + Math.floor(answer * 100) / 100.0);
    }

}
