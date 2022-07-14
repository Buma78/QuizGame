import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Quiz implements ActionListener{
    
	String[] question= {
			           "The values of mA and µA are:",
			           "What is the minimum resistance which can be made using five resistors, each of 1/5 ohm?",
			           "At the time of short circuit, the electric current in the circuit:",
			           "Unit of electric power may also be expressed as:",
			           "The instrument used for measuring electric current is:",
			           "The unit of potential difference is:",
			           "The unit of electric current is:",
			           "How to get maximum value of five resistance by connecting them as:",
			           "the theory of relativity was proposed by",
			           "The formula of resistance is:"
	                   };
	String[][] options= {
			{"10-6 and 10-9","10-3 and 10-6 A","10-3 and 10-9 A","10-6 and 10-3 A"},
			{"1/5 ohm","1/25 ohm","1/10 ohm","25 ohm"},		
			{"vary continuously","does not change","reduces substantially","increases heavily"},
			{"volt-ampere","kilowatt-hour","Watt-second","joule-second"},		
			{"potentiometer","voltmeter","ammeter","galvanometer"},		
			{"JC","J/C","J","C/J"},
			{"Ampere","Volt","Watt","Joule"},
			{"Parallel","Series","Two Parallel Three series","None"},
			{"isaac newton","Albert Einstein","madame curie","Srinivasa Ramanujan"},
			{"V*I","I/V","V/I","V*V/I"}		 
			
	        };
	char[] answers= {'B','B','D','A','C','B','A','B','B','C'};
	
	char guess;
	char answer;
	int index;
	int correct_guess=0;
	int total_question=question.length;
	 double result;
	int second=30;
	
	JFrame frame=new JFrame("Science Quiz");
	JTextField textfield=new JTextField();
	JTextArea textarea=new JTextArea();
	
	JButton a=new JButton();
	JButton b=new JButton();
	JButton c=new JButton();
	JButton d=new JButton();
	
	JLabel ans_a=new JLabel();
	JLabel ans_b=new JLabel();
	JLabel ans_c=new JLabel();
	JLabel ans_d=new JLabel();
	
	JLabel timer=new JLabel();
	JLabel time_left=new JLabel();
	
	JTextField number_right=new JTextField();
	JTextField percentage=new JTextField();
	//private ActionListener ActionListener;
	Timer time=new Timer(1000,new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			second--;
			time_left.setText(String.valueOf(second));
			if(second<=0) {
				displayAnswer();
			}
		}
		});
	
	
	public Quiz() {
	    
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 650);
		frame.getContentPane().setBackground(new Color(50,50,50));
		
		frame.setLayout(null);
		frame.setResizable(false);
		
		textfield.setBounds(0,0,650,50);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,250,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		textarea.setBounds(0,50,650,50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(25,250,0));
		textarea.setFont(new Font("MV Boli",Font.BOLD,30));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		a.setBounds(0, 100, 100, 100);
		a.setFont(new Font("MV Boli",Font.BOLD,30));
		a.setFocusable(false);
		a.addActionListener(this);
		a.setText("A");
		
		b.setBounds(0, 200, 100, 100);
		b.setFont(new Font("MV Boli",Font.BOLD,30));
		b.setFocusable(false);
		b.addActionListener(this);
		b.setText("B");
		
		c.setBounds(0, 300, 100, 100);
		c.setFont(new Font("MV Boli",Font.BOLD,30));
		c.setFocusable(false);
		c.addActionListener(this);
		c.setText("C");
		
		d.setBounds(0, 400, 100, 100);
		d.setFont(new Font("MV Boli",Font.BOLD,30));
		d.setFocusable(false);
		d.addActionListener(this);
		d.setText("D");
		
		ans_a.setBounds(125,100, 500, 100);
		ans_a.setBackground(new Color(50,50,50));
		ans_a.setForeground(new Color(25,255,0));
		ans_a.setFont(new Font("MV Boli",Font.ITALIC,35));
		ans_a.setText("testing");
		
		ans_b.setBounds(125,200, 500, 100);
		ans_b.setBackground(new Color(50,50,50));
		ans_b.setForeground(new Color(25,255,0));
		ans_b.setFont(new Font("MV Boli",Font.ITALIC,30));
		ans_b.setText("testing");
		
		ans_c.setBounds(125,300, 500, 100);
		ans_c.setBackground(new Color(50,50,50));
		ans_c.setForeground(new Color(25,255,0));
		ans_c.setFont(new Font("MV Boli",Font.ITALIC,30));
		ans_c.setText("testing");
		
		ans_d.setBounds(125,400, 500, 100);
		ans_d.setBackground(new Color(50,50,50));
		ans_d.setForeground(new Color(25,255,0));
		ans_d.setFont(new Font("MV Boli",Font.ITALIC,30));
		ans_d.setText("testing");
		
		time_left.setBounds(535,510, 100, 100);
		time_left.setBackground(new Color(50,50,50));
		time_left.setForeground(new Color(255,0,0));
		time_left.setFont(new Font("Ink Free",Font.BOLD,60));
		time_left.setBorder(BorderFactory.createBevelBorder(1));
		time_left.setOpaque(true);
		time_left.setHorizontalAlignment(JTextField.CENTER);
		time_left.setText(String.valueOf(second));
		
		timer.setBounds(535,475,100,25);
		timer.setBackground(new Color(255,50,50));
		timer.setForeground(new Color(50,0,0));
		timer.setFont(new Font("MV Boli",Font.PLAIN,20));
		timer.setHorizontalAlignment(JTextField.CENTER);
		timer.setText("Timer");
		
		number_right.setBounds(225, 225,200, 100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,225,0));
		number_right.setFont(new Font("Ink Free",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setVisible(false);
		//number_right.setText("aaaa");
		
		percentage.setBounds(225, 325,200, 100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,225,0));
		percentage.setFont(new Font("Ink Free",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setVisible(false);
		//percentage.setText("23");
		
		frame.add(percentage);
		frame.add(number_right);
		frame.add(timer);
		frame.add(time_left);
		frame.add(ans_a);
		frame.add(ans_b);
		frame.add(ans_c);
		frame.add(ans_d);
		frame.add(a);
		frame.add(b);
		frame.add(c);
		frame.add(d);
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
		
		nextQuestion();
	}
	
	public void nextQuestion() {
		if(index>=total_question) {
			result();
		}
		else {
			textfield.setText("Question "+(index+1));
			textarea.setText(question[index]);
			ans_a.setText(options[index][0]);
			ans_b.setText(options[index][1]);
			ans_c.setText(options[index][2]);
			ans_d.setText(options[index][3]);
			time.start();
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		a.setEnabled(false);
		b.setEnabled(false);
		c.setEnabled(false);
		d.setEnabled(false);
		
		if(e.getSource()==a) {
			answer='A';
			if(answer==answers[index]) {
				correct_guess++;
			}
		}
		if(e.getSource()==b) {
			answer='B';
			if(answer==answers[index]) {
				correct_guess++;
			}
		}
		if(e.getSource()==c) {
			answer='C';
			if(answer==answers[index]) {
				correct_guess++;
			}
		}
		if(e.getSource()==d) {
			answer='D';
			if(answer==answers[index]) {
				correct_guess++;
			}
		}
		displayAnswer();
	}
	
	public void displayAnswer() {
		time.stop();
		a.setEnabled(false);
		b.setEnabled(false);
		c.setEnabled(false);
		d.setEnabled(false);
		if(answers[index]!='A') {
			ans_a.setForeground(new Color(255,0,0));
		}
		if(answers[index]!='B') {
			ans_b.setForeground(new Color(255,0,0));
		}
		if(answers[index]!='C') {
			ans_c.setForeground(new Color(255,0,0));
		}
		if(answers[index]!='D') {
			ans_d.setForeground(new Color(255,0,0));
		}
		
		Timer pause=new Timer(2000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ans_a.setForeground(new Color(25,225,0));
				ans_b.setForeground(new Color(25,225,0));
				ans_c.setForeground(new Color(25,225,0));
				ans_d.setForeground(new Color(25,225,0));
				
				answer=' ';
				second=10;
				time_left.setText(String.valueOf(second));
		        
				a.setEnabled(true);
				b.setEnabled(true);
				c.setEnabled(true);
				d.setEnabled(true);
				index++;
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}
	
	public void result() {
		a.setEnabled(false);
		b.setEnabled(false);
		c.setEnabled(false);
		d.setEnabled(false);
		
		result =(((double)correct_guess/(double)total_question)*100);
	    
		textfield.setText("RESULT !");
		textarea.setText("");
		ans_a.setText("");
		ans_b.setText(" ");
		ans_c.setText("");
		ans_d.setText("");
		
		number_right.setText("( "+correct_guess+"/"+total_question);
		percentage.setText(result+"% ");
		//System.out.print(number_right+"   "+percentage);
		number_right.setVisible(true);
		percentage.setVisible(true);
		frame.add(number_right);
		frame.add(percentage);
		
		
	}
	
}
