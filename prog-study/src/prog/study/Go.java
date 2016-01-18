
package prog.study;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Go {

    /**
     * Solution problems:
     *   - we didn`t check if it was case sensitive
     *   - we didn`t check if whitespace is significant
     *
     *   We could have done:
     *
     *    Sort strings which should be equal but sorted differently and compare it
     *    Do the same thing with and int array
     * @param a
     * @param b
     * @return
     */
    static boolean checkPermutation(String a, String b){
        if (a.length() != b.length()){
            return false;
        }
        // poderiamos usar um vetor de bits mas como neste caso podemos ter letras repetidas não sera possivel

        // modo força lenta e bruta
        Map<Character, Integer> wordToTest = new HashMap<>();
        for (char c : a.toCharArray()){
            Character key = Character.valueOf(c);
            // preenche o map com cada caracter e a quantidade do mesmo na string
            wordToTest.put(key, wordToTest.containsKey(key) ? wordToTest.get(key) + 1 : 1);
        }
        for (char d : b.toCharArray()){
            Character key = Character.valueOf(d);
            // valida a segunda string, subtraindo a quantidade de cada caracter encontrado na primeira
            // caso algum caracter nao existe coloca a quantidade -1
            wordToTest.put(key, wordToTest.containsKey(key) ? wordToTest.get(key) - 1 : -1);
            if (wordToTest.get(key) < 0){
                // caso algum registro aponte quantidade
                return false;
            }
        }
        return true;
    }

    // Unthinked
    static boolean checkPermutation2(String a, String b){
        if (a.length() != b.length()){
            return  false;
        }
        return sort(a).equals(sort(b));
    }

    private static String sort(String a) {
        char[] content = a.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    static boolean checkPermutation3(String a, String b){
        if (a.length() != b.length()){
            return  false;
        }
        int[] letters = new int[256];
        char[] s_array = a.toCharArray();

        for (char c : s_array){
            letters[c]++;
        }
        for (int i =0;i < b.length();i++){
            int c = (int) b.charAt(i);
            if (--letters[c] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "abcabcabcabcascabc";
        String b = "abcabsabcabcabcabc";
        long start = System.nanoTime();
        System.out.println(checkPermutation(a, b));
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start));

        start = System.nanoTime();
        System.out.println(checkPermutation2(a, b));
        end = System.nanoTime();
        System.out.println("Time: " + (end - start));

        start = System.nanoTime();
        System.out.println(checkPermutation3(a, b));
        end = System.nanoTime();
        System.out.println("Time: " + (end - start));
    }



}
