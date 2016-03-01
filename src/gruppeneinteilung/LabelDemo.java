import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LabelDemo extends JFrame {
  public LabelDemo(  ) {
	super("LabelDemo v1.0");
	setSize(300, 300);
	setLocation(200, 200);
	Icon icon = new ImageIcon("em2012.jpg");
	JLabel labelFussball = new JLabel(icon);
	JLabel text = new JLabel("EM 2012");
	setLayout(new FlowLayout(  ));
	add(labelFussball);
	add(text);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
  }
  public static void main(String[] args) {
	JFrame f = new LabelDemo(  );
  }
}
