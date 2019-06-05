import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SpinnerListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;


/*******************************************************************************
 * Copyright (c) 2019 zuflucht.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * zuflucht - initial API and implementation
*******************************************************************************/
public class GUI_Main {

	private JFrame frmGradientFlowCalculator;
	static JTextField textField;
	static JTextField textField_1;
	static JTextField textField_2;
	static JTextField textField_3;
	static JTextField textField_4;
	static JTextField textField_5;
	static JRadioButton rdbtnHydrogen;
	static JRadioButton rdbtnHelium;
	static JRadioButton rdbtnNitrogen;
	static JLabel lblDtc;
	
	private static double length, innerDiameter, df, temperature, p_In, p_Out, dT, aGradient, kappa;
	private static JTextField textResultFlow;
	private static int gasType = 1;
	boolean isGradient = false;
	String str = "Test";
	double Test;
	static JTextField textField_6;
	static JTextField textField_7;
	private JTextField textField_8;
	
	//Objekte
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {
					GUI_Main window = new GUI_Main();
					window.frmGradientFlowCalculator.setVisible(true);
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				getValuesFromGUI();				
				// System.out.println("Flow = " + flow_cap1.getFlow());
				// setValuesInGUI();
				
				
				
			}
		});	
	}



	private static void getValuesFromGUI() {
		length = Double.valueOf(textField.getText());
		innerDiameter = Double.valueOf(textField_1.getText());
		df = Double.valueOf(textField_2.getText());
		temperature = Double.valueOf(textField_3.getText());
		p_In = Double.valueOf(textField_4.getText()) * 1000 + 101300;
		p_Out = Double.valueOf(textField_5.getText());
		dT = Double.valueOf(textField_6.getText());
		aGradient = Double.valueOf(textField_7.getText());
		// gasType im radiobutton
	}
	
	




	private void setValuesInGUI(double flow) {		
		textResultFlow.setText(Double.toString(flow));
		textField_8.setText(Double.toString(kappa));
	}
	
	private void calculate(){
		getValuesFromGUI();
		 Capillary cap1 = new Capillary(length, innerDiameter, df, temperature, gasType, isGradient, dT, aGradient);
		 Flow flow_cap1 = new Flow(p_In, p_Out, cap1.getKappa());
		 kappa = cap1.getKappa();
		setValuesInGUI(flow_cap1.getFlow()); 
		
	}
	

	/**
	 * Create the application.
	 */
	public GUI_Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmGradientFlowCalculator = new JFrame();
		frmGradientFlowCalculator.setTitle("Gradient Flow Calculator");
		frmGradientFlowCalculator.setBounds(100, 100, 752, 518);
		frmGradientFlowCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGradientFlowCalculator.getContentPane().setLayout(null);
		
		JLabel lblCarrierGas = new JLabel("Carrier Gas:");
		lblCarrierGas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCarrierGas.setBounds(397, 38, 104, 20);
		frmGradientFlowCalculator.getContentPane().add(lblCarrierGas);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			calculate();}
		});
		textField.setText("10.1");
		textField.setBounds(348, 145, 86, 20);
		frmGradientFlowCalculator.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate();}
		});
		textField_1.setText("0.25");
		textField_1.setBounds(348, 176, 86, 20);
		frmGradientFlowCalculator.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate();}
		});
		textField_2.setText("0.15");
		textField_2.setBounds(348, 207, 86, 20);
		frmGradientFlowCalculator.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate();}
		});
		textField_3.setText("50.0");
		textField_3.setBounds(348, 238, 86, 20);
		frmGradientFlowCalculator.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblLengthm = new JLabel("Length [m]");
		lblLengthm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLengthm.setBounds(221, 145, 104, 20);
		frmGradientFlowCalculator.getContentPane().add(lblLengthm);
		
		JLabel lblIdmm = new JLabel("ID [mm]");
		lblIdmm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdmm.setBounds(221, 176, 104, 20);
		frmGradientFlowCalculator.getContentPane().add(lblIdmm);
		
		JLabel lblDfm = new JLabel("df [µm]");
		lblDfm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDfm.setBounds(221, 207, 104, 20);
		frmGradientFlowCalculator.getContentPane().add(lblDfm);
		
		JLabel lblTemperaturec = new JLabel("Temp [°C]");
		lblTemperaturec.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTemperaturec.setBounds(221, 238, 117, 20);
		frmGradientFlowCalculator.getContentPane().add(lblTemperaturec);
		
		JLabel lblCapillaryData = new JLabel("Capillary Data");
		lblCapillaryData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCapillaryData.setBounds(221, 112, 213, 20);
		frmGradientFlowCalculator.getContentPane().add(lblCapillaryData);
		
		textField_4 = new JTextField();
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate();}
		});
		textField_4.setText("250.0");
		textField_4.setColumns(10);
		textField_4.setBounds(158, 327, 86, 20);
		frmGradientFlowCalculator.getContentPane().add(textField_4);
		
		JLabel lblPinkpag = new JLabel("p_In [kPa (g)]");
		lblPinkpag.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPinkpag.setBounds(31, 327, 117, 20);
		frmGradientFlowCalculator.getContentPane().add(lblPinkpag);
		
		textField_5 = new JTextField();
		textField_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate();}
		});
		textField_5.setText("101300");
		textField_5.setColumns(10);
		textField_5.setBounds(580, 327, 86, 20);
		frmGradientFlowCalculator.getContentPane().add(textField_5);
		
		JLabel lblPoutkpaabs = new JLabel("p_out [Pa (abs)]");
		lblPoutkpaabs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPoutkpaabs.setBounds(407, 327, 163, 20);
		frmGradientFlowCalculator.getContentPane().add(lblPoutkpaabs);
		
		JLabel lblFlowsmlmin = new JLabel("Flow [smL/min]");
		lblFlowsmlmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFlowsmlmin.setBounds(120, 376, 163, 20);
		frmGradientFlowCalculator.getContentPane().add(lblFlowsmlmin);
		
		JLabel lblFlowCalculatorVers = new JLabel("Gradient Flow Calculator Vers. 0.1");
		lblFlowCalculatorVers.setBounds(10, 11, 186, 14);
		frmGradientFlowCalculator.getContentPane().add(lblFlowCalculatorVers);
		
		JLabel lblcPeter = new JLabel("(c) 2019 Peter J. Müller \r\n");
		lblcPeter.setBounds(10, 30, 251, 14);
		frmGradientFlowCalculator.getContentPane().add(lblcPeter);
		
		JLabel lblPjmuellerunibonnde = new JLabel("pj.mueller@uni-bonn.de");
		lblPjmuellerunibonnde.setBounds(10, 44, 155, 14);
		frmGradientFlowCalculator.getContentPane().add(lblPjmuellerunibonnde);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				calculate();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(474, 375, 139, 23);
		frmGradientFlowCalculator.getContentPane().add(btnNewButton);
		
		textResultFlow = new JTextField();
		textResultFlow.setText("250.0");
		textResultFlow.setColumns(10);
		textResultFlow.setBounds(251, 379, 213, 20);
		frmGradientFlowCalculator.getContentPane().add(textResultFlow);
		
		JPanel panel = new JPanel();
		panel.setBounds(511, 34, 139, 75);
		frmGradientFlowCalculator.getContentPane().add(panel);
		panel.setLayout(null);
		
		rdbtnNitrogen = new JRadioButton("Nitrogen");
		rdbtnNitrogen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (rdbtnNitrogen.isSelected() == true) {
					gasType = 2; 
					rdbtnHelium.setSelected(false);
					rdbtnHydrogen.setSelected(false);
					calculate();
				} else {
					if (rdbtnNitrogen.isSelected() == false  & rdbtnHydrogen.isSelected() == false & rdbtnHelium.isSelected() == false ) {
						rdbtnNitrogen.setSelected(true);
					}
				}
				
				
			}
		});
		rdbtnNitrogen.setBounds(0, 28, 106, 21);
		panel.add(rdbtnNitrogen);
		
		rdbtnHydrogen = new JRadioButton("Hydrogen");
		rdbtnHydrogen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (rdbtnHydrogen.isSelected() == true) {
					gasType = 3; 
					rdbtnNitrogen.setSelected(false);
					rdbtnHelium.setSelected(false);
					calculate();
				}else {
					if (rdbtnNitrogen.isSelected() == false  & rdbtnHydrogen.isSelected() == false & rdbtnHelium.isSelected() == false ) {
						rdbtnHydrogen.setSelected(true);
					}
				} 
				
			}
		});
		rdbtnHydrogen.setBounds(0, 52, 106, 23);
		panel.add(rdbtnHydrogen);
		
		rdbtnHelium = new JRadioButton("Helium");
		rdbtnHelium.setSelected(true);
		rdbtnHelium.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (rdbtnHelium.isSelected() == true) {
							gasType = 1; 
							rdbtnNitrogen.setSelected(false);
							rdbtnHydrogen.setSelected(false);
							calculate();
						}else {
							if (rdbtnNitrogen.isSelected() == false  & rdbtnHydrogen.isSelected() == false & rdbtnHelium.isSelected() == false ) {
								rdbtnHelium.setSelected(true);
							}
						}				
			}
		});
		rdbtnHelium.setBounds(0, 2, 106, 23);
		panel.add(rdbtnHelium);
		
		JCheckBox chckbxGradient = new JCheckBox("Gradient");
		chckbxGradient.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (chckbxGradient.isSelected()==true) {
					isGradient = true;
					System.out.println(isGradient);
					calculate();					
					} else {
					isGradient = false;
					System.out.println(isGradient);
					calculate();					
				}
				
			}
		});
		chckbxGradient.setBounds(221, 265, 75, 23);
		frmGradientFlowCalculator.getContentPane().add(chckbxGradient);
		
		textField_6 = new JTextField();
		textField_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate();}
		});
		textField_6.setText("50.0");
		textField_6.setBounds(394, 263, 86, 20);
		frmGradientFlowCalculator.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		lblDtc = new JLabel("dT [°C]");
		lblDtc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDtc.setBounds(302, 263, 117, 20);
		frmGradientFlowCalculator.getContentPane().add(lblDtc);
		
		JLabel lblTypea = new JLabel("type (a)");
		lblTypea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTypea.setBounds(302, 294, 117, 20);
		frmGradientFlowCalculator.getContentPane().add(lblTypea);
		
		textField_7 = new JTextField();
		textField_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate();}
		});
		textField_7.setText("0");
		textField_7.setColumns(10);
		textField_7.setBounds(394, 294, 86, 20);
		frmGradientFlowCalculator.getContentPane().add(textField_7);
		
		JLabel lblKappaSumme = new JLabel("Kappa Summe");
		lblKappaSumme.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblKappaSumme.setBounds(109, 423, 163, 20);
		frmGradientFlowCalculator.getContentPane().add(lblKappaSumme);
		
		textField_8 = new JTextField();
		textField_8.setText("250.0");
		textField_8.setColumns(10);
		textField_8.setBounds(251, 426, 213, 20);
		frmGradientFlowCalculator.getContentPane().add(textField_8);
		
		
	}
}
