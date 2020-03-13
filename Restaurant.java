

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

import com.sun.jmx.snmp.Timestamp;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;


public class Restaurant {

	private JFrame frmDepartment;
	private JTextField insertCard;
	public static int[] array = {0, 0, 0, 0, 0, 0};
	public static String result [][] = new String [6][3];
	public static JButton arrr [] = new JButton[6];
	private JTextField total;
	private Connection connection = CardHolderDatabase.getConnection();


	public Restaurant() throws SQLException {
		initialize();
	}
	
	private void initialize() throws SQLException {
		frmDepartment = new JFrame();
		frmDepartment.setTitle("Abby's Restaurant");
		frmDepartment.getContentPane().setBackground(new Color(95, 158, 160));
		frmDepartment.setBounds(100, 100, 450, 300);
		frmDepartment.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{136, 125, 117, 0};
		gridBagLayout.rowHeights = new int[]{30, 29, 29, 29, 29, 29, 29, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmDepartment.getContentPane().setLayout(gridBagLayout);
		
		total = new JTextField();
		total.setEditable(false);
		total.setBackground(new Color(255, 255, 0));
		GridBagConstraints gbc_total = new GridBagConstraints();
		gbc_total.insets = new Insets(0, 0, 5, 5);
		gbc_total.fill = GridBagConstraints.HORIZONTAL;
		gbc_total.gridx = 0;
		gbc_total.gridy = 0;
		frmDepartment.getContentPane().add(total, gbc_total);
		total.setColumns(10);
		
		JTextArea screen = new JTextArea(10,10);
		
		screen.setEditable(false);	
		screen.setBackground(new Color(255, 250, 205));
		GridBagConstraints gbc_screen = new GridBagConstraints();
		gbc_screen.gridheight = 3;
		gbc_screen.insets = new Insets(0, 0, 5, 5);
		gbc_screen.fill = GridBagConstraints.BOTH;
		gbc_screen.gridx = 0;
		gbc_screen.gridy = 1;
		
		JButton btnNewButton_1 = new JButton("Soup $5.00");
		arrr[0] = btnNewButton_1;
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				array[0] = array[0] + 1;
				setScreen(btnNewButton_1, 0, screen);
				calTotal(screen, total);
			}
		});
		
		JButton btnLeave = new JButton("Leave");
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDepartment.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnLeave = new GridBagConstraints();
		gbc_btnLeave.insets = new Insets(0, 0, 5, 0);
		gbc_btnLeave.gridx = 2;
		gbc_btnLeave.gridy = 0;
		frmDepartment.getContentPane().add(btnLeave, gbc_btnLeave);
		frmDepartment.getContentPane().add(screen, gbc_screen);
		
		
		JButton btnNewButton = new JButton("Hamburger $7.00");
		arrr[1] = btnNewButton;
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				array[1] = array[1] + 1;
				setScreen(btnNewButton, 1, screen);
				calTotal(screen, total);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		frmDepartment.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Pizza 2.00");
		arrr[2] = btnNewButton_2;
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				array[2] = array[2] + 1;
				setScreen(btnNewButton_2, 2, screen);
				calTotal(screen, total);
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 3;
		frmDepartment.getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
		
		JLabel lblInsertCard = new JLabel("Enter Purchase");
		GridBagConstraints gbc_lblInsertCard = new GridBagConstraints();
		gbc_lblInsertCard.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsertCard.gridx = 0;
		gbc_lblInsertCard.gridy = 4;
		frmDepartment.getContentPane().add(lblInsertCard, gbc_lblInsertCard);
		
		JButton btnNewButton_3 = new JButton("Pepsi $2.00");
		arrr[3] = btnNewButton_3;
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				array[3] = array[3] + 1;
				setScreen(btnNewButton_3, 3, screen);
				calTotal(screen, total);
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 4;
		frmDepartment.getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
		
		insertCard = new JTextField();
		GridBagConstraints gbc_insertCard = new GridBagConstraints();
		gbc_insertCard.insets = new Insets(0, 0, 5, 5);
		gbc_insertCard.fill = GridBagConstraints.HORIZONTAL;
		gbc_insertCard.gridx = 0;
		gbc_insertCard.gridy = 5;
		frmDepartment.getContentPane().add(insertCard, gbc_insertCard);
		insertCard.setColumns(10);
		
		
		JButton btnNewButton_4 = new JButton("Spaghetti $7.00");
		arrr[4] = btnNewButton_4;
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				array[4] = array[4] + 1;
				setScreen(btnNewButton_4, 4, screen);
				calTotal(screen, total);
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 2;
		gbc_btnNewButton_4.gridy = 5;
		frmDepartment.getContentPane().add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton Clear = new JButton("Clear");
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < arrr.length; i++) {
					arrr[i].setEnabled(true);
				}
				screen.setText("");
				insertCard.setText("");
				for(int i=0; i<array.length;i++) {
					array[i] = 0;
				}
				lblInsertCard.setText("Enter Purchase");
				total.setText("");
			}
		});
		
		
		JButton btnNewButton_5 = new JButton("Tacos $3.00");
		arrr[5] = btnNewButton_5;
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				array[5] = array[5] + 1;
				setScreen(btnNewButton_5, 5, screen);
				calTotal(screen, total);
			}
		});
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 2;
		gbc_btnNewButton_5.gridy = 6;
		frmDepartment.getContentPane().add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton pay = new JButton("Pay");
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!screen.getText().isEmpty() && !insertCard.getText().isEmpty() ) 
					lblInsertCard.setText("Card Inserted");
				else
					lblInsertCard.setText("Insert Card");
			}
		});
		GridBagConstraints gbc_pay = new GridBagConstraints();
		gbc_pay.insets = new Insets(0, 0, 0, 5);
		gbc_pay.gridx = 0;
		gbc_pay.gridy = 7;
		frmDepartment.setVisible(true);
		frmDepartment.getContentPane().add(pay, gbc_pay);
		
		
		JButton btnPickUp = new JButton("Pick Up");
		btnPickUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!insertCard.getText().isEmpty() && !total.getText().equals("Error")) {
					screen.setText("");
					insertCard.setText("");
					for(int i=0; i<array.length;i++) {
						array[i] = 0;
					}
					lblInsertCard.setText("Enter Purchase");
					total.setText("");
					for(int i = 0; i < arrr.length; i++) {
						arrr[i].setEnabled(true);
					}
				}
				
			}
		});
		
		GridBagConstraints gbc_btnPickUp = new GridBagConstraints();
		gbc_btnPickUp.insets = new Insets(0, 0, 5, 5);
		gbc_btnPickUp.gridx = 1;
		gbc_btnPickUp.gridy = 1;
		frmDepartment.getContentPane().add(btnPickUp, gbc_btnPickUp);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 1;
		frmDepartment.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		GridBagConstraints gbc_Clear = new GridBagConstraints();
		gbc_Clear.insets = new Insets(0, 0, 5, 5);
		gbc_Clear.gridx = 0;
		gbc_Clear.gridy = 6;
		frmDepartment.getContentPane().add(Clear, gbc_Clear);
		
	
	

	pay.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(!screen.getText().isEmpty() && !insertCard.getText().isEmpty()) {
				for(int i = 0; i < arrr.length; i++) {
					arrr[i].setEnabled(false);
				}
				ArrayList<Integer> card = new ArrayList<>();
				ArrayList<Double> currCredit = new ArrayList<>();
				
				try {
					fill(card, "cardNumber", "CardHolder");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					fillDouble(currCredit, "remainingCredit", "CardHolder");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				if(card.contains(Integer.parseInt(insertCard.getText()))) {
					int x = card.indexOf(Integer.parseInt(insertCard.getText()));
					if(currCredit.get(x) > Double.parseDouble(total.getText().substring(1))) {
						try {
							screen.setText("Card is valid " + "\n" + "Transaction Completed" + "\n"+ "Please Pick Up" );
							String query = "update CardHolderDB.CardHolder set remainingCredit = ? where cardNumber = ?";
							PreparedStatement pS = connection.prepareStatement(query);
							pS.setDouble(1, currCredit.get(x) - Double.parseDouble(total.getText().substring(1)));
							pS.setString(2, insertCard.getText());
							pS.executeUpdate();
							query = " insert into CardHolderDB.ShopTable (transactionID, cardNumber, clientName, transactionDate,transactionAmount, description)"
							        + " values (?, ?, ?, ?, ?, ?)";
							pS = connection.prepareStatement(query);
							Random rand = new Random(); 
							int rand_int1 = rand.nextInt(1000); 
						    pS.setInt(1, rand_int1 + Integer.parseInt(insertCard.getText()));
						    pS.setInt (2, Integer.parseInt(insertCard.getText()));
						    pS.setString(3, "Client");
						    
						    
						    java.util.Date d = new java.util.Date();
						    java.sql.Timestamp sd = new java.sql.Timestamp(d.getTime());
						    
						    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						    Calendar cal = Calendar.getInstance();
						    System.out.print(cal);
						    pS.setString(4, dateFormat.format(cal.getTime()));
						    pS.setDouble(5, Double.parseDouble(total.getText().substring(1)));
						    pS.setString(6, "Abby's Restaurant");
						    
						    pS.execute();
						    
						   
						}
						catch(Exception e1) {
							e1.printStackTrace();
						}
						
					}
					else {
						screen.setText("Low Balance");
						total.setText("Error");
					}
				}
	
					else {
						screen.setText("Card is not valid" );
						total.setText("Error");
					}
			}
		
		}
		});	
	
	
	
}
		
	public void fill(ArrayList<Integer> a, String head, String table) throws SQLException {
		String query = "select " + head + " from CardHolderDB." + table;
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
			a.add(rs.getInt(head));
	}	
	
	public void fillDouble(ArrayList<Double> a, String head, String table) throws SQLException {
		String query = "select " + head + " from CardHolderDB." + table;
		PreparedStatement ps = connection.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
			a.add(rs.getDouble(head));
	}
	
	
	public static void setScreen(JButton button, int index, JTextArea screen) {
		String a = screen.getText();
		result[index][0] = Integer.toString(array[index]);
		String b[] = button.getText().split(" ");
		result[index][1] = b[0];
		result[index][2] = b[1];
		String r ="";
		double total = 0;
		if(a.contains(result[index][1])) {
			String c[] = a.split("\n");
			for(int i = 0; i < c.length; i++) {
				if(c[i].contains(result[index][1])){
					String []s = c[i].split(" ");
					s[0]=Integer.toString(array[index]);
					String sum = cal(result[index][2], array[index]);
					c[i] = s[0]+ " " + s[1]+ " $" + sum;
					total = total + Double.parseDouble(sum);
				}
				r = r + c[i] + "\n";
				
			}
		}
		else {
			r = a + result[index][0] + " " + result[index][1] + " " + result[index][2] + "\n";
		}
	
		screen.setText(r);
		
		
	}
	
	public static void calTotal(JTextArea screen, JTextField total) {
		BigDecimal a = new BigDecimal(0);
		String b = screen.getText();
		String c[] = b.split("\n");
		for(int i = 0;i < c.length; i++) {
			String d[] = c[i].split(" ");
			String x = d[2].substring(1, d[2].length());
			BigDecimal z =  new BigDecimal(x);
			a = a.add(z);
			
		}
		total.setText("$" + a.toString());
	}
	
	

	public static String cal(String y, int c) {
		String d = y.substring(1, y.length());
		BigDecimal a =  new BigDecimal(d);
		BigDecimal b =  new BigDecimal(c);
		BigDecimal e = a.multiply(b);
		String sum = e.toString();
		return sum;
	}
}