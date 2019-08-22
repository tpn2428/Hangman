import java.util.ArrayList;
import java.util.Random;

public class HangmanGame implements HangmanGameInterface {
	private ArrayList<String> wordDictionary;
	private String resultWord;
	private String checkingWord;
	private int failedAttempts;
	/**
	 * The constructor has been given that the wordDictionary is automatically initialized;
	 * resultWord will be randomly selected from the dictionary;
	 * checkingWord will hide all of its characters matching with resultWord
	 * failedAttempts will start at 0
	 * getRandomWord() and hideGuessingWord() have been already written for you
	 */
	public HangmanGame() {
		this.wordDictionary = FileHelper.getDictionary();
		this.resultWord = this.getRandomWord().toLowerCase();
		this.checkingWord = this.hideGuessingWord(this.resultWord);
		this.failedAttempts = 0;
	}
	private String getRandomWord() {
		Random rand = new Random();
		int randomIndex = rand.nextInt(wordDictionary.size());
		return wordDictionary.get(randomIndex);
	}
	private String hideGuessingWord(String word) {
		String hiddenWord = "";
		for (int i = 0; i < word.length(); i++) {
			hiddenWord += "-";
		}
		return hiddenWord;
	}
	/**
	 * This method is a getter which returns the pre-selected
	 * result word
	 *
	 * @return String
	 */
	public String getResultWord() {
		return this.resultWord;
	}
	/**
	 * This method is a getter which returns the number
	 * of failed attempts
	 *
	 * @return int
	 */
	public int getFailedAttempts() {
		return this.failedAttempts;
	}
	/**
	 * This method is a getter which returns the current
	 * checking word
	 *
	 * @return String
	 */
	public String getCheckingWord( ) {
		return this.checkingWord;
	}
	/**
	 * This method should accept the guessing character
	 * coming from user's keyboard. Assuming the character exists, reveal all locations
	 * that this character exists in the result word within
	 * the checking word
	 *
	 * @param char guessingChar
	 */
	public void revealGuessingWordByLetter(char guessingChar) {
		String wordAfterRevealedABit = "";
		for (int i = 0; i < this.resultWord.length(); i++) {
			if (this.resultWord.charAt(i) == guessingChar) {
				wordAfterRevealedABit += guessingChar;
			} else if(this.checkingWord.charAt(i) != '-') {
				wordAfterRevealedABit += this.checkingWord.charAt(i);
			} else {
				wordAfterRevealedABit += "-";
			}
		}
		this.checkingWord = wordAfterRevealedABit;
	}
	/**
	 * This method should check if the word is fully revealed
	 * Hint: use one of the string method to quickly achieve this
	 *
	 * @return boolean
	 */
	public boolean isWordFullyRevealed() {
		return this.checkingWord.equalsIgnoreCase(this.resultWord);
	}
	/**
	 * This method should check if the guessing character exist in the result word
	 * Hint: use one of the string method to quickly achieve this
	 *
	 * @param char guessingChar
	 * @return boolean
	 */
	public boolean doesCharacterExistInResultWord(char guessingChar) {
		return this.resultWord.indexOf(guessingChar + "") >= 0;
	}
	/**
	 * This method should update the number of failed attempts
	 * after user makes a wrong guess
	 *
	 */
	public void wrongGuess() {
		this.failedAttempts++;
	}
	/**
	 * This method should check if the number of failed attempts is 6
	 *
	 * @return boolean
	 */
	public boolean isItTimeToGiveAWarning() {
		return this.failedAttempts == 6;
	}
	/**
	 * This method should check if the number of failed attempts is 7
	 *
	 * @return boolean
	 */
	public boolean isGameOver() {
		return this.failedAttempts == 7;
	}
}
