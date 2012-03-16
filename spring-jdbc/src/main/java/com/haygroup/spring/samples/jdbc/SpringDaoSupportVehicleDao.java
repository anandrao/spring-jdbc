package com.haygroup.spring.samples.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.util.CollectionUtils;

import com.haygroup.spring.samples.dao.VehicleDao;
import com.haygroup.spring.samples.entity.Vehicle;

public class SpringDaoSupportVehicleDao extends SimpleJdbcDaoSupport implements
		VehicleDao {

	public void insert(Vehicle vehicle) {
		String sql = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) "
				+ "VALUES (?, ?, ?, ?)";
		getSimpleJdbcTemplate().update(sql,
				new Object[] { vehicle.getVehicleNo(), vehicle.getColor(),
						vehicle.getWheel(), vehicle.getSeat() });

	}

	public void update(Vehicle vehicle) {
		// TODO Auto-generated method stub

	}

	public void delete(Vehicle vehicle) {
		getSimpleJdbcTemplate().update("DELETE FROM VEHICLE WHERE VEHICLE_NO = ?",
				new Object[] { vehicle.getVehicleNo() });

	}

	public Vehicle findByVehicleNo(String vehicleNo) {
		String sql = "SELECT * FROM VEHICLE WHERE VEHICLE_NO = :vehicleNo";
		
		final Map<String,String> parameterMapper = new HashMap<String,String>();
		parameterMapper.put("vehicleNo", vehicleNo);
		List<Vehicle> vehicles = getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(Vehicle.class), parameterMapper);
		if (!CollectionUtils.isEmpty(vehicles)) {
			return vehicles.get(0);
		} else {
			return null;
		}
	}

}
