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
                    System.err.println("cd error: too many arguments");
                } else {
                    directoryManagement.setCurrentDirectory(arg[1]);
                }
                break;
            case "mv":
                if (arg.length != 3) {
                    System.err.println("mv error: wrong number of arguments, two expected");
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

        try{
            DirectoryManagement directoryManagement = new DirectoryManagement(args[0]);
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
