package testcgpa;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class StudentClass implements ActionListener
{
	JLabel j1=new JLabel("Enter name");
	JLabel j2=new JLabel("Enter age");
	JLabel j3=new JLabel("Enter sem 1 mark");
	JLabel j4=new JLabel("Enter sem 2 mark");
	JLabel j6=new JLabel("Enter category");
	JLabel j7=new JLabel("CGPA");
	JComboBox j5=new JComboBox();
	JTextField name=new JTextField(5);
	JTextField age=new JTextField(5);
	JTextField sgpa1=new JTextField(5);
	JTextField sgpa2=new JTextField(5);
	JButton compute=new JButton("Compute");
	JButton done=new JButton("done");
	JButton display=new JButton("Display");
	JFrame f1=new JFrame("Student info");
	JFrame f2=new JFrame("Student Information");
	JTextArea stud=new JTextArea(20,20);
	JTextField cgpa=new JTextField(5);
	StudentClass()
	{
		f1.add(j1);f1.add(name);
		f1.add(j2);f1.add(age);
		f1.add(j3);f1.add(sgpa1);
		f1.add(j4);f1.add(sgpa2);
		j5.addItem("SC");j5.addItem("GM");
		f1.add(j6);f1.add(j5);
		f1.add(j7);f1.add(cgpa);
		f1.add(compute);f1.add(display);
		f1.setSize(900, 800);
		f1.setLayout(new GridLayout(10,10));
		f1.setVisible(true);
		f2.add(stud);
		compute.addActionListener(this);
		done.addActionListener(this);
		display.addActionListener(this);
	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==compute)
		{
			try
			{
				int a=Integer.parseInt(age.getText());
				if(a<18 || a>35)
				{
					String ag1=JOptionPane.showInputDialog("Enter age");
					age.setText(ag1);
				}
			}
			catch(NumberFormatException e)
			{
				String ag1=JOptionPane.showInputDialog("Enter age");
				age.setText(ag1);
			}
			float cal=cal_cgpa();
			cgpa.setText(Float.toString(cal));
		}
		if(evt.getSource()==display)
		{
			f1.setVisible(false);
			f2.setVisible(true);
			f2.setSize(500,500);
			stud.append(age.getText()+"\n");
			stud.append(sgpa1.getText()+"\n");
			stud.append(name.getText()+"\n");
			stud.append(cgpa.getText()+"\n");
		}
	}
	float cal_cgpa()
	{
		float v1=Float.parseFloat(sgpa1.getText());
		float v2=Float.parseFloat(sgpa2.getText());
		float sgpa=(v1+v2)/2;
		return sgpa;
	}
	public static void main(String args[])
	{
		StudentClass sc=new StudentClass();
	}
}
