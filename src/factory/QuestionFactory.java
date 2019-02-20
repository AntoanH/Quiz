package factory;
/**
 * @author Antoan Hristov and Patrick Wakil
 * @date 2018-02-19
 * Factory class for creating question objects
 */
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.sql.ResultSet;
import java.sql.SQLException;

import datamodel.Answer;
import datamodel.AssociativeQuestion;
import datamodel.MCQuestion;
import datamodel.OpenQuestion;
import datamodel.Question;


public class QuestionFactory {

	public static QuestionFactory FACTORY = new QuestionFactory();
	
	/**
	 * Return the Question based on r
	 * @param r the row from database 
	 * @return the concrete Question
	 */
	public Question buildQuestion(ResultSet r) throws SQLException{
		// make sure the names of columns from database structure are correct in order to retrieve column required
		String text = r.getString("text");
		int difficulty = Integer.parseInt(r.getString("difficulty"));
		String topic = r.getString("topic");
		String typeQuestion = r.getString("type_question");
		String answerString = r.getString("answer");
		String hint = r.getString("hint");
		String extraContent = r.getString("extra_content");
		//System.out.println(answerString);
		switch(typeQuestion) {
			case "OpenQuestion" : return new OpenQuestion(text, difficulty, topic, answerString, hint, extraContent);
			case "MCQuestion": return new MCQuestion(text, difficulty, topic, answerString, extraContent);
			case "AssociativeQuestion": return new AssociativeQuestion(text, difficulty, topic, answerString);
			}
		return null;
		}

}
