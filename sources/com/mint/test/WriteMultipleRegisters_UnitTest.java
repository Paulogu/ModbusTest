package com.mint.test;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


import com.mint.io.modbus.ModbusTCP_Connection;
import com.mint.io.modbus.functions.ModbusTCP_WriteMultipleRegisters;
import com.mint.io.modbus.utilities.ByteUtilities;


public class WriteMultipleRegisters_UnitTest {
	
	public static void main(String[] args) throws IOException {
		InetAddress ad = null;
		
		
		try {
			ad = InetAddress.getByName("192.168.1.91");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		ModbusTCP_Connection connection= new ModbusTCP_Connection(ad);
		connection.setUnitId(1);
		
		
		// define function
		ModbusTCP_WriteMultipleRegisters function = new ModbusTCP_WriteMultipleRegisters(0, 4);
		byte[] bytes = function.getData();
		ByteUtilities.writeInteger16(bytes, 0, 16);
		ByteUtilities.writeInteger16(bytes, 2, 17);
		ByteUtilities.writeInteger16(bytes, 4, 18);
		ByteUtilities.writeInteger16(bytes, 6, 19);
		
		
		
		
		// execute
		connection.execute(function);
	}
	
	
}
