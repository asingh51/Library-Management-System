package com.demo;

import java.util.Random;
  
public class Randoms{
	
	public static void main(String[] args) {
	Random rnd = new Random();
	int numTimes = 10;
	for(int i = 0; i < numTimes*1; i++){
	   System.out.println(rnd.nextInt(10));
	}}
}