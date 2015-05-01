import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Test extends JFrame implements WindowListener, ActionListener
{
	/**
	 * 
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
	JLabel testing;
	JButton Start;
	JButton NewWord;
	JButton ShowAnswer;
	JButton Quit;
	LetterPanel le;
	Hang man;
	int numWrong;
	public Test(String s)
	{
		super(s);
		//sets up the stuff from the game
		this.Wordlist = new WordList();
		this.Wordlist.loadWords();
		//this.pz = this.Wordlist.getWord().toPuzzle();
		numWrong = 0;
		setSize(750,600);
		setResizable(false);
		addWindowListener(this);
		setLayout(null);
		le = new LetterPanel();
		Word w = new Word("poopman","thing");
		pz = w.toPuzzle();
		
		le.setWord(pz);
		le.setBounds(20,300,705,70);
		this.add(le);
		testing = new JLabel(pz.toString() + " " + pz.getCategory());
		this.add(testing);
		testing.setBounds(0,0,200,15);
		
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
		
		//sets up the quit button
		Quit = new JButton("Quit");
		Quit.setBounds(560,480,170,40);
		Quit.addActionListener(this);
		add(Quit);
		
		statusPanel = new JPanel();
		statusPanel.setLayout(null);
		statusPanel.setBounds(20,50,100,200);
		this.add(statusPanel);
		status = new JLabel("You Lose");
		status.setBounds(0,0,100,200);
		statusPanel.add(status);
		

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
		if(event.getActionCommand().equals("Quit"))
		{
			System.exit(0);
		}
		else if(event.getActionCommand().equals("New Word"))
		{
			Word temp = Wordlist.getWord();
			testing.setText(temp.toString()+" " + temp.getCategory());
		}
		else if(event.getActionCommand().equals("Show Answer"))
		{
			pz.guessAll();
			setEnabledBs(false);
		}
		else if(event.getActionCommand().equals("Start"))
		{
			setEnabledBs(true);
			NewWord.setEnabled(true);
			ShowAnswer.setEnabled(true);
			Start.setEnabled(false);
		}
		else if(Bs.contains(event.getSource()))
		{
			((JButton)event.getSource()).setEnabled(false);
			System.out.println(((JButton)event.getSource()).getActionCommand());
			if(pz.guessBlanks(((JButton)event.getSource()).getActionCommand()))
			{
				le.setWord(pz);
				le.removeAll();
				le.repaint();
			}
			else
			{
				man.nextPart();
				man.repaint();
				man.checkLoss();
			}
		}
		
		System.out.println("Worked "  + ((JButton)event.getSource()).getActionCommand());
	}
	public void setEnabledBs(boolean b)
	{
		for(JButton B: Bs)
		{
			B.setEnabled(b);
		}
	}
	public static void main(String []args)
	{
		new Test("Title");
	}
}
