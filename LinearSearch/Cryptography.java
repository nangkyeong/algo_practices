package LinearSearch;

import java.util.*;

public class Cryptography{

    public static void main(String[] args) {
        /*
        numbers = {1, 3, 2, 1, 1, 3}
        returns: 36 
        */
        int[] numbers = {1, 3, 2, 1, 1, 3};

        long ret=0;
        ret = cryptography(numbers);
        System.out.println("ret = "+ret);
        
    }

    private static long cryptography(int[] numbers) {
        long ret=1;
        Arrays.sort(numbers);
        numbers[0]++;
        for (int n: numbers){
            ret *= n;
        }

        return ret;
    }
}