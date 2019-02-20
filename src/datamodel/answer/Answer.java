package datamodel.answer;
/**
 * @author Antoan Hristov and Patrick Wakil
 * This  generic class represents an Answer. The type of the answer value is generic. 
 * @param <T> The type of the value of the answer
 */
public abstract class Answer<T> {
	//Fields
	protected T answerValue;
	
	public Answer(String answerToCreate){
		this.answerValue = this.createAnswerValue(answerToCreate);
	}
	
	/**
	 * Return the value of an Answer. The value of an Answer is the answer part of a question, all the choices and answers 
	 * @param answerToCreate is the answer we want to create
	 * @return the value of the answer corresponding to  answerToCreate
	 */
	public abstract T createAnswerValue(String answerToCreate);
	
	/**
	 * Verify if the the string answer is valid depending on the concrete Answer  
	 * @param answer is the string of answer to verify 
	 * @return true if answer could be used as comparing string on concrete answer type
	 */
	public abstract boolean isValid(String answer);
	
	/**
	 * Return information about providing answer values
	 * @return the String of this Answer information
	 */
	public abstract String usage();
	
	/**
	 * Return the value content of this Answer
	 * @return the answerValue of this Answer
	 */
	public T getAnswerValue(){
		return this.answerValue;
	}
	
	/**
	 * Return true if providedAnswer is correct  
	 * @param providedAnswer is the answer  String to test
	 * @return true if answer is correct to this Answer or false otherwise
	 */
	public abstract boolean isCorrect(String providedAnswer);
	
	/**
	 * Display Answer content
	 */
	public abstract void displayAnswers();
	
	/**
	 * Display correct answer value 
	 */
	public abstract void displayCorrectAnswer();
}
