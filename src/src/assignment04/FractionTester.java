package assignment04;
/**
 * This class is a tester class and is going to test all the methods
 * inside "Fraction" class.
 * @author Yingjie Lian
 * @version 02/09/2017
 * @class CS-1410
 */
public class FractionTester 
{
	public static void main (String[] args)
	{
		System.out.println("Fraction tester: ");
		
		// Calling constructor and testing constructor
		Fraction a = new Fraction(2, 3); System.out.println ("Fraction a contains: " + a);
		Fraction b = new Fraction (1, 4); System.out.println ("Fraction b contains: " + b);
		Fraction c = new Fraction (5, 15); System.out.println ("Fraction c contains: " + c);
		Fraction d = new Fraction (6, -3); System.out.println ("Fraction d contains: " + d);
		Fraction e = new Fraction (-4, 7); System.out.println ("Fraction e contains: " + e);
		
		// Testing second Fraction constructor
		Fraction f = new Fraction (12); System.out.println ("Fraction f contains: " + f);
		Fraction g = new Fraction (-9); System.out.println ("Fraction g contains: " + g);
		Fraction h = new Fraction(-17); System.out.println ("Fraction h contains: " + h);
		
		// Testing toString method
		System.out.println(a.toString());
		System.out.println(g.toString());
		System.out.println(c.toString());
		
		// Testing getNumerator method
		System.out.println ("B's numerator is: " + b.getNumerator());
		System.out.println ("A's numerator is: " + a.getNumerator());
		System.out.println ("F's numerator is: " + f.getNumerator());
		
		// Testing getDenominator method
		System.out.println ("B's denominator is: " + b.getDenominator());
		System.out.println ("A's denominator is: " + a.getDenominator());
		System.out.println ("F's denominator is: " + f.getDenominator());
		
		// Testing multiply method
		Fraction multiply01 = a.multiply(b); System.out.println(a + " * " + b + " = " + multiply01);
		Fraction multiply02 = c.multiply(e); System.out.println(c + " * " + e + " = " + multiply02);
		Fraction multiply03 = a.multiply(f); System.out.println(a + " * " + f + " = " + multiply03);
		
		// Testing divide method
		Fraction divide01 = b.divide(c); System.out.println(b + " / " + c + " = " + divide01);
		Fraction divide02 = h.divide(c); System.out.println(h + " / " + c + " = " + divide02);
		Fraction divide03 = g.divide(d); System.out.println(g + " / " + d + " = " + divide03);
		
		// Testing add method
		Fraction add01 = b.add(c); System.out.println(b + " + " + c + " = " + add01);
		Fraction add02 = a.add(g); System.out.println(a + " + " + g + " = " + add02);
		Fraction add03 = h.add(e); System.out.println(h + " + " + e + " = " + add03);
		
		// Testing subtract method
		Fraction subtract01 = a.subtract(b); System.out.println(a + " - " + b + " = " + subtract01);
		Fraction subtract02 = c.subtract(h); System.out.println(c + " - " + h + " = " + subtract02);
		Fraction subtract03 = f.subtract(e); System.out.println(f + " - " + e + " = " + subtract03);

		// Testing toDouble method
		double aDouble = a.toDouble(); System.out.println(aDouble + " approximates to " + a + " as a decimal form.");
		double bDouble = b.toDouble(); System.out.println(bDouble + " approximates to " + b + " as a decimal form.");
		double hDouble = h.toDouble(); System.out.println(hDouble + " approximates to " + h + " as a decimal form.");
		double dDouble = d.toDouble(); System.out.println(dDouble + " approximates to " + d + " as a decimal form.");
	}	
}
