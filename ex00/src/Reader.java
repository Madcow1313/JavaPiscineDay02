
import java.io.FileInputStream;

public class Reader {
    private String filePath;
    private String signature;
    Reader(String filePath){
        setFilePath(filePath);
    }

    Reader(){}

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getSignature() {
        return signature;
    }

    public String readSignature(){
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            byte[] temp = new byte[8];
            fileInputStream.read(temp, 0, 8);
            signature = byteArrayToHex(temp);
            return signature;
        }
        catch (Exception e){}
        return null;
    }
    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a)
            sb.append(String.format("%02x", b));
        return sb.toString();
    }
}
