package GraphSearch;

import java.util.LinkedList;
import java.util.Queue;

public class MazeMaker {
    public static void main(String[] args) {
        /*
        maze = { ".......",
                 "X.X.X..",
                 "XXX...X",
                 "....X..",
                 "X....X.",
                 "......." }
        startRow = 5
        startCol = 0
        moveRow = {1, 0, -1, 0, -2, 1}
        moveCol = {0, -1, 0, 1, 3, 0}
        returns: 7
        */
        String[] maze = {".......",
                         "X.X.X..",
                         "XXX...X",
                         "....X..",
                         "X....X.",
                         "......."};
        int startRow = 5;
        int startCol = 0;
        int[] moveRow = {1, 0, -1, 0, -2, 1};
        int[] moveCol = {0, -1, 0, 1, 3, 0};
        //returns: 7
        
        //int ret = longestPath(maze, startRow, startCol, moveRow, moveCol);
        int ret = longestPath2(maze, startRow, startCol, moveRow, moveCol);
        System.out.println("ret = " + ret);

    }

    private static int longestPath2(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
        int ret=0;

        //이동량 저장을 위한 dp
        int mazeRow=maze.length;
        int mazeCol=maze[0].length();
        int[][] dp = new int[mazeRow][mazeCol];

        //모든 값을 -1로 초기화
        for(int i=0; i<mazeRow; i++)
            for(int j=0; j<mazeCol; j++)
                dp[i][j] = -1;

        //시작지점
        dp[startRow][startCol]=0;

        //BFS를 위한 Queue
        Queue<Integer> queRow = new LinkedList<Integer>();
        Queue<Integer> queCol = new LinkedList<Integer>();

        //시작 지점 다음 노드 처리를 위해 첫 지점 add
        queRow.add(startRow);
        queCol.add(startCol);

        //BFS 시작
        while(!queRow.isEmpty()){//더이상 이동 가능한 다음 칸이 없을 때까지
            int nowRow = queRow.poll();
            int nowCol = queCol.poll();

            //이동 가능한 다음 칸들을 모두 탐색
            for(int i=0; i<moveRow.length; i++){
                //i번째 이동 가능한 칸의 좌표
                int nextRow = nowRow + moveRow[i];
                int nextCol = nowCol + moveCol[i];

                //이동할 수 있는 칸인지 조건 검사
                if(nextRow>=0 && nextRow<mazeRow && nextCol>=0 && nextCol<mazeCol //maze 범위에서 벗어나지 않는 좌표이면서
                    && maze[nextRow].charAt(nextCol)=='.' //들어갈 수 있는 칸이면서
                    && dp[nextRow][nextCol]== -1 ){ //아직 지나가지 않은 칸일때
                        dp[nextRow][nextCol] = dp[nowRow][nowCol] + 1; //누적 이동 횟수를 1 증가시킨다
                        //다다음 지점 처리를 위해 큐에 추가한다
                        queRow.add(nextRow);
                        queCol.add(nextCol);
                    }
            }

        }

        //처리가 다 끝난 후 return할 값을 검사
        for(int i=0; i<mazeRow; i++){
            for(int j=0; j<mazeCol; j++){
                //접근할 수 있는 칸이었는데 도달하지 못한 경우
                if(maze[i].charAt(j)=='.' && dp[i][j]==-1)
                    return -1;
                else //-1의 값이 아닌 경우 최대 누적 이동 수를 구한다
                    ret = Math.max(ret, dp[i][j]);
            }
        }

        return ret;
    }

    public static int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
        int ret = 0;
        
        //이동 횟수를 기억할 저장공간 생성 및 초기화  
        int[][] dp = new int[maze.length][maze[0].length()];
        for (int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length(); j++){
                dp[i][j]= -1;
            }
        }

        //시작 지점 설정
        dp[startRow][startCol] = 0;

        //Queue 생성
        Queue<Integer> qr = new LinkedList<Integer>();
        Queue<Integer> qc = new LinkedList<Integer>();
        
        qr.add(startRow);
        qc.add(startCol);

        while(!qr.isEmpty()){
            //큐에서 처리할 다음 노드 꺼내기
            int r = qr.poll();
            int c = qc.poll();

            //해당 노드에서 이동할 수 있는 다른 칸 탐색
            for(int i=0; i<moveRow.length; i++){
                //다음 칸의 좌표 구하기
                int nextr = r+moveRow[i];
                int nextc = c+moveCol[i];

                //이동 가능 여부 검사
                if( nextc >=0 && nextc < maze[0].length()
                    && nextr >=0 && nextr < maze.length
                    && maze[nextr].charAt(nextc)=='.'
                    && dp[nextr][nextc]==-1 ){
                        //누적 이동 수 기록
                        dp[nextr][nextc] = dp[r][c]+1;
                        
                        //큐에 다음 방문 지점을 넣는다
                        qr.add(nextr);
                        qc.add(nextc);
                    }
            }

            //최대 누적 이동 수를 찾는다. 이동 가능한데 방문하지 못한 지점(-1)이 있으면 -1를 리턴
            for(int i=0; i<maze.length; i++){
                for(int j=0; j<maze[0].length(); j++){
                    if(dp[i][j]==-1 && maze[i].charAt(j)=='.') return -1;
                    ret = Math.max(ret, dp[i][j]);
                }
            }           
        }
        return ret;
    }
}