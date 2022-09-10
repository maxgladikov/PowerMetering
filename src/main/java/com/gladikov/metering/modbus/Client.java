package com.gladikov.metering.modbus;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.intelligt.modbus.jlibmodbus.Modbus;
import com.intelligt.modbus.jlibmodbus.data.ModbusHoldingRegisters;
import com.intelligt.modbus.jlibmodbus.master.ModbusMaster;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterFactory;
import com.intelligt.modbus.jlibmodbus.slave.ModbusSlave;
import com.intelligt.modbus.jlibmodbus.slave.ModbusSlaveFactory;
import com.intelligt.modbus.jlibmodbus.tcp.TcpParameters;
import com.intelligt.modbus.jlibmodbus.exception.ModbusIOException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusNumberException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusProtocolException;

public class Client implements Runnable{
	private ModbusMaster client;
	private TcpParameters tcpParameters;
	private String ip;
	
	public Client(String ip) throws UnknownHostException {
		this.ip=ip;
		tcpParameters = new TcpParameters();
		tcpParameters.setKeepAlive(true);
        tcpParameters.setPort(Modbus.TCP_PORT);
        tcpParameters.setHost(InetAddress.getByName(ip));
        client = ModbusMasterFactory.createModbusMasterTCP(tcpParameters);
        Modbus.setAutoIncrementTransactionId(true);
	}
	
	
	public void run() {
        int slaveId = 1;
        int offset = 0;
        int quantity = 10;

        try {
            if (!client.isConnected()) {
                client.connect();
            }
        int[] registerValues = client.readHoldingRegisters(slaveId, offset, quantity);
        for (int value : registerValues) {
            System.out.println("Address: " + offset++ + ", Value: " + value);
        	}
		
        }catch (ModbusProtocolException e) {
	        e.printStackTrace();
	    } catch (ModbusNumberException e) {
	        e.printStackTrace();
	    } catch (ModbusIOException e) {
	        e.printStackTrace();
	    } finally {
        try {
            client.disconnect();
        } catch (ModbusIOException e) {
            e.printStackTrace();
        }}}
	


}
