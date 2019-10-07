package LinearSearch;

import java.util.*;

public class InterestingParty{
    
    public static void main(String[] args) {
        String[] first = {"snakes", "programming", "cobra", "monty"};
        String[] second = {"python", "python", "anaconda", "python"};
        //returns: 3
        int ret = 0;
        //ret = interestingParty1(first, second);
        ret = interestingParty2(first, second);

        System.out.println("ret = "+ret);
    }

    private static int interestingParty2(String[] first, String[] second) {
        
        int ret=0;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        for (int i=0; i<first.length; i++){
            hm.put(first[i],0);
            hm.put(second[i],0);
        }        

        for (int i=0; i<first.length; i++){
            hm.put(first[i], hm.get(first[i])+1);
            hm.put(second[i], hm.get(second[i])+1);
        }

        for (String key: hm.keySet()){
            ret = Math.max(hm.get(key), ret);
        }
        
        return ret;
    }

    public static int interestingParty1(String[] first, String[] second) {

        int ret = 0;

        for(int i=0; i<first.length; i++){
            String fsubj = first[i];
            String ssubj = second[i];
            int fsame = 0;
            int ssame = 0;
            for (int j=0; j<first.length; j++){
                if (first[j].equals(fsubj)) fsame ++;
                if (second[j].equals(fsubj)) fsame ++;
                if (first[j].equals(ssubj)) ssame ++;
                if (second[j].equals(ssubj)) ssame ++;
            //if (second[j].equals(subj)) same++;
            }
            //System.out.println("middle point"+ ret);
            ret = Math.max(ret, fsame);
            ret = Math.max(ret, ssame);
        }
        return ret;
    }
}