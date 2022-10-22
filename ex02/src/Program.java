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
                    System.out.println("shit");
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

        DirectoryManagement directoryManagement = new DirectoryManagement(args[0]);
        Scanner scanner = new Scanner(System.in);
        String input;
        String[] temp;

        while (true){
            input = scanner.nextLine();
            temp = input.split("\\s");
            input = temp[0];

            manageOperations(input, temp, directoryManagement);
        }

    }
}
