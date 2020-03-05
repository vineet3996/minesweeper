package com.test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.test.main.util.TimerDisp;

public class CreateFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int CELL_SIZE=60;
	static List<List<CreatePanel>> cellsList;
	private static int XDIM,YDIM;
	static ResultPanel panel;
	static TimerDisp timer;

	public CreateFrame(int x,int y, int mines) {
		super("Minesweeper");
		XDIM=x;YDIM=y;
		List<List<Integer>> board=BoardGenerator.getBoard(mines, x, y);
		cellsList=new ArrayList<List<CreatePanel>>(x);
		int frameSizeX=x*CELL_SIZE + 2*CELL_SIZE+60;
		int frameSizeY=y*CELL_SIZE + 2*CELL_SIZE>900?x*CELL_SIZE + 2*CELL_SIZE:1000;
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		for(int i=0;i<x;i++) {
			List<CreatePanel> temp=new ArrayList<CreatePanel>(y);
			for(int j=0;j<y;j++) {
				CreatePanel p = new CreatePanel(board.get(i).get(j), i,j);
				
				p.setBounds(CELL_SIZE+j*CELL_SIZE, 100+i*CELL_SIZE, CELL_SIZE, CELL_SIZE);
				add(p);
				temp.add(p);
			}
			cellsList.add(temp);
		}
		
		setBackground(Color.BLACK);
		setSize(frameSizeY,frameSizeX);
		setVisible(true);
		
		panel = new ResultPanel(frameSizeY);
		
		JLabel timeLabel = new JLabel("Time : 0", JLabel.CENTER);
		timer = new TimerDisp(timeLabel);
		panel.add(timeLabel, BorderLayout.SOUTH);
		JLabel minesLabel = new JLabel("Mines : "+mines, JLabel.CENTER);
		panel.add(minesLabel, BorderLayout.EAST);
		
		
		/*
		 * JPanel xyPanel = new JPanel(); xyPanel.setBounds(0, 0, 100, 80);
		 */
		
		JLabel lblFName = new JLabel("First Name:");
        JTextField tfFName = new JTextField();
        lblFName.setLabelFor(tfFName);
 
        JLabel lblLName = new JLabel("Last Name:");
        JTextField tfLName = new JTextField();
        lblLName.setLabelFor(tfLName);
        
        tfLName.setBounds(0, 0, 200, 10);
        tfLName.setVisible(true);
        
        panel.add(tfLName,BorderLayout.WEST);
        
        add(panel,BorderLayout.NORTH);
		
	}
	
	public static void clearCells(int x, int y, List<Integer> list) {
		if(list.contains(x*XDIM+y))
			return;
		
		int val = cellsList.get(x).get(y).text;
		if(cellsList.get(x).get(y).isButtonVisible()) {
			cellsList.get(x).get(y).hideButton();
		}
		list.add(x*XDIM+y);
		for(int i=x-1;i<=x+1;++i) {
			for(int j=y-1;j<=y+1;++j) {
				if((i>=0 && i<XDIM && j>=0 && j<YDIM) && !(i==x && j==y)) {
					if(val==0) {
						clearCells(i, j,list);
					}
					else {
						if(cellsList.get(i).get(j).text==0) {
							clearCells(i, j,list);
						}
					}
				}
			}
		}
	}
	
	public static boolean clearAll(int x, int y) {
		if(cellsList.get(x).get(y).text==-1) {
			for(int i=0;i<XDIM;i++) {
				for(int j=0;j<YDIM;j++) {
					cellsList.get(i).get(j).hideButton();
				}
			}
			JLabel label = new JLabel("YOU LOSE", JLabel.CENTER);
			panel.add(label);
			timer.stopTime();
			return false;
		}
		return true;
	}
	
	public static void hasWon() {
		for(int i=0;i<XDIM;i++) {
			for(int j=0;j<YDIM;j++) {
				if(cellsList.get(i).get(j).text!=-1 && cellsList.get(i).get(j).isButtonVisible())
					return;
			}
		}
		for(int i=0;i<XDIM;i++) {
			for(int j=0;j<YDIM;j++) {
				cellsList.get(i).get(j).hideButton();
			}
		}
		JLabel label = new JLabel("YOU WIN!!!", JLabel.CENTER);
		panel.add(label);
		timer.stopTime();
	}
	
	/*
	 * public static void clearCells(int x, int y) { int tempX=x; int tempY=y; int
	 * anchorXU=x; int anchorYU=y; int anchorXD=x; int anchorYD=y; boolean
	 * isOverU=false; boolean isOverD=false; int
	 * currVal=board.get(tempX).get(tempY);
	 * 
	 * while(currVal==0 && tempX<=XDIM && tempX>=0 && tempY<=YDIM && tempY>=0) {
	 * 
	 * cellsList.get(tempX).get(tempY).hideButton(); tempY++;
	 * currVal=board.get(tempX).get(tempY); if(tempX!=XDIM && tempY<=YDIM &&
	 * board.get(tempX+1).get(tempY)==0 && !isOverU) { isOverU=true;
	 * anchorXU=tempX+1; anchorYU=tempY; } if(tempX!=0 &&
	 * board.get(tempX-1).get(tempY)==0 && !isOverD) { isOverD=true; anchorXD=tempX;
	 * anchorYD=tempY; } } tempY++; if(tempX<=x && tempX>=0 && tempY<=y && tempY>=0)
	 * cellsList.get(tempX).get(tempY).hideButton();
	 * 
	 * tempX=x; tempY=y; currVal=board.get(tempX).get(tempY);
	 * 
	 * while(currVal==0 && tempX<=x && tempX>=0 && tempY<=y && tempY>=0) {
	 * 
	 * cellsList.get(tempX).get(tempY).hideButton(); tempY--;
	 * currVal=board.get(tempX).get(tempY); if(tempX!=XDIM && tempY>=0 &&
	 * board.get(tempX+1).get(tempY)==0 && !isOverU) { isOverU=true;
	 * anchorXU=tempX+1; anchorYU=tempY; } if(tempX!=0 &&
	 * board.get(tempX-1).get(tempY)==0 && !isOverD) { isOverD=true; anchorXD=tempX;
	 * anchorYD=tempY; } } tempY--; if(tempX<=x && tempX>=0 && tempY<=y && tempY>=0)
	 * cellsList.get(tempX).get(tempY).hideButton();
	 * 
	 * }
	 */
	
	
}
