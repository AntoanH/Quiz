package datamodel;

public class AssociativeQuestion extends Question {

	public AssociativeQuestion(String description, int difficulty, String topic, String answerToCreate) {
		super(description, difficulty, topic, answerToCreate);
	}

	@Override
	public Answer<?> createAnswer(String answerToCreate) {
		return new AssociativeAnswer(answerToCreate);
	}

	/**
	 * Displaying a question consists of its particular content and the display of answers
	 */
	@Override
	public void display() {
		System.out.println(this.description);
		this.answer.displayAnswers();
	}
	
	

}
