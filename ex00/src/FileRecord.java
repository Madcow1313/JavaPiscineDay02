import java.io.FileOutputStream;
import java.util.Scanner;

public class FileRecord {
    private String pathToWriteResults;
    FileRecord (){

    }

    public void setPathToWriteResults(String pathToWriteResults) {
        this.pathToWriteResults = pathToWriteResults;
    }

    public void writeToFile(String str){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathToWriteResults, true);
            fileOutputStream.write(str.getBytes());
        }
        catch (Exception e){
            System.err.println(e.toString());
        }

    }

    public void Record(Scanner scanner, Reader reader, SignaturesFileReader sfReader,FileChecker fileChecker){
        String path;
        String signature;
        while (!(path = scanner.nextLine()).equals("42")){
            reader.setFilePath(path);
            signature = reader.readSignature();
            if (signature != null){
                signature = signature.toUpperCase();
                if (fileChecker.CheckFile(signature)){
                    writeToFile(sfReader.getTypeMap().get(signature) + "\n");
                    System.out.println("PROCESSED");
                }
                else{
                    System.out.println("UNDEFINED");
                }
            }
            else{
                System.out.println("No signature for nonexistent file");
            }
        }
    }
}
