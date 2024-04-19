package lab1;

import java.util.Scanner;

public class EIINPUR {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// read input values
		int N = sc.nextInt(); // cost of laptop
		int X = sc.nextInt(); // monthly payment
		int M = sc.nextInt(); // total months
		int K = sc.nextInt(); // month to pay remaining cost

		// calculate remaining cost after paying for M-1 months
		double remainingCost = N;
		double totalPaid = 0;
		for (int i = 1; i <= M - 1; i++) {
			double monthlyInterestRate = binarySearch(0, 1, X, M, i) / 12;
			double monthlyPayment = Math.min(remainingCost * monthlyInterestRate, X) + X;
			totalPaid += monthlyPayment;
			remainingCost -= X - Math.min(remainingCost * monthlyInterestRate, X);
		}
		remainingCost += remainingCost * binarySearch(0, 1, X, M, M - 1) / 12;

		// calculate the final payment in the Kth month
		double monthlyInterestRate = binarySearch(0, 1, X, M, K - 1) / 12;
		double remainingAmount = remainingCost;
		for (int i = K - 1; i <= M - 1; i++) {
			double monthlyPayment = Math.min(remainingAmount * monthlyInterestRate, X) + X;
			remainingAmount += remainingAmount * monthlyInterestRate - monthlyPayment;
		}
		double finalPayment = remainingCost + remainingAmount;
		System.out.println((finalPayment));
	}

	private static double binarySearch(double low, double high, double monthlyPayment, int totalMonths,
			int paidMonths) {
		double mid = (low + high) / 2;
		if (Math.abs(low - high) < 0.0001) {
			return mid;
		}
		double remaining = 0;
		for (int i = paidMonths; i < totalMonths; i++) {
			remaining += monthlyPayment;
			remaining *= (1 + mid / 12);
		}
		if (remaining < 0) {
			return binarySearch(low, mid, monthlyPayment, totalMonths, paidMonths);
		} else {
			return binarySearch(mid, high, monthlyPayment, totalMonths, paidMonths);
		}
	}
}
