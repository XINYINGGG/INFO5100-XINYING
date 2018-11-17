package assignment8;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class studentIS extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Students students = new Students();
		StudentView view = new StudentView(students); 
		StudentController controller = new StudentController(students, view);
		view.setVisible(true);
	}

}
	
	

// Array Students
	class Students {
		private Collection<Student> students = new ArrayList<Student>();

		public Collection<Student> getStudents() {
			return students;

		}

		public void addStudent(Student s) {
			students.add(s);
		}

		public int getNumberOfStudents() {
			return getStudents().size();
		}

	}
	
	
// Student Modify class
	class Student {

		String id;
		String first;
		String last;
		String gender;

		public Student( String id, String first, String last, String gender) {
	
			this.id = id;
			this.first = first;
			this.last = last;
			this.gender = gender;
		}
		public void setId(String id){
			this.id = id;
		}
		public void setFirst(String first){
			this.first = first;
		}
		public void setLast(String last){
			this.last = last;
		}
		public void setGender(String gender){
			this.gender = gender;
		}
	}
	
	
//Studnet View class
	class StudentView extends JFrame{
		private JTextField id, lastName, firstName;
		public JButton add;
		private JLabel genderLabel, studentId,studentLastName, studentFirstName;
		private JRadioButton male, female;
		private Font font;
		public JTable studentsTable;
		private GridLayout grid;
		public JScrollPane jsp;
		public StudentsTableModel model;
		
		private String[] columnName = {"ID","Name","Gender"};
		private String[][] rowData = new String[10][3];
		private JTable StuInfoTable;
		public static int NumberOfStu = 0;

		
		public StudentView(Students students) {
			createComponents(students);
			addComponents();
			display();
			setLayout();
		}
		public void setRowData(String ID, String Name, String Gender) {
			this.rowData[NumberOfStu][0] = ID;
			this.rowData[NumberOfStu][1] = Name;
			this.rowData[NumberOfStu][2] = Gender;
			NumberOfStu++;
			jsp.setViewportView(StuInfoTable);
			add(jsp);
			
		}
		
		public void createComponents(Students students) {
			font = new Font("TimesRoman", font.PLAIN, 15);
//			model = new StudentsTableModel(students);
//			studentsTable = new JTable(model);
			
			StuInfoTable = new JTable(rowData,columnName);
			jsp = new JScrollPane(StuInfoTable);
			
			add = new JButton("ADD");
			add.setFont(font);
			
			id = new JTextField();
			lastName = new JTextField();
			firstName = new JTextField();
			male = new JRadioButton("Male");
			female = new JRadioButton("Female");
			
			genderLabel = new JLabel("Select Gender:");
			studentId = new JLabel("Studnet id:");
			studentLastName = new JLabel("Last Name:");
			studentFirstName = new JLabel("First Name");
			
			
			

			Container con = this.getContentPane();
			con.add(jsp);

		}
		private void addComponents() {
	        
			Container c = getContentPane();
			JPanel panel = new JPanel();
			grid = new GridLayout(3, 2,1,1);  
			panel.setLayout(grid);
			panel.add(studentId);
			panel.add(id);
			panel.add(studentLastName);
			panel.add(lastName);
			panel.add(studentFirstName);
			panel.add(firstName);
			c.add(panel);
			
			
			panel = new JPanel();
			grid = new GridLayout(1,3,1,1);  
			panel.add(genderLabel);
			panel.add(male);
			panel.add(female);
			c.add(panel);
			
			panel = new JPanel();
			grid = new GridLayout(1,1,1,1);
			panel.add(add);
			c.add(panel);
			

			
		}
		private void display() {
			setSize(600,600);
			setVisible(true);
 
		}
		private void setLayout() {
			GridLayout gl = new GridLayout(6,1);
			Container c = this.getContentPane();
			c.setLayout(gl);
		}
		public String getId() {
			return id.getText();
		}
		public String getLastName() {
			return lastName.getText();
		}
		public String getFirstName() {
			return firstName.getText();
		}
		public String getGender() {
			if(female.isSelected())
				return "female";
			if(male.isSelected()){
				return "male";
			}
			return null;
		}
		
	}
	
	
	
	class StudentsTableModel implements TableModel {

		private Students students;

		public StudentsTableModel(Students students) {
			this.students = students;
		}

		@Override
		public int getRowCount() {
			return students.getNumberOfStudents();
		}

		@Override
		public int getColumnCount() {
			return 4;
		}

		@Override
		public String getColumnName(int columnIndex) {
			if (columnIndex == 0) {
				return "ID";
			}
			if (columnIndex == 1) {
				return "First";
			}
			if (columnIndex == 2)
				return "Last";
			if (columnIndex == 3)
				return "Gender";
			return null;
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return String.class;
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {

			return false;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Collection<Student> s = students.getStudents();
			int row = -1;
			for (Student student : s) {
				row++;
				if (row == rowIndex) {
					if (columnIndex == 0) {
						return student.id + "";
					}
					if (columnIndex == 1) {
						return student.first;
					}
					if (columnIndex == 2) {
						return student.last;
					}
					if (columnIndex == 3) {
						return student.gender;
					}
				}
			}
			return null;
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub

		}

		@Override
		public void addTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub

		}

		@Override
		public void removeTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub

		}

	}
	class StudentController{
		public Students studentlist;
		public StudentView view;
		
		StudentController(Students studentlist, StudentView view){
			this.studentlist = studentlist;
			this.view = view;
			
			view.add.addActionListener(new insertStudent());
		}
		public class insertStudent implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				String sId = view.getId();
				String sLastName = view.getLastName();
				String sFirstName = view.getFirstName();
				String sGender = view.getGender();
				view.setRowData(sId, sFirstName+" "+sLastName, sGender);

			}
		}
	}