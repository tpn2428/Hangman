import java.util.ArrayList;
import java.util.Random;

public class HangmanGame {
	private ArrayList<String> wordDictionary;
	private String resultWord;
	private String checkingWord;
	private int failedAttempts;
	
	public HangmanGame() {
		this.wordDictionary = FileHelper.getDictionary();
		this.resultWord = this.getRandomWord().toLowerCase();
		this.checkingWord = this.hideGuessingWord(this.resultWord);
		this.failedAttempts = 0;
	}
	public String getResultWord() {
		return this.resultWord;
	}
	public int getFailedAttempts() {
		return this.failedAttempts;
	}
	public String getCheckingWord( ) {
		return this.checkingWord;
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
	public boolean isWordFullyRevealed() {
		return this.checkingWord.equalsIgnoreCase(this.resultWord);
	}
	public boolean doesCharacterExistInResultWord(char guessingChar) {
		return this.resultWord.indexOf(guessingChar + "") >= 0;
	}
	public void wrongGuess() {
		this.failedAttempts++;
	}
	public boolean isItTimeToGiveAWarning() {
		return this.failedAttempts == 6;
	}
	public boolean isGameOver() {
		return this.failedAttempts == 7;
	}
}
