package com.haygroup.spring.samples.dao;

import com.haygroup.spring.samples.entity.Vehicle;

public interface VehicleDao {
	public void insert(Vehicle vehicle);
	public void update(Vehicle vehicle);
	public void delete(Vehicle vehicle);
	public Vehicle findByVehicleNo(String vehicleNo);
}
