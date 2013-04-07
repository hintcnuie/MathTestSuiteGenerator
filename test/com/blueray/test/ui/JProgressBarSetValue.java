package com.blueray.test.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class JProgressBarSetValue extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4380796527367180693L;
	JProgressBar bar = new JProgressBar();
	JButton step = new JButton("Step");

	public JProgressBarSetValue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		step.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value = bar.getValue() + 7;
				if (value > bar.getMaximum()) {
					value = bar.getMaximum();
				}
				bar.setValue(value);
			}
		});

		getContentPane().add(bar, BorderLayout.NORTH);
		getContentPane().add(step, BorderLayout.EAST);
		pack();
		setVisible(true);
	}

	public static void main(String arg[]) {
		new JProgressBarSetValue();
	}
}
