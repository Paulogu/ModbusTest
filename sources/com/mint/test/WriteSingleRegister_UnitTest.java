package com.mint.test;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


import com.mint.io.modbus.ModbusTCP_Connection;
import com.mint.io.modbus.functions.ModbusTCP_WriteSingleRegister;

public class WriteSingleRegister_UnitTest {

	public static void main(String[] args) throws IOException {
		InetAddress ad = null;
		
		try {
			ad = InetAddress.getByName("192.168.0.21");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		ModbusTCP_Connection connection= new ModbusTCP_Connection(ad);
		connection.setUnitId(1);
		
		
		// define function
		ModbusTCP_WriteSingleRegister function = new ModbusTCP_WriteSingleRegister();
		function.setInteger(258);
		function.setAddress(0);
		// execute
		connection.execute(function);
	}

}
