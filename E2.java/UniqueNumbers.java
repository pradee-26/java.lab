package exp2;
import java.util.*;

public class UniqueNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter the numbers: ");
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

       
        System.out.print("X = ");
        int X = sc.nextInt(); 

     
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> uniqueNumbers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueNumbers.add(entry.getKey());
            }
        }

        
        System.out.println("Count = " + uniqueNumbers.size());
        System.out.print("Unique numbers are = ");
        for (int i = 0; i < uniqueNumbers.size(); i++) {
            System.out.print(uniqueNumbers.get(i));
            if (i < uniqueNumbers.size() - 1) {
                System.out.print(",");
            }
        }
    }
}
