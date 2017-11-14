/*****************************
 *CHAPTER NUMBER: 12 UML
 *FILE NAME: Book Project 2
 *PROGRAMMER: Jack Rollinson
 *DATE LAST MODIFIED: 10/27/2016
 *
 *====PROBLEM======
 *Write a test main function that creates a pizza order
 *Adds several pizzas to it, and then outputs the total cost of the order.
 *
 *====ALGORITHM====
 *I made a few extra methods for the pizza and pizzaOrder classes, I added a
 *	printOrder() method that calls the toString for each pizza object in the
 *	pizzaOrder and also a clearOrder() method that clears all pizzas in said order.
 *Add 3 pizzas to jacks order	
 *Print out jacks order(the pizzas and what toppings they have)
 *Calculate the total cost for jacks order and output it to the order.
 *Use the clearOrder() method to clear the order.
 *Calculate the total cost for jack again to show that the order has been cleared.
 *****************************/
 
public class Driver
{
	public static void main(String[] args)
	{
		PizzaOrder jack = new PizzaOrder();
		
		//could get information from the user to fill the parameters, but the book only asked for a test.
		jack.addPizzaToOrder(true, true, false, 'l');
		jack.addPizzaToOrder(false, false, false, 'm');
		jack.addPizzaToOrder(true, false, true, 's');
		
		jack.printOrder(); //prints out contents of the current order.
		
		System.out.println("Total cost: $" + jack.calcCost());
		
		System.out.println("\nClearing orders...\n");
		jack.clearOrder();
		
		//array is now empty, so you can add new orders!
		
		System.out.println("Total cost: $" + jack.calcCost()); //proof that array was cleared.
	}
}