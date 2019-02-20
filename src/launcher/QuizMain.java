package launcher;

import java.io.FileNotFoundException;
import java.util.List;

import datamodel.Question;
import services.QuestionJDBCDAO;

public class QuizMain {

	public static void main(String[] args) throws FileNotFoundException {
		QuestionJDBCDAO jdbc = new QuestionJDBCDAO();
		String[] topics = {"Java", "C"};
		List<Question> questions = jdbc.search(1, "Java");
		Quiz q = new Quiz(questions);
		q.askAll();
	}

}
