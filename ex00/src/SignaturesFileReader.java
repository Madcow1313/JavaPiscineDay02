import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class SignaturesFileReader {
    private String pathToSignaturesFile;
    private HashMap<String, String> typeMap;

    SignaturesFileReader(String pathToSignaturesFile){
        this.pathToSignaturesFile = pathToSignaturesFile;
        typeMap = new HashMap<>();
    }

    public HashMap<String, String> readSignaturesFile(){
        try{
            FileInputStream fileInputStream = new FileInputStream(pathToSignaturesFile);
            Scanner scanner = new Scanner(fileInputStream);
            String temp;
            while (scanner.hasNextLine()){
                temp = scanner.next();
                temp = temp.substring(0, temp.indexOf(','));
                typeMap.put(scanner.nextLine().replaceAll("\\s", ""), temp);
            }
            fileInputStream.close();
            scanner.close();
        }
        catch (Exception error){
            System.err.println(error.toString());
        }
        return typeMap;
    }

    public HashMap<String, String> getTypeMap() {
        return typeMap;
    }
}
