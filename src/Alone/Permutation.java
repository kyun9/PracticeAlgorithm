package Alone;

public class Permutation {

   public static void main(String[] args) {
      int[] arr = { 1, 2};
      
      for(int i=1; i<arr.length+1;i++) {
         int[] result=new int[i];
         perm(arr,i,0,result);
      } 
   }

   static void perm(int[] arr, int r, int depth, int[] result) {
      if(depth==r) {
         print(result);
         return;
      }
      for(int i=depth;i<arr.length;i++) {
         swap(arr,i,depth);
         result[depth]=arr[depth];
         perm(arr, r, depth+1 , result);
         swap(arr,i,depth);
      }
   }

   static void swap(int[] arr, int i, int depth) {
      int temp=arr[i];
      arr[i]= arr[depth];
      arr[depth]=temp;
   }
   static void print(int[] result) {
      for(int i : result)
         System.out.print(i+ " ");
      System.out.println();
   }
}
