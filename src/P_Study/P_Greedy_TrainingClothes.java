package P_Study;

class Solution_2 {
  public int solution(int n, int[] lost, int[] reserve) {
     int answer = 0;
     int[] tmp= new int[n];

     //전부 체육복 있다고하고 1로 초기화
     for (int i = 0; i < n; i++) {
        tmp[i] = 1;
     }
     
     //체육복 잃어버린  사람 1씩 감소
     for (int i = 0; i < lost.length; i++) {
        tmp[lost[i] - 1]--;
     }
     //체육복 여분있는 사람 1씩 증가
     for (int i = 0; i < reserve.length; i++) {
         tmp[reserve[i] - 1]++;
      }
     // 여분있는 사람 기준으로 반복
		for (int i = 0; i < reserve.length; i++) {
			// 체육복이 2개 있을떄만
			if (tmp[reserve[i] - 1] == 2) {

				// 맨 오르쪽 일때 체육복 없는지 왼쪽만 검사
				if((reserve[i]-1)==0) {
			           if(tmp[(reserve[i]-1)+1]==0) {
			              tmp[(reserve[i]-1)+1]++;
			              tmp[(reserve[i]-1)]--;
			           }
			        }
				// 맨 왼쪽 일때 체육복 없는지 오른쪽만 검사
				 else if((reserve[i]-1)==(n-1)) {
			           if(tmp[(reserve[i]-1)-1]==0) {
			              tmp[(reserve[i]-1)-1]++;
			              tmp[(reserve[i]-1)]--;
			           }
			        }
				// 가운데 있을때
				else {
					// 왼쪽 체육복 없는지 검사
					if (tmp[(reserve[i] - 1) - 1] == 0) {
						tmp[(reserve[i] - 1) - 1]++;
						tmp[(reserve[i] - 1)]--;
					}
					// 오른쪽 체육복 없는지 검사
					else if (tmp[(reserve[i] - 1) + 1] == 0) {
						tmp[(reserve[i] - 1) + 1]++;
						tmp[(reserve[i] - 1)]--;
					}
				}
			}
		}
     
     for(int su:tmp) {
   	  	if(su>0) {
   		  answer++;
   	  }
      }
     
     return answer;
  }
}
public class P_Greedy_TrainingClothes {

   public static void main(String[] args) {

      int n=5;
      int[] lost = {2,4};
      int[] reserve = {1,3,5};
      int[] lost1 = {2,4};
      int[] reserve1 = {3};
      int[] lost2 = {3};
      int[] reserve2 = {1};
      int[] lost3 = {2,3};
      int[] reserve3 = {1,2};
      int[] lost4 = {3,4};
      int[] reserve4 = {5,4};
      
      Solution_2 s = new Solution_2();
      System.out.println(s.solution(n,lost3,reserve3));
      System.out.println("-------------------------------");
      System.out.println(s.solution(n,lost4,reserve4));
   }

}
//정답자 풀이
//class Solution {
//    public int solution(int n, int[] lost, int[] reserve) {
//        int answer = 0;
//        answer = n;
//
//        for(int i = 0; i < lost.length; i++) {
//            boolean rent = false;
//            int j = 0;
//            while(!rent) {
//                if(j == reserve.length)                   break;
//                if(lost[i] == reserve[j])                {reserve[j] = -1; rent=true;}
//                else if(lost[i] - reserve[j] == 1 )      {reserve[j] = -1; rent=true;}
//                else if(lost[i] - reserve[j] == -1)      {reserve[j] = -1; rent=true;}
//                else                                     {j++;                      }
//            }
//            if(!rent) answer--;
//        }
//        return answer;
//    }
//}


//오답  boolean으로 해서 true false로는 못구해 왜냐하면 (3,4 이고 5,4) 이거나 (2,3 이고 1,2)인걸 못구해
//class Solution_3 {
//   public int solution(int n, int[] lost, int[] reserve) {
//      int answer = 0;
//      boolean[] b = new boolean[n];
//
//      for (int i = 0; i < n; i++) {
//         b[i] = true;
//      }
//      
//      System.out.println("처음 boolean 배열 true 초기화");
//      for(int i=0;i<b.length;i++) {
//         System.out.print(b[i] + " ");
//      }
//      System.out.println();
//      
//      
//      for (int i = 0; i < lost.length; i++) {
//         b[lost[i] - 1] = false;
//      }
//      
//      System.out.println();
//      System.out.println("처음 boolean 배열 lost를 false변환");
//      for(boolean i:b) {
//         System.out.print(i + " ");
//      }
//      System.out.println();
//      System.out.println(answer);
//      System.out.println(b.length-1+" "+(reserve[0]-1)+" "+reserve.length);
//      for(int i=0;i<reserve.length;i++) {
//    	 if(b[reserve[i]-1]==false) {
//    		  b[reserve[i]-1]= true;
//    		  System.out.println("과정1");
//    		  for(boolean a:b) {
//    		         System.out.print(a + " ");
//    		      }
//    		      System.out.println();
//    	  }
//    	 else if((reserve[i]-1)==0) {
//            if(b[(reserve[i]-1)+1]==false) {
//               b[(reserve[i]-1)+1]=true;
//               System.out.println("과정2");
//     		  for(boolean a:b) {
//     		         System.out.print(a + " ");
//     		      }
//     		      System.out.println();
//            }
//         }
//    	 else if((reserve[i]-1)==(n-1)) {
//            if(b[(reserve[i]-1)-1]==false) {
//               b[(reserve[i]-1)-1]=true;
//               System.out.println("과정3");
//     		  for(boolean a:b) {
//     		         System.out.print(a + " ");
//     		      }
//     		      System.out.println();
//            }
//         }
//         else {
//            if(b[(reserve[i]-1)-1]==false) {
//               b[(reserve[i]-1)-1]=true;
//               System.out.println("과정4");
//     		  for(boolean a:b) {
//     		         System.out.print(a + " ");
//     		      }
//     		      System.out.println();
//            }
//            else if(b[(reserve[i]-1)+1]==false) {
//               b[(reserve[i]-1)+1]=true;
//               System.out.println("과정5");
//     		  for(boolean a:b) {
//     		         System.out.print(a + " ");
//     		      }
//     		      System.out.println();
//            }
//         }
//      }
//      
//      for(boolean i:b) {
//    	  if(i==true) {
//    		  answer++;
//    	  }
//       }
//      
//      return answer;
//   }
//}
