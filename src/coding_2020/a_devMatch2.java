package coding_2020;


class Robot{
	int x;
	int y;
	int dic;
	Robot(int x, int y, int dic){
		this.x =x;
		this.y=y;
		this.dic = dic;
	}
}
public class a_devMatch2 {
	//북 동 남 서
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) {

		int[][] office = { { 5, -1, 4 }, { 6, 3, -1 }, { 2, -1, 1 } };
		int r = 1;
		int c = 0;
		String[] move = { "go", "go", "right", "go", "right", "go", "left", "go" };
		System.out.println(solution(office, r, c, move));
	}

	static public int solution(int[][] office, int r, int c, String[] move) {
		int answer = 0;
		
		Robot robot = new Robot(r,c,0);
		answer += office[r][c];
		office[r][c]=0;
		
		int n = office.length;
		int m = office[0].length;
		
		int x=0;
		int y=0;
		int dic =0;
		for(int i=0;i<move.length;i++) {
			x=0; y=0; dic =0;
			if(move[i].equals("go")) {
				x= robot.x+dx[robot.dic];
				y= robot.y+dy[robot.dic];
				
				if(0<=x&&x<n&&0<=y&&y<m) {
					if(office[x][y]!=-1) {
						robot.x=x;
						robot.y=y;
						
						answer += office[robot.x][robot.y];
						office[robot.x][robot.y]=0;
					}
				}
			}else if(move[i].equals("right")) {
				dic = robot.dic;
				dic +=1;
				if(dic==4) {
					dic =0;
				}
				robot.dic=dic;
			}else if(move[i].equals("left")) {
				dic = robot.dic;
				dic -=1;
				if(dic==-1) {
					dic =3;
				}
				robot.dic=dic;
			}
		}
		
		return answer;
	}

}
