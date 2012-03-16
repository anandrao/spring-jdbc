package com.haygroup.spring.samples.jdbc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.haygroup.spring.samples.entity.Vehicle;

@ContextConfiguration (locations = {"classpath:applicationContext.xml"})
public class JdbcVehicleDaoTest extends AbstractJUnit4SpringContextTests{

	@Autowired
	private JdbcVehicleDao jdbcVehicleDao;
	

	@Test
	public void insertSelectDelete() {
		final String vehicleNumber = "KJH-657";
		Vehicle vehicle = new Vehicle(vehicleNumber, "Red", 4, 4);
		jdbcVehicleDao.insert(vehicle);
		assertEquals("Red", jdbcVehicleDao.findByVehicleNo(vehicleNumber).getColor());
		jdbcVehicleDao.delete(vehicle);
		assertNull(jdbcVehicleDao.findByVehicleNo(vehicleNumber));
	}
}
