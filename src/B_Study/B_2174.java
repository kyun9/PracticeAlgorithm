package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Robot {
	int x;
	int y;
	int d;

	Robot(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

public class B_2174 {
	static int A, B, N, M;
	static int[][] map;
	static Robot[] robots;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean fail;

	public static void main(String[] args) throws Exception {
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        A = Integer.parseInt(st.nextToken());
	        B = Integer.parseInt(st.nextToken());
	        
	        map = new int[B][A];
	        
	        st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        
	        robots = new Robot[N];
	        int idx = 0;
	        for (int i = 0; i < N; i++) {
	            st = new StringTokenizer(br.readLine());
	            int x = Integer.parseInt(st.nextToken());
	            int y = Integer.parseInt(st.nextToken());
	            int d = getDir(st.nextToken().charAt(0));
	            
	            robots[idx++] = new Robot(B-y, x-1, d);
	            map[B-y][x-1] = idx;
	        }
	        
	        loop : for (int m = 0; m < M; m++) {
	            st = new StringTokenizer(br.readLine());
	            int robot = Integer.parseInt(st.nextToken());
	            char cmd = st.nextToken().charAt(0);
	            int loop = Integer.parseInt(st.nextToken());
	            
	            for (int i = 0; i < loop; i++) {
	                if(cmd == 'L') {
	                    left(robot);
	                }
	                else if (cmd == 'R') {
	                    right(robot);
	                }
	                else {    // move
	                    if(!go(robot)) {
	                        break loop;
	                    }
	                }
	            }
	        }
	        if(!fail)
	            System.out.println("OK");
	}

	static void left(int robot) {
		Robot r = robots[robot - 1];
		r.d = (r.d - 1 == -1 ? 3 : r.d - 1);
	}

	static void right(int robot) {
		Robot r = robots[robot - 1];
		r.d = (r.d + 1 == 4 ? 0 : r.d + 1);
	}

	static boolean go(int robot) {
		int d = robots[robot - 1].d;
		int x = robots[robot - 1].x;
		int y = robots[robot - 1].y;
		int nx = x + dx[d];
		int ny = y + dy[d];

		if (nx < 0 || nx >= B || ny < 0 || ny >= A) {
			System.out.printf("Robot %d crashes into the wall%n", robot);
			fail = true;
			return false;
		}

		if (map[nx][ny] != 0) {
			System.out.printf("Robot %d crashes into robot %d%n", robot, map[nx][ny]);
			fail = true;
			return false;
		}

		map[x][y] = 0;
		map[nx][ny] = robot;
		robots[robot - 1].x = nx;
		robots[robot - 1].y = ny;

		return true;
	}

	static int getDir(char d) {
		int temp = 0;
		switch (d) {
		case 'E':
			temp = 1;
			break;
		case 'W':
			temp = 3;
			break;
		case 'S':
			temp = 2;
			break;
		case 'N':
			temp = 0;
			break;
		}
		return temp;
	}
}
