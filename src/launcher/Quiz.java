package launcher;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import datamodel.answer.Answer;
import datamodel.question.Question;
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
		int nbCorrect=0;
		for (Question q : this.questions){
			System.out.println("-----------------------------------------");
			System.out.println("Question" +i++ + ":");
			q.display();
			Answer<?> answer = q.getAnswer();
			streamAnswer = this.verifyAnswerSyntax(answer);
			if(answer.isCorrect(streamAnswer)){
				System.out.println("Correct");
				nbCorrect+=1;
			}
			else{
				System.out.print("Incorrect: ");
				answer.displayCorrectAnswer();
			}
		}
		System.out.println("Congratulations you finished the quiz!");
		double percent = ((double) nbCorrect/this.questions.size() * 100);
		System.out.println(MessageFormat.format("{0}/{1}({2}%)", nbCorrect, this.questions.size(),percent));
		System.out.println("Do you want to export the quiz (yes/no): ");
		streamAnswer = scanner.nextLine();
		if (streamAnswer.equals("yes")) {
			this.export();
		}
	}
	
	/**
	 * Method which export quiz to a file with current date to the root of project.
	 * @throws FileNotFoundException 
	 */
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
