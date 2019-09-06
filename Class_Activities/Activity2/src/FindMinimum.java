
public class FindMinimum {

	public static void main(String[] args) {
		
	}
	
	//TODO: finish implementing slowFindMinimum
//	public int slowFindMinimum(int[] arr, int arrLen) {
//		if (arrLen == 0) {
//			System.out.println("no minimum");
//			return -1;
//		}
//		int absMin = 0;
//		for (int i = 0; i < arrLen; i++) {
//			int tempMin= i;
//			for (int j = 0; j < arrLen; j++) {
//				if (arr[tempMin] > arr[j]) {
//					tempMin = j;
//				}
//			}
//			if (arr[absMin] > arr[tempMin])
//				absMin = tempMin;
//		}
//		return absMin;
//	}
	
	public int fastFindMinimum(int[] arr, int arrLen) {
		if (arrLen == 0) {
			System.out.println("no minimum");
			return -1;
		}
		int absMin = arr[0];
		for (int i = 1; i < arrLen; i++) {
			if (arr[i] < absMin) {
				absMin = arr[i];
			}
		}
		return absMin;
	}

}
