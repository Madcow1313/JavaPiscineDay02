import java.util.HashMap;

public class Program {
    public static void main(String[] args){
        MyFileReader myFileReader = new MyFileReader();
        HashMap<String, Integer> temp;
        DictionaryCreator dictionaryCreator;
        myFileReader.setFilePath("./ex01/src/1.txt");

        myFileReader.readFile();
        temp = myFileReader.getFileContent();

        myFileReader.setFilePath("./ex01/src/2.txt");
        myFileReader.readFile();

        dictionaryCreator = new DictionaryCreator(temp, myFileReader.getFileContent());
        dictionaryCreator.makeDictionary();

        FilesComparer filesComparer = new FilesComparer(temp, myFileReader.getFileContent());
        System.out.println(filesComparer.calculateSimilarity(dictionaryCreator.getDictionary()));
    }

}
