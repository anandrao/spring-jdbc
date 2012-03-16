package com.haygroup.spring.samples.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.haygroup.spring.samples.entity.Vehicle;

@ContextConfiguration (locations = {"classpath:applicationContext-jdbc-simple-dao-support.xml"})
public class SpringDaoSupportVehicleDaoTest extends
		AbstractJUnit4SpringContextTests {

	@Autowired
	private SpringDaoSupportVehicleDao springDaoSupportVehicleDao;
	
	@Test
	public void insertSelectDelete() {
		final String vehicleNumber = "KJH-657";
		Vehicle vehicle = new Vehicle(vehicleNumber, "Red", 4, 4);
		springDaoSupportVehicleDao.insert(vehicle);
		assertEquals("Red", springDaoSupportVehicleDao.findByVehicleNo(vehicleNumber).getColor());
		springDaoSupportVehicleDao.delete(vehicle);
		assertNull(springDaoSupportVehicleDao.findByVehicleNo(vehicleNumber));
	}
}
