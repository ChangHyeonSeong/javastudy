package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 99; i++) {
			int zzac = 0;
			String str = Integer.toString(i);
			
			for (int k = 0; k <str.length();k++) {
				if(str.charAt(k) == '3' || str.charAt(k) == '6' || str.charAt(k) == '9' ) {
					zzac++;
				}
			}
			
			System.out.print(i + " ");
			for (int j = 0; j < zzac; j++) {
				System.out.print("짝");
			}
			System.out.print("\n");
		}
		
	}
}
