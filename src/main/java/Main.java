import java.util.Scanner;

public class Main {
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
                if (command[1].equals("exit") || command[1].equals("echo") || command[1].equals("type")){
                    System.out.println(String.format("%s is a shell builtin", command[1]));
                } else {
                    System.out.println(String.format("%s: command not found", command[1]));
                }
            }
            else {
                System.out.println(String.format("%s: command not found", input));
            }
        }
    }
}
