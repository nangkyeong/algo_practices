package GraphSearch;

public class CrazyBot {

    public static void main(String[] args) {
        /*
        n=14
        east=50
        west=50
        south=0
        north=0
        returns: 2/(2¹⁴)확률
        */
        
        int n=14;
        int east=50;
        int west=50;
        int south=0;
        int north=0;

        double ret = getProbability(n, east, west, south, north);
        System.out.println("ret= " + ret);
    }

    // 로봇이 방문한 곳을 기억하기 위한 그리드
    // 한번에 직선으로 가장 멀리 갈 수 있는 지점은 +14까지, 적당히 30*30의 그리드를 준비함
    static boolean[][] grid = new boolean[30][30];

    // (cx[i],cy[i])로 동서남북의 이동 좌표
    static int[] cx = { 1, -1, 0, 0 };
    static int[] cy = { 0, 0, -1, 1 };

    // 다른 메소드에서도 접근 가능하도록 전역 변수
    static double[] probs = new double[4];

    public static double getProbability(int n, int east, int west, int south, int north) {

        probs[0] = east/100.0;
        probs[1] = west/100.0;
        probs[2] = south/100.0;
        probs[3] = north/100.0;
        
        //만약 필요하다면 grid를 초기화
        /*
        for(int i=0; i<30; i++){
            for(int j=0; j<30; j++){
                grid[i][j] = false;
            }
        }*/

        return dfs(15,15,n);
    }

    private static double dfs(int x, int y, int n) {

        //방문했던 지점을 방문하게 되는 경로인 경우, 경로 무효화
        if(grid[x][y]) return 0;
        //움직이는 횟수를 다 사용한 경우 (말단 노드)
        if(n==0) return 1.0;

        //방문하게 된 지점을 표시함
        grid[x][y] = true;

        double ret = 0.0;
        for(int i=0; i<4; i++){ 
            //동서남북 순서로 각각 다음 좌표에 대한 확률을 처리하여 리턴받는다
            ret += dfs(x+cx[i],y+cy[i],n-1) * probs[i];
        }

        //처리를 완료한 지점에 대해서는 방문 표시를 초기화
        grid[x][y] = false;

        return ret;
    }
    
}