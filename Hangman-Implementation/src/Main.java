public class Main {
	private static HangmanUI gameGUI;
	public static void main(String[] args) {
		resetGame();
	}

	public static void resetGame() {
		if (gameGUI != null) {
			gameGUI.hide();
		}
		gameGUI = new HangmanUI();
		System.out.println("we can print attempts to the console");
	    gameGUI.display();
	}
}
