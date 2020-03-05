package com.test.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class CreateButton extends JButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Font f = new Font("Arial", Font.BOLD, CreateFrame.CELL_SIZE/6);
	int x,y;

	public CreateButton(String title,final int x,final int y) {
		super(title);
		setBackground(Color.GREEN);
		setBounds(0, 0, CreateFrame.CELL_SIZE, CreateFrame.CELL_SIZE);
		setVisible(true);
		setHorizontalTextPosition(SwingConstants.CENTER);
		//setVerticalTextPosition(SwingConstants.CENTER);
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
			    if(e.getButton() == MouseEvent.BUTTON1) {
			    	setVisible(false);
			    	List<Integer> list=new ArrayList<Integer>();
			    	CreateFrame.clearCells(x,y,list);
			    	if(CreateFrame.clearAll(x, y))
			    		CreateFrame.hasWon();
			    }
			    else if (e.getButton() == MouseEvent.BUTTON3) {
			    	//System.out.println("right click");
			    	setFont(f);
			    	if(getText().isEmpty())
			    		setText("Flag");
			    	else
			    		setText("");
			    }
			    
			}
		});
		
		
		/*
		 * addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent e) {
		 * 
		 * setVisible(false); }
		 * 
		 * });
		 */
	}

}
