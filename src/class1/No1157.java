package CLASS1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class No1157 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        HashMap<Character, Integer> counts = new HashMap<Character, Integer>();

        String str = scanner.nextLine();

        for(int i = 0; i < str.length(); i++){
            char alphabet = Character.toUpperCase(str.charAt(i));
            if(counts.containsKey(alphabet))
                counts.replace(alphabet, counts.get(alphabet) + 1);
            else
                counts.put(alphabet, 1);
        }

        Set<Character> keys = counts.keySet();

        Iterator<Character> it = keys.iterator();

        char result = ' ';
        int max_count = 0;
        boolean hasSameCounts = false;

        while(it.hasNext()){
            char alphabet = it.next();
            if(counts.get(alphabet) > max_count){
                result = alphabet;
                max_count = counts.get(alphabet);
                hasSameCounts = false;
            }
            else if(counts.get(alphabet) == max_count){
                hasSameCounts = true;
            }
        }
        if(hasSameCounts)
            System.out.println('?');
        else
            System.out.println(result);
    }
}
