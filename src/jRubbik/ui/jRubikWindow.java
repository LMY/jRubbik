package jRubbik.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import jRubbik.state.CubeState;
import jRubbik.utils.LastUsedFolder;
import jRubbik.utils.Utils;


public class jRubikWindow extends JFrame {

	private static final long serialVersionUID = 1370028090893596099L;
	public final static double ASPECT_RATIO = 16.0/9.0;
	public final static int WINDOW_WIDTH = 1100;
	public final static int WINDOW_HEIGHT = (int) (WINDOW_WIDTH/ASPECT_RATIO);
	public final static Dimension PREFERRED_DIMENSION = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
	
	private JTabbedPane tabs;
	
	
	public jRubikWindow()
	{
		super("jRubik");
		
		LastUsedFolder.init(".");
		
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
	    		System.exit(0);
		    }
		});
		
		setPreferredSize(PREFERRED_DIMENSION);
		
		CreateMenuBar();
		
		tabs = new JTabbedPane();
		addPanelCube();
		
		this.add(tabs);

		Utils.associateKeyBind(this, tabs, KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_DOWN_MASK), "Close");
		
		// pack and display
		pack();
		Utils.centerWindow(this);
	}
	
	public void addPanelCube()
	{
		addPanelCube(new CubeState());
	}
	
	public void addPanelCube(CubeState state)
	{
		tabs.add("Cube", new CubePanelDraw(state));
	}
	
	
	
	public void CreateMenuBar()
	{
		final JMenuBar menubar = new JMenuBar();
		
		final JMenu filemenu = new JMenu("File");
		filemenu.setMnemonic(KeyEvent.VK_F);
		final JMenuItem menunew = new JMenuItem("New");
		menunew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) { }
		});
		menunew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));

		final JMenuItem openmenu = new JMenuItem("Open...");
		openmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {  }
		});
		openmenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));

		final JMenuItem closemenu = new JMenuItem("Close");
		closemenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {  }
		});
		closemenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK));

		final JMenuItem savemenu = new JMenuItem("Save");
		savemenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) { }
		});
		savemenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));

		final JMenuItem saveasmenu = new JMenuItem("Save as...");
		saveasmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {  }
		});
		saveasmenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));

		final JMenuItem exitmenu = new JMenuItem("Quit");
		exitmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) { System.exit(0); }
		});


		filemenu.add(menunew);
		filemenu.addSeparator();
		filemenu.add(openmenu);
		filemenu.addSeparator();
		filemenu.add(closemenu);
		filemenu.addSeparator();
		filemenu.add(savemenu);
		filemenu.add(saveasmenu);
		filemenu.addSeparator();
		filemenu.add(exitmenu);
		
		final JMenu cubemenu = new JMenu("Cube");
		final JMenuItem newcubemenu = new JMenuItem("New Cube");
		newcubemenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) { addPanelCube(); }
		});
		cubemenu.add(newcubemenu);
		
		menubar.add(filemenu);
		menubar.add(cubemenu);
		
		menubar.add(Box.createHorizontalGlue());

		setJMenuBar(menubar);
	}

}
