package test;

public class Matrix {

	public static void main(String[] args) {

		int ab[][] = { { 3, 5, 6 }, { 5, 8, 8 }, { 11, 5, -8 } };

		int min = ab[0][0];
		int mincol = 0;
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (ab[i][j] < min) {
					min = ab[i][j];
					mincol = j;
				}
			}
		}

		int maxcolnum = ab[0][mincol];
		int k = 0;
		while (k < 3) {

			if(ab[k][mincol] > maxcolnum) {
				maxcolnum = ab[k][mincol];
			}
			k++;
			
		}

		System.out.println("max no in col " + maxcolnum);
		
		
		System.out.println("min " + min);

		int max = ab[0][0];

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (ab[i][j] > max) {
					max = ab[i][j];
				}
			}
		}

		System.out.println(max);
	}
}
