DROP TABLE IF EXISTS QUESTIONS;
CREATE TABLE QUESTIONS(ID INT PRIMARY KEY AUTO_INCREMENT, text VARCHAR(255) NOT NULL, difficulty INT NOT NULL, topic VARCHAR(255) NOT NULL, type_question CHAR(255) NOT NULL, hint CHAR(255) default NULL, extra_content TEXT default NULL, answer TEXT NOT NULL);
/*OpenQuestion*/
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, hint, answer) VALUES ('If method have same name as class name and method don’t have any return type then it is known as', 1, 'Java Advanced', 'OpenQuestion', 'Hint: Cons_______', 'Constructor');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, hint, answer) VALUES ('Inheritance means', 1, 'Java Basics', 'OpenQuestion', 'Hint: Sub class _______ _____ class', 'Sub class extends super class');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, answer) VALUES ('String is the predefined', 1, 'Java Advanced', 'OpenQuestion', 'Class');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, hint, answer) VALUES ('Execution of program always begins with', 1, 'Java Basics', 'OpenQuestion', 'Hint: M___ m_____', 'Main method');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, answer) VALUES ('Which method can’t be overriden', 2, 'Java Basics', 'OpenQuestion', 'final');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, hint, answer) VALUES ('Main method parameter has which type of data type', 2, 'Java Basics', 'OpenQuestion', 'Hint: S_____', 'String');

/**DROP TABLE IF EXISTS QUESTIONS;
CREATE TABLE QUESTIONS(ID INT PRIMARY KEY AUTO_INCREMENT, text VARCHAR(255) NOT NULL, difficulty INT NOT NULL, topic VARCHAR(255) NOT NULL, type_question CHAR(255) NOT NULL, hint CHAR(255) default NULL, extra_content TEXT default NULL, answer TEXT NOT NULL);*/
/**MCQuestion*/
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, extra_content, answer) VALUES ('What will happen when you compile and run the following code?', 1, 'Java Advanced', 'MCQuestion', 'public class Test{
	
	public static void main(String[] args){
		
		double d1 = Double.NaN;		
		double d2 = d1;
		
		if(d1 == d2)
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
	}
	
}', 'Equal->true|Not Equal->false|The code will not compile->false|The code will compile but will throw run time error->false');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, extra_content, answer) VALUES ('What will happen when you compile and run the following code?', 1, 'Java Basics', 'MCQuestion', 'public class Test{
	
	public static void main(String[] args){		
		
		int i = 10;
		int j = 12;
		i+=++j;
		System.out.println(i);

	}
	
}', '13->false|23->true|22->false|12->false');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, extra_content, answer) VALUES ('What will happen when you compile and run the following code?', 2, 'Java Basics', 'MCQuestion', 'public class Test{
	
	public static void main(String[] args){	
		byte b1 = 5, b2 = 2;
		byte b = b1 % b2;
		System.out.println(b);
	}
}', '0->false|1->false|2->false|Compilation error->true');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, extra_content, answer) VALUES ('What will happen when you compile and run the following code?', 1, ' Java Advanced', 'MCQuestion', 'class One{
	int i = 1;
	public int getInt(){
		return i;
	}
}

class Two extends One{
	int i = 2;
	public int getInt(){
		return i;
	}	
}
public class Test{
	public static void main(String[] args) {
		One one = new One();
		Two two = (Two)one;
		System.out.println( two.getInt() );
	}
}', '1->false|2->false|Runtime error->true|Compilation error->false');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, extra_content, answer) VALUES ('What will happen when you compile and run the following code?', 2, ' Java Advanced', 'MCQuestion', 'class One{	
	public static void print(){
		System.out.println("1");
	}
}

class Two extends One{
	public static void print(){
		System.out.println("2");
	}
}

public class Test{	
	public static void main(String args[]){
		One one = new Two();
		one.print();
	}	
}', '1->true|2->false|Runtime error->false|Compilation error->false');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, extra_content, answer) VALUES ('What will happen when you compile and run the following code?', 1, ' Java Advanced', 'MCQuestion', 'class One{	
	public static void print(int i){
		System.out.println("Parent");
	}
}

