package com.mint.test;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.mint.io.modbus.ModbusTCP_Connection;
import com.mint.io.modbus.functions.ModbusTCP_ReadMultipleRegisters;

public class ReadMultipleRegisters_UniTest {
	public static void main(String[] args) throws IOException {
		InetAddress ad = null;
		
		try {
			ad = InetAddress.getByName("192.168.0.21");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		ModbusTCP_Connection connection= new ModbusTCP_Connection(ad);
		connection.setUnitId(1);
		
		int nbHRegs=4;
		
		ModbusTCP_ReadMultipleRegisters function= new ModbusTCP_ReadMultipleRegisters(0, nbHRegs);
		connection.execute(function);
		
		for(int i=0; i<nbHRegs; i++){
			System.out.print(function.getRegisters(i)+", ");	
		}
	}
}
