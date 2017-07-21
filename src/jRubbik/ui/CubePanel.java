package jRubbik.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import jRubbik.moves.BasicMoves;
import jRubbik.moves.IMove;
import jRubbik.moves.MoveParser;
import jRubbik.state.CubeState;
import jRubbik.state.Scrambler;

public abstract class CubePanel extends JPanel {

	private static final long serialVersionUID = -8791902983413545183L;

	
	public abstract void display(IMove move);
	protected abstract void init();

	
	protected CubeState state;
	private JTextField sequenceField;
	private JTree stateTree;
	private DefaultTreeModel treeModel;
	private DefaultMutableTreeNode stateRoot;
	
	
	public CubePanel(CubeState state) {
		super();
		
		this.state = state;
		setLayout(new BorderLayout());
		
		stateRoot = new DefaultMutableTreeNode("/");
		treeModel = new DefaultTreeModel(stateRoot);
//		treeModel.addTreeModelListener(new MyTreeModelListener());

		stateTree = new JTree(treeModel);
		stateTree.setEditable(true);
		stateTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		stateTree.addTreeSelectionListener(new MyTreeSelectionListener());
		stateTree.setShowsRootHandles(true);
		
		
		final JPanel south = new JPanel();
		south.setLayout(new BorderLayout());
		
		sequenceField = new JTextField();
		sequenceField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				newnode();
			}
		});
		
		final JPanel movePanel = new JPanel();
		movePanel.setLayout(new FlowLayout());
		
		
		south.add(new JLabel("Sequence: "), BorderLayout.WEST);
		south.add(sequenceField, BorderLayout.CENTER);
		south.add(movePanel, BorderLayout.SOUTH);
		add(south, BorderLayout.SOUTH);
		
		final JScrollPane scrolltree = new JScrollPane(stateTree);
