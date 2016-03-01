import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TestButton extends JFrame implements ActionListener{
	JLabel ausgabe;
	JButton button;
	int i=0;
  public TestButton(  ) {
	super("PictureButton v1.0");
	setSize(200, 80);
	setLocation(200, 200);
	button = new JButton("Plus");
	button.addActionListener(this);
	ausgabe = new JLabel("0");
	setLayout(new FlowLayout(  ));//Layout festlegen
	add(button);
	add(ausgabe);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e) {
	if(e.getSource()==button){
	i++;
	ausgabe.setText(""+i); 
    }
  }

  public static void main(String[] args) {
	TestButton f = new TestButton(  );
  }
}

