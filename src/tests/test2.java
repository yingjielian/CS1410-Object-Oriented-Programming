package tests;

import javax.swing.JOptionPane;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if (isBuyOrSell("BUY"))
			JOptionPane.showMessageDialog(null, "NBA","MESSAGE",JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Your Finance data is matched!");
	
		
		
	}

	public static boolean isBuyOrSell(String s)
	{
		if (s.equals("BUY")|| s.toLowerCase() == "sell")
			return true;
		else
			return false;
	}
}
