package assignment04;

public class BigFractionTester 
{
	public static void main (String[] args)
	{
		System.out.println("BigFraction tester: ");
		
		// Calling constructor and testing constructor
		BigFraction a = new BigFraction(2, 3); System.out.println ("BigFraction a contains: " + a);
		BigFraction b = new BigFraction (1, 4); System.out.println ("BigFraction b contains: " + b);
		BigFraction c = new BigFraction (5, 15); System.out.println ("BigFraction c contains: " + c);
		BigFraction d = new BigFraction (6, -3); System.out.println ("BigFraction d contains: " + d);
		BigFraction e = new BigFraction (-4, 7); System.out.println ("BigFraction e contains: " + e);
		
		// Testing second BigFraction constructor
		BigFraction f = new BigFraction (12); System.out.println ("BigFraction f contains: " + f);
		BigFraction g = new BigFraction (-9); System.out.println ("BigFraction g contains: " + g);
		BigFraction h = new BigFraction(-17); System.out.println ("BigFraction h contains: " + h);
		
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
		BigFraction multiply01 = a.multiply(b); System.out.println(a + " * " + b + " = " + multiply01);
		BigFraction multiply02 = c.multiply(e); System.out.println(c + " * " + e + " = " + multiply02);
		BigFraction multiply03 = a.multiply(f); System.out.println(a + " * " + f + " = " + multiply03);
		
		// Testing divide method
		BigFraction divide01 = b.divide(c); System.out.println(b + " / " + c + " = " + divide01);
		BigFraction divide02 = h.divide(c); System.out.println(h + " / " + c + " = " + divide02);
		BigFraction divide03 = g.divide(d); System.out.println(g + " / " + d + " = " + divide03);
		
		// Testing add method
		BigFraction add01 = b.add(c); System.out.println(b + " + " + c + " = " + add01);
		BigFraction add02 = a.add(g); System.out.println(a + " + " + g + " = " + add02);
		BigFraction add03 = h.add(e); System.out.println(h + " + " + e + " = " + add03);
		
		// Testing subtract method
		BigFraction subtract01 = a.subtract(b); System.out.println(a + " - " + b + " = " + subtract01);
		BigFraction subtract02 = c.subtract(h); System.out.println(c + " - " + h + " = " + subtract02);
		BigFraction subtract03 = f.subtract(e); System.out.println(f + " - " + e + " = " + subtract03);

		// Testing toDouble method
		double aDouble = a.toDouble(); System.out.println(aDouble + " approximates to " + a + " as a decimal form.");
		double bDouble = b.toDouble(); System.out.println(bDouble + " approximates to " + b + " as a decimal form.");
		double hDouble = h.toDouble(); System.out.println(hDouble + " approximates to " + h + " as a decimal form.");
		double dDouble = d.toDouble(); System.out.println(dDouble + " approximates to " + d + " as a decimal form.");
	}	

}
