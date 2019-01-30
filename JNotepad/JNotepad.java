import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JNotepad extends JFrame implements ActionListener {

	private JPanel contentPane;
	JTextArea text  = new JTextArea(); // TODO work on tabbed interface with new text areas per-tab


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
		super("JMenu Test");

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
				JMenuItem open = new JMenuItem("Open...");
				JMenuItem save = new JMenuItem("Save");
				JMenuItem saveas = new JMenuItem("Save As...");
				JMenuItem exit = new JMenuItem("Exit");
			// Event handler reg
				JMenuItem[] items = {open, save, saveas, exit};
				for (JMenuItem item : items) {
				item.addActionListener(this);
				}
			// add all
					filemenu.add(open); filemenu.add(save); filemenu.add(saveas); filemenu.add(exit);
			JMenu editmenu = new JMenu("Edit");
			mmb.add(filemenu);
			add(text);
			setJMenuBar(mmb);
			
			///
			ArrayList<File> MFL = new ArrayList<File>();
			///
		}
		
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().contentEquals("Open...")){ // use FilePicker
			// Open file
			int returnVal = Chooser.showOpenDialog(JNotepad.this);

		    if (returnVal == JFileChooser.APPROVE_OPTION) {
		        File file = Chooser.getSelectedFile();
		        open(text,file);
		    } else {
		    	return; // do nothing unless a file is opened properly
		    }
		} else if(e.getActionCommand().contentEquals("Save")) {
			
		}else if (e.getActionCommand().contentEquals("Save As...")) {
			
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

	}


