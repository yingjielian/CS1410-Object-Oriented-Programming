package tests;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inputNum = 1;
        int nextNum = 1;
        while (true) {
            inputNum = nextNum; //assign the variable being computed to the next integer
            while (inputNum != 1) { // so long as inputNum is larger than 1, do hailstone algorithm
                if (inputNum % 2 == 1) { // if inputNum is odd, make even according to algorithm
                    inputNum = inputNum * 3 + 1;
                }
                inputNum = inputNum / 2; // inputNum is even, divide by 2 for next part of algorithm
                if (inputNum < 0) {
                    System.out.println("The first number that cannot have its Hailstone computed is: " + nextNum + ".");
                    System.exit(0); 
                }
            }
            nextNum++; //increase next number for Hailstone computation.
        }

	}

}
