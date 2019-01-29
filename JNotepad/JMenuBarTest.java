import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class JMenuBarTest extends JFrame implements ActionListener {

	private JPanel contentPane;
	JTextArea text  = new JTextArea();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMenuBarTest frame = new JMenuBarTest();
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
	public JMenuBarTest() {
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
			
		}
		
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().contentEquals("Open...")){
			// Open file
			
		} else if(e.getActionCommand().contentEquals("Save")) {
			
		}else if (e.getActionCommand().contentEquals("Save As...")) {
			
		}else if (e.getActionCommand().contentEquals("Exit")) {
			System.exit(0);
		}
	}
	
	private void open() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("test.txt"));
			String line;
			while(( line = br.readLine()) != null ) {
				text.append(line + "\n");
			}
			
			br.close();
		}catch (FileNotFoundException e) { // FNFE must come FIRST, before IOE
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	}


