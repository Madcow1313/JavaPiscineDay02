import java.io.FileInputStream;
import java.util.HashMap;

public class FileChecker {
    private HashMap<String, String> typeMap;

    FileChecker(HashMap<String, String> typeMap){
        this.typeMap = typeMap;
    }

    public boolean CheckFile(String signature){
        signature = signature.toUpperCase();
        if (typeMap.containsKey(signature))
            return true;
        return false;
    }
}
