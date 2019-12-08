import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ThreadBall extends Frame {
	private JPanel canvas;
	private BallThread b;

	public ThreadBall() {
		setSize(500,500);
		setTitle("Ball Demo");
		setLayout(new BorderLayout());
		canvas = new JPanel();
		canvas.setBackground(Color.black);
		add(canvas, BorderLayout.CENTER);

		JPanel p = new JPanel();
		addButton(p, "Start", new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(b == null){
					b = new BallThread(canvas);
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

class BallThread extends Thread {
	private JPanel b;
	private Dimension d;
	private int x;
	private int y = 0;
	private int dy = 5;
	private static final int SIZE = 50;
	boolean stop = false;
	

	public BallThread(JPanel b) {
		this.b = b;
	}

	public void move() {
		d = b.getSize();
		x = ((int)d.getWidth() / 2) - 30;
		if(!b.isVisible()) return;
		Graphics g = b.getGraphics();
		g.setXORMode(b.getBackground());
		g.setColor(Color.red);
		g.fillOval(x, y, SIZE, SIZE);
		y += dy;
		if(y + SIZE >= d.height)
			y = 0;
		g.fillOval(x, y, SIZE, SIZE);
	}

	public void draw() {
		d = b.getSize();
		x = ((int)d.getWidth() / 2) - 30;
		Graphics g = b.getGraphics();
		g.setColor(Color.red);
		g.fillOval(x, y, SIZE, SIZE);
	}

	public void run() {
		try {
			for(;;) {
				draw();
				move();
				Thread.sleep(10);
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

public class FrameBallDemo {
	public static void main(String[] args) {
		new ThreadBall();
	}
}