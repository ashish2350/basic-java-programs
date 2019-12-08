import java.awt.*;
import java.awt.event.*;

public class Hut extends Frame {

	public Hut() {
		super("Hut");
		setBackground(new Color(135,206,250));	// skyblue color
		setSize(1000,1000);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
	}

	public void paint(Graphics g) {
		// roof polygon
		int[] polyx1 = {200,350,650,800};
		int[] polyy1 = {600,450,450,600};

		// door polygon
		int[] polyx2 = {300,375,375,300};
		int[] polyy2 = {700,725,875,900};

		//color layout
		g.setColor(new Color(156, 93, 82));	// brown color
		g.fillPolygon(polyx1,polyy1,4);
		g.setColor(new Color(255,106,106));	// indian red color
		g.fillRect(200,600,600,300);
		g.setColor(Color.green);
		g.fillRect(300,700,100,200);
		g.setColor(Color.orange);
		g.fillPolygon(polyx2,polyy2,4);
		g.setColor(Color.green);
		g.fillRect(600,700,100,100);
		g.setColor(Color.yellow);
		g.fillOval(360,790,10,10);
		g.setColor(Color.yellow);
		g.fillOval(800,100,100,100);

		//border layout
		g.setColor(Color.black);
		g.drawRect(200,600,600,300);
		g.drawLine(500,600,500,900);
		g.drawRect(300,700,100,200);
		g.drawPolygon(polyx1,polyy1,4);
		g.drawLine(350,450,500,600);
		g.drawRect(600,700,100,100);
		g.drawLine(650,700,650,800);
		g.drawLine(600,750,700,750);
		g.drawPolygon(polyx2,polyy2,4);
		g.drawOval(360,790,10,10);
		g.drawOval(800,100,100,100);
	}

	public static void main(String[] args) {
		new Hut();
	}
}