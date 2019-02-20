package datamodel.answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MCAnswer extends Answer<List<Map<String,String>>> {

	public MCAnswer(String answerToCreate) {
		super(answerToCreate);
	}

	/**
	 * Return the value of an MCAnswer. MCAnswer is constituted of choice and its value true/false 
	 * @param answerToCreate is the answer we want to create
	 * @return the value of the answer corresponding to answerToCreate
	 */
	@Override
	public List<Map<String,String>> createAnswerValue(String answerToCreate) {
		List<Map<String,String>> answerChoices = new ArrayList<Map<String,String>>();
		String[] choicesArray = answerToCreate.split("\\|");
		for (String s : choicesArray) {
			String[] answerChoice = s.split("->");
			Map<String,String> answer = new HashMap<String,String>();
			answer.put("value", answerChoice[1]);
			answer.put("description", answerChoice[0]);
			answerChoices.add(answer);
		}
		return answerChoices;
	}
	
	/**
	 * Correct value for MCAnswer is when all the "true" values are provided
	 * @param providedAnswer the answer to be verified if it is correct
	 * @return true if answer is correct according to MCAnswer or false otherwise
	 */
	@Override
	public boolean isCorrect(String providedAnswer) {
		boolean res = true;
		String[] parsedAnswer = providedAnswer.split(" ");
		for (String answer : parsedAnswer) {
			// answer given is the number corresponded to the index choice answer
			int indexAnswer = Integer.parseInt(answer);
			boolean boolVal = Boolean.parseBoolean(this.answerValue.get(indexAnswer).get("value"));
			res &=boolVal;
		}
		return res;
	}

	/**
	 * Return true if valid string provided
	 * @param answer is the answer to be tested
	 * @return true if valid otherwise false
	 */
	//TODO
	@Override
	public boolean isValid(String answer) {
		// only 4 choice answers to a question
		// only one index of answer permitted or index and spaces in case of more correct answers
		return answer.matches("[0-3|\\s]+");
	}
	
	/**
	 * Return information about providing answer values
	 * @return the String of this Answer information
	 */
	@Override
	public String usage() {
		return "Multiple choice answer (1 or more choices are correct)\n"
				+ "Example (only one correct): 1\n"
				+ "Example (two correct): 1 3";
	}

	/**
	 * MCAnswer displaying is all the keywords from 0-3 and the description of answer
	 */
	@Override
	public void displayAnswers() {
		int i=0;
		for (Map<String,String> m : this.answerValue) {
			System.out.println(i++ +". " + m.get("description"));
		}
		System.out.println(this.usage());
	}

	/**
	 * MCAnswer displaying correct answer/s - only the 'true' values
	 */
	@Override
	public void displayCorrectAnswer() {
		System.out.printf("The correct answer is: ");
		for (Map<String,String> m : this.answerValue) {
			String v = m.get("value");
			if(v.equals("true")) {
				System.out.println(m.get("description") + ' ');
			}
		}
	}

}
