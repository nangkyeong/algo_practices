package GraphSearch;

public class NumberMagicEasy{

    public static void main(String[] args) {
        /*
        answer = "YNYY"
        returns: 5
        
        answer = "YNNN"
        returns: 8
        */
        String answer = "YNNN";
        int ret = theNumber(answer);
        System.out.println("ret: "+ret);
    }

    public static int theNumber(String answer){
        int ret = 0;
        //각 대답을 각 리프 노드에 매핑시키자
        String[] allAns = { "YYYY", "YYYN", "YYNY", "YYNN", //1~4
                            "YNYY", "YNYN", "YNNY", "YNNN", //5~8
                            "NYYY", "NYYN", "NYNY", "NYNN", //9~12
                            "NNYY", "NNYN", "NNNY", "NNNN" }; //13~16

        //idx로 정답 숫자를 찾아내자
        for(int i=0; i<allAns.length; i++){
            if(allAns[i].equals(answer)) ret = i+1;
        }
        
        return ret;
    }
}