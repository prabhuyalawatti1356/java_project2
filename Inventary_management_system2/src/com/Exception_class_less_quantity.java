package com;

public class Exception_class_less_quantity  extends Exception{
	
	private String message;

	public Exception_class_less_quantity(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}
	

}

class Exception_class_less_stock extends Exception
{
	
}
class Exception_class_for_productID extends Exception
{
	
}
