package tests;

public class Test {

	public static void main(String[] args) {
		System.out.println("Question 1");
		System.out.println("public class Test{\n" + 
				"	\n" + 
				"	public static void main(String[] args){\n" + 
				"		\n" + 
				"		double d1 = Double.NaN;		\n" + 
				"		double d2 = d1;\n" + 
				"		\n" + 
				"		if(d1 == d2)\n" + 
				"			System.out.println(\"Equal\");\n" + 
				"		else\n" + 
				"			System.out.println(\"Not Equal\");\n" + 
				"	}\n" + 
				"	\n" + 
				"}");
	
	System.out.println("Equal");
	System.out.println("Not equal");
	System.out.println("The code will not compile");
	System.out.println("The code will compile but will throw run time error ");
	}
}
