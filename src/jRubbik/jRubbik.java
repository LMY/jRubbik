package jRubbik;

import javax.swing.UIManager;

import jRubbik.ui.jRubikWindow;
import jRubbik.utils.Utils;

public class jRubbik {
	
	public static void main(String args[])
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception exception) {
			Utils.MessageBox(null, "Invalid look and feel.", "ERROR");
		}
				
		final jRubikWindow main = new jRubikWindow();
		
		main.setVisible(true);
	}
}
