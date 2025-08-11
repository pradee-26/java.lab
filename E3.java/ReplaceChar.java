package exp3;
import java.util.Scanner;

public class ReplaceChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter a string:");
        String str = sc.nextLine();

        if (str.length() > 0) {
            char firstChar = str.charAt(0);

            
            String result = firstChar + str.substring(1).replace(firstChar, '$');

            System.out.println(result);
        } else {
            System.out.println("String is empty!");
        }

        sc.close();
    }
}


