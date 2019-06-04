
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
public class Flow {
	private double pIn, pOut, setKappa;
	private double flow;
	
	//Konstruktor
	public Flow (double pIn, double pOut, double kappa){
		this.pIn = pIn;
		this.pOut = pOut;
		this.setKappa = kappa;
		calcFlow();
	}
	
	// Factor_A Berechnen (konstante)
	
	final double FACTOR_A = Math.PI * (25.0+273.15)/(256.0 * 1.013 * 100000);
		
	
	// FlussBerechnen
	private double calcFlow(){
		flow = 60 * 1000000 * (Math.pow(pIn, 2)-Math.pow(pOut, 2)) * FACTOR_A / setKappa ;
		//System.out.println( "Factor A: " + FACTOR_A);	
		return flow;
	}
	
	public double getFlow(){
		
		return flow;		
	}
	
}
