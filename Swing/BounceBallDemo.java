import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BounceBall extends Frame {
	private JPanel canvas;
	private Ball b;
	public BounceBall() {
		setSize(500,500);
		setTitle("Ball Demo");
		setLayout(new BorderLayout());
		canvas = new JPanel();
		canvas.setBackground(new Color(135,206,250));	// skyblue color
		add(canvas, BorderLayout.CENTER);

		JPanel p = new JPanel();
		addButton(p, "Start", new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(b == null){
					b = new Ball(canvas);
					b.start();
				} else {
					b.resume();
				}
			}
		});

		addButton(p, "Stop", new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				b.stop = true;
			}
		});

		addButton(p, "Close", new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		add(p, BorderLayout.SOUTH);

		setVisible(true);
	}

	public void addButton(Container c, String title, ActionListener a) {
		JButton b = new JButton(title);
		c.add(b);
		b.addActionListener(a);
	}
}

class Ball extends Thread {
	private JPanel b;
	private Dimension d;
	private int x;
	private int y;
	private int dx = 5;
	private int dy = 5;
	private static final int SIZE = 50;
	boolean stop = false;
	

	public Ball(JPanel b) {
		this.b = b;
	}

	public void move() {
		d = b.getSize();
		if(!b.isVisible()) return;
		Graphics g = b.getGraphics();
		g.setXORMode(b.getBackground());
		g.setColor(Color.red);
		g.fillOval(x, y, SIZE, SIZE);
		x += dx;
		y += dy;
		if((x <= 0) || (x + SIZE >= d.width)) {
			dx = -dx;
		}
		if((y <= 0) || (y + SIZE >= d.height)) {
			dy = -dy;
		}
		g.fillOval(x, y, SIZE, SIZE);
	}

	public void draw() {
		d = b.getSize();
		Graphics g = b.getGraphics();
		g.setColor(Color.red);
		g.fillOval(x, y, SIZE, SIZE);
	}

	public void run() {
		try {
			for(;;) {
				draw();
				move();
				Thread.sleep(30);
				if(stop) {
					suspend();
					stop = false;
				}
			}
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
}

public class BounceBallDemo {
	public static void main(String[] args) {
		new BounceBall();
	}
}