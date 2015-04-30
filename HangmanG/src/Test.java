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
	private Player P;
	private WordList Wordlist;
	private Puzzle pz;
	private boolean over;
	JLabel testing;
	JButton Start;
	JButton NewWord;
	JButton ShowAnswer;
	JButton Quit;
	
	public Test(String s)
	{
		super(s);
		//sets up the stuff from the game
		this.P = new Player();
		this.Wordlist = new WordList();
		this.Wordlist.loadWords();
		this.pz = this.Wordlist.getWord().toPuzzle();
		this.over = false;
		
		setSize(750,600);
		setResizable(false);
		addWindowListener(this);
		setLayout(null);
		testing = new JLabel(pz.toString() + " " + pz.getCategory());
		this.add(testing);
		testing.setBounds(0,0,200,15);
		
		Hang dude = new Hang();
		dude.setLayout(null);
		this.add(dude);
		dude.setBounds(550,50,150,200);
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
		
		
		//disables all letter buttons
		for(JButton B: Bs)
		{
			B.setEnabled(false);
		}
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
		else if(event.getActionCommand().equals("Start"))
		{
			for(JButton B: Bs)
			{
				B.setEnabled(true);
			}
			NewWord.setEnabled(true);
			ShowAnswer.setEnabled(true);
			Start.setEnabled(false);
		}
		else if(Bs.contains(event.getSource()))
		{
			((JButton)event.getSource()).setEnabled(false);
		}
		
		System.out.println("Worked "  + ((JButton)event.getSource()).getActionCommand());
	}
	public static void main(String []args)
	{
		new Test("Title");
	}
}
