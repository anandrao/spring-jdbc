package com.haygroup.spring.samples.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.haygroup.spring.samples.entity.Vehicle;

@ContextConfiguration (locations = {"classpath:applicationContext-jdbc-template.xml"})
public class SpringTemplateJdbcVehicleDaoTest extends AbstractJUnit4SpringContextTests{

		@Autowired
		private SpringTemplateJdbcVehicleDao springTemplateJdbcVehicleDao;
		

		@Test
		public void insertSelectDelete() {
			final String vehicleNumber = "KJH-657";
			Vehicle vehicle = new Vehicle(vehicleNumber, "Red", 4, 4);
			springTemplateJdbcVehicleDao.insert(vehicle);
			assertEquals("Red", springTemplateJdbcVehicleDao.findByVehicleNo(vehicleNumber).getColor());
			springTemplateJdbcVehicleDao.delete(vehicle);
			assertNull(springTemplateJdbcVehicleDao.findByVehicleNo(vehicleNumber));
		}
}
