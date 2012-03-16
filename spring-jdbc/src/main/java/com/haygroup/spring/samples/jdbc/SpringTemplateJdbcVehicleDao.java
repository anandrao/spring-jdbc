package com.haygroup.spring.samples.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.CollectionUtils;

import com.haygroup.spring.samples.dao.VehicleDao;
import com.haygroup.spring.samples.entity.Vehicle;

public class SpringTemplateJdbcVehicleDao implements VehicleDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insert(Vehicle vehicle) {
		String sql = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) "
				+ "VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql,
				new Object[] { vehicle.getVehicleNo(), vehicle.getColor(),
						vehicle.getWheel(), vehicle.getSeat() });
	}

	public void update(Vehicle vehicle) {
	}

	public void delete(Vehicle vehicle) {
		jdbcTemplate.update("DELETE FROM VEHICLE WHERE VEHICLE_NO = ?",
				new Object[] { vehicle.getVehicleNo() });
	}

	public Vehicle findByVehicleNo(String vehicleNo) {
		String sql = "SELECT * FROM VEHICLE WHERE VEHICLE_NO = ?";
		List<Vehicle> vehicles = jdbcTemplate.query(sql,
				new Object[] { vehicleNo }, new RowMapper<Vehicle>() {
					public Vehicle mapRow(ResultSet rs, int arg1)
							throws SQLException {
						Vehicle vehicle = new Vehicle();
						vehicle.setVehicleNo(rs.getString("VEHICLE_NO"));
						vehicle.setColor(rs.getString("COLOR"));
						vehicle.setWheel(rs.getInt("WHEEL"));
						vehicle.setSeat(rs.getInt("SEAT"));
						return vehicle;
					}
				});
		if (!CollectionUtils.isEmpty(vehicles)) {
			return vehicles.get(0);
		} else {
			return null;
		}
	}
}
