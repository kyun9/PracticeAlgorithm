package coding_2020;

class Hands {
	int x;
	int y;

	Hands(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class kakao_Internship1 {

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand = "right";

		System.out.println(solution(numbers, hand));
	}

	static public String solution(int[] numbers, String hand) {
		String answer = "";

		Hands left = new Hands(3, 0);
		Hands right = new Hands(3, 2);

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				answer += "L";
				if (numbers[i] == 1) {
					left.x = 0;
					left.y = 0;
				} else if (numbers[i] == 4) {
					left.x = 1;
					left.y = 0;
				} else {
					left.x = 2;
					left.y = 0;
				}
			} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				answer += "R";
				if (numbers[i] == 3) {
					right.x = 0;
					right.y = 2;
				} else if (numbers[i] == 6) {
					right.x = 1;
					right.y = 2;
				} else {
					right.x = 2;
					right.y = 2;
				}
			} else {
				if (numbers[i] == 2) {
					if ((Math.abs(left.x - 0) + Math.abs(left.y - 1)) > (Math.abs(right.x - 0) + Math.abs(right.y - 1))) {
						answer += "R";
						right.x = 0;
						right.y = 1;
					} else if ((Math.abs(left.x - 0) + Math.abs(left.y - 1)) < (Math.abs(right.x - 0) + Math.abs(right.y - 1))) {
						answer += "L";
						left.x = 0;
						left.y = 1;
					} else {
						if (hand.equals("right")) {
							answer += "R";
							right.x = 0;
							right.y = 1;
						} else {
							answer += "L";
							left.x = 0;
							left.y = 1;
						}
					}
				} else if (numbers[i] == 5) {
					if ((Math.abs(left.x - 1) + Math.abs(left.y - 1)) > (Math.abs(right.x - 1) + Math.abs(right.y - 1))) {
						answer += "R";
						right.x = 1;
						right.y = 1;
					} else if ((Math.abs(left.x - 1) + Math.abs(left.y - 1)) < (Math.abs(right.x - 1) + Math.abs(right.y - 1))) {
						answer += "L";
						left.x = 1;
						left.y = 1;
					} else {
						if (hand.equals("right")) {
							answer += "R";
							right.x = 1;
							right.y = 1;
						} else {
							answer += "L";
							left.x = 1;
							left.y = 1;
						}
					}
				} else if(numbers[i]==8){
					if ((Math.abs(left.x - 2) + Math.abs(left.y - 1)) > (Math.abs(right.x - 2) + Math.abs(right.y - 1))) {
						answer += "R";
						right.x = 2;
						right.y = 1;
					} else if ((Math.abs(left.x - 2) + Math.abs(left.y - 1)) < (Math.abs(right.x - 2) + Math.abs(right.y - 1))) {
						answer += "L";
						left.x = 2;
						left.y = 1;
					} else {
						if (hand.equals("right")) {
							answer += "R";
							right.x = 2;
							right.y = 1;
						} else {
							answer += "L";
							left.x = 2;
							left.y = 1;
						}
					}
				}
				else {
					if ((Math.abs(left.x - 3) + Math.abs(left.y - 1)) > (Math.abs(right.x - 3) + Math.abs(right.y - 1))) {
						answer += "R";
						right.x = 3;
						right.y = 1;
					} else if ((Math.abs(left.x - 3) + Math.abs(left.y - 1)) < (Math.abs(right.x - 3) + Math.abs(right.y - 1))) {
						answer += "L";
						left.x = 3;
						left.y = 1;
					} else {
						if (hand.equals("right")) {
							answer += "R";
							right.x = 3;
							right.y = 1;
						} else {
							answer += "L";
							left.x = 3;
							left.y = 1;
						}
					}
				}
			}

		}
		return answer;
	}
}
