package datamodel.question;

import datamodel.answer.Answer;
import datamodel.answer.MCAnswer;

public class MCQuestion extends Question {

	//Fields
	private String extraContent;

	
	public MCQuestion(String description, int difficulty, String topic, String answerToCreate, String extraContent) {
		super(description, difficulty, topic, answerToCreate);
		this.extraContent = extraContent;
	}

	@Override
	public Answer<?> createAnswer(String answerToCreate) {
		return new MCAnswer(answerToCreate);
	}
	
	protected String getExtraContent() {
		return extraContent;
	}

	protected void setExtraContent(String extraContent) {
		this.extraContent = extraContent;
	}
	
	/**
	 * Displaying a question consists of its particular content and the display of answers
	 */
	@Override
	public void display() {
		System.out.println(this.description);
		if (!(this.extraContent == null)) {
			System.out.println(this.extraContent);	
		}
		this.answer.displayAnswers();
	}

}
