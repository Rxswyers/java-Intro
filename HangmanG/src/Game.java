/*Author: 			Ruben Swyers
* Creation Date: 	April 30, 2015 
* Due Date: 		April 30, 2015
* Course: 			CSC243
* Professor Name: 	Dr. Kaplan
* Assignment: 		#3
* Filename: 		Game.java
* Purpose:		  	Hangman game, it will run as a JFrame
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Game extends JFrame implements WindowListener, ActionListener
{
	/**
	 * Pleasing the Eclipse editor by making it have a serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	//members
	JButton B;
	ArrayList<JButton> Bs = new ArrayList<JButton>();
	private WordList Wordlist;
	private Puzzle pz;
	JPanel statusPanel;
	JLabel status;
	JPanel categoryPanel;
	JLabel category;
	JLabel testing;
	JButton Start;
	JButton NewWord;
	JButton ShowAnswer;
	JButton Quit;
	LetterPanel le;
	Hang man;
	int numWrong;
	JLabel header;
	JLabel instructions;
	public Game(String s)
	{
		super(s);
		//sets up the header
		header = new JLabel("Hangman");
		Font labelFont = header.getFont();
		header.setBounds(200,0,400,55);
		header.setFont(new Font(labelFont.getName(), Font.PLAIN, 48));
		this.add(header);
		
		//displays the instructions
		JOptionPane.showMessageDialog(this, "You will be shown space holders for a word.\nGuess one letter at a time from the alphabet and see if you can guess the word.\nThe category of the word will be displayed in the middle of the game.");
		//sets up the wordlist
		this.Wordlist = new WordList();
		this.Wordlist.loadWords();
		//gets a new puzzle to start
		this.pz = this.Wordlist.getWord().toPuzzle();
		category = new JLabel(pz.getCategory());
		//sets up the frame
		setSize(750,600);
		setResizable(false);
		addWindowListener(this);
		setLayout(null);
		//makes the letterpanel
		le = new LetterPanel();
		le.setWord(pz);
		le.setBounds(20,300,705,70);
		this.add(le);
		//sets up the gallows
		man = new Hang();
		man.setLayout(null);
		this.add(man);
		man.setBounds(550,60,150,200);
		//sets up the letter buttons and adds them to an ArrayList
		char letter = 'A';
		int xOff = 55;
		int yOff = 50;
		for(int i = 0; i < 2; i ++)
		{
			for(int j = 0; j < 13; j ++)
			{
				B = new JButton(Character.toString(letter));
				B.setBounds(20 + (xOff * j),375 + (yOff *i),50,40);
				this.add(B);
				Bs.add(B);
				B.addActionListener(this);
				letter ++;
			}
		}
		//sets up the start button
		Start = new JButton("Start");
		Start.setBounds(20,480,170,40);
		add(Start);
		Start.addActionListener(this);
		
		//sets up the new word button
		NewWord = new JButton("New Word");
		NewWord.setBounds(200,480,170,40);
		add(NewWord);
		NewWord.addActionListener(this);
		
		//sets up the show answer button
		ShowAnswer = new JButton("Show Answer");
		ShowAnswer.setBounds(380,480,170,40);
		add(ShowAnswer);
		ShowAnswer.addActionListener(this);
		
		//sets up the quit button
		Quit = new JButton("Quit");
		Quit.setBounds(560,480,170,40);
		Quit.addActionListener(this);
		add(Quit);
		
		//sets up the statuspanel
		statusPanel = new JPanel();
		statusPanel.setLayout(null);
		statusPanel.setBounds(20,50,300,200);
		this.add(statusPanel);
		status = new JLabel("You Lose");
		status.setBounds(0,0,300,200);
		status.setFont(new Font(labelFont.getName(), Font.PLAIN, 48));
		statusPanel.add(status);
		statusPanel.setVisible(false);
		
		//sets up the categorypanel
		categoryPanel = new JPanel();
		categoryPanel.setLayout(null);
		categoryPanel.setBounds(220, 50, 200, 200);
		category.setFont(new Font(labelFont.getName(), Font.PLAIN, 48));
		category.setBounds(0,0,200,200);
		categoryPanel.add(category);
		this.add(categoryPanel);
		
		//disables all letter buttons
		setEnabledBs(false);
		
		NewWord.setEnabled(false);
		ShowAnswer.setEnabled(false);
		setVisible(true);
		
		
	}
	public void windowClosed(WindowEvent event) {}
	public void windowDeiconified(WindowEvent event) {}
	public void windowIconified(WindowEvent event) {}
	public void windowActivated(WindowEvent event) {}
	public void windowDeactivated(WindowEvent event) {}
	public void windowOpened(WindowEvent event) {}
	public void windowClosing(WindowEvent event) {System.exit(0);}

	public void actionPerformed(ActionEvent event)
	{
		//the user clicked the quit button
		if(event.getActionCommand().equals("Quit"))
		{
			//exits
			System.exit(0);
		}
		//the user clicked the new word button
		else if(event.getActionCommand().equals("New Word"))
		{
			//swaps the panels because they would overlap
			statusPanel.setVisible(false);
			categoryPanel.setVisible(true);
			//resets the gallows
			man.reset();
			man.repaint();
			//gets a new word and makes it a puzzle
			Word temp = Wordlist.getWord();
			pz = temp.toPuzzle();
			category.setText(pz.getCategory());
			//resets the letterpanel
			le.removeAll();
			le.setWord(pz);
			le.repaint();
			//reenables the alphabet buttons
			setEnabledBs(true);
			
		}
		//the user clicked the show answer button
		else if(event.getActionCommand().equals("Show Answer"))
		{
			//fills out the puzzle and presents the answer
			pz.guessAll();
			le.setWord(pz);
			le.removeAll();
			le.repaint();
			//disables the alphabet buttons
			setEnabledBs(false);
		}
		//the user clicked on the start button
		else if(event.getActionCommand().equals("Start"))
		{
			//enables the alphabet buttons and show answer, disables start and new word
			setEnabledBs(true);
			NewWord.setEnabled(true);
			ShowAnswer.setEnabled(true);
			Start.setEnabled(false);
		}
		//the user clicked on an alphabet button
		else if(Bs.contains(event.getSource()))
		{
			//disables it
			((JButton)event.getSource()).setEnabled(false);
			//guesses the button
			if(pz.guessBlanks(((JButton)event.getSource()).getActionCommand()))
			{
				//updates the letterpanel
				le.setWord(pz);
				le.removeAll();
				le.repaint();
				//checks to see if you guessed the whole word
				if(pz.allGuessed())
				{
					//sets the status to win, shows the status panel, hides the category panel
					status.setText("You Win!");
					categoryPanel.setVisible(false);
					statusPanel.setVisible(true);
					//disables the alphabet buttons
					setEnabledBs(false);
				}
			}
			//the user guessed wrong
			else
			{
				//updates the gallows
				man.nextPart();
				man.repaint();
				//checked to see if you lost
				if(man.checkLoss())
				{
					//sets up the status panel for a loss
					status.setText("You Lose!");
					categoryPanel.setVisible(false);
					statusPanel.setVisible(true);
					setEnabledBs(false);
				}
			}
		}
	}
	//Name:			setEnabledBs
	//Discription:	enables or disables the alphabet buttons
	//Parameters:	true or false boolean
	//Returns:		n/a
	public void setEnabledBs(boolean b)
	{
		for(JButton B: Bs)
		{
			B.setEnabled(b);
		}
	}
	public static void main(String []args)
	{
		new Game("Title");
	}
}
