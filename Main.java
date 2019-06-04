
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
public class Main {
	
	 static double a = 40;
	 static double b = 0.2;
	 static double c = 0;
	 static double d = 340.0;
	 static double e = 300000;
	 static double f = 101300;
	 static double string;
	
	
	public static void main(String[] args){	
		
		Capillary cap1 = new Capillary(	a, b, c, d, 1, true, 50.0, 0); //innerDiameter,  df,  temperature
		Flow flow_cap1 = new Flow(e,f,cap1.getKappa());		
		System.out.println("hallo welt");
		System.out.println("kappa = "+ cap1.getKappa());
		//System.out.println("eta = " + cap1.eta);
		//System.out.println("Flow = " + flow_cap1.flow);
		string = flow_cap1.getFlow();
		System.out.println(string);
	
	}
	
	public void getValues(){
		
	}
	
}
