package StudyAlgorithm_P;

public class RotationMatrix {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arr1 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		int[][] arr2 = new int[10][10];
		int count = 1;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = count++;
			}
		}

		// rotateMatrix testCase
		printMatrix(arr);
		printMatrix(rotateMatrix(arr));
		printMatrix(arr1);
		printMatrix(rotateMatrix(arr1));
		printMatrix(arr2);
		printMatrix(rotateMatrix(arr2));

		// rotateMatrix1 testCase
		printMatrix(arr);
		printMatrix(rotateMatrix1(arr));
		printMatrix(arr1);
		printMatrix(rotateMatrix1(arr1));
		printMatrix(arr2);
		printMatrix(rotateMatrix1(arr2));
	}

	// ���簢�� �迭�� �ð�������� ��ĭ�� �̵�
	// ���⸦ �����ϼ��� :)
	public static int[][] rotateMatrix(int[][] arr) {
		int[][] result = new int[arr.length][arr[0].length];

		int n = 0;
		int arraySize = arr.length - 1;

		while (n - 1 != arraySize - n) {
			if (n == arraySize - n) {
				result[n][n] = arr[n][n];
				break;
			} else {

				// up
				for (int j = arraySize - n; j > n; j--) {
					result[n][j] = arr[n][j - 1];
				}

				// right
				for (int i = arraySize - n; i > n; i--) {
					result[i][arraySize - n] = arr[i - 1][arraySize - n];
				}

				// down
				for (int j = arraySize - 1 - n; j >= n; j--) {
					result[arraySize - n][j] = arr[arraySize - n][j + 1];
				}
				// left

				for (int i = arraySize - 1 - n; i >= n; i--) {
					result[i][n] = arr[i + 1][n];
				}

				n++;
			}
		}

		return result;

	}

	// ���簢�� �迭�� Ȧ����° ���� �ݽð����, ¦����° ���� �ð�������� ��ĭ�� �̵�
	// ���⸦ �����ϼ��� :)
	public static int[][] rotateMatrix1(int[][] arr) {
		int[][] result = new int[arr.length][arr[0].length];

		int n = 0;
		int arraySize = arr.length - 1;
		boolean b = true;

		while (n - 1 != arraySize - n) {

			// ------------------------when(n = n) break;
			if (n == arraySize - n) {
				result[n][n] = arr[n][n];
				break;
			}
			// --------------------------when even
			else if (b) {

				// up
				for (int j = arraySize - n; j > n; j--) {
					result[n][j] = arr[n][j - 1];
				}

				// right
				for (int i = arraySize - n; i > n; i--) {
					result[i][arraySize - n] = arr[i - 1][arraySize - n];
				}

				// down
				for (int j = arraySize - 1 - n; j >= n; j--) {
					result[arraySize - n][j] = arr[arraySize - n][j + 1];
				}
				// left

				for (int i = arraySize - 1 - n; i >= n; i--) {
					result[i][n] = arr[i + 1][n];
				}

				n++;
				b = false;

			}
			// --------------------------when odd
			else if (!b) {
				// up
				for (int j = n; j < arraySize - n; j++) {
					result[n][j] = arr[n][j + 1];
				}

				// right
				for (int i = n; i < arraySize - n; i++) {
					result[i][arraySize - n] = arr[i + 1][arraySize - n];
				}

				// down
				for (int j = n + 1; j <= arraySize - n; j++) {
					result[arraySize - n][j] = arr[arraySize - n][j - 1];
				}
				// left

				for (int i = n + 1; i <= arraySize - n; i++) {
					result[i][n] = arr[i - 1][n];
				}
				n++;
				b = true;
			}
		}

		return result;

	}

	public static void printMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (j > 0) {
					System.out.print(" ");
					if (arr[i][j] < 10)
						System.out.print(" ");
				} else if (j == 0 && arr[i][j] < 10)
					System.out.print(" ");
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}