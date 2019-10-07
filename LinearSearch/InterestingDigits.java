package LinearSearch;

import java.util.*;

public class InterestingDigits{
    public static void main(String[] args) {
        
    /*
        2)
        base: 9
        retruns: {2, 4, 8}

        3)
        base: 26
        retruns: {5, 25}
    */
    
    int n = 9;
    int[] ret = interestingDigits(n);
    for (int i : ret){
        System.out.print(String.format("%3d, ", i));
    }

    }

    public static int[] interestingDigits (int base){

        ArrayList<Integer> ls = new ArrayList<>();
        for(int i = 2; i<= base; i++){
            boolean chk = true; //일단 i에는 반례가 없다고 생각하고 시작함
            for(int k1=0; k1<=base ; k1++){
                for(int k2=0; k2<=base ; k2++){
                    for(int k3=0; k3<=base ; k3++){
                        if((k1*base*base + k2*base + k3)%i == 0 && (k1 + k2 + k3)%i !=0){
                            //수 자체는 i의 배수여도 각 자릿수의 합이 i의 배수가 아니라면(반례발생), i는 조건에 완전히 부합하는 수가 아님
                            //반례가 하나라도 발견되면 해당 i 는 제외되어야 함 (더이상 탐색할 필요가 없음)
                            chk = false; 
                            break;
                        }                         
                    }
                    if(!chk) break; //chk가 false라면 탐색 중지를 위해 break 
                }
                if(!chk) break; //chk가 false라면 탐색 중지를 위해 break 
            }
            if(chk) ls.add(i); 
            // 해당 부분에서 여전히 chk가 true라면 반례가 없는(조건에 부합하는) i이므로 리스트에 추가
        }
        int[] ret = new int[ls.size()];
        for(int i=0; i<ls.size(); i++){
            ret[i] = ls.get(i);
        }
        return ret;
    }
}