//		scrolltree.setMinimumSize(new Dimension(100,0));
		scrolltree.setPreferredSize(new Dimension(100,0));
		add(scrolltree, BorderLayout.EAST);
		
		addMovesToPanel(movePanel, BasicMoves.PUBLIC_ALL_SIMPLE, BasicMoves.PUBLIC_ALL_SIMPLE_INV, BasicMoves.PUBLIC_ALL_SIMPLE2);
		addMovesToPanel(movePanel, BasicMoves.PUBLIC_ALL_DOUBLE, BasicMoves.PUBLIC_ALL_DOUBLE_INV, BasicMoves.PUBLIC_ALL_DOUBLE2);
		addMovesToPanel(movePanel, BasicMoves.PUBLIC_ALL_MIDDLE, BasicMoves.PUBLIC_ALL_MIDDLE_INV, BasicMoves.PUBLIC_ALL_MIDDLE2);
		addMovesToPanel(movePanel, BasicMoves.PUBLIC_ALL_ORIENTATION, BasicMoves.PUBLIC_ALL_ORIENTATION_INV, BasicMoves.PUBLIC_ALL_ORIENTATION2);

		final JPanel Panelbasic = new JPanel();
		Panelbasic.setLayout(new GridLayout(3, 0));
		
		final JButton scramble = new JButton("Scramble");
		scramble.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				perform(new Scrambler().scramble());
			}
		});
		Panelbasic.add(scramble);
		
		final JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setState(new CubeState());
			}
		});
		Panelbasic.add(reset);
		
		final JButton resetorient = new JButton("Reset Orientation");
		resetorient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final CubeState newstate = getState().clone();
				newstate.resetOrientation();
				setState(newstate);
			}
		});
		Panelbasic.add(resetorient);
		
		movePanel.add(Panelbasic);
		
		init();
		
		display();
	}
	
	public void addMovesToPanel(final JPanel movePanel, IMove[] normal, IMove[] inverse, IMove[] mdouble)
	{
		final JPanel Panelbasic = new JPanel();
		final int howmany = (normal == null ? 0 : 1) + (inverse == null ? 0 : 1) + (mdouble == null ? 0 : 1);
		
		Panelbasic.setLayout(new GridLayout(howmany, normal.length));
		
		if (normal != null)
			for (int i = 0; i<normal.length; i++)
				Panelbasic.add(buttonMove(normal[i]));
		
		if (inverse != null)
			for (int i = 0; i<inverse.length; i++)
				Panelbasic.add(buttonMove(inverse[i]));
		
		if (mdouble != null)
			for (int i = 0; i<inverse.length; i++)
				Panelbasic.add(buttonMove(mdouble[i]));
		
		movePanel.add(Panelbasic);
	}
	
	
	
	public JButton buttonMove(final IMove move) {
		final JButton clearButton = new JButton(move.toString());
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				sequenceField.setText(sequenceField.getText()+" "+move.toString());
				perform(move);
			}
		});
		clearButton.addKeyListener(new MyKeyListener());
		return clearButton;
	}
	
	public void display() { display(null); }

	public void perform(IMove move) {
		move.apply(state);
		display(move);
		fork(move.toString());
	}

	public CubeState getState() {
		return state;
	}

	public void setState(CubeState state) {
		this.state = state;
		display();
	}

	public class MyKeyListener implements KeyListener
	{
		@Override
		public void keyPressed(KeyEvent arg0) {
			char c = arg0.getKeyChar();
			
			if (Character.isSpaceChar(c) || c == 0)
				return;
			
			if (Character.isUpperCase(c)) c = Character.toLowerCase(c);
			else /*if (Character.isUpperCase(c))*/ c = Character.toUpperCase(c);
			
			boolean ctrl = arg0.isAltDown();
			
			try {
				final String text = ""+c+(ctrl?"'":"");
				final IMove move = MoveParser.parse(text);
				if (move != null)
					perform(move);
			}
			catch (Exception e) {}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {}

		@Override
		public void keyTyped(KeyEvent arg0) {}
	}
	
	public void fork() {
//		final String text = sequenceField.getText();
//		sequenceField.setText("");
		fork("FORK");
	}
	public void newnode() {
		final String text = sequenceField.getText();
		sequenceField.setText("");
		newnode(text);
		perform(MoveParser.parseSequence(text));
	}
	
	
	
	public void fork(String text) {
		
		DefaultMutableTreeNode path = stateRoot;
				
		try {
			path = (DefaultMutableTreeNode)stateTree.getSelectionPath().getLastPathComponent();
		}
		catch (Exception e) {}
		
		treeModel.insertNodeInto(new DefaultMutableTreeNode(new DescribedState(text, state.clone())), path, path.getChildCount());
	}
	
	public void newnode(String text) {
		DefaultMutableTreeNode path = stateRoot;
		
		try {
			final int len = stateTree.getSelectionPath().getPathCount();
			path = (DefaultMutableTreeNode)stateTree.getSelectionPath().getPathComponent(len-1);
		}
		catch (Exception e) {}
		
		treeModel.insertNodeInto(new DefaultMutableTreeNode(new DescribedState(text, state.clone())), path, path.getChildCount());
	}
	
	
	class DescribedState
	{
		public String desc;
		public CubeState state;
		
		public DescribedState(String desc, CubeState state) {
			this.desc = desc;
			this.state = state;
		}
		
		public String toString() {
			return desc;
		}
	}
	
//	public DescribedState getSelectedNode() {
//		try {
//			return (DescribedState)stateTree.getSelectionPath().getLastPathComponent();
//		}
//		catch (Exception e) {
//			return null;
//		}
//	}
	
	
	class MyTreeSelectionListener implements TreeSelectionListener {
		public void valueChanged(TreeSelectionEvent e) {
		    final DefaultMutableTreeNode node = (DefaultMutableTreeNode) stateTree.getLastSelectedPathComponent();

		    if (node == null)
		    	return;

		    final Object nodeInfo = node.getUserObject();
		    
		    try {
//		    if (node.isLeaf())
		        setState(e.getPath().getPathCount() == 1 ? new CubeState() : ((DescribedState)nodeInfo).state);
		    }
		    catch (Exception exc) {}
//		    else
//		        displayURL(helpURL); 
		}

	}
	
//	class MyTreeModelListener implements TreeModelListener {
//	    public void treeNodesChanged(TreeModelEvent e) {
//	        DefaultMutableTreeNode node;
//	        node = (DefaultMutableTreeNode)
//	                 (e.getTreePath().getLastPathComponent());
//
//	        /*
//	         * If the event lists children, then the changed
//	         * node is the child of the node we have already
//	         * gotten.  Otherwise, the changed node and the
//	         * specified node are the same.
//	         */
//	        try {
//	            int index = e.getChildIndices()[0];
//	            node = (DefaultMutableTreeNode) (node.getChildAt(index));
//	        } catch (NullPointerException exc) {}
//
//	        System.out.println("The user has finished editing the node.");
//	        System.out.println("New value: " + node.getUserObject());
//	    }
//	    public void treeNodesInserted(TreeModelEvent e) {
//	    }
//	    public void treeNodesRemoved(TreeModelEvent e) {
//	    }
//	    public void treeStructureChanged(TreeModelEvent e) {
//	    }
//	}
}
