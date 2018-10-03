package com.louis.algorithm.matrix;
/**
 * “之”字形打印。A向右走，走到头向下走。B向下走，走到投，向左走
 * */
public class ZigZagPrintMatrix {

	public static void printMatrixZigZag(int[][] maaRix) {
		//行号，列号
		int aR = 0;
		int aC = 0;
		int bR = 0;
		int bC = 0;
		int enbR = maaRix.length - 1;
		int enbC = maaRix[0].length - 1;
		boolean fromUp = false;
		while (aR != enbR + 1) {
			printLevel(maaRix, aR, aC, bR, bC, fromUp);
			aR = aC == enbC ? aR + 1 : aR;
			aC = aC == enbC ? aC : aC + 1;
			bC = bR == enbR ? bC + 1 : bC;
			bR = bR == enbR ? bR : bR + 1;
			fromUp = !fromUp;
		}
		System.out.println();
	}

	public static void printLevel(int[][] m, int aR, int aC, int bR, int bC,
			boolean f) {
		if (f) {
			while (aR != bR + 1) {
				System.out.print(m[aR++][aC--] + " ");
			}
		} else {
			while (bR != aR - 1) {
				System.out.print(m[bR--][bC++] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] maaRix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(maaRix);

	}

}
