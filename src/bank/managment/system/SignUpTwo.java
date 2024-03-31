package bank.managment.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUpTwo extends JFrame implements ActionListener{
	
	JComboBox religionInputs,categoryInputs,incomeInputs,educationInputs,occupationInputs;
	JTextField panTextField,aadhaarTextField;
	JRadioButton syes,sno,eyes,eno;
	JButton next;
	String formno;
	
	SignUpTwo(String formno){
		this.formno=formno;
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		JLabel additionalDetail=new JLabel("Page 2: Additional Details");
		additionalDetail.setFont(new Font("Raleway",Font.BOLD,22));
		additionalDetail.setBounds(290,80,400,30);
		add(additionalDetail);
		
		JLabel religion=new JLabel("Religion:");
		religion.setFont(new Font("Raleway",Font.BOLD,20));
		religion.setBounds(100,140,100,30);
		add(religion);
		
		String valReligion[]= {"Buddhist","Hindu","Muslim","Christanity","Sikh","Jain","Other"};
		religionInputs=new JComboBox(valReligion);
		religionInputs.setBounds(300,140,400,30);
		religionInputs.setBackground(Color.white);
		add(religionInputs);
		
		JLabel Category=new JLabel("Category:");
		Category.setFont(new Font("Raleway",Font.BOLD,20));
		Category.setBounds(100,190,200,30);
		add(Category);
		
		String valCategory[]= {"General","SC","ST","OBC","Other"};
		categoryInputs=new JComboBox(valCategory);
		categoryInputs.setBounds(300,190,400,30);
		categoryInputs.setBackground(Color.white);
		add(categoryInputs);
		
		
		JLabel income=new JLabel("Income:");
		income.setFont(new Font("Raleway",Font.BOLD,20));
		income.setBounds(100,240,200,30);
		add(income);
		
		String valIncome[]= {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
		incomeInputs=new JComboBox(valIncome);
		incomeInputs.setBounds(300,240,400,30);
		incomeInputs.setBackground(Color.white);
		add(incomeInputs);
		
		JLabel education=new JLabel("Educational");
		education.setFont(new Font("Raleway",Font.BOLD,20));
		education.setBounds(100,290,200,30);
		add(education);
		
		JLabel qualification=new JLabel("Qualification:");
		qualification.setFont(new Font("Raleway",Font.BOLD,20));
		qualification.setBounds(100,315,200,30);
		add(qualification);
		
		String valEducation[]= {"High School","Under-Graduate","Graduate","Post Graduate","Doctrate","Other"};
		educationInputs=new JComboBox(valEducation);
		educationInputs.setBounds(300,305,400,30);
		educationInputs.setBackground(Color.white);
		add(educationInputs);
		
		JLabel occupation=new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway",Font.BOLD,20));
		occupation.setBounds(100,390,200,30);
		add(occupation);
	
		String valOccupation[]= {"Salaried","Self-Employed","Bussinessman","Student","Retired","Other"};
		occupationInputs=new JComboBox(valOccupation);
		occupationInputs.setBounds(300,390,400,30);
		occupationInputs.setBackground(Color.white);
		add(occupationInputs);
		
		JLabel pan=new JLabel("Pan Number:");
		pan.setFont(new Font("Raleway",Font.BOLD,20));
		pan.setBounds(100,440,200,30);
		add(pan);
		
		panTextField=new JTextField();
		panTextField.setFont(new Font("Raleway",Font.BOLD,14));
		panTextField.setBounds(300,440,400,30);
		add(panTextField);
		
		JLabel aadhaar=new JLabel("Aadhaar Number:");
		aadhaar.setFont(new Font("Raleway",Font.BOLD,20));
		aadhaar.setBounds(100,490,200,30);
		add(aadhaar);
		
		aadhaarTextField=new JTextField();
		aadhaarTextField.setFont(new Font("Raleway",Font.BOLD,14));
		aadhaarTextField.setBounds(300,490,400,30);
		add(aadhaarTextField);
		
		JLabel senior=new JLabel("Senior Citizen:");
		senior.setFont(new Font("Raleway",Font.BOLD,20));
		senior.setBounds(100,540,200,30);
		add(senior);
		
		syes=new JRadioButton("Yes");
		syes.setBounds(300,540,60,30);
		add(syes);
		
		sno=new JRadioButton("No");
		sno.setBounds(400,540,60,30);
		add(sno);
		
		ButtonGroup sGroup=new ButtonGroup();
		sGroup.add(syes);
		sGroup.add(sno);
		
		JLabel pincode=new JLabel("Existing Account:");
		pincode.setFont(new Font("Raleway",Font.BOLD,20));
		pincode.setBounds(100,590,200,30);
		add(pincode);
		
		eyes=new JRadioButton("Yes");
		eyes.setBounds(300,590,60,30);
		add(eyes);
		
		eno=new JRadioButton("No");
		eno.setBounds(400,590,60,30);
		add(eno);
		
		ButtonGroup eGroup=new ButtonGroup();
		eGroup.add(eyes);
		eGroup.add(eno);
		
		next=new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(620,660,80,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.white);
		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		String religion=(String)religionInputs.getSelectedItem();
		String category=(String)categoryInputs.getSelectedItem();
		String income=(String)incomeInputs.getSelectedItem();
		String education=(String)educationInputs.getSelectedItem();
		String occupation=(String)occupationInputs.getSelectedItem();
		String pan=panTextField.getText();
		String aadhaar=aadhaarTextField.getText();
		String senior=null;
		if(syes.isSelected()) {
			senior="Yes";
		}else if(sno.isSelected()) {
			senior="No";
		}
		String exists=null;
		if(eyes.isSelected()) {
			exists="Yes";
		}else if(eno.isSelected()) {
			exists="No";
		}
		try {
			if(pan.equals("")) {
				JOptionPane.showMessageDialog(null, "Pan is Required");
			} else {
				Conn c=new Conn();
				String query="insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhaar+"','"+senior+"','"+exists+"')";
				c.s.executeUpdate(query);
				
				//signup3 object
				setVisible(false);
				new SignupThree(formno).setVisible(true);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignUpTwo("");
	}
	
	

}
