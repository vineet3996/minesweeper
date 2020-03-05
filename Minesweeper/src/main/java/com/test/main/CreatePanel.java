package com.test.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CreatePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int text;
	private static final Font f = new Font("Arial", Font.BOLD, 15);
	CreateButton b;
	public CreatePanel(int text, int x, int y) {
		this.text=text;
		setVisible(true);
		setBackground(Color.RED);
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.black));
		b = new CreateButton("",x,y);
		add(b);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.GRAY);
		if(text==-1) {
			g.setColor(Color.RED);
			//g.drawRect(x, y, width, height);
			g.fillRect(25, 25, 50, 20);
		}
		else {
			g.setFont(f);
			g.drawString(""+(text==0?"":text), 40, 40);
		}
		
	}
	
	public void hideButton(){
		if(b.isVisible())
			b.setVisible(false);
	}
	
	public boolean isButtonVisible(){
		return b.isVisible();
	}
	
	public void mousePressed() {
		b.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
			    if(e.getButton() == MouseEvent.BUTTON1) {
			    	setVisible(false);
			    }
			    else if (e.getButton() == MouseEvent.BUTTON3) {
			    	//System.out.println("right click");
			    	b.setText("F");
			    }
			    
			}
		});
	}

}