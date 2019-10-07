package LinearSearch;

public class FriendScore {
    public static void main(String[] args) {
        /*
        friends = { "NYNNN",
                    "YNYNN",
                    "NYNYN",
                    "NNYNY",
                    "NNNYN" }
        returns: 4
        */

        String[] friends = { "NYNNN",
                            "YNYNY",
                            "NYNYN",
                            "NNYNY",
                            "NYNYN" };
        int ans = highestScore(friends);
        System.out.println("ans: "+ans);
    }

    private static int highestScore(String[] friends) {
        
        int ans=0;
        for(int i=0; i<friends.length; i++){
            int cnt = 0;
            for(int j=0; j<friends[i].length(); j++){
                if(i==j) continue;
                if(friends[i].charAt(j)=='Y')  cnt++;
                else{
                    for(int k=0; k<friends[j].length(); k++){
                        if(friends[j].charAt(k) == 'Y' && friends[k].charAt(i)=='Y') {//cnt++;
                            cnt++;
                            break; 
                            //공통인 친구가 단 한명이라도 있으면 간접 친구가 됨. 더이상 탐색할 필요 없으므로 break
                        }
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}