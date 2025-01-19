import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class Main {

    private static List<String> builtin = List.of("exit", "echo", "type");

    private static String getPath(String parameter) {
        for (String path : System.getenv("PATH").split(":")) {
          Path fullPath = Path.of(path, parameter);
          if (Files.isRegularFile(fullPath)) {
            return fullPath.toString();
          }
        }
        return null;
      }
    public static void main(String[] args) throws Exception {
        //Uncomment this block to pass the first stage

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("$ ");
            String input = scanner.nextLine();
            String[] command = input.split(" ", 2);
            if (command[0].equals("exit")){
                if(command.length > 2){
                    System.out.println("exit: too many arguments");
                } else {
                    System.exit(0);
                }
            } else if (command[0].equals("echo")){
                System.out.println(command[1]);
            } else if (command[0].equals("type")){
                if (builtin.contains(command[1])){
                    System.out.println(String.format("%s is a shell builtin", command[1]));
                } else {
                    String path = getPath(command[1]);
                    if (path != null) {
                        System.out.println(command[1] + " is " + path);
                    } else {
                        System.out.println(command[1] + ": not found");
                    } 
                }
            }
            else {
                System.out.println(String.format("%s: command not found", input));
            }
        }
    }
}
