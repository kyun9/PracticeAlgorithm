package B_Collections;

import java.util.HashMap;
import java.util.Scanner;

public class B_1076 {

	public static void main(String[] args) {
		HashMap<String,Integer> hm = new HashMap<String, Integer>();
		hm.put("black",0);
        hm.put("brown",1);
        hm.put("red",2);
        hm.put("orange",3);
        hm.put("yellow",4);
        hm.put("green",5);
        hm.put("blue",6);
        hm.put("violet",7);
        hm.put("grey",8);
        hm.put("white",9);
        
        Scanner sc = new Scanner(System.in);
        
        String a = sc.next();
        String b = sc.next();
        String c = sc.next();
        sc.close();
        int num = hm.get(a)*10+hm.get(b);
        for (int i=0; i<hm.get(c); i++) {
            num *= 10;
        }
        
        System.out.println(num);
	}

}
