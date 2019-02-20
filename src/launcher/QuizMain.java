package launcher;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import datamodel.question.Question;
import services.QuestionJDBCDAO;

public class QuizMain {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException {
		QuestionJDBCDAO jdbc = new QuestionJDBCDAO();
		String streamAnswer;
		Integer[] difficulties = {1, 2};
		String[] topics = {"Java Basics", "Java Advanced"};
		System.out.println("Choose desired difficulty: 1 or 2 ");
		streamAnswer = scanner.nextLine();
		while (!Arrays.asList(difficulties).contains(Integer.parseInt(streamAnswer))) {
			System.out.println("Provide proper value!");
			streamAnswer = scanner.nextLine();
		}
		int diff = Integer.parseInt(streamAnswer);
		System.out.println("Choose desired topic: Java Basics or Java Advanced ");
		streamAnswer = scanner.nextLine();
		while (!Arrays.asList(topics).contains(streamAnswer)) {
			System.out.println("Provide proper value!");
			streamAnswer = scanner.nextLine();
		}
		List<Question> questions = jdbc.search(diff, streamAnswer);
		Quiz q = new Quiz(questions);
		q.askAll();
	}

}
