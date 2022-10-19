import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        SignaturesFileReader sfReader = new SignaturesFileReader("/Users/wabathur/signatures.txt");
        FileChecker fileChecker = new FileChecker(sfReader.readSignaturesFile());
        FileRecord fileRecord = new FileRecord();
        Reader reader = new Reader();
        fileRecord.setPathToWriteResults("results.txt");
        Scanner scanner = new Scanner(System.in);

        fileRecord.Record(scanner, reader, sfReader, fileChecker);
    }
}
