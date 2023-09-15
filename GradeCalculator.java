import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total number of subjects: ");
        int sub = sc.nextInt();
        String S = "";
        int i = 1,total_marks = 0;
        while (sub!=0){
            System.out.print("Enter marks of SUBJECT"+i+": ");
            int marks = sc.nextInt();
            if(marks<40){
                S = "F";
            }
            total_marks += marks;
            i++;
            sub--;
        }
        System.out.println();
        double percentage = (double)total_marks/(i-1);
        displayresult(total_marks,percentage,i-1,S);
    }
    static void displayresult(int marks,double percentage,int i,String s){
        System.out.println("YOUR FINAL RESULT");
        System.out.println("-------------------");
        System.out.println("Total Marks : "+marks+"(out of "+(i*100)+")");
        System.out.println("Average Percentage : "+percentage);
        if(s.equalsIgnoreCase("F")){
            System.out.println("Grade : F (Fail)");
        }else {
            switch ((int) percentage / 10) {
                case 10:
                case 9:
                    System.out.println("Grade : O (Outstanding)");
                    break;
                case 8:
                    System.out.println("Grade : E (Excellent)");
                    break;
                case 7:
                    System.out.println("Grade : A (Very Good)");
                    break;
                case 6:
                    System.out.println("Grade : B (Good)");
                    break;
                case 5:
                    System.out.println("Grade : C (Average)");
                    break;
                case 4:
                    System.out.println("Grade : D (Below Average)");
                    break;
                default:
                    System.out.println("Grade : F (Fail)");
                    break;
            }
        }
        System.out.println("-------------------");
    }
}
