import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	JPanel panel2;
	
	
	Font myFont = new Font("Helvetica Neue",Font.PLAIN,28);
	
	double num1=0,num2=0,result=0;
	char operator;
	
	Calculator(){
		
		frame = new JFrame("IOS Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setSize(360, 780);
		frame.setResizable(false);
		frame.setLayout(null);
		
		textfield = new JTextField("");
		textfield.setBounds(12, 135, 336 ,125);
		textfield.setBackground(Color.BLACK);
		textfield.setForeground(Color.WHITE);
		textfield.setFont(new Font("Ink Free",Font.PLAIN,90));
		textfield.setHorizontalAlignment(JTextField.RIGHT);
		textfield.setEditable(false);
		textfield.setOpaque(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("×");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("%");
		clrButton = new JButton("C");
		negButton = new JButton("±");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = equButton;
		functionButtons[5] = decButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		//#a5a5a5
		for(int i =0;i<9;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setForeground(Color.WHITE);
			numberButtons[i].setBackground(Color.decode("#333333"));
			numberButtons[i].setOpaque(true);
			numberButtons[i].setBorderPainted(false);
			numberButtons[i].setFocusable(false);
		}
		numberButtons[0].setBounds(12, 613, 162, 75);
		for(int i =0;i<5;i++) {
			functionButtons[i].setBackground(Color.decode("#ff9f06"));
			functionButtons[i].setForeground(Color.WHITE);
			functionButtons[i].setOpaque(true);
			functionButtons[i].setBorderPainted(false);
		}
		
			decButton.setBackground(Color.decode("#333333"));
			decButton.setForeground(Color.WHITE);
			decButton.setOpaque(true);
			decButton.setBorderPainted(false);
			decButton.setFocusable(false);
		
		for(int i =6;i<9;i++) {
			functionButtons[i].setBackground(Color.decode("#a5a5a5"));
			functionButtons[i].setForeground(Color.BLACK);
			functionButtons[i].setOpaque(true);
			functionButtons[i].setBorderPainted(false);
		}
		
		decButton.setBounds(186, 613, 75, 75);
		
		equButton.setBounds(273, 613, 75, 75);
		
		panel = new JPanel();
		panel.setBounds(12, 265, 336, 336);
		panel.setBackground(Color.BLACK);
		panel.setLayout(new GridLayout(4,4,12,12));

		panel.add(clrButton);
		panel.add(negButton);
		panel.add(delButton);
		panel.add(divButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		
		
		frame.add(textfield);
		frame.add(panel);
		frame.add(numberButtons[0]);
		frame.add(decButton);
		frame.add(equButton);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
		if(e.getSource()==equButton) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			if(string.length()==1) {
				textfield.setText("");
			}
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
	}
}