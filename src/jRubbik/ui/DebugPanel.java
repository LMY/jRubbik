package jRubbik.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import jRubbik.utils.Utils;

public class DebugPanel extends JPanel {
	
	private static final long serialVersionUID = 7213682118242638035L;

	private JTextArea area;
	
	
	public DebugPanel() {
		super();
		
		setLayout(new BorderLayout());
		
		area = new JTextArea();
		final JScrollPane scp = new JScrollPane(area);
		add(scp, BorderLayout.CENTER);
		
		final JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		add(south, BorderLayout.SOUTH);
		
		
		final JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("");
			}
		});
		
		final JButton copyButton = new JButton("Copy");
		copyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Utils.clipboardCopy(area.getText());
			}
		});
//		
		south.add(clearButton);
		south.add(copyButton);
	}
	
	public void clear() { area.setText(""); }
	public String getText() { return area.getText(); }
	
	public void append(String line) { area.setText(area.getText()+"\n"+line); }
	public void setText(String line) { area.setText(line); }
}