class Two extends One{
	public static void print(byte b){
		System.out.println("Child");
	}
}

public class Test{
	
	public static void main(String args[]){
		One one = new Two();
		one.print(10);
	}	
}', 'Parent->true|Child->false|Runtime error->false|Compilation error->false');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, extra_content, answer) VALUES ('Will this code compile?', 1, 'Java Basics', 'MCQuestion', 'public class Test{
	
	static int i = 0;
	public static void main(String args[]){
		Test t = new Test();
		t.print();
	}
	
	public void print(){
		System.out.println(this.i);
	}
}', 'Yes->true|No->false');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, extra_content, answer) VALUES ('Will this code compile without error?', 2, 'Java Basics', 'MCQuestion', 'public class Test{
	
	static native int compute(int i, int j);
}', 'Yes->true|No->false');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, answer) VALUES ('main is a java keyword', 1 , 'Java Basics', 'MCQuestion','Yes->false|No->true');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, extra_content, answer) VALUES ('What will happen when you compile and run the following code?', 2, 'Java Advanced', 'MCQuestion', 'public class Test{
	
	public static void main(String[] args) {
		int i = 5, j = 8, k = 0;
		
		if(i > j && i++ < 10 && (k += i + j) > 10){
			System.out.print("true");
		}
		
		System.out.print(i);
		System.out.print(j);
		System.out.print(k);
	}
}', 'true580->false|580->true|5814->false|6813->false');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, extra_content, answer) VALUES ('What will happen when you compile and run the following code?', 1, 'Java Basics', 'MCQuestion', 'public class Test{
	
	public static void main(String[] args) {
		int i = 50, j = 10;
		int k = i + 10 / j;
		System.out.println(k);
	}
}', '6->false|70->false|51->true|60->false');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, extra_content, answer) VALUES ('What will happen when you compile and run the following code?', 2, 'Java Basics', 'MCQuestion', 'public class Test{
	
	public static void main(String[] args){		
		int i = 0;
		System.out.println(~i);
	}	
}', '0->false|-0->false|1->true|-1->false');
/**AssociativeQuestions*/
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, answer) VALUES ('Associate keywords with their definitions', 1, 'Java Advanced', 'AssociativeQuestion', 'abstract->defines a behavior or a meta-class, allowing to generify the code and to change the implementation if needed|interface->can be used on class or method definitions, means that a part of the implementation will be assumed by descending classes|static->can be used on fields or methods, indicating that this field/method is held by the class definition. When placed on a field, the value is shared by all instances of that class|void->used as a method return type, indicates that the method returns no value');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, answer) VALUES ('Associate keywords with their definitions', 2, 'Java Advanced', 'AssociativeQuestion', 'extends->creates a subclass — a class that reuses functionality from a previously defined class|final-> Indicates that a variable’s value cannot be changed, that a class’s functionality cannot be extended, or that a method cannot be overridden|import-> Enables the programmer to abbreviate the names of classes defined in a package|protected-> Indicates that a variable or method can be used in subclasses from another package');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, answer) VALUES ('Associate keywords with their definitions', 1, 'Java Basics', 'AssociativeQuestion', 'double-> Indicates that a value is a 64-bit number with one or more digits after the decimal point|int-> Indicates that a value is a 32-bit whole number|float-> Indicates that a value is a 32-bit number with one or more digits after the decimal point|long-> Indicates that a value is a 64-bit whole number');
INSERT INTO QUESTIONS (text, difficulty, topic, type_question, answer) VALUES ('Associate keywords with their definitions', 2, 'Java Advanced', 'AssociativeQuestion', 'aggregation-> relationship between two classes that is best described as a "has-a" and "whole/part" relationship|inheritance-> mechanism in which one object acquires all the properties and behaviors of a parent object|composition->is the design technique to implement has-a relationship in classes|association-> is a relationship between two separate classes and it can be of any type say one to one, one to may etc');


