package com;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.Scanner;

public class Implementation implements Operations  {

	Scanner s = new Scanner(System.in);

	
	Product p;
	public void addNewProduct() {
		// TODO Auto-generated method stub
		 p = new Product();
		System.out.println("Enter the ProductId");
	    p.setProductId(s.nextInt());
		System.out.println("Enter the Product name");
		p.setName(s.next());
		System.out.println("Enter the Price");
		p.setPrice(s.nextDouble());
		System.out.println("Enter Quantity");
		p.setQuantity(s.nextInt());
		
		
		
		
	}
	
	
	public void addProduct()
	{
		int prodID = p.getProductId();
		String name = p.getName();
		 double price = p.getPrice();
		int qnt = p.getQuantity();
		
		System.out.println(prodID);
		System.out.println(qnt);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c  =	DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","root"); 
			PreparedStatement s = c.prepareStatement("insert into product values(?,?,?,?)");
			s.setInt(1,prodID);
			s.setString(2, name);
			s.setDouble(3,price);
			s.setInt(4,qnt);
			s.execute();
			s.close();
			c.close();
			System.out.println("Data Added to dataBase");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void UpdateProduct()  {
		System.out.println("Enter the id that has to be updated");
		int id1 = s.nextInt();
		if (id1 == p.getProductId())
		{
			System.out.println("Enter the ProductName to be Updated");
			p.setName(s.next());
			System.out.println("Enter the price to be Updated");
			p.setPrice(s.nextDouble());
			System.out.println("Enter the quantity to be updated");
			p.setQuantity(s.nextInt());
			System.out.println("Data Updated sucessfully");
		}
		else
		{
		
			
		

		try {
			
	
				Exception_class_less_quantity a = 
						new Exception_class_less_quantity("Invalid Input");
				throw a;
				
			} catch (Exception_class_less_quantity e) {
				// TODO: handle exception
				System.out.println("input wrong");
				e.getMessage();
			}

		}
		
		
	}
	
	
	
	@Override
	public void UpdateProduct_db() {
		
		System.out.println("Enter the ProductId to updated");
		
		int prodID = s.nextInt();
//		String name = p.getName();
//		 double price = p.getPrice();
//		int qnt = p.getQuantity();
		
//		System.out.println(prodID);
//		System.out.println(qnt);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c  =	DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","root"); 
		
		PreparedStatement s = c.prepareStatement("select * from product where productId=?");
		s.setInt(1,prodID);
		
		ResultSet r =s.executeQuery();
//		int id1 = r.getInt(1);
		
		if(r.next())
		{
			System.out.println(r.getInt(1));
			System.out.println(r.getString(2));
			System.out.println(r.getDouble(3));
			System.out.println(r.getInt(4));
			System.out.println("--------------------------------");
			Scanner s2 = new Scanner(System.in);
			
			PreparedStatement s1 = c.prepareStatement("update product set productName=?, productprice=?, productQnt=? where productId=?");
			System.out.println("Enter the ProductId to be Updated");
			
			s1.setInt(4,s2.nextInt());
			System.out.println("Enter the ProductName to be Updated");
			s1.setString(1,s2.next());
			System.out.println("Enter the price to be Updated");
			s1.setDouble(2,s2.nextDouble());
			System.out.println("Enter the quantity to be updated");
			s1.setInt(3,s2.nextInt());
			s1.executeUpdate();
			System.out.println("++++++++");
			s1.close();
		}
//		System.out.println("--------------------------------");
		
		
		else 
		{
			try {
				
				
				Exception_class_less_quantity a = 
						new Exception_class_less_quantity("Invalid Input");
				throw a;
				
			} catch (Exception_class_less_quantity e) {
				// TODO: handle exception
				System.out.println("input wrong");
				e.getMessage();
			} 
		}
		
		
//	     Scanner s2 = new Scanner(System.in);
//		
//			PreparedStatement s1 = c.prepareStatement("update product set name=? price=? qnt=? where prodID=?");
//			System.out.println("Enter the ProductId to be Updated");
//			
//			s1.setInt(1,s2.nextInt());
//			System.out.println("Enter the ProductName to be Updated");
//			s1.setString(2,s2.next());
//			System.out.println("Enter the price to be Updated");
//			s1.setDouble(3,s2.nextDouble());
//			System.out.println("Enter the quantity to be updated");
//			s1.setInt(4,s2.nextInt());
			
		
			 
			
			s.close();
			c.close();
			System.out.println("Data Updated to dataBase");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void ReduceStock() {
		
//		if (p.getQuantity()== 0 || p.getQuantity()<=5)
//		{
//			try {
//				throw new Exception_class_less_stock ();
//			} catch (Exception_class_less_stock e) {
//				System.out.println("product with name:"+p.getName());
//			}
//		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c  =	DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","root"); 
			
			PreparedStatement s = c.prepareStatement("select * from product where productQnt<=5 ");
			      ResultSet r = s.executeQuery();
			      
			      System.out.println("-----------------------------------------------------------------");
			      System.out.println("ProductId    ProductName   productPrice   ProductQnt");
			      System.out.println("-----------------------------------------------------------------");
			      while(r.next())
			      {
			    	 
			    	  System.out.println(r.getInt(1)+"                "+r.getString(2)+"           "+r.getDouble(3)+
			    	  		"         "+r.getInt(4));
			    	  System.out.println();
			      }
			      System.out.println("-----------------------------------------------------------------");
			      c.close();
			      s.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public void DisplayAllProducts() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c  =	DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","root"); 
			
			PreparedStatement s = c.prepareStatement("select * from product");
			      ResultSet r = s.executeQuery();
			      
			      System.out.println("-----------------------------------------------------------------");
			      System.out.println("ProductId    ProductName   productPrice   ProductQnt");
			      System.out.println("-----------------------------------------------------------------");
			      while(r.next())
			      {
			    	 
			    	  System.out.println(r.getInt(1)+"                "+r.getString(2)+"           "+r.getDouble(3)+
			    	  		"         "+r.getInt(4));
			    	  System.out.println();
			      }
			      System.out.println("-----------------------------------------------------------------");
			      c.close();
			      s.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void FindProduct() {
		
		System.out.println("Enter the ProductId that has to be displayed");
	
		
		int prodID = s.nextInt();
//		String name = p.getName();
//		 double price = p.getPrice();
//		int qnt = p.getQuantity();
		
//		System.out.println(prodID);
//		System.out.println(qnt);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c  =	DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","root"); 
		
		PreparedStatement s = c.prepareStatement("select * from product where productId=?");
		s.setInt(1,prodID);
		
		ResultSet r =s.executeQuery();
//		int id1 = r.getInt(1);
		
		if(r.next())
		{
			System.out.println(r.getInt(1));
			System.out.println(r.getString(2));
			System.out.println(r.getDouble(3));
			System.out.println(r.getInt(4));
			System.out.println("--------------------------------");
			
		}
		

		
		
		else 
		{
			try {
				
				
				Exception_class_less_quantity a = 
						new Exception_class_less_quantity("Invalid Input");
				throw a;
				
			} catch (Exception_class_less_quantity e) {
				// TODO: handle exception
				System.out.println("input wrong");
				e.getMessage();
			} 
		}
		
		
//	     Scanner s2 = new Scanner(System.in);
//		
//			PreparedStatement s1 = c.prepareStatement("update product set name=? price=? qnt=? where prodID=?");
//			System.out.println("Enter the ProductId to be Updated");
//			
//			s1.setInt(1,s2.nextInt());
//			System.out.println("Enter the ProductName to be Updated");
//			s1.setString(2,s2.next());
//			System.out.println("Enter the price to be Updated");
//			s1.setDouble(3,s2.nextDouble());
//			System.out.println("Enter the quantity to be updated");
//			s1.setInt(4,s2.nextInt());
			
		
			 
			
			s.close();
			c.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void ReOrderProducts(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c  =	DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","root"); 
			
			PreparedStatement s = c.prepareStatement("select * from product where productQnt<=10 ");
			      ResultSet r = s.executeQuery();
			      
			      System.out.println("-----------------------------------------------------------------");
			      System.out.println("ProductId    ProductName   productPrice   ProductQnt");
			      System.out.println("-----------------------------------------------------------------");
			      while(r.next())
			      {
			    	 
			    	  System.out.println(r.getInt(1)+"                "+r.getString(2)+"           "+r.getDouble(3)+
			    	  		"         "+r.getInt(4));
			    	  System.out.println();
			      }
			      System.out.println("-----------------------------------------------------------------");
			      System.out.println("Above Products should be Reordered");
			      System.out.println("-----------------------------------------------------------------");
			      c.close();
			      s.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	

}
