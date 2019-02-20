package launcher;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import datamodel.Answer;
import datamodel.Question;
import services.QuestionJDBCDAO;

public class Quiz {

	//Fields
	private static final Scanner scanner = new Scanner(System.in);
	protected List<Question> questions;
	
	public Quiz(List<Question> questions){
		this.questions = questions;
	}
	
	/**
	 * Return the correct streamAnswer, this method do a loop until the user give the valid syntax answer 
	 * @param answer is the answer validity to respect
	 * @return the valid streamAnswer
	 */
	public String verifyAnswerSyntax(Answer<?> answer){
		String forceAnswer = "Give your answer: ";
		System.out.println(forceAnswer);
		String streamAnswer = scanner.nextLine();
		while(true){
			try {
			if(!answer.isValid(streamAnswer)) {
				
				System.out.println(forceAnswer);
				streamAnswer = scanner.nextLine();
				}
			else {break;}
			}
		catch (Exception e) {
			System.out.println(forceAnswer);
		}
		}
		return streamAnswer;
	}
	
	/**
	 * Method which is doing all the questions answers interaction
	 * @throws FileNotFoundException 
	 */
	public void askAll() throws FileNotFoundException {
		int i=1;
		String streamAnswer;
		for (Question q : this.questions){
			System.out.println("-----------------------------------------");
			System.out.println("Question" +i++ + ":");
			q.display();
			Answer<?> answer = q.getAnswer();
			streamAnswer = this.verifyAnswerSyntax(answer);
			if(answer.isCorrect(streamAnswer)){
				System.out.println("correct");
			}
			else{
				String response = "You provided incorrect answer: " + streamAnswer;
			}
		}
		System.out.println("Do you want to export the quiz (yes/no): ");
		streamAnswer = scanner.nextLine();
		if (streamAnswer.equals("yes")) {
			this.export();
		}
	}
	
	public void export() throws FileNotFoundException {
		// filename curr datetime
		String fileName = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
		PrintStream out = new PrintStream(new FileOutputStream("Quiz-"+fileName));
		System.setOut(out);
		int i=1;
		for (Question q : this.questions){
			System.out.println("-----------------------------------------");
			System.out.println("Question" +i++ + ":");
			q.display();
			}
	}
	
}
