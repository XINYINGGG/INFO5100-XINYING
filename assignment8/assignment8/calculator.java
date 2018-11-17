package assignment8;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

enum Operation {
	ADD, SUBTRACT, MULTIPLY, DIVIDE
}
public class calculator extends JFrame {
	private JTextField resultTextField;
	private JButton add, subtract, multiply, divide, compute, ac;
	
	private JButton numbers[];
	private Font font;
	
	
	int first = 0;
	int second = 0;
	
	Operation o = null;
	
	
	class OperationListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == add) {
				o = Operation.ADD;
			}if(e.getSource() == subtract) {
				o = Operation.SUBTRACT;
			}if(e.getSource() == multiply) {
				o = Operation.MULTIPLY;
			}if(e.getSource() == divide) {
				o = Operation.DIVIDE;
			}
		}
	}
	
	
	class ComputeListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int result = 0;
			if(o == Operation.ADD) {
				result = first + second;
			}if(o == Operation.SUBTRACT) {
				result = first - second;
			}if(o == Operation.MULTIPLY) {
				result = first * second;
			}if(o == Operation.DIVIDE) {
				result = first / second;
			}
			first = result;
			second = 0;
			resultTextField.setText(result + "");
		}
	}
	
	class NumberListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int number = 0;
			boolean isFirst = true;
			if(e.getSource() == numbers[1]) {
				number = 1;
			}
			if(e.getSource() == numbers[2]) {
				number = 2;
			}
			if(e.getSource() == numbers[3]) {
				number = 3;
			}
			if(e.getSource() == numbers[4]) {
				number = 4;
			}
			if(e.getSource() == numbers[5]) {
				number = 5;
			}
			if(e.getSource() == numbers[6]) {
				number = 6;
			}
			if(e.getSource() == numbers[7]) {
				number = 7;
			}
			if(e.getSource() == numbers[8]) {
				number = 8;
			}
			if(e.getSource() == numbers[9]) {
				number = 9;
			}
			if(e.getSource() == numbers[0]) {
				number = 0;
			}
			if(o == Operation.ADD || o == Operation.SUBTRACT || o == Operation.DIVIDE || o == Operation.MULTIPLY) {
				isFirst = false;
			}

			if(isFirst) {
				first = 10*first + number;
				resultTextField.setText(first+"");
			}
				
			else {
				second = 10* second +number;
				resultTextField.setText(second+"");
			}
		}
	}
	
	
	class ACListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			first = 0;
			second = 0;
			o = null;
			resultTextField.setText("0");
		}
	}
	
	
	
	private void addBehaviors() {
		ComputeListener c1 = new ComputeListener();
		compute.addActionListener(c1);
		
		OperationListener ol = new OperationListener();
		add.addActionListener(ol);
		subtract.addActionListener(ol);
		multiply.addActionListener(ol);
		divide.addActionListener(ol);
		
		NumberListener nl = new NumberListener();
		for(int i = 0; i < 10; i++) {
			numbers[i].addActionListener(nl);
		}
		
		ACListener al = new ACListener();
		ac.addActionListener(al);
		
		
	}
	
	private void display() {
		setSize(600,600);
		setVisible(true);
	}
	
	private void addComponents() {
		Container c = getContentPane();
		c.add(resultTextField);
		
		JPanel panel = new JPanel();
		panel.add(add);
		panel.add(subtract);
		panel.add(divide);
		panel.add(multiply);
		panel.add(ac);
		c.add(panel);
		
		panel = new JPanel();
		panel.add(compute);
		c.add(panel);
		
		JPanel p = new JPanel();
		p.add(numbers[1]);
		p.add(numbers[2]);
		p.add(numbers[3]);
		p.add(numbers[4]);
		
		c.add(p);
		
		
		p = new JPanel();
		p.add(numbers[5]);
		p.add(numbers[6]);
		p.add(numbers[7]);
		p.add(numbers[8]);
		
		c.add(p);
		
		
		p = new JPanel();
		p.add(numbers[9]);
		p.add(numbers[0]);

		c.add(p);
	}
	
	
	private void setLayout() {
		GridLayout gl = new GridLayout(6,1);
		Container c = this.getContentPane();
		c.setLayout(gl);
	}
	
	
	private void createComponents() {
		font = new Font("TimesRoman", font.PLAIN, 36);
		resultTextField = new JTextField(10);
		resultTextField.setFont(font);
		
		add = new JButton("+");
		add.setFont(font);
		subtract = new JButton("-");
		subtract.setFont(font);
		multiply = new JButton("*");
		multiply.setFont(font);
		divide = new JButton("/");
		divide.setFont(font);
		compute = new JButton("=");
		compute.setFont(font);
		ac = new JButton("AC");
		ac.setFont(font);
		
		numbers = new JButton[10];
		for(int i = 0; i < 10; i++) {
			numbers[i] = new JButton(i + "");
			numbers[i].setFont(font);
		}
	}

	
	public calculator() {
		createComponents();
		setLayout();
		addComponents();
		addBehaviors();
		display();
	}
	
	public static void main(String[] args) {
		calculator c = new calculator();
	}


}
