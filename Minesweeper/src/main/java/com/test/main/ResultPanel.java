package com.test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ResultPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Font f = new Font("Arial", Font.BOLD, 15);
	public ResultPanel(int size) {
		setVisible(true);
		setBackground(Color.RED);
		setBounds(size/4, 0, size/2, 80);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(new BorderLayout());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.RED);
		
	}


}
