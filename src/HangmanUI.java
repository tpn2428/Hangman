import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

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
	JLabel description1Label;
	JLabel description2Label;
	JLabel description3Label;
	JLabel description4Label;
	JLabel resultMessageLabel;
	JLabel guessingWordLabel;
	JLabel hangmanPic;
	
	JButton aButton;
    JButton bButton;
    JButton cButton;
    JButton dButton;
    JButton eButton;
    JButton fButton;
    JButton gButton;
    JButton hButton;
    JButton iButton;
    JButton jButton;
    JButton kButton;
    JButton lButton;
    JButton mButton;
    
    JButton nButton;
    JButton oButton;
    JButton pButton;
    JButton qButton;
    JButton rButton;
    JButton sButton;
    JButton tButton;
    JButton uButton;
    JButton vButton;
    JButton wButton;
    JButton xButton;
    JButton yButton;
    JButton zButton;
	
	JButton newGameButton; // To be supported soon
	JButton closeButton;
	
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
		this.description1Label = new JLabel();
		this.description2Label = new JLabel();
		this.description3Label = new JLabel();
		this.description4Label = new JLabel();
		this.resultMessageLabel = new JLabel();
		this.guessingWordLabel = new JLabel();
		this.hangmanPic = new JLabel();
		
		this.aButton = new JButton("a");
		this.bButton = new JButton("b");
		this.cButton = new JButton("c");
		this.dButton = new JButton("d");
		this.eButton = new JButton("e");
		this.fButton = new JButton("f");
		this.gButton = new JButton("g");
		this.hButton = new JButton("h");
		this.iButton = new JButton("i");
		this.jButton = new JButton("j");
		this.kButton = new JButton("k");
		this.lButton = new JButton("l");
		this.mButton = new JButton("m");
	    
		this.nButton = new JButton("n");
		this.oButton = new JButton("o");
		this.pButton = new JButton("p");
		this.qButton = new JButton("q");
		this.rButton = new JButton("r");
		this.sButton = new JButton("s");
		this.tButton = new JButton("t");
		this.uButton = new JButton("u");
		this.vButton = new JButton("v");
		this.wButton = new JButton("w");
		this.xButton = new JButton("x");
		this.yButton = new JButton("y");
		this.zButton = new JButton("z");
		
		this.closeButton = new JButton("Close");
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
		this.description1Label.setText("Directions: You");
		this.description2Label.setText("must guess the letters in the result word. If you get it right, it will reveal the locations of ");
		this.description3Label.setText("the letter you just guessed. If you get it wrong, a new part of the hangman will be drawn. You ");
		this.description4Label.setText("lose if hangman is fully drawn. You win if you have guessed the full word before the man is fully hung. Good luck :)");
		this.resultMessageLabel.setText("");
		this.resultMessageLabel.setFont(quizMidFont);
		this.guessingWordLabel.setText(this.hangmanGame.getCheckingWord());
		this.guessingWordLabel.setFont(quizBigFont);
		
		this.aButton.addActionListener(new LetterButtonListener());
		this.bButton.addActionListener(new LetterButtonListener());
		this.cButton.addActionListener(new LetterButtonListener());
		this.dButton.addActionListener(new LetterButtonListener());
		this.eButton.addActionListener(new LetterButtonListener());
		this.fButton.addActionListener(new LetterButtonListener());
		this.gButton.addActionListener(new LetterButtonListener());
		this.hButton.addActionListener(new LetterButtonListener());
		this.iButton.addActionListener(new LetterButtonListener());
		this.jButton.addActionListener(new LetterButtonListener());
		this.kButton.addActionListener(new LetterButtonListener());
		this.lButton.addActionListener(new LetterButtonListener());
		this.mButton.addActionListener(new LetterButtonListener());
		this.nButton.addActionListener(new LetterButtonListener());
		this.oButton.addActionListener(new LetterButtonListener());
		this.pButton.addActionListener(new LetterButtonListener());
		this.qButton.addActionListener(new LetterButtonListener());
		this.rButton.addActionListener(new LetterButtonListener());
		this.sButton.addActionListener(new LetterButtonListener());
		this.tButton.addActionListener(new LetterButtonListener());
		this.uButton.addActionListener(new LetterButtonListener());
		this.vButton.addActionListener(new LetterButtonListener());
		this.wButton.addActionListener(new LetterButtonListener());
		this.xButton.addActionListener(new LetterButtonListener());
		this.yButton.addActionListener(new LetterButtonListener());
		this.zButton.addActionListener(new LetterButtonListener());
		
		this.closeButton.addActionListener(new CloseButtonListener());
		
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
		this.descriptionPanel.add(this.description1Label);
		this.descriptionPanel.add(this.description2Label);
		this.descriptionPanel.add(this.description3Label);
		this.descriptionPanel.add(this.description4Label);
		this.alphabetPanel1.add(this.aButton);
		this.alphabetPanel1.add(this.bButton);
		this.alphabetPanel1.add(this.cButton);
		this.alphabetPanel1.add(this.dButton);
		this.alphabetPanel1.add(this.eButton);
		this.alphabetPanel1.add(this.fButton);
		this.alphabetPanel1.add(this.gButton);
		this.alphabetPanel1.add(this.hButton);
		this.alphabetPanel1.add(this.iButton);
		this.alphabetPanel1.add(this.jButton);
		this.alphabetPanel1.add(this.kButton);
		this.alphabetPanel1.add(this.lButton);
		this.alphabetPanel1.add(this.mButton);
		this.alphabetPanel2.add(this.nButton);
		this.alphabetPanel2.add(this.oButton);
		this.alphabetPanel2.add(this.pButton);
		this.alphabetPanel2.add(this.qButton);
		this.alphabetPanel2.add(this.rButton);
		this.alphabetPanel2.add(this.sButton);
		this.alphabetPanel2.add(this.tButton);
		this.alphabetPanel2.add(this.uButton);
		this.alphabetPanel2.add(this.vButton);
		this.alphabetPanel2.add(this.wButton);
		this.alphabetPanel2.add(this.xButton);
		this.alphabetPanel2.add(this.yButton);
		this.alphabetPanel2.add(this.zButton);
		this.guessingWordPanel.add(this.guessingWordLabel);
		this.resultMessagePanel.add(this.resultMessageLabel);
		this.hangmanImagePanel.add(this.hangmanPic);
		this.buttonsPanel.add(this.closeButton);
		
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
		JFrame theFrame = new JFrame("Hangman");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setContentPane(this);
		theFrame.setPreferredSize(new Dimension(1000, 900));
		theFrame.pack();
		theFrame.setVisible(true);
	}
	
	public void disableAllAlphabetButtons() {
		this.aButton.setEnabled(false);
		this.bButton.setEnabled(false);
		this.cButton.setEnabled(false);
		this.dButton.setEnabled(false);
		this.eButton.setEnabled(false);
		this.fButton.setEnabled(false);
		this.gButton.setEnabled(false);
		this.hButton.setEnabled(false);
		this.iButton.setEnabled(false);
		this.jButton.setEnabled(false);
		this.kButton.setEnabled(false);
		this.lButton.setEnabled(false);
		this.mButton.setEnabled(false);
		this.nButton.setEnabled(false);
		this.oButton.setEnabled(false);
		this.pButton.setEnabled(false);
		this.qButton.setEnabled(false);
		this.rButton.setEnabled(false);
		this.sButton.setEnabled(false);
		this.tButton.setEnabled(false);
		this.uButton.setEnabled(false);
		this.vButton.setEnabled(false);
		this.wButton.setEnabled(false);
		this.xButton.setEnabled(false);
		this.yButton.setEnabled(false);
		this.zButton.setEnabled(false);
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
}
