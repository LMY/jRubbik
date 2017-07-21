package jRubbik.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import jRubbik.moves.BasicMoves;
import jRubbik.moves.IMove;
import jRubbik.solver.SolverCFOP;
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
		addPanelCube(new CubeState());
		
		this.add(tabs);

		Utils.associateKeyBind(this, tabs, KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_DOWN_MASK), "Close");
		
		// pack and display
		pack();
		Utils.centerWindow(this);
	}
	

	public void addPanelCube(CubeState state)
	{
		tabs.add("Cube", new CubePanelDraw(state));
		tabs.setSelectedComponent(tabs.getComponent(tabs.getTabCount()-1));
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
			public void actionPerformed(ActionEvent ae) { tabs.remove(tabs.getSelectedComponent()); }
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
			public void actionPerformed(ActionEvent ae) { addPanelCube(new CubeState()); }
		});
		cubemenu.add(newcubemenu);
		
		final JMenuItem clonecubemenu = new JMenuItem("Clone Cube");
		clonecubemenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) { 
				final CubeState act = getActiveCubeState();
				if (act != null)
					addPanelCube(act.clone());
			}
		});
		cubemenu.add(clonecubemenu);
		
		
//		final JMenu debugmenu = new JMenu("Debug");
//		final JMenuItem debugmenu1 = new JMenuItem("Fork");
//		debugmenu1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent ae) { 
//				try{
//					getActiveCubePanel().fork();
//				}
//				catch (Exception e) {}
//			}
//		});
//		debugmenu.add(debugmenu1);
//		
//		final JMenuItem debugmenu2 = new JMenuItem("New");
//		debugmenu2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent ae) { 
//				try{
//					getActiveCubePanel().newnode();
//				}
//				catch (Exception e) {}
//			}
//		});
//		debugmenu.add(debugmenu2);
		
		
		final JMenu solvermenu = new JMenu("Solver");
		{
			final JMenuItem cfopmenu = new JMenuItem("CFOP");
			cfopmenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) { 
					try{
						final IMove solve = new SolverCFOP().solve(getActiveCubeState());
						getActiveCubePanel().perform(solve);
					}
					catch (Exception e) {
						Utils.MessageBox(e.toString(), "");
					}
				}
			});
			solvermenu.add(cfopmenu);
		}
		

		menubar.add(filemenu);
		menubar.add(cubemenu);
//		menubar.add(debugmenu);
		menubar.add(solvermenu);
		menubar.add(createMenuMovesOLL("OLL", BasicMoves.OLLs));
		menubar.add(createMenuMovesPLL("PLL", BasicMoves.PLLs));
		
		
		// add the following aligned to the right
//		menubar.add(Box.createHorizontalGlue());

		setJMenuBar(menubar);
	}
	
	// align OLLs in a grid. there are too many for a normal vertical menu...
	// https://stackoverflow.com/questions/7913938/java-swing-how-to-align-menu-items-in-rows-and-columns
	private JMenu createMenuMovesOLL(String name, IMove[] moves) {
	    
		final JMenu menu = new JMenu(name);
	    final JPopupMenu popupMenu = menu.getPopupMenu();
	    
	    final int columns = 7;
	    @SuppressWarnings("unused")
		final int rows = moves.length/(columns == 0 ? 1 : columns) + 1;
	    
	    popupMenu.setLayout(new GridLayout(rows, columns));
	    
	    int idx = 0;
	    
	    for (int r = 0; r < rows; r++) {
	    	if (idx == moves.length)
	    		break;
	    	
	        for (int c = 0; c < columns; c++) {
	            //popupMenu.add(new JMenuItem("(" + (r + 1) + ", " + (c + 1) + ")"));
	        	
		    	if (idx == moves.length)
		    		break;
		    	
	        	final IMove move = moves[idx++];
	        	
	        	if (move == null)
	        		continue;
	        	
	        	final JMenuItem debugmenu2 = new JMenuItem(move.toString());
				debugmenu2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) { 
						try{
							getActiveCubePanel().perform(move);
						}
						catch (Exception e) {}
					}
				});
				popupMenu.add(debugmenu2);
	        }
	    }

    	return menu;
	}
    
    
	private JMenu createMenuMovesPLL(String name, IMove[] moves) {
		final JMenu solvermenu = new JMenu(name);
		

		for (IMove move : moves) {
			final JMenuItem debugmenu2 = new JMenuItem(move.toString());
			debugmenu2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) { 
					try{
						getActiveCubePanel().perform(move);
					}
					catch (Exception e) {}
				}
			});
			solvermenu.add(debugmenu2);
		}
		
		
		return solvermenu;
	}


	public CubePanel getActiveCubePanel() {
		return (CubePanel) tabs.getSelectedComponent();
	}
	
	public CubeState getActiveCubeState() {
		final CubePanel sel = getActiveCubePanel();
		return sel != null ? sel.getState() : null;
	}

}
