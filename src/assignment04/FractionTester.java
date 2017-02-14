package assignment04;
/**
 * 
 * @author Yingjie Lian
 * @version 02/09/2017
 * @class CS-1410
 */
public class FractionTester 
{
	public static void main (String[] args)
	{
		System.out.println("Fraction tester: ");
		
		// Called constructor
		Fraction f = new Fraction(2, 3);
		
		Fraction g = new Fraction (1, 4);
		
		Fraction h = new Fraction (5, 1);
		
		Fraction i = new Fraction (6, -3);
		
		Fraction j = new Fraction (-4, 7);
		
		Fraction k = new Fraction (12);
		
		Fraction l = new Fraction (-9);
		System.out.println ("Fraction f contains: " + f);
		System.out.println ("Fraction g contains: " + g);
		System.out.println ("Fraction h contains: " + h);
		System.out.println ("Fraction i contains: " + i);
		System.out.println ("Fraction j contains: " + j);
		System.out.println ("Fraction k contains: " + k);
		System.out.println ("Fraction l contains: " + l);
		
		System.out.println ("G's denominator is: " + g.getDenominator());
		
		Fraction p = f.multiply(g);
		
		Fraction q = g.divide(h);
		
		Fraction r = g.add(h);
		
		Fraction s = f.subtract(g);

		double u = f.toDouble();
		
		System.out.println(f + " * " + g + " = " + p);
		
		System.out.println(g + " / " + h + " = " + q);
		
		System.out.println(g + " + " + h + " = " + r);
		
		System.out.println(f + " - " + g + " = " + s);
		
		System.out.println(u + " approximates to " + f);
	}
	
	
}
