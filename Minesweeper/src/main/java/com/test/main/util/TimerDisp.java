package com.test.main.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class TimerDisp {

    private JLabel label;
    Timer countdownTimer;
    int timeRemaining = 0;

    public TimerDisp(JLabel passedLabel) {
       countdownTimer = new Timer(1000, new CountdownTimerListener());
       this.label = passedLabel;
       countdownTimer.start();
    }
    
    public void stopTime() {
    	countdownTimer.stop();
    }

     class CountdownTimerListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
			/*
			 * if (--timeRemaining > 0) { label.setText(String.valueOf(timeRemaining)); }
			 * else { label.setText("Time's up!"); countdownTimer.stop(); }
			 */
        	 ++timeRemaining;
        	 label.setText("Time : "+String.valueOf(timeRemaining));
         }
     }
}
