package B_Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//실패 코드
class Machine {
	int num;
	int x;
	int y;
	char dic;

	Machine(int num,int x, int y, char dic) {
		this.num=num;
		this.x = x;
		this.y = y;
		this.dic = dic;
	}
}

public class B_2174_self {
	static int[][] map;
	static int dx;
	static int dy;
	static ArrayList<Machine> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken()) + 1;
		int B = Integer.parseInt(st.nextToken()) + 1;
		map = new int[B][A];

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken()) - 1;
			char dic = st.nextToken().charAt(0);
			list.add(new Machine(i+1,B - 1 - y, x, dic));
		}
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int target =Integer.parseInt(st.nextToken());
			char order = st.nextToken().charAt(0);
			int count = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<list.size();j++) {
				if(list.get(i).num==target) {
					for(int k=0;k<count;k++) {
						changeDic(order, list.get(i).dic,i);
						for(int a=0;a<list.size();a++) {
							if(j==a) continue;
							if(list.get(i).x==list.get(a).x&&list.get(i).y==list.get(a).y) {
								System.out.println("Robot "+target+" crashes into robot "+list.get(a).num);
								return;
							}
						}
						if(1>list.get(i).x||(B-1)<list.get(i).x||list.get(i).y<1||list.get(i).y>(A-1)) {
							System.out.println("Robot "+target+" crashes into the wall");
							return;
						}
					}
				}
			}
			
		}
		System.out.println("OK");
	}

	static void changeDic(char order, char c, int target) {
		if (c == 'N') {
			if (order == 'L') {
				c = 'W';
			} else if (order == 'R') {
				c = 'E';
			} else if (order == 'F') {
				list.get(target).x-=1;
			}
		} else if (c == 'W') {
			if (order == 'L') {
				c = 'S';
			} else if (order == 'R') {
				c = 'N';
			} else if (order == 'F') {
				list.get(target).y-=1;
			}
		} else if (c == 'E') {
			if (order == 'L') {
				c = 'N';
			} else if (order == 'R') {
				c = 'S';
			} else if (order == 'F') {
				list.get(target).y+=1;
			}
		} else if (c == 'S') {
			if (order == 'L') {
				c = 'E';
			} else if (order == 'R') {
				c = 'W';
			} else if (order == 'F') {
				list.get(target).x+=1;
			}
		}
	}
}
