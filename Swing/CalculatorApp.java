import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CalculatorApp extends JFrame implements ActionListener {
	private JTextField result;
	private JTextField memory;
	private double firstNo;
	private double secondNo;
	private double mem;
	private int operator;

	JMenuBar mb;
	JMenu edit, help;
	JMenuItem cut, copy, helpTopics, about;

	private JButton addp;
	private JButton sub;
	private JButton mul;
	private JButton div;
	private JButton perc;
	private JButton eqls;
	private JButton sqrt;
	private JButton plmi;
	private JButton dot;
	private JButton cancel;
	private JButton clear;
	private JButton oneby;
	private JButton back;
	private JButton madd;
	private JButton msub;
	private JButton mclr;
	private JButton mret;
	private JButton mstr;

	private JButton one1;
	private JButton two2;
	private JButton three3;
	private JButton four4;
	private JButton five5;
	private JButton six6;
	private JButton seven7;
	private JButton eight8;
	private JButton nine9;
	private JButton zero0;

	private Object source;
	public CalculatorApp() {
		super("Java Calculator App");
		setBackground(Color.white);
		setLayout(new GridLayout(6, 1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(500,200);

		JPanel entry = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();

		entry.setLayout(new FlowLayout());
		result = new JTextField("0", 20);
		result.setFont(new Font("Serif", Font.BOLD, 20));
		result.setEnabled(false);
		result.setHorizontalAlignment(SwingConstants.RIGHT);
		entry.add(result);

		p1.setLayout(new FlowLayout());
		mclr = new JButton("MC");
		mclr.addActionListener(this);
		p1.add(mclr);
		memory = new JTextField(2);
		memory.setFont(new Font("Serif", Font.BOLD, 20));
		memory.setEnabled(false);
		memory.setHorizontalAlignment(SwingConstants.CENTER);
		p1.add(memory);
		back = new JButton("Backspace");
		back.addActionListener(this);
		p1.add(back);
		clear = new JButton("CE");
		clear.addActionListener(this);
		p1.add(clear);
		cancel = new JButton("C");
		cancel.addActionListener(this);
		p1.add(cancel);

		p2.setLayout(new FlowLayout());
		mret = new JButton("MR");
		mret.addActionListener(this);
		p2.add(mret);
		seven7 = new JButton("7");
		seven7.addActionListener(this);
		p2.add(seven7);
		eight8 = new JButton("8");
		eight8.addActionListener(this);
		p2.add(eight8);
		nine9 = new JButton("9");
		nine9.addActionListener(this);
		p2.add(nine9);
		div = new JButton("/");
		div.addActionListener(this);
		p2.add(div);
		sqrt = new JButton("sqrt");
		sqrt.addActionListener(this);
		p2.add(sqrt);

		p3.setLayout(new FlowLayout());
		mstr = new JButton("MS");
		mstr.addActionListener(this);
		p3.add(mstr);
		four4 = new JButton("4");
		four4.addActionListener(this);
		p3.add(four4);
		five5 = new JButton("5");
		five5.addActionListener(this);
		p3.add(five5);
		six6 = new JButton("6");
		six6.addActionListener(this);
		p3.add(six6);
		mul = new JButton("*");
		mul.addActionListener(this);
		p3.add(mul);
		perc = new JButton("%");
		perc.addActionListener(this);
		p3.add(perc);

		p4.setLayout(new FlowLayout());
		madd = new JButton("M+");
		madd.addActionListener(this);
		p4.add(madd);
		one1 = new JButton("1");
		one1.addActionListener(this);
		p4.add(one1);
		two2 = new JButton("2");
		two2.addActionListener(this);
		p4.add(two2);
		three3 = new JButton("3");
		three3.addActionListener(this);
		p4.add(three3);
		sub = new JButton("-");
		sub.addActionListener(this);
		p4.add(sub);
		oneby = new JButton("1/x");
		oneby.addActionListener(this);
		p4.add(oneby);

		p5.setLayout(new FlowLayout());
		msub = new JButton("M-");
		msub.addActionListener(this);
		p5.add(msub);
		zero0 = new JButton("0");
		zero0.addActionListener(this);
		p5.add(zero0);
		plmi = new JButton("+/-");
		plmi.addActionListener(this);
		p5.add(plmi);
		dot = new JButton(".");
		dot.addActionListener(this);
		p5.add(dot);
		addp = new JButton("+");
		addp.addActionListener(this);
		p5.add(addp);
		eqls = new JButton("=");
		eqls.addActionListener(this);
		p5.add(eqls);

		add(entry);
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);

		pack();
		setVisible(true);
	}

	public void showResult() {
		if(source == addp) {
			firstNo = Double.parseDouble(result.getText());
			result.setText("0");
			operator = 1;
		} else if(source == sub) {
			firstNo = Double.parseDouble(result.getText());
			result.setText("0");
			operator = 2;
		} else if(source == mul) {
			firstNo = Double.parseDouble(result.getText());
			result.setText("0");
			operator = 3;
		} else if(source == div) {
			firstNo = Double.parseDouble(result.getText());
			result.setText("0");
			operator = 4;
		} else if(source == perc) {
			firstNo = Double.parseDouble(result.getText());
			result.setText("0");
			operator = 5;
		} else if(source == eqls) {
			secondNo = Double.parseDouble(result.getText());
			switch(operator) {
				case 1:	result.setText(Double.toString(firstNo + secondNo));
					firstNo = 0.0;
					secondNo = 0.0;
					break;

				case 2:	result.setText(Double.toString(firstNo - secondNo));
					firstNo = 0.0;
					secondNo = 0.0;
					break;

				case 3:	result.setText(Double.toString(firstNo * secondNo));
					firstNo = 0.0;
					secondNo = 0.0;
					break;

				case 4:	if(secondNo != 0.0) {
						result.setText(Double.toString(firstNo / secondNo));
						firstNo = 0.0;
						secondNo = 0.0;
					} else {
						result.setText("0");
					}
					break;
					case 5:	result.setText(Double.toString(firstNo % secondNo));
					firstNo = 0.0;
					secondNo = 0.0;
					break;
			}
		} else if(source == oneby) {
			if(!result.getText().equals("0")) {
				result.setText(Double.toString(1 / Double.parseDouble(result.getText())));
			}
		} else if(source == madd) {
			if(result.getText().equals("0") || result.getText().equals("0.0")) {
				result.setText("0");
			} else {
				mem += Double.parseDouble(result.getText());
				result.setText("0");
				memory.setText("M");					
			}
		} else if(source == msub) {
			if(result.getText().equals("0") || result.getText().equals("0.0")) {
				result.setText("0");
			} else {
				mem -= Double.parseDouble(result.getText());
				result.setText("0");
				memory.setText("M");					
			}
		} else if(source == mstr) {
			mem = Double.parseDouble(result.getText());
			memory.setText("M");
			result.setText("0");
		} else if(source == mret) {
			result.setText(Double.toString(mem));
		} else if(source == mclr) {
			mem = 0.0;
			memory.setText("");
			result.setText("0");
		} else if(source == back) {
			if (!(result.getText().equals("0") || result.getText().equals("0.0")) && result.getText().length() > 1) {
				if(result.getText().length() == 2 && result.getText().charAt(0) == '-') {
					result.setText("0");
				} else {
					result.setText(result.getText().substring(0, result.getText().length()-1));
				}
			} else {
				result.setText("0");
			}
		} else if(source == clear) {
			result.setText("0");
		} else if(source == cancel) {
			result.setText("0");
			firstNo = 0.0;
			secondNo = 0.0;
		} else if(source == dot) {
			if (result.getText().equals("0")) {
				result.setText("0.");
			} else if (result.getText().indexOf('.') == -1) {
				result.setText(result.getText() + ".");
			}
		} else if(source == sqrt) {
			if(Double.parseDouble(result.getText()) > 0.0) {
				result.setText(Double.toString(Math.sqrt(Double.parseDouble(result.getText()))));
			}
		} else if(source == plmi) {
			if(!result.getText().equals("0") && !result.getText().equals("0.0")) {
				if(Double.parseDouble(result.getText()) < 0.0) {
					result.setText(result.getText().substring(1, result.getText().length()));
				} else {
					result.setText("-" + result.getText());
				}
			}
		} else if(source == zero0) {
			if(!result.getText().equals("0")) {
				result.setText(result.getText() + "0");
			}
		} else if(source == one1) {
			if(!result.getText().equals("0")) {
				result.setText(result.getText() + "1");
			} else {
				result.setText("1");
			}
		} else if(source == two2) {
			if(!result.getText().equals("0")) {
				result.setText(result.getText() + "2");
			} else {
				result.setText("2");
			}
		} else if(source == three3) {
			if(!result.getText().equals("0")) {
				result.setText(result.getText() + "3");
			} else {
				result.setText("3");
			}
		} else if(source == four4) {
			if(!result.getText().equals("0")) {
				result.setText(result.getText() + "4");
			} else {
				result.setText("4");
			}
		} else if(source == five5) {
			if(!result.getText().equals("0")) {
				result.setText(result.getText() + "5");
			} else {
				result.setText("5");
			}
		} else if(source == six6) {
			if(!result.getText().equals("0")) {
				result.setText(result.getText() + "6");
			} else {
				result.setText("6");
			}
		} else if(source == seven7) {
			if(!result.getText().equals("0")) {
				result.setText(result.getText() + "7");
			} else {
				result.setText("7");
			}
		} else if(source == eight8) {
			if(!result.getText().equals("0")) {
				result.setText(result.getText() + "8");
			} else {
				result.setText("8");
			}
		} else if(source == nine9) {
			if(!result.getText().equals("0")) {
				result.setText(result.getText() + "9");
			} else {
				result.setText("9");
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		source = e.getSource();
		showResult();
	}

	public static void main(String[] args) {
		new CalculatorApp();
	}
}