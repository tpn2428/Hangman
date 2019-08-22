import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class HangmanUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2944511187100344308L;

	HangmanGame hangmanGame;
	
	JPanel welcomeMessagePanel;
	JPanel descriptionPanel;
	JPanel alphabetPanel1;
	JPanel alphabetPanel2;
	JPanel guessingWordPanel;
	JPanel resultMessagePanel;
	JPanel hangmanImagePanel;
	JPanel buttonsPanel;
	
	JLabel welcomeMessageLabel;
	JTextArea descriptionTextArea;
	JLabel resultMessageLabel;
	JLabel guessingWordLabel;
	JLabel hangmanPic;
	
	ArrayList<JButton> letterButtons1;
	ArrayList<JButton> letterButtons2;
	
	JButton newGameButton; // To be supported soon
	JButton closeButton;
	
	JFrame theFrame;
	
	public HangmanUI() {
		this.makeAllComponents();
		this.initUIAndGame();
	}
	public void makeAllComponents() {
		this.welcomeMessagePanel = new JPanel();
		this.descriptionPanel = new JPanel();
		this.alphabetPanel1 = new JPanel();
		this.alphabetPanel2 = new JPanel();
		this.guessingWordPanel = new JPanel();
		this.resultMessagePanel = new JPanel();
		this.hangmanImagePanel = new JPanel();
		this.buttonsPanel = new JPanel();
		
		this.welcomeMessageLabel = new JLabel();
		this.descriptionTextArea = new JTextArea(3, 60);
		this.resultMessageLabel = new JLabel();
		this.guessingWordLabel = new JLabel();
		this.hangmanPic = new JLabel();
		
		this.letterButtons1 = new ArrayList<JButton>();
		this.letterButtons2 = new ArrayList<JButton>();
		for (int i = 0; i < 13; i++) {
			this.letterButtons1.add(new JButton((char)('a' + i) + ""));
		}
		for (int i = 13; i < 26; i++) {
			this.letterButtons2.add(new JButton((char)('a' + i) + ""));
		}
		
		this.newGameButton = new JButton("New Game");
		this.closeButton = new JButton("Close");
		
		this.theFrame = new JFrame("Hangman");
		this.theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.theFrame.setContentPane(this);
		this.theFrame.setPreferredSize(new Dimension(800, 700));
		this.theFrame.pack();
	}
	
	public void initUIAndGame() {
		this.hangmanGame = new HangmanGame();
		System.out.println(hangmanGame.getResultWord());
		
		this.welcomeMessagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.descriptionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.alphabetPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.alphabetPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.guessingWordPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.resultMessagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.hangmanImagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		Font quizBigFont = new Font("Helvetica Bold", Font.BOLD, 30);
		Font quizMidFont = new Font("Helvetica Bold", Font.BOLD, 20);
		
		this.welcomeMessageLabel.setText("Welcome to the Hangman Game");
		this.welcomeMessageLabel.setFont(quizBigFont);
		this.descriptionTextArea.setWrapStyleWord(true);
		this.descriptionTextArea.setLineWrap(true);
		this.descriptionTextArea.setOpaque(false);
		this.descriptionTextArea.setEditable(false);
		this.descriptionTextArea.setFocusable(false);
	    this.descriptionTextArea.setBackground(UIManager.getColor("Label.background"));
	    this.descriptionTextArea.setFont(UIManager.getFont("Label.font"));
	    this.descriptionTextArea.setBorder(UIManager.getBorder("Label.border"));
		this.descriptionTextArea.setText("Directions: You must guess the letters in the result word. If you get it right, it will reveal the locations of "
				+ "the letter you just guessed. If you get it wrong, a new part of the hangman will be drawn. You "
				+ "lose if hangman is fully drawn. You win if you have guessed the full word before the man is fully hung. Good luck :)");
		this.resultMessageLabel.setText("");
		this.resultMessageLabel.setFont(quizMidFont);
		this.guessingWordLabel.setText(this.hangmanGame.getCheckingWord());
		this.guessingWordLabel.setFont(quizBigFont);
		
		for (int i = 0; i < this.letterButtons1.size(); i++) {
			this.letterButtons1.get(i).addActionListener(new LetterButtonListener());
		}
		for (int i = 0; i < this.letterButtons2.size(); i++) {
			this.letterButtons2.get(i).addActionListener(new LetterButtonListener());
		}
		
		this.closeButton.addActionListener(new CloseButtonListener());
		this.newGameButton.addActionListener(new NewGameButtonListener());
		
		try {
			BufferedImage myPicture = ImageIO.read(new File("src/man0.png"));
			ImageIcon imageIcon = new ImageIcon(myPicture);
			Image image = imageIcon.getImage(); // transform it 
			Image newimg = image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			imageIcon = new ImageIcon(newimg);
			this.hangmanPic.setIcon(imageIcon);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		this.welcomeMessagePanel.add(this.welcomeMessageLabel);
		this.descriptionPanel.add(this.descriptionTextArea);
		for (int i = 0; i < this.letterButtons1.size(); i++) {
			this.alphabetPanel1.add(this.letterButtons1.get(i));
		}
		for (int i = 0; i < this.letterButtons2.size(); i++) {
			this.alphabetPanel2.add(this.letterButtons2.get(i));
		}
		this.guessingWordPanel.add(this.guessingWordLabel);
		this.resultMessagePanel.add(this.resultMessageLabel);
		this.hangmanImagePanel.add(this.hangmanPic);
		this.buttonsPanel.add(this.closeButton);
		this.buttonsPanel.add(this.newGameButton);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(this.welcomeMessagePanel);
		this.add(this.descriptionPanel);
		this.add(this.alphabetPanel1);
		this.add(this.alphabetPanel2);
		this.add(this.guessingWordPanel);
		this.add(this.resultMessagePanel);
		this.add(this.hangmanImagePanel);
		this.add(this.buttonsPanel);
	}
	
	public void display() {
		theFrame.setVisible(true);
	}
	
	public void hide() {
		theFrame.setVisible(false);
	}
	
	public void disableAllAlphabetButtons() {
		for (int i = 0; i < this.letterButtons1.size(); i++) {
			this.letterButtons1.get(i).setEnabled(false);
		}
		for (int i = 0; i < this.letterButtons2.size(); i++) {
			this.letterButtons2.get(i).setEnabled(false);
		}
	}
	
	class LetterButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton callingButton = (JButton) e.getSource();
			callingButton.setEnabled(false);
			char guessingChar = callingButton.getText().charAt(0);
			hangmanGame.revealGuessingWordByLetter(guessingChar);
			System.out.println(guessingChar);
			if (hangmanGame.doesCharacterExistInResultWord(guessingChar)) {
				guessingWordLabel.setText(hangmanGame.getCheckingWord());
				if (hangmanGame.isWordFullyRevealed()) {
					resultMessageLabel.setText("You've won!");
					resultMessageLabel.setForeground(Color.BLUE);
					disableAllAlphabetButtons();
				}
			} else {
				hangmanGame.wrongGuess();
				try {
					BufferedImage myPicture = ImageIO.read(new File("src/man" + hangmanGame.getFailedAttempts() + ".jpg"));
					ImageIcon imageIcon = new ImageIcon(myPicture);
					Image image = imageIcon.getImage(); // transform it 
					Image newimg = image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
					imageIcon = new ImageIcon(newimg);
					hangmanPic.setIcon(imageIcon);
				} catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
				if (hangmanGame.isItTimeToGiveAWarning()) {
					resultMessageLabel.setText("You only have one attempt left!");
					resultMessageLabel.setForeground(Color.ORANGE);
					return;
				}
				if (hangmanGame.isGameOver()) {
					resultMessageLabel.setText("The answer is " + hangmanGame.getResultWord() + ". The innocent man has been hung! You lose!");
					resultMessageLabel.setForeground(Color.RED);
					disableAllAlphabetButtons();
					return;
				}
			}
		}
	}
	class CloseButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	class NewGameButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Main.resetGame();
		}
	}
}
