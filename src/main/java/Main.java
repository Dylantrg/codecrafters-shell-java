import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //Uncomment this block to pass the first stage

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("$ ");
            String input = scanner.nextLine();
            if (input.equals("exit")){
                System.exit(0);
            }
            System.out.println(String.format("%s: command not found", input));
        }
    }
}
