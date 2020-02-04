package Review;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S_4014 {
	static int T,N,X, result;
	static int[][] map;
	static ArrayList<String> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int test =1; test<=T;test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			X=Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			result=0;
			searchRoad();
			confirmRoad();
			
			System.out.println("#"+test+" "+result);
		}
	}
	static void searchRoad() {
		list = new ArrayList<>();
		String s="";
		for(int i=0;i<N;i++) {
			s="";
			for(int j=0;j<N;j++) {
				s+=map[i][j];
			}
			list.add(s);
		}
		for(int i=0;i<N;i++) {
			s="";
			for(int j=0;j<N;j++) {
				s+=map[j][i];
			}
			list.add(s);
		}
	}
	static void confirmRoad() {
		int[] arr = new int[N];
		while(!list.isEmpty()) {
			String s = list.remove(0);
			for(int i=0;i<s.length();i++) {
				arr[i]=s.charAt(i)-'0';
			}
			
			int cnt=0;
			int temp=arr[0];
			boolean flag=true;
			boolean flag2=false;
			for(int j=0;j<N;j++) {
				if(temp==arr[j]) {
					cnt++;
					if(flag2&&cnt==X) {
						cnt=0;
						flag2=false;
					}
				}
				else if(temp-arr[j]==1) {
					if(flag2&&cnt<X) {
						flag=false;
						flag2=false;
						break;
					}
					cnt=1;
					flag2=true;
					temp=arr[j];
				}
				else if(temp-arr[j]==-1) {
					if(flag2&&cnt<X) {
						flag=false;
						flag2=false;
						break;
					}
					flag2=false;
					if(cnt<X) {
						flag=false;
						break;
					}
					cnt=1;
					temp=arr[j];
				}else {
					flag=false;
					flag2=false;
					break;
				}
			}
			if(flag2) {
				if(cnt<X) {
					flag=false;
				}
			}
			if(flag) {
				result++;
			}
		}
	}
}
