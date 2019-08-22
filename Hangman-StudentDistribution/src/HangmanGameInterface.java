public interface HangmanGameInterface {
	/**
	 * This method is a getter which returns the pre-selected
	 * result word
	 *
	 * @return String
	 */
	public String getResultWord();
	/**
	 * This method is a getter which returns the number
	 * of failed attempts
	 *
	 * @return int
	 */
	public int getFailedAttempts();
	/**
	 * This method is a getter which returns the current
	 * checking word
	 *
	 * @return String
	 */
	public String getCheckingWord();
	/**
	 * This method should accept the guessing character
	 * coming from user's keyboard. Assuming the character exists, reveal all locations
	 * that this character exists in the result word within
	 * the checking word
	 *
	 * @param char guessingChar
	 */
	public void revealGuessingWordByLetter(char guessingChar);
	/**
	 * This method should check if the word is fully revealed
	 * Hint: use one of the string method to quickly achieve this
	 *
	 * @return boolean
	 */
	public boolean isWordFullyRevealed();
	/**
	 * This method should check if the guessing character exist in the result word
	 * Hint: use one of the string method to quickly achieve this
	 *
	 * @param char guessingChar
	 * @return boolean
	 */
	public boolean doesCharacterExistInResultWord(char guessingChar);
	/**
	 * This method should update the number of failed attempts
	 * after user makes a wrong guess
	 *
	 */
	public void wrongGuess();
	/**
	 * This method should check if the number of failed attempts is 6
	 *
	 * @return boolean
	 */
	public boolean isItTimeToGiveAWarning();
	/**
	 * This method should check if the number of failed attempts is 7
	 *
	 * @return boolean
	 */
	public boolean isGameOver();
}
