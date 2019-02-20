package datamodel.question;

import datamodel.answer.Answer;

/**
 * @author Antoan Hristov and Patrick Wakil
 * Question object is constituted of its content and answer part
 */
public abstract class Question {
	
	//Fields
	protected String description;
	protected int difficulty;
	protected String topic;
	protected Answer<?> answer;
	
	
	public Question(String description, int difficulty, String topic, String answerString) {
		this.description = description;
		this.difficulty = difficulty;
		this.topic = topic;
		this.answer = this.createAnswer(answerString);
	}
	
	/**
	 * Return the proper Answer object according to type of Question
	 * @param answerToCreate is the answer we want to create
	 * @return the answer corresponding to answerToCreate
	 */
	protected abstract Answer createAnswer(String answerToCreate);
	
	/**
	 * Display according to Question structure
	 */
	public abstract void display();
	
	/**
	 * Return Answer object according to type of Question
	 * @return the answer with corresponded generic type
	 */
	public Answer<?> getAnswer() {
		return this.answer;
	}

	/**
	 * Set Answer object according to type of Question
	 * @param answer the answer
	 */
	public void setAnswer(Answer<?> answer) {
		this.answer = answer;
	}
	
	/**
	 * Get question description information
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set description to a question
	 * @param description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get question difficulty information
	 * @return int
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * Set difficulty for question
	 * @param difficulty the difficulty wanted
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * Get question topic information
	 * @return String
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * Set topic to question
	 * @param topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}

}
