import java.awt.*;
import java.awt.event.*;

public class Face extends Frame{

	public Face() {
		super("Face");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setBackground(Color.yellow);
		setSize(1000,1000);
		setVisible(true);
	}

	public void paint(Graphics g) {
		g.fillOval(250,100,500,400);
		g.setColor(new Color(255,218,185));	// skin color
		g.fillOval(300,200,400,500);
		g.fillOval(225,350,75,200);
		g.fillOval(700,350,75,200);
		g.setColor(Color.black);
		g.drawOval(300,200,400,500);
		g.drawArc(355,278,115,140,30,120);
		g.drawArc(355,279,115,140,30,120);
		g.drawArc(355,280,115,140,30,120);
		g.drawArc(355,281,115,140,30,120);
		g.drawArc(355,282,115,140,30,120);
		g.drawArc(530,278,115,140,30,120);
		g.drawArc(530,279,115,140,30,120);
		g.drawArc(530,280,115,140,30,120);
		g.drawArc(530,281,115,140,30,120);
		g.drawArc(530,282,115,140,30,120);
		g.drawOval(375,300,75,100);
		g.drawOval(550,300,75,100);
		g.fillOval(379,350,67,50);
		g.fillOval(554,350,67,50);
		g.drawOval(225,350,75,200);
		g.drawOval(700,350,75,200);
		g.drawLine(488,400,468,500);
		g.drawLine(489,400,469,500);
		g.drawLine(490,400,470,500);
		g.drawLine(491,400,471,500);
		g.drawLine(492,400,472,500);
		g.drawLine(468,498,530,498);
		g.drawLine(468,499,530,499);
		g.drawLine(468,500,530,500);
		g.drawLine(468,501,530,501);
		g.drawLine(468,502,530,502);
		g.drawArc(375,271,250,350,210,120);
		g.drawArc(375,272,250,350,210,120);
		g.drawArc(375,273,250,350,210,120);
		g.drawArc(375,274,250,350,210,120);
		g.drawArc(375,275,250,350,210,120);
	}

	public static void main(String[] args) {
		new Face();
	}
}