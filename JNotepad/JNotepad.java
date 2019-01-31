import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicButtonUI;

public class JNotepad extends JFrame implements ActionListener {

	private JPanel contentPane;
	JTextArea text  = new JTextArea();
	private JTabbedPane TabContent = new JTabbedPane();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JNotepad frame = new JNotepad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JNotepad() {
		super("NotePad-- Pre-Alpha");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		init();
		
	}
		
		private void init() {
			JMenuBar mmb = new JMenuBar();
			JMenu filemenu = new JMenu("File");
				JMenuItem newtab = new JMenuItem("New File");
				JMenuItem open = new JMenuItem("Open...");
				JMenuItem save = new JMenuItem("Save");
				JMenuItem saveas = new JMenuItem("Save As...");
				JMenuItem exit = new JMenuItem("Exit");
			// Event handler reg
				JMenuItem[] items = {newtab,open, save, saveas, exit};
				for (JMenuItem item : items) {
				item.addActionListener(this);
				}
			// add all
					filemenu.add(newtab); filemenu.add(open); filemenu.add(save); filemenu.add(saveas); filemenu.add(exit);
			JMenu editmenu = new JMenu("Edit");
			mmb.add(filemenu);
			add(TabContent);
			TabContent.addTab("(New 1)",null, text); // default blank file
			setJMenuBar(mmb);
			
			///
			ArrayList<File> MFL = new ArrayList<File>();
			///
		}
	    protected JComponent makeTextPanel(String text) {
	        JPanel panel = new JPanel(false);
	        JLabel filler = new JLabel(text);
	        filler.setHorizontalAlignment(JLabel.CENTER);
	        panel.setLayout(new GridLayout(1, 1));
	        panel.add(filler);
	        return panel;
	    }
		
	public void actionPerformed(ActionEvent e) {
		String debugstring = e.getActionCommand();
		if (e.getActionCommand().contentEquals("New File")) {
			// make new file
			JTextArea jta = new JTextArea();
		 TabContent.addTab("New "+(TabContent.getTabCount()+1)+"",null,jta);

		} else if(e.getActionCommand().contentEquals("Open...")){ // use FilePicker
			// Open file
			int returnVal = Chooser.showOpenDialog(JNotepad.this);

		    if (returnVal == JFileChooser.APPROVE_OPTION) {
		        File file = Chooser.getSelectedFile();
		        open(((JTextArea)TabContent.getComponentAt(TabContent.getSelectedIndex())),file);
		        TabContent.setTitleAt(TabContent.getSelectedIndex(), Chooser.getSelectedFile().toString());
		    } else {
		    	return; // do nothing unless a file is opened properly
		    }
		    
		} else if(e.getActionCommand().contentEquals("Save")) {
			// if file not found, go to save as
			
			
			
		}else if (e.getActionCommand().contentEquals("Save As...")) {
			// saveAs();
			int ret = Chooser.showSaveDialog(JNotepad.this);
			
			if (ret == JFileChooser.APPROVE_OPTION) {
				File file = Chooser.getSelectedFile();
				save(text,file);
			}
		}else if (e.getActionCommand().contentEquals("Exit")) {
			System.exit(0);
		}
	}
	//////////////////////////////////////////////////////////
	final JFileChooser Chooser = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter ( "Text Files Only", "txt");
	//Chooser.setFileFilter(filter);
	/*int */
	///////////////////////////////////////////////////// 
	private void open(JTextArea text, File file){ // input: the file from the dialog, and the textarea we're working with. Because we have a tabbed interface, we need to specify.
		BufferedReader br = null;
		try {
		br = new BufferedReader(new FileReader(file));
		String line;
		while(( line = br.readLine()) != null ) {
			text.append(line + "\n");
		}	
		br.close();
		}catch (FileNotFoundException e) { // FNFE must come FIRST, before IOE
			e.printStackTrace();
		} catch (IOException e) { // As above.
			e.printStackTrace();
		}
	}
	
	private boolean save(JTextArea text, File file) {
		// TODO
		
		
		/*try {
		}catch (FileNotFoundException e) { // FNFE must come FIRST, before IOE
			e.printStackTrace();
		} catch (IOException e) { // As above.
			e.printStackTrace();
		}*/
		
		return false;
	}
	}
    
	

