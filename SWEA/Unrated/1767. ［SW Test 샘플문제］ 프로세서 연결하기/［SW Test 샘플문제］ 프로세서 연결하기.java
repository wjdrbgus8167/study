
import java.io.*;
import java.util.*;

class Core {
    int x;
    int y;
    
    public Core(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
   
	static int N;
    static int minDistance;
    static int maxCoreCount;
    static int[][] map;
    static ArrayList<Core> cores;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
       
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            cores = new ArrayList<>();

            for (int i = 0; i < N; i++) {
            	st = new StringTokenizer(br.readLine());
                
                for (int j = 0; j < N; j++) {
                    
                	map[i][j] = Integer.parseInt(st.nextToken());
                   // 맨 가장자리 이미 연결된 코어를 제외한 나머지 코어들의 좌표값 저장
                    if (map[i][j] == 1 && (i != 0 && j != 0 && i != N - 1 && j != N - 1)) {
                        cores.add(new Core(i, j));
                    }
                }
            }
            
            // 최소거리, 최대 코어 개수 초기화 
            minDistance = Integer.MAX_VALUE;
            maxCoreCount = 0;
            dfs(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(minDistance).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int idx, int coreCount, int length) {
       
    	// 모든 코어 개수만큼 시도했다면 
    	if (idx == cores.size()) {
            // 코어의 개수가 기존 코어보다 많을때
    		if (coreCount > maxCoreCount) {
                maxCoreCount = coreCount;
                minDistance = length;
            } else if (coreCount == maxCoreCount) {
                minDistance = Math.min(minDistance, length);
            }
            return;
        }
    	// 코어의 좌표 
        int x = cores.get(idx).x;
        int y = cores.get(idx).y;

        for (int i = 0; i < 4; i++) {
            int nx = x, ny = y;
            int count = 0;

            while (true) {
                nx += dx[i];
                ny += dy[i];
                
                // 전원이 연결되었다면
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    // 연결확정
                    connect(x, y, i, count, true);
                    // 그 다음 코어 보기 
                    dfs(idx + 1, coreCount + 1, length + count);
                    // 코어 다시 되돌리기 
                    connect(x, y, i, count, false); 
                    break;
                }
                // 코어를 연결하지 못할때 
                if (map[nx][ny] != 0) break; 
                count++;
            }
        }

        // 현재 코어를 연결하지 않고 다음 코어로 넘어감
        dfs(idx + 1, coreCount, length);
    }

    static void connect(int x, int y, int d, int count, boolean isConnect) {
        int nx = x, ny = y;
        // 연결된 코어는 map의 값을 2로 바꿔주기 
        for (int i = 0; i < count; i++) {
            nx += dx[d];
            ny += dy[d];
            map[nx][ny] = isConnect ? 2 : 0;
        }
    }
}
