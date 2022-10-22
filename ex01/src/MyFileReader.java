import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class MyFileReader {
    private String filePath;
    private HashMap<String, Integer> fileContent;
    MyFileReader(String filePath){
        setFilePath(filePath);
    }

    MyFileReader(){
        filePath = null;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void readFile(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            String[] temp;
            fileContent = new HashMap<>();
            while ((line = reader.readLine()) != null){
                temp = line.split("\\s");
                for (String str : temp){
                    if (fileContent.containsKey(str)){
                        fileContent.put(str, fileContent.get(str) + 1);
                    }
                    else{
                        fileContent.put(str, 1);
                    }
                }
            }
            reader.close();
        }
        catch (Exception e){
            System.out.println("File not found");
            System.exit(-1);
        }
    }

    public HashMap<String, Integer> getFileContent() {
        return fileContent;
    }
}
