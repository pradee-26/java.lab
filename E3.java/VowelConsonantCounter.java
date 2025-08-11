package exp3;
import java.util.ArrayList;
import java.util.Scanner;

public class VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

  
        System.out.println("Enter the paragraph:");
        String paragraph = sc.nextLine();

      
        ArrayList<Character> vowels = new ArrayList<>();
        ArrayList<Character> consonants = new ArrayList<>();

        String vowelSet = "aeiouAEIOU";

        for (char ch : paragraph.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (vowelSet.indexOf(ch) != -1) {
                    vowels.add(ch);
                } else {
                    consonants.add(ch);
                }
            }
        }

     
        System.out.print("Vowels are: ");
        for (int i = 0; i < vowels.size(); i++) {
            System.out.print(vowels.get(i));
            if (i < vowels.size() - 1) System.out.print(", ");
        }
        System.out.println(", Total = " + vowels.size());

   
        System.out.print("Consonants are: ");
        for (int i = 0; i < consonants.size(); i++) {
            System.out.print(consonants.get(i));
            if (i < consonants.size() - 1) System.out.print(", ");
        }
        System.out.println(", Total = " + consonants.size());

        sc.close();
    }
}
