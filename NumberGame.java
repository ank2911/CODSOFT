import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void game(int attempt,int rnum){
        int current = attempt;
        Scanner sc = new Scanner(System.in);
        while (current != 0) {
            System.out.print("Guess any Number between 1 to 100: ");
            int num = sc.nextInt();
            current--;
            if (num == rnum) {
                System.out.println("Congratulations You have guessed the Correct Number ");
                System.out.println("You took "+(attempt-current)+" attempts");
                current = 0;
            } else if (num > rnum) {
                System.out.println("TOO HIGH");
            } else {
                System.out.println("TOO LOW");
            }
        }
        if(current==0){
            System.out.println("DO you want to play another round?(Y/N): ");
            String str = sc.next();
            if(str.equalsIgnoreCase("Y")){
                Random r = new Random();
                int rnum1 = r.nextInt(100);
                game(5,rnum1);
            }else{
                System.out.println("Exiting the game...");
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Game!!!");
        System.out.println("You have 5 attempts to guess the correct number!!!");
        int attempt = 5;
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int rnum = r.nextInt(100);
        game(attempt,rnum);
        }
    }
