package LinearSearch;

public class ThePalindrome{
    public static void main(String[] args) {
        /*
        s = "abdfhdyrbdbsdfghjkllkjhgfds"
        returns: 38
        */
        String s = "abdfhdyrbdbsdfghjkllkjhgfds";
        int ret = find(s);
        System.out.println("ret = " + ret);
    }

    public static int find(String s){
        int lastidx = s.length()-1;
        int add = 0;
        for (int i=0; i<s.length(); i++){
            if( i>=add 
                && s.charAt(i) != s.charAt(lastidx-i)){
                    lastidx++;
                    add++;
            }
        }
        int ret = lastidx+1;
        return ret;
    }
}