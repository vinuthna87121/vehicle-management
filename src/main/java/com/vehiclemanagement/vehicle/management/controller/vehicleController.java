package com.vehiclemanagement.vehicle.management.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vehiclemanagement.vehicle.management.domain.Vehicle;
import com.vehiclemanagement.vehicle.management.service.vehicleService;

@RequestMapping("/vms")
@RestController
public class vehicleController {

	@Autowired
	vehicleService vehicleservice;

	@GetMapping("/getall")
	public List<Vehicle> getallvehicles() {
		return vehicleservice.getvehicles();

	}

	@GetMapping("/groupByStatus")
	public Map<String, Integer> groupByStatus() {
		List<Vehicle> getall = getallvehicles();
		Map<String, List<Vehicle>> groupedVehicles = vehicleservice.groupByAvailability(getall);

		// Prepare a result map that only includes the count of vehicles per status
		Map<String, Integer> result = new HashMap<>();

		for (Map.Entry<String, List<Vehicle>> entry : groupedVehicles.entrySet()) {
			String status = entry.getKey();
			List<Vehicle> vehiclesInStatus = entry.getValue();

			int count = vehiclesInStatus.size();

			result.put(status, count);
		}

		return result;
	}

	@GetMapping("/getbyId/{id}")
	public ResponseEntity<Vehicle> getById(@PathVariable int id) {
		Vehicle byid = vehicleservice.getById(getallvehicles(), id);
		if (byid != null) {

			return ResponseEntity.ok(byid);
		} else {
			// If vehicle is not found, return 404 Not Found
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@GetMapping("/getByStatus/{status}")
	public ResponseEntity<List<Vehicle>> getByStatus(@PathVariable String status) {

		List<Vehicle> avail = vehicleservice.getbyAvailability(getallvehicles(), status);
		if (avail != null) {
			return ResponseEntity.ok(avail);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/updateYear")
	public ResponseEntity<Vehicle> updateYear(@RequestParam int id, @RequestParam int year) {
		Vehicle updtey = vehicleservice.updatetype(getallvehicles(), id, year);
		if (updtey != null) {
			return ResponseEntity.ok(updtey);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/latest/{year}")
	public ResponseEntity<List<Vehicle>> getlatest(@PathVariable int year) {
		List<Vehicle> latst = vehicleservice.getLatestVehicles(getallvehicles(), year);
		if (latst != null) {
			return ResponseEntity.ok(latst);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Vehicle> updatevehicle(@RequestParam int id, @RequestParam String newStatus) {

		List<Vehicle> allVehicles = getallvehicles();

		Vehicle updatedVehicle = vehicleservice.modifyVehicle(allVehicles, id, newStatus);

		if (updatedVehicle != null) {
			return ResponseEntity.ok(updatedVehicle);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/create")
	public ResponseEntity<Vehicle> createvehicle(@RequestBody Vehicle vehicle) {
		vehicleservice.addVehicle(vehicle);
		return new ResponseEntity<>(vehicle, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Vehicle> deletevehicle(@PathVariable int id) {
		Vehicle deletedvehicle = vehicleservice.deleteVehicle(getallvehicles(), id);
		if (deletedvehicle != null) {
			return ResponseEntity.noContent().build();
		} else {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
