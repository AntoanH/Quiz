package datamodel;

public class OpenQuestion extends Question {

	//Fields
	private String extraContent;
	private String hint;

	public OpenQuestion(String description, int difficulty, String topic, String answerString, String hint, String extraContent) {
		super(description, difficulty, topic, answerString);
		this.extraContent = extraContent;
		this.hint = hint;
	}
	
	@Override
	public Answer<?> createAnswer(String answerToCreate) {
		return new OpenAnswer(answerToCreate);
	}

	public String getExtraContent() {
		return this.extraContent;
	}

	public void setExtraContent(String extraContent) {
		this.extraContent = extraContent;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	/**
	 * Displaying a question consists of its particular content and the display of answers
	 */
	@Override
	public void display() {
		System.out.println(this.description);
		System.out.println(this.extraContent);
		System.out.println(this.hint);
		this.answer.displayAnswers();
	}

}
