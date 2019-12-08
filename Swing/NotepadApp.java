import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.awt.print.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.undo.*;

public class NotepadApp extends JFrame implements ActionListener, ItemListener, MenuListener, DocumentListener{
	private FileOutputStream fos;
	private BufferedInputStream bis;
	private JMenuBar mb;
	private JMenu file, edit, format, view, help;
	private JMenuItem newFile, openFile, saveFile, saveAs, pageSetup, print, exit, undo, redo, cut, copy, paste, delete, find, findNext, replace, go_to, selAll, timeDate, font, helpTopics, about;
	private JCheckBoxMenuItem wordWrap, statusBar;
	private JTextArea ta;
	private JScrollPane scrlpane;
	private JFileChooser dialog;
	private UndoManager manager;
	private FontSelector f;
	private Find finder;
	private String fileName, str, content;
	private Object source;
	private boolean askToSave, openForTheFirstTime;

	public NotepadApp() {
		setTitle("Untitled - Java Notepad");
		setLayout(new BorderLayout());

		dialog = new JFileChooser();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				saveBeforeExit();
			}
		});

		manager = new UndoManager();

		askToSave = false;
		openForTheFirstTime = true;
		finder = new Find(this);

		mb = new JMenuBar();
		setJMenuBar(mb);

		file = new JMenu("File"); file.setMnemonic('F');
		edit = new JMenu("Edit"); edit.setMnemonic('E');
		format = new JMenu("Format"); format.setMnemonic('o');
		view = new JMenu("View"); view.setMnemonic('V');
		help = new JMenu("Help"); help.setMnemonic('H');

		mb.add(file);
		mb.add(edit);
		mb.add(format);
		mb.add(view);
		mb.add(help);

		newFile = new JMenuItem("New"); newFile.setMnemonic('N');
		openFile = new JMenuItem("Open"); openFile.setMnemonic('O');
		saveFile = new JMenuItem("Save"); saveFile.setMnemonic('S');
		saveAs = new JMenuItem("Save As..."); saveAs.setMnemonic(KeyEvent.VK_A);
		try {
			saveAs.setDisplayedMnemonicIndex(5);
		} catch(Exception e) {
			e.printStackTrace();
		}
		pageSetup = new JMenuItem("Page Setup..."); pageSetup.setMnemonic('u');
		print = new JMenuItem("Print"); print.setMnemonic('P');
		exit = new JMenuItem("Exit"); exit.setMnemonic('x');

		openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK, true));
		saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK, true));
		newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK, true));
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK, true));

		newFile.addActionListener(this);
		openFile.addActionListener(this);
		saveFile.addActionListener(this);
		saveAs.addActionListener(this);
		pageSetup.addActionListener(this);
		print.addActionListener(this);
		exit.addActionListener(this);		

		undo = new JMenuItem("Undo");
		undo.setMnemonic('U');
		redo = new JMenuItem("Redo");
		redo.setMnemonic('R');
		cut = new JMenuItem("Cut");
		cut.setMnemonic('t');
		copy = new JMenuItem("Copy");
		copy.setMnemonic('C');
		paste = new JMenuItem("Paste");
		paste.setMnemonic('P');
		delete = new JMenuItem("Delete");
		delete.setMnemonic('l');
		find = new JMenuItem("Find...");
		find.setMnemonic('F');
		findNext = new JMenuItem("Find Next");
		findNext.setMnemonic('N');
		replace = new JMenuItem("Replace...");
		replace.setMnemonic('e');
		go_to = new JMenuItem("Go To...");
		go_to.setMnemonic('G');
		selAll = new JMenuItem("Select All");
		selAll.setMnemonic('A');
		timeDate = new JMenuItem("Time/Date");
		timeDate.setMnemonic('D');

		undo.addActionListener(this);
		redo.addActionListener(this);
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		delete.addActionListener(this);
		find.addActionListener(this);
		findNext.addActionListener(this);
		replace.addActionListener(this);
		go_to.addActionListener(this);
		selAll.addActionListener(this);
		timeDate.addActionListener(this);

		undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK, true));
		redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK, true));
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK, true));
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK, true));
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK, true));
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0, true));
		find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK, true));
		findNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0, true));
		replace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK, true));
		go_to.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK, true));
		selAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK, true));
		timeDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0, true));

		wordWrap = new JCheckBoxMenuItem("Word Wrap");
		wordWrap.setMnemonic('W');
		font = new JMenuItem("Font...");
		font.setMnemonic('F');

		wordWrap.addItemListener(this);
		font.addActionListener(this);

		statusBar = new JCheckBoxMenuItem("Status Bar");
		statusBar.setMnemonic('S');

		statusBar.addItemListener(this);

		helpTopics = new JMenuItem("Help Topics");
		helpTopics.setMnemonic('H');
		about = new JMenuItem("About Java Notepad");
		about.setMnemonic('A');

		helpTopics.addActionListener(this);
		about.addActionListener(this);

		file.add(newFile);
		file.add(openFile);
		file.add(saveFile);
		file.add(saveAs);
		file.addSeparator();
		file.add(pageSetup);
		file.add(print);
		file.addSeparator();
		file.add(exit);

		edit.add(undo);
		edit.add(redo);
		edit.addSeparator();
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(delete);
		edit.addSeparator();
		edit.add(find);
		edit.add(findNext);
		edit.add(replace);
		edit.add(go_to);
		edit.addSeparator();
		edit.add(selAll);
		edit.add(timeDate);
		edit.addMenuListener(this);

		format.add(wordWrap);
		format.add(font);

		view.add(statusBar);

		help.add(helpTopics);
		help.addSeparator();
		help.add(about);

		ta = new JTextArea();
		add(ta, BorderLayout.CENTER);
		ta.getDocument().addDocumentListener(this);
		ta.getDocument().addUndoableEditListener(manager);

		scrlpane = new JScrollPane(ta);	//ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED by default;
		add(scrlpane);

		setSize(600, 600);
		setVisible(true);
	}

	public void menuSelected(MenuEvent ml) {
		if(ml.getSource()==edit) {
			if(openForTheFirstTime) {
				cut.setEnabled(false);
				copy.setEnabled(false);
				delete.setEnabled(false);
				undo.setEnabled(false);
				redo.setEnabled(false);
				find.setEnabled(false);
				findNext.setEnabled(false);
				replace.setEnabled(false);
			} else if((ta.getSelectedText()) == null || (ta.getText() == null)) {
				cut.setEnabled(false);
				copy.setEnabled(false);
				delete.setEnabled(false);
			} else {
				cut.setEnabled(true);
				copy.setEnabled(true);
				delete.setEnabled(true);
			}
		}
	}

	public void menuDeselected(MenuEvent ml) {}

	public void menuCanceled(MenuEvent ml) {}

	public void insertUpdate(DocumentEvent e) {
		if(openForTheFirstTime) {
			openForTheFirstTime = false;
			askToSave = true;
		}
		undo.setEnabled(true);
		redo.setEnabled(true);
		find.setEnabled(true);
		findNext.setEnabled(true);
		replace.setEnabled(true);
	}

	public void removeUpdate(DocumentEvent e) {
		askToSave = true;
		if(ta.getText() == null) {
			find.setEnabled(false);
			findNext.setEnabled(false);
			replace.setEnabled(false);
		}
	}

	public void changedUpdate(DocumentEvent e) {}

	public int isModified()
	{
		int y = 0;
		int x=JOptionPane.showConfirmDialog(this, "The text in the "+getTitle().substring(0, getTitle().indexOf("-") - 1)+" has changed\nDo you want to save the changes?", "Java Notepad", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if(x==JOptionPane.YES_OPTION) y = 1;
		else if(x==JOptionPane.NO_OPTION) y = 2;
		return y;
	}

	public void saveFileName(int saveFlag) {
		File f;
		try {
			if(saveFlag==0)
			{
				int x=dialog.showSaveDialog(this);
				if(x==0){
					f=dialog.getSelectedFile();
					if(f == null) {
						JOptionPane.showMessageDialog(this, "Enter a File Name!", "Save Error", JOptionPane.ERROR_MESSAGE);
					} else {
						fos = new FileOutputStream(f);
						setTitle(f.getName()+" - Java Notepad");
						PrintStream ps = new PrintStream(fos, true);
						ps.print(ta.getText());
						askToSave = false;
						content = "";

						ps.close();
						fos.close();
					}
				}
			}
			else if(ta.getText() != content)
			{
				f = new File(getTitle().substring(0, getTitle().indexOf("-") - 1));
				fos = new FileOutputStream(f);
				setTitle(f.getName()+" - Java Notepad");
				PrintStream ps = new PrintStream(fos, true);
				ps.print(ta.getText());
				askToSave = false;
				content = "";

				ps.close();
				fos.close();
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, e, "Save Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void openFileName() {
		int x=dialog.showOpenDialog(this);
		if(x==0){
			try {
				File f=dialog.getSelectedFile();
				if(f == null) {
					JOptionPane.showMessageDialog(this, "Select a File!!", "Open Error", JOptionPane.ERROR_MESSAGE);
				} else {
					bis=new BufferedInputStream(new FileInputStream(f));
					setTitle(f.getName()+" - Java Notepad");
					ta.setText("");
					BufferedReader br=new BufferedReader(new InputStreamReader(bis));
					while((str=br.readLine())!=null) ta.append(str+"\n");
					ta.replaceRange("", ta.getText().length()-1, ta.getText().length());
					askToSave = false;
					openForTheFirstTime = true;
					ta.setCaretPosition(0);
					content = ta.getText();

					br.close();
					bis.close();
				}
			} catch(Exception e) {
				JOptionPane.showMessageDialog(this, e, "Open Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void saveBeforeExit()
	{
		ta.selectAll();
		if(ta.getSelectedText() != null && askToSave) {
			int x = isModified();
			if(x == 1) {
				int result = dialog.showSaveDialog(this);
				if(result == JFileChooser.APPROVE_OPTION) {
					fileName = dialog.getSelectedFile().getPath();
					if(getTitle().equals("Untitled - Java Notepad")) saveFileName(0);
					else saveFileName(1);
				} else {
					return;
				}
			} else if(x == 2) {
				System.exit(0);
			}
		} else if(askToSave) {
			int x = isModified();
			if(x == 1) {
				int result = dialog.showSaveDialog(this);
				if(result == JFileChooser.APPROVE_OPTION) {
					fileName = dialog.getSelectedFile().getPath();
					if(getTitle().equals("Untitled - Java Notepad")) saveFileName(0);
					else saveFileName(1);
				} else {
					return;
				}
			} else if(x == 2) {
				System.exit(0);
			}
		} else System.exit(0);
	}

	public void saveAsFileName() {
		int r = dialog.showSaveDialog(this);
		if(r==dialog.CANCEL_OPTION) return;
		File myfile = dialog.getSelectedFile();
		if(myfile==null || myfile.getName().equals("")) {
			JOptionPane.showMessageDialog(this,"Please enter a file name!","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
 
		if(myfile.exists()) {
			r = JOptionPane.showConfirmDialog(this, "A file with same name already exists!\nAre you sure want to overwrite?");
			if(r != 0) return;
		}
		try {
			FileWriter fw = new FileWriter(myfile);
			fw.write(ta.getText());
			content = ta.getText();
			setTitle(myfile.getName()+" - Java Notepad");
			fw.close();
		} catch(IOException e) {
			JOptionPane.showMessageDialog(this,"Failed to save the file","Error",JOptionPane.ERROR_MESSAGE);
		}
	}


	public void actionPerformed(ActionEvent ae) {
		source = ae.getSource();

		if(source == newFile) {
			int x;
			if(askToSave) {
				x = isModified();
				if(x == 1) {
					if(getTitle().equals("Untitled - Java Notepad")) saveFileName(0);
					else saveFileName(1);
				} else if(x == 2) {
					ta.setText("");
					setTitle("Untitled - Java Notepad");
					askToSave = false;
				}
			} else {
				ta.setText("");
				setTitle("Untitled - Java Notepad");
				askToSave = false;
			}
		} else if(source == openFile) {
			int x;
			if(askToSave)
			{
				x = isModified();
				if(x == 1) {
					if(getTitle().equals("Untitled - Java Notepad")) saveFileName(0);
					else saveFileName(1);
					openFileName();
				} else if(x == 2) {
					openFileName();
				}
			} else openFileName();
		} else if(source == saveFile) {
			if(getTitle().equals("Untitled - Java Notepad")) saveFileName(0);
			else saveFileName(1);
		} else if(source == saveAs) {
			saveAsFileName();
		} else if(source == pageSetup) {
			try {
				ta.print();				
			} catch(Exception e) {
				JOptionPane.showMessageDialog(this, e, "Page Setup Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if(source == print) {
			try {
				ta.print();
			} catch(Exception e) {
				JOptionPane.showMessageDialog(this, e, "Print Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if(source == exit) {
			saveBeforeExit();
		} else if(source == undo) {
			try {
				manager.undo();
			} catch(Exception e) {
				JOptionPane.showMessageDialog(this, e, "Undo Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if(source == redo) {
			try {
				manager.redo();
			} catch(Exception e) {
				JOptionPane.showMessageDialog(this, e, "Redo Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if(source == cut) {
			ta.cut();
		} else if(source == copy) {
			ta.copy();
		} else if(source == paste) {
			ta.paste();
		} else if(source == delete) {
			ta.replaceSelection("");
		} else if(source == find) {
			finder.setVisible(true);
		} else if(source == findNext) {
			finder.find_next();
		} else if(source == replace) {
			finder.setVisible(true);
		} else if(source == go_to) {
		
		} else if(source == selAll) {
			ta.selectAll();
		} else if(source == timeDate) {
			 try {
				Thread.sleep(1000);
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a dd/mm/yyyy");
				ta.insert(sdf.format(cal.getTime()), ta.getCaretPosition());
			} catch(Exception e) {
				JOptionPane.showMessageDialog(this, e, "Time Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if(source == font) {
			if(f == null) {
				f = new FontSelector();
				ta.setFont(f.selectedFont);
			} else {
				Font fnt = ta.getFont();
				String fontName = fnt.getName();
				int fontStyle = fnt.getStyle();
				int fontSize = fnt.getSize();
				for(int i = 0; i < f.availableFontString.length; i++) {
					if(f.availableFontString[i].toString().equals(fontName)) {
						f.fontList.setSelectedIndex(i);
						break;
					}
				}
				f.styleList.setSelectedIndex(fontStyle);
				for(int j = 0; j < f.fontSizeString.length; j++) {
					if(Integer.parseInt(f.fontSizeString[j]) == fontSize) {
						f.sizeList.setSelectedIndex(j);
						break;
					}
				}
				f.setVisible(true);
				ta.setFont(f.selectedFont);
			}
		} else if(source == helpTopics) {
			JOptionPane.showMessageDialog(null, "Same options as in Notepad but with extra functionality of undo(Ctrl + Z) and redo(Ctrl + Y) options\n\nKnown Bug: When user closes the window and even text has been modified, closing the dialog box makes frame invisible.", "Help Topics", JOptionPane.INFORMATION_MESSAGE);
		} else if(source == about) {
			JOptionPane.showMessageDialog(null, "This is a simple Notepad Application built using Java.\n\nCreated by: Ashish Agarwal\nStudent ID: S131109400534\nBatch: B130190\nemail - address: ashish2350@gmail.com", "About Java Notepad", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void itemStateChanged(ItemEvent ie) {
		if((wordWrap.getState()) == true) {
			ta.setWrapStyleWord(true);
			ta.setLineWrap(true);
			statusBar.setEnabled(false);
		} else if((wordWrap.getState()) == false) {
			ta.setWrapStyleWord(false);
			ta.setLineWrap(false);
			statusBar.setEnabled(true);
		} else if((statusBar.getState()) == true) {
		
		}
	}

	class Find extends JFrame implements ActionListener {
		int startIndex=0;
		Label l1, l2;
		TextField tf, tr;
		JButton find_btn, find_next, replace, replace_all, cancel;

		NotepadApp samp;

		public Find(NotepadApp mynote) {
			super("Find / Replace");
			samp = mynote;

			l1 = new Label("Find What: ");
			l2 = new Label("Replace With: ");
			tf = new TextField(30);
			tr = new TextField(30);
			find_btn = new JButton("Find");
			find_next = new JButton("Find Next");
			replace = new JButton("Replace");
			replace_all = new JButton("Replace All");
			cancel = new JButton("Cancel");

			setLayout(null);
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			int label_w = 80;
			int label_h = 20;
			int tf_w    = 120;

			l1.setBounds(10,10, label_w, label_h);
			add(l1);
			tf.setBounds(10+label_w, 10, tf_w, 20);
			add(tf);
			l2.setBounds(10, 10+label_h+10, label_w, label_h);
			add(l2);
			tr.setBounds(10+label_w, 10+label_h+10, tf_w, 20);
			add(tr);

			find_btn.setBounds(220, 10, 100, 20);
			add(find_btn);
			find_btn.addActionListener(this);
			find_next.setBounds(220, 30, 100, 20);
			add(find_next);
			find_next.addActionListener(this);
			replace.setBounds(220, 50, 100, 20);
			add(replace);
			replace.addActionListener(this);
			replace_all.setBounds(220, 70, 100, 20);
			add(replace_all);
			replace_all.addActionListener(this);
			cancel.setBounds(220, 90, 100, 20);
			add(cancel);
			cancel.addActionListener(this);

			int w = 340;
			int h = 150;
 
			setSize(w,h);
			// set window position
			Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
			setLocation(center.x-w/2, center.y-h/2);
			setVisible(false);
		}

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==find_btn) {
				find();
			} else if(e.getSource() == find_next) {
				find_next();
			} else if(e.getSource() == replace) {
				replace();
			} else if(e.getSource() == replace_all) {
				replace_all();
			} else if(e.getSource() == cancel) {
				this.setVisible(false);
			}
		}

		public void find() {
			int select_start = samp.ta.getText().indexOf(tf.getText());
			if(select_start == -1) {
				startIndex = 0;
				JOptionPane.showMessageDialog(null, "Could not find "+tf.getText()+"!");
				return;
			}
			if(select_start == samp.ta.getText().lastIndexOf(tf.getText())) {
				startIndex = 0;
			}
			int select_end = select_start+tf.getText().length();
			samp.ta.select(select_start, select_end);
		}
 
		public void find_next() {
			String selection = samp.ta.getSelectedText();
			try {
				selection.equals("");
			} catch(NullPointerException e) {
				selection = tf.getText();
				try {
					selection.equals("");
				} catch(NullPointerException e2) {
					selection = JOptionPane.showInputDialog("Find:");
					tf.setText(selection);
				}
			}

			try {
				int select_start = samp.ta.getText().indexOf(selection, startIndex);
				int select_end = select_start+selection.length();
				samp.ta.select(select_start, select_end);
				startIndex = select_end+1;

				if(select_start == samp.ta.getText().lastIndexOf(selection)) {
					startIndex = 0;
				}
			} catch(NullPointerException e) {}
		}

		public void replace() {
			try {
				find();
				samp.ta.replaceSelection(tr.getText());
			} catch(NullPointerException e) {
				System.out.print("Null Pointer Exception: "+e);
			}
		}

		public void replace_all() {
			samp.ta.setText(samp.ta.getText().replaceAll(tf.getText(), tr.getText()));
		}
	}

	class FontSelector extends JFrame implements ActionListener {
		String[] availableFontString = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		JList fontList = new JList(availableFontString);
		//fontList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		JLabel fontLabel = new JLabel("Font: ");
		JTextField valueFont = new JTextField("Dialog");
		JScrollPane fontPane = new JScrollPane(fontList); 
		String[] fontStyleString = {"Regular", "Bold", "Italic", "Bold Italic"};
		JList styleList = new JList(fontStyleString);
		//styleList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		JLabel styleLabel = new JLabel("Style: ");
		JScrollPane stylePane=new JScrollPane(styleList);
		JTextField valueStyle = new JTextField("Regular");
		String[] fontSizeString = {"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72"};
		JList sizeList = new JList(fontSizeString);
		//sizeList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		JLabel sizeLabel = new JLabel("Font size");
		JScrollPane sizePane = new JScrollPane(sizeList);
		JTextField valueSize = new JTextField("12");
		JButton okButton = new JButton("Ok");
		JButton cancelButton = new JButton("Cancel");
		JLabel sampleLabel = new JLabel("Sample: ");
		JTextField sample = new JTextField("AaBbCc");
		Font selectedFont; 
		public FontSelector() {
			setSize(500, 400);
			setTitle("Font");
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setVisible(true);
			sample.setEditable(false);
			setLayout(null);
			fontLabel.setBounds(10, 10, 170, 20);
			valueFont.setBounds(10, 35, 170, 20);
			fontPane.setBounds(10, 60, 170, 150);
			styleLabel.setBounds(200, 10, 100, 20);
			valueStyle.setBounds(200, 35, 100, 20);
			stylePane.setBounds(200, 60, 100, 150);
			sizeLabel.setBounds(320, 10, 50, 20);
			valueSize.setBounds(320, 35, 50, 20);
			sizePane.setBounds(320, 60, 50, 150);

			valueFont.setEnabled(false);
			valueStyle.setEnabled(false);
			valueSize.setEnabled(false);

			okButton.setBounds(400, 35, 80, 20);
			cancelButton.setBounds(400, 60, 80, 20);

			sampleLabel.setBounds(150, 220, 100, 30);
			sample.setBounds(150, 250, 150, 50);
			sample.setHorizontalAlignment(SwingConstants.CENTER);

			add(fontLabel);
			add(fontPane);
			add(valueFont);

			add(styleLabel);
			add(stylePane);
			add(valueStyle);

			add(sizeLabel);
			add(sizePane);
			add(valueSize);

			add(okButton);
			add(cancelButton);
			add(sampleLabel);
			add(sample); 
			okButton.addActionListener(this);
			cancelButton.addActionListener(this);

			fontList.setSelectedIndex(49);
			styleList.setSelectedIndex(0);
			sizeList.setSelectedIndex(4);

			fontList.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent event) {
					if(!event.getValueIsAdjusting()) {
						valueFont.setText(fontList.getSelectedValue().toString());
						selectedFont= new Font(valueFont.getText(), styleList.getSelectedIndex(), Integer.parseInt(valueSize.getText()));
						sample.setFont(selectedFont);
					}
				}
			});

			styleList.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent event) {
					if(!event.getValueIsAdjusting()) {
						valueStyle.setText(styleList.getSelectedValue().toString());
						selectedFont= new Font(valueFont.getText(), styleList.getSelectedIndex(), Integer.parseInt(valueSize.getText()));
						sample.setFont(selectedFont);
					}
				}
			});

			sizeList.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent event) {
					if(!event.getValueIsAdjusting()) {
						valueSize.setText(sizeList.getSelectedValue().toString());
						selectedFont= new Font (valueFont.getText(), styleList.getSelectedIndex(), Integer.parseInt(valueSize.getText()));
						sample.setFont(selectedFont);
					}
				}
			});
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==okButton) {
				selectedFont= new Font(valueFont.getText(), styleList.getSelectedIndex(), Integer.parseInt(valueSize.getText()));
				ta.setFont(selectedFont);
				setVisible(false);
			} else {
				setVisible(false);
			}
		}
	}

	public static void main(String[] args) {
		new NotepadApp();
	}
}