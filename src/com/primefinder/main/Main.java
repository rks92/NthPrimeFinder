package com.primefinder.main;

import java.util.Scanner;
import java.util.Vector;

public class Main {
	public static void main (String[] args){
					
		Scanner stdin = new Scanner(System.in);
		String NthPrime = stdin.nextLine();
		stdin.close();
		
		long NthPrimeToFind = Long.parseLong(NthPrime);
		if (NthPrimeToFind <= 0){
			System.out.println("Enter a positive number greater than 0!");
			return;
		}
		
		Vector<Long> primes = new Vector<Long>();
		primes.add((long) 2);
		
		boolean isPrime = true;
		long i = 3;
		
		while (primes.size() < NthPrimeToFind){
			for (int j = 0; j < primes.size(); j++){
				if (i % primes.elementAt(j) == 0)
					isPrime = false;
			}
			if (isPrime == true){
				primes.add(i);
			}
			isPrime = true;
			i++;
		}
		
		System.out.println(primes.lastElement());
	}
}
