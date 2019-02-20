package datamodel.answer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AssociativeAnswer extends Answer<Map<String,String>> {
	
	//Fields
	private Map<Character, String> letterAssociation;
	
	public AssociativeAnswer(String answerToCreate) {
		super(answerToCreate);
		
	}

	/**
	 * Return the value of an AssociativeAnswer. AssociativeAnswer has keywords and their descriptions 
	 * @param answerToCreate is the answer we want to create
	 * @return the value of the answer corresponding to answerToCreate
	 */
	@Override
	public Map<String,String> createAnswerValue(String answerToCreate) {
		this.letterAssociation = new HashMap<Character,String>();
		Map<String,String> answerChoices = new TreeMap<String,String>();
		String[] choicesArray = answerToCreate.split("\\|");
		for (String s : choicesArray) {
			String[] answerChoice = s.split("->");
			answerChoices.put(answerChoice[0], answerChoice[1]);

		}
		List<String> l = new ArrayList<String>(answerChoices.values());
		int c = 97;
		Collections.shuffle(l);
		for (Object o : l) {
			char letterDesc = (char)c++;
			this.letterAssociation.put(Character.valueOf(letterDesc),(String) o);
		}
		return answerChoices;
	}	
	
	/**
	 * Return true if valid string provided
	 * @param answer is the answer to be tested
	 * @return true if valid otherwise false
	 */
	//TODO
	@Override
	public boolean isValid(String answer) {
		return answer.matches("[0-3|a-d|\\s]+");
		
	}
	
	/**
	 * Return information about providing answer values
	 * @return the String of this Answer information
	 */
	@Override
	public String usage() {
		return "Associative answers (match every keyword with description for ex. 0a 2b 3d 1c)";
	}

	/**
	 * Correct value for Associative answer is when all the keywords match their descriptions
	 * @param providedAnswer the answer to be verified if it is correct
	 * @return true if answer is correct according to AssociativeAnswer or false otherwise
	 */
	// even if some of provided association is correct the total is counted (it means all the association should be correct)
	@Override
	public boolean isCorrect(String providedAnswer) {
		boolean res = true;
		String[] parsedAnswer = providedAnswer.split(" ");
		List l = new ArrayList(this.answerValue.keySet());
		for (String answer : parsedAnswer) {
			// answer given is the number corresponded to the index choice answer
			int indexAnswer = Integer.parseInt(String.valueOf(answer.charAt(0)));
			Character choice = answer.charAt(1);
			boolean boolVal = this.answerValue.get(l.get(indexAnswer)).equals(this.letterAssociation.get(choice));
			if (!boolVal) {
				return false;
			}
		}
		return res;
	}

	
	/**
	 * AssociativeAnswer displaying is all the keywords from 0-3 and descriptions from a-d
	 */
	@Override
	public void displayAnswers() {
		int i=0;
		for (String k : this.answerValue.keySet()) {
			System.out.println( i++ + ". "+k);
		}
		System.out.println('\n');
		for (Character c : this.letterAssociation.keySet()) {
			System.out.println(c +". " +this.letterAssociation.get(c));
			//System.out.println((char) c++ +". " +v);	
		}
		System.out.println(this.usage());

	}

	/**
	 * AssociativeAnswer displaying is all the keywords corresponded to their descriptions
	 */
	@Override
	public void displayCorrectAnswer() {
		System.out.println("The correct answer is: ");
		for (String k : this.answerValue.keySet()) {
			System.out.println(k + "->" +this.answerValue.get(k));
		}
	}
	

}

