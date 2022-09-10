package com.gladikov.metering;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.gladikov.metering.modbus.Client;

public class Main {

	public static void main(String[] args) throws UnknownHostException {
//		ApplicationContext ctx = SpringApplication.run(ElectricMeteringApplication.class, args);
//		String [] beanNames=ctx.getBeanDefinitionNames();
//		System.out.println(beanNames);
		
		
//		InetAddress address=InetAddress.getByName("192.168.0.1");
//		System.out.println(address);
		
		new Thread(new Client("192.168.56.105")).start();
	}

}
