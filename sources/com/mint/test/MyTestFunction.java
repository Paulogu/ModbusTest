package com.mint.test;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


import com.mint.io.modbus.ModbusTCP_Connection;
import com.mint.io.modbus.functions.ModbusTCP_WriteCoil;
import com.mint.io.modbus.functions.ModbusTCP_WriteSingleRegister;

public class MyTestFunction {

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
		ModbusTCP_WriteCoil function1 = new ModbusTCP_WriteCoil();
		function1.setValue(true);
		function1.setAddress(0);
		ModbusTCP_WriteSingleRegister function2 = new ModbusTCP_WriteSingleRegister();
		function2.setInteger(25);
		function2.setAddress(3);
		// execute
		connection.execute(function1);
		connection.execute(function2);
		System.out.printf("Fini");
	}

}
