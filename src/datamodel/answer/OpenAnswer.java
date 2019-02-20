package datamodel.answer;

public class OpenAnswer extends Answer<String> {

	public OpenAnswer(String answerToCreate) {
		super(answerToCreate);
	}

	/**
	 * Return the value of an OpenAnswer 
	 * @param answerToCreate is the answer we want to create
	 * @return the value of the answer corresponding to answerToCreate
	 */
	@Override
	public String createAnswerValue(String answerToCreate) {
		this.answerValue = answerToCreate;
		return this.answerValue;
	}
	
	
	/**
	 * Correct value for OpenAnswer is when providedAnswer match the answerValue
	 * @param providedAnswer the answer to be verified if it is correct
	 * @return true if answer is correct according to OpenAnswer or false otherwise
	 */
	@Override
	public boolean isCorrect(String providedAnswer) {
		if( this.answerValue.equalsIgnoreCase(providedAnswer)){
			return true;
		}
		return false;
	}

	/**
	 * Valid value for this type of answer is whether it contains characters
	 * @param answer the answer to be verified if it is correct
	 * @return true if answer is valid according to OpenAnswer or false otherwise
	 */
	@Override
	public boolean isValid(String answer) {
		return answer.matches("[a-z|A-Z|\\s]+");
	}

	/**
	 * Return information about providing answer values
	 * @return the String of this Answer information
	 */
	@Override
	public String usage() {
		return "Open answer (enter your value)";
	}

	/**
	 * MCAnswer display is only constituted of usage
	 */
	@Override
	public void displayAnswers() {
		System.out.println(this.usage());
	}

	/**
	 * MCAnswer displaying correct answer is the answerValue
	 */
	@Override
	public void displayCorrectAnswer() {
		System.out.println("The correct answer is: " +this.answerValue);
	}

}
