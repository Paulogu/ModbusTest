package com.mint.test;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.mint.io.modbus.ModbusTCP_Connection;
import com.mint.io.modbus.functions.ModbusTCP_ReadDiscreteInputs;

public class ReadDiscreteInputs_UnitTest {
	public static void main(String[] args) throws IOException {
		InetAddress ad = null;
		
		try {
			ad = InetAddress.getByName("192.168.0.21");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		ModbusTCP_Connection connection= new ModbusTCP_Connection(ad);
		connection.setUnitId(1);
		
		int nbInputs = 4;
		
		
		// define function
		ModbusTCP_ReadDiscreteInputs function = new ModbusTCP_ReadDiscreteInputs(0,nbInputs);
		
		connection.execute(function);
		
		for(int i=0; i<nbInputs; i++){
			System.out.print(function.getInputs(i)+", ");	
		}				
	}
}
