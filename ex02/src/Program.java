import java.util.Scanner;

public class Program {
    public static void manageOperations(String input, String[] arg, DirectoryManagement directoryManagement){
        switch (input) {
            case "pwd":
                directoryManagement.displayDirectory();
                break ;
            case "ls":
                directoryManagement.displayContentOfDirectory();
                break;
            case "cd":
                if (arg.length > 2) {
                    System.err.println("Too many arguments, one expected");
                } else {
                    directoryManagement.setCurrentDirectory(arg[1]);
                }
                break;
            case "mv":
                if (arg.length != 3) {
                    System.err.println("Wrong number of arguments, two expected");
                } else {
                    directoryManagement.moveOrRename(arg[1], arg[2]);
                }
                break;
            case "exit":
                System.exit(0);
            default:
                System.err.println("Unknown command");
                break;
        }
    }

    public static void main(String[] args){
        if (args.length != 1){
            System.err.println("One argument expected, no more, no less");
            System.exit(-1);
        }
        String path = args[0];
        if (!path.startsWith("--current_folder=")){
            System.err.println("Wrong input");
            System.exit(-1);
        }
        path = path.substring(path.indexOf("=") + 1);
        try{
            DirectoryManagement directoryManagement = new DirectoryManagement(path);
            Scanner scanner = new Scanner(System.in);
            String input;
            String[] temp;

            directoryManagement.displayDirectory();
            while (true){
                input = scanner.nextLine();
                temp = input.split("\\s");
                input = temp[0];

                manageOperations(input, temp, directoryManagement);
            }
        }
        catch (IllegalArgumentException e){
            System.err.println("Path is not absolute");
            System.exit(-1);
        }


    }
}
