package StudyAlgorithm_P;

public class GroupSequence {

	public static void main(String[] args) {
		solution(4);
	}
	
	
	public static long solution(long k) {
		long i=1;
		long j=0;
		long result=0, tmp =0;
		
		while(true) {
			i=i+j;
			if(i==k) {
				result = 1;
				break;
			}
			else if(i>k) {
				tmp= i-k;
				result = j+1-tmp;
				break;
			}
			j++;
			
		}
		System.out.println(result);
		return result;
	}
	
}
//-----------------------------------------------------------------------------------------------------
//���� 3(100��)
//-----------------------------------------------------------------------------------------------------
//���� ����
//������ � ��Ģ�� ���� ���� ���� ������ �������� ��, ������ ������ �̷���� ������ �������̶�� �մϴ�.
//
//���Ѽ��� S = (1), (1, 2), (1, 2, 3), (1, 2, 3, 4).... �Դϴ�. �� ������ ��Ģ�� ������ �����ϴ�.
//
//N ��° ������ 1���� N������ �ڿ����� ũ�� ������� �ֽ��ϴ�.
//������ k ��° ����, ���� ������� �� �պ��� ���� �����մϴ�. ��, ���� S�� 4��° ���� 1�� �˴ϴ�.
//�� k�� �־��� ��, ���� S���� k ��° ���� ���� ��ȯ�ϴ� solution �Լ��� �ϼ��ϼ���.
//
//���ѻ���
//k�� 50,000,000,000,000 ������ �ڿ����Դϴ�.