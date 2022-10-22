import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardCopyOption.*;

public class DirectoryManagement {
    private Path currentDirectory;
    private File directory;

    DirectoryManagement(String defaultDirectory){
        this.currentDirectory = FileSystems.getDefault().getPath(defaultDirectory);
        if (!currentDirectory.isAbsolute()){
            throw new IllegalArgumentException();
        }
        directory = new File(currentDirectory.toString());
    }

    public void setCurrentDirectory(String folder) {
        Path temp = currentDirectory;
        Path temp2 = FileSystems.getDefault().getPath(folder);
        if (temp2.isAbsolute())
            this.currentDirectory = FileSystems.getDefault().getPath(folder);
        else{
            temp2 = currentDirectory.resolve(temp2);
            this.currentDirectory = temp2.normalize();
        }
        directory = new File(currentDirectory.toString());
        if (!directory.isDirectory() || !displayDirectory()){
            System.err.println("cd error: can't change directory to " + currentDirectory.toString());
            setCurrentDirectory(temp.toString());
        }
    }

    public Path getCurrentDirectory() {
        return currentDirectory;
    }

    public boolean displayDirectory(){
        if (!directory.exists()){
            System.err.println("No such directory, please enter new path");
            return false;
        }
        System.out.println(currentDirectory.toAbsolutePath());
        return true;

    }

    public long getFolderSize(File folder){
        long length = 0;

        File[] files = folder.listFiles();
        try{
            if (files == null) throw new AssertionError();
            for (File file : files) {
                if (file.isFile()) {
                    length += file.length();
                } else {
                    length += getFolderSize(file);
                }
            }
        }
        catch (AssertionError e){
            System.err.println("Something went wrong");
            System.exit(-1);
        }
        return length;
    }

    public void displayContentOfDirectory(){
        if (!directory.exists()){
            System.err.println("No such directory");
            return;
        }
        System.out.println(currentDirectory.toAbsolutePath().normalize().toString());
        directory = new File(currentDirectory.toAbsolutePath().normalize().toString());
        File[] contentsOfDirectory = directory.listFiles();
        long size;
        try{
            if (contentsOfDirectory == null) throw new AssertionError();
            for (File object : contentsOfDirectory){
                if (object.isFile()){
                    size = object.length();
                }
                else{
                    size = getFolderSize(object);
                }
                System.out.println(object.getName() + " " + Math.round(size / 1024.0) + " Kb");
            }
        }
        catch (AssertionError e){
            System.err.println("Something went wrong");
            System.exit(-1);
        }
    }

    public void moveOrRename(String what, String where){
        Path path = currentDirectory.resolve(where).normalize();
        Path filePath = currentDirectory.resolve(what).normalize();
        File file = new File(filePath.toString());
        if (file.exists()){
                try{
                    Files.move(filePath, path, StandardCopyOption.ATOMIC_MOVE);
                }
                catch (IOException e){
                    System.err.println("IO error");
                }
            }
        else{
            System.err.println("No file to move or rename");
        }
    }
}
