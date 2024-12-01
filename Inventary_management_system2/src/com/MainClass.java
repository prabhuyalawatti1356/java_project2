package com;

import java.util.Scanner;



public class MainClass {
	
	public static void main(String[] args) {
		
		int choice=0;
		System.out.println("Welcome to Project");
		System.out.println("===============================================");
		Scanner s = new Scanner(System.in);
		
		
		System.out.println("1.Add New Product\n2.update\n3.ReduceStock\n4.DisplayAllProducts\n"
				+ "5.FindProduct\n6.DisplayAll\n7.Exit ==================");
		
		Operations imp = new Implementation();
		
		while (true)
		{
			
		
		System.out.println("Enter the Choice");
		 choice = s.nextInt();
		switch (choice) {
		case 1: {
			imp.addNewProduct();
			imp.addProduct();
			System.out.println("Product Added Sucessfully"); 
			break;
		
		}
		case 2: {
//			imp.UpdateProduct();
			imp.UpdateProduct_db();
			System.out.println("Product Updated Sucessfully");
			break;
		
		}
		case 4: {
			imp.DisplayAllProducts();
			System.out.println("All Product Displayed Sucessfully");
			break;
		
		}
		case 3 :
		{
			
			imp.ReduceStock();
			System.out.println("The Stock is less");
			break;
		}
		
		case 5 :
		{
			imp.FindProduct();
			System.out.println("Data displayed Sucessfully");
			break;
		}
		case 6 :
		{
			imp.ReOrderProducts();
		}
		default:
			System.out.println("Invalid_Choice");
		}
		
		
		}
		
		
	}

}
