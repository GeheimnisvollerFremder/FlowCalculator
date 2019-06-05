
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
public class Capillary {
	// Instanzvariablen 
	private double kappa;
	private double eta;
	private double length, innerDiameter,  df,  temperature;
	private int gasType;
	private boolean isGradientEnabled = false;
	private double dTemp;
	private double aGradient=0;
	
	//Konstruktor
	public Capillary(double length,double innerDiameter,double  df,double  temperature, int gasType, boolean isGradient, double dT, double aGradient){
		this.length = length;
		this.innerDiameter = innerDiameter;
		this.df = df;
		this.temperature = temperature;
		this.gasType = gasType;
		this.isGradientEnabled = isGradient;
		this.dTemp = dT;
		this.aGradient = aGradient;
		System.out.println("Get Construktor: "+  length + " "+ innerDiameter + " "+  df + " "+ temperature);
		System.out.println("Set Construktor: "+  this.length + " "+ this.innerDiameter + " "+  this.df + " "+ this.temperature);
		
	}
	
	double getKappa(){		
		calcKappa();
		return kappa;
	}
	
	// Faktor Kappa ehemals Faktor K berechnen
	private double calcKappa() {			
		double position;
		double tempAtPosition = temperature + dTemp;
		double EtaAtPosition;
		double kappaAtPosition;
		int i;
		kappa = 0;
		
		if(isGradientEnabled==false){
				calcEta(temperature);
				kappa = (eta * length * (temperature + 273.15) / Math.pow((innerDiameter - 2 *df / 1000) / 1000, 4));
			} else { 
				if(isGradientEnabled==true){
				for (i=0; i<1001; i++){
					
					// step 1: Calculate positon z 
					position = i * length/1000;
					
					if (position > 0){
						
					
					// step 2: calculate temperatur at Position
					// Formel Jan Leppert Excel Sheet
					tempAtPosition = (temperature) + dTemp * (Math.exp(-(position*aGradient)/temperature) - (position/length) * Math.exp(-aGradient)); 
					
					
					// step 3: correlating eta
					EtaAtPosition = calcEta(tempAtPosition);
					
					//step 4: calculate kappe at Point
					kappaAtPosition = (EtaAtPosition * length/1000 * (tempAtPosition + 273.15) / Math.pow((innerDiameter - 2* df / 1000) / 1000, 4));
					
					//step 5: Summ Kappa
					kappa = kappa + kappaAtPosition;
					
					} else {}
					System.out.println(i  +"; "+ position +"; "+ tempAtPosition +"; "+ kappa);
				}
			
				}
			}
		
		
		
		return kappa;
	}
	
	

	// Viskositat berechnen
	private double calcEta(double temperature){
		double eta0 = 0;
		double Xi0 = 0, Xi1 = 0;
		
		switch (gasType){
			case 1: // Helium
				eta0 =18.63;
				Xi0 =0.6958;
				Xi1 =-0.0071;
				break;
			case 2: // Nitrogen
				eta0 =16.62;
				Xi0 =0.7665;
				Xi1 =-0.0378;
				break;
			case 3: // Hydrogen
				eta0 =8.382;
				Xi0 =0.6892;
				Xi1 =0.005;
				break;
		
				}
		
		eta = 0.000001 * eta0 * Math.pow((temperature + 273.15) / 273.15, (Xi0 + Xi1 * temperature / 273.15));
		
		
		return eta;
	}
	
	
	
	
}
