package StudyAlgorithm;

import java.util.*;

public class p2018winter_coding1 {
	static ArrayList<Integer>[] list;

	public static void main(String[] args) {
		System.out.println(solution("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA" }));
	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		int size = skill_trees.length;

		list = new ArrayList[skill_trees.length];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		char[] temp;
		for (int i = 0; i < skill_trees.length; i++) {
			if (!skill_trees[i].contains(String.valueOf(skill.charAt(0)))) {
				size -= 1;
				continue;
			}
			temp = skill_trees[i].toCharArray();
			for (int j = 0; j < temp.length; j++) {
				if (skill.indexOf(temp[j]) != -1) {
					list[i].add(skill.indexOf(temp[j]));
				}
			}
		}

		for (int i = 0; i < list.length; i++) {
			a: for (int j = 0; j < list[i].size(); j++) {
				if (list[i].get(j) != j) {
					size -= 1;
					break a;
				}
			}
		}

		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}

		answer = size;
		return answer;
	}
}
