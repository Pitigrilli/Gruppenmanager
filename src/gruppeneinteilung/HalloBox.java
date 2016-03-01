import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HalloBox extends JFrame implements ActionListener {
    
	JTextField field = new JTextField(  );
	JLabel antwort = new JLabel("");
	
  public HalloBox(  ) {
	super("HalloBox v1.0");
	setSize(200, 100);
	setLocation(200, 200);
	JLabel frage = new JLabel("Wie heisst Du?");
	field = new JTextField(  );
	add(frage, BorderLayout.NORTH);
	add(field, BorderLayout.CENTER);
	add(antwort, BorderLayout.SOUTH);
	field.requestFocus(  );
	field.addActionListener(this);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
  }
  
  public void actionPerformed(ActionEvent ae) {
		 antwort.setText("Hallo "+field.getText(  ));
		 field.setText("");
   }

  public static void main(String[] args) {
	HalloBox f = new HalloBox(  );
  }
}
