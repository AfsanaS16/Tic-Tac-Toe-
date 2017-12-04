//Afsana Siraj 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class TicTacToe  {
	
		JFrame frame = new JFrame("NULL");
		private JButton[] buttons;
		private JButton reset;
		private JLabel title;
		private JPanel panel1, panel2, panel3;
		private String letter = "";
		private boolean userWin = false;
		private boolean compWin = false;
		private int turn = 1;
		private final int WINDOW_WIDTH = 500;
		private final int WINDOW_HEIGHT = 500;
		
		public TicTacToe()
		{
			frame.setTitle("Project 2: Tic Tac Toe Game");
			frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			
			makeButtons();
			
			title = new JLabel("Tic Tac Toe");
			title.setFont(new Font("Calabri", Font.BOLD, 24));
			
			panel1 = new JPanel();
			panel1.add(title);
			
			
			panel3 = new JPanel();
			panel3.add(reset);
			
			frame.setLayout(new BorderLayout());
			frame.add(panel1, BorderLayout.NORTH);
			frame.add(panel2, BorderLayout.CENTER);
			frame.add(panel3, BorderLayout.EAST);
			
			frame.setVisible(true);
		}
		public void makeButtons()
		{
			buttons = new JButton[9];
			
			panel2 = new JPanel();
			panel2.setLayout(new GridLayout(3,3));
			
			for(int i=0; i<buttons.length; i++)
			{
				buttons[i] = new JButton();
				buttons[i].setText("");
				buttons[i].addActionListener(new GameListener());
					
				panel2.add(buttons[i]);
			}
			reset = new JButton("Restart");
			reset.addActionListener(new ResetListener());
		}
		public void compTurn()
		{
			if (turn >= 9 || userStat() == true)
				return;
			
			letter = "O";
			Random rand = new Random();
			int num = rand.nextInt(9);
			
			buttons[0].setFont(new Font("Calibri", Font.BOLD, 70));
			buttons[1].setFont(new Font("Calibri", Font.BOLD, 70));
			buttons[2].setFont(new Font("Calibri", Font.BOLD, 70));
			buttons[3].setFont(new Font("Calibri", Font.BOLD, 70));
			buttons[4].setFont(new Font("Calibri", Font.BOLD, 70));
			buttons[5].setFont(new Font("Calibri", Font.BOLD, 70));
			buttons[6].setFont(new Font("Calibri", Font.BOLD, 70));
			buttons[7].setFont(new Font("Calibri", Font.BOLD, 70));
			buttons[8].setFont(new Font("Calibri", Font.BOLD, 70));
			
			if(num == 0 && buttons[0].isEnabled())
			{
				buttons[0].setText(letter);
				buttons[0].setEnabled(false);
			}
			else if (num == 1 && buttons[1].isEnabled())
			{
				buttons[1].setText(letter);
				buttons[1].setEnabled(false);
			}
			else if (num == 2 && buttons[2].isEnabled())
			{
				buttons[2].setText(letter);
				buttons[2].setEnabled(false);
			}
			else if (num == 3 && buttons[3].isEnabled())
			{
				buttons[3].setText(letter);
				buttons[3].setEnabled(false);
			}
			else if (num == 4 && buttons[4].isEnabled())
			{
				buttons[4].setText(letter);
				buttons[4].setEnabled(false);
			}
			else if (num == 5 && buttons[5].isEnabled())
			{
				buttons[5].setText(letter);
				buttons[5].setEnabled(false);
			}
			else if (num == 6 && buttons[6].isEnabled())
			{
				buttons[6].setText(letter);
				buttons[6].setEnabled(false);
			}
			else if (num == 7 && buttons[7].isEnabled())
			{
				buttons[7].setText(letter);
				buttons[7].setEnabled(false);
			}
			else if (num == 8 && buttons[8].isEnabled())
			{
				buttons[8].setText(letter);
				buttons[8].setEnabled(false);
			}
			else if (turn < 9 && compWin == false)
			{
				compTurn();
			}
			if (compStat() && turn <= 9)
			{
				compWin = true;
				JOptionPane.showMessageDialog(null, "Computer Won!");
			}
			if (turn==2 || turn==4 || turn==6 || turn==8 && userStat() == false)
				turn++;
		}
		public boolean compStat()
		{
			boolean win = false;
			
			if(buttons[0].getText() == buttons[1].getText()&&
			   buttons[1].getText() == buttons[2].getText()&&
			   buttons[0].getText() == "O" && win == false)
			   win = true;
			else if(buttons[3].getText() == buttons[4].getText()&&
					buttons[4].getText() == buttons[5].getText()&&
					buttons[3].getText() == "O" && win == false)
					win = true;
			else if(buttons[6].getText() == buttons[7].getText()&&
					buttons[7].getText() == buttons[8].getText()&&
					buttons[6].getText() == "O" && win == false)
					win = true;
			else if(buttons[0].getText() == buttons[3].getText()&&
					buttons[3].getText() == buttons[6].getText()&&
					buttons[0].getText() == "O" && win == false)
					win = true;
			else if(buttons[1].getText() == buttons[4].getText()&&
					buttons[4].getText() == buttons[7].getText()&&
					buttons[1].getText() == "O" && win == false)
					win = true;
			else if(buttons[2].getText() == buttons[5].getText()&&
					buttons[5].getText() == buttons[8].getText()&&
					buttons[2].getText() == "O" && win == false)
					win = true;	
			else if(buttons[0].getText() == buttons[4].getText()&&
					buttons[4].getText() == buttons[8].getText()&&
					buttons[0].getText() == "O" && win == false)
					win = true;
			else if(buttons[2].getText() == buttons[4].getText()&&
					buttons[4].getText() == buttons[6].getText()&&
					buttons[2].getText() == "O" && win == false)
					win = true;
			return win;
		}
		public boolean userStat()
		{
			boolean win = false;
			if(buttons[0].getText() == buttons[1].getText()&&
			   buttons[1].getText() == buttons[2].getText()&&
			   buttons[0].getText() == "X" && win == false)
			   win = true;
			else if(buttons[3].getText() == buttons[4].getText()&&
					buttons[4].getText() == buttons[5].getText()&&
					buttons[3].getText() == "X" && win == false)
					win = true;
			else if(buttons[6].getText() == buttons[7].getText()&&
					buttons[7].getText() == buttons[8].getText()&&
					buttons[6].getText() == "X" && win == false)
					win = true;
			else if(buttons[0].getText() == buttons[3].getText()&&
					buttons[3].getText() == buttons[6].getText()&&
					buttons[0].getText() == "X" && win == false)
					win = true;
			else if(buttons[1].getText() == buttons[4].getText()&&
					buttons[4].getText() == buttons[7].getText()&&
					buttons[1].getText() == "X" && win == false)
					win = true;
			else if(buttons[2].getText() == buttons[5].getText()&&
					buttons[5].getText() == buttons[8].getText()&&
					buttons[2].getText() == "X" && win == false)
					win = true;	
			else if(buttons[0].getText() == buttons[4].getText()&&
					buttons[4].getText() == buttons[8].getText()&&
					buttons[0].getText() == "X" && win == false)
					win = true;
			else if(buttons[2].getText() == buttons[4].getText()&&
					buttons[4].getText() == buttons[6].getText()&&
					buttons[2].getText() == "X" && win == false)
					win = true;
			return win;
		}
		private class GameListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				letter = "X";
				
				if (e.getSource() == buttons[0])
				{
					buttons[0].setText(letter);
					buttons[0].setEnabled(false);
				}
				else if (e.getSource() == buttons[1])
				{
					buttons[1].setText(letter);
					buttons[1].setEnabled(false);
				}
				else if (e.getSource() == buttons[2])
				{
					buttons[2].setText(letter);
					buttons[2].setEnabled(false);
				}
				else if (e.getSource() == buttons[3])
				{
					buttons[3].setText(letter);
					buttons[3].setEnabled(false);
				}
				else if (e.getSource() == buttons[4])
				{
					buttons[4].setText(letter);
					buttons[4].setEnabled(false);
				}
				else if (e.getSource() == buttons[5])
				{
					buttons[5].setText(letter);
					buttons[5].setEnabled(false);
				}
				else if (e.getSource() == buttons[6])
				{
					buttons[6].setText(letter);
					buttons[6].setEnabled(false);
				}
				else if (e.getSource() == buttons[7])
				{
					buttons[7].setText(letter);
					buttons[7].setEnabled(false);
				}
				else if (e.getSource() == buttons[8])
				{
					buttons[8].setText(letter);
					buttons[8].setEnabled(false);
				}
				if(userStat() && turn<=9)
				{
					userWin = true;
					JOptionPane.showMessageDialog(null, "You won!");	
				}
				else if(userWin == false && compWin == false && turn >= 9)
				{
					JOptionPane.showMessageDialog(null, "It's a tie!");
					return;
				}
				if (turn==1 || turn==3 || turn==5 || turn==7 || turn==9)
					turn++;
				
				compTurn();
			}
		}
		private class ResetListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				letter = "";
				userWin=false;
				compWin=false;
				turn = 1;
				for(int i=0; i<buttons.length; i++)
				{
					buttons[i].setText("");
					buttons[i].setEnabled(true);
			
				}
			}
		}
	
		public static void main(String[] args)
		{
			new TicTacToe();
		}
}
