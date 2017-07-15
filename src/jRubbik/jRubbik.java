package jRubbik;

import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.UIManager;

import jRubbik.ui.jRubikWindow;
import jRubbik.utils.Utils;

public class jRubbik {
	
	public static boolean USE_SCRAMBLE_DEBUG = true;
	public static String OFFICIAL_SCRAMBLE = "R2 B2 R2 L' B' R2 U2 B2 F R U2 B2 F' D' R' F R2 L2 B' U'";
	
	public static String SCRAMBLE_DEBUG = "U2 (R U')(R U)(R U)(R U') R' U' R2 U'"; 
			//OFFICIAL_SCRAMBLE;
	
	public static void main(String args[])
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception exception) {
			Utils.MessageBox(null, "Invalid look and feel.", "ERROR");
		}
		
		Locale.setDefault(Locale.US);
		NumberFormat.getInstance(Locale.US).setGroupingUsed(false);
		
		final jRubikWindow main = new jRubikWindow();
		
		main.setVisible(true);
	}
}
