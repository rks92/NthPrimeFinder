package com.primefinder.main;

import java.util.Scanner;
import java.util.Vector;

public class Main {
	public static void main (String[] args){
		long startTime = System.currentTimeMillis();
		
		Scanner stdin = new Scanner(System.in);
		String NthPrime = stdin.nextLine();
		stdin.close();
		
		long NthPrimeToFind = Long.parseLong(NthPrime);
		if (NthPrimeToFind <= 0 || NthPrime.contains(".")){
			System.out.println("Enter a positive number greater than 0!");
			return;
		}
		
		Vector<Long> primes = new Vector<Long>();
		primes.add((long) 2);
		
		boolean isPrime = true;
		long i = 3;
		
		int SizeOfPrimes = primes.size();
		/* why is this faster than `while (SizeOfPrimes < NthPrimeToFind) */
		
		while (primes.size() < NthPrimeToFind){
			for (int j = 0; j < SizeOfPrimes; j++){
				if (i % primes.elementAt(j) == 0)
					isPrime = false;
			}
			if (isPrime == true){
				primes.add(i);
				SizeOfPrimes++;
			}
			isPrime = true;
			i++;
		}
		
		System.out.println(primes.lastElement());
		System.out.println("Execution took " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}
}
