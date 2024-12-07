package com.vehiclemanagement.vehicle.management.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;



import org.springframework.stereotype.Service;

import com.vehiclemanagement.vehicle.management.domain.Vehicle;



@Service
public class vehicleService {
	List<Vehicle> vehicle = new ArrayList<>();

	public static void main(String[] args) {

//		vehicleService vehicleservice = new vehicleService();
//		List<Vehicle> getall = vehicleservice.getvehicles();
//		System.out.println("List of vehicles:-------");
//		getall.forEach(System.out::println);
//		
//		 Vehicle v11=new Vehicle(11, "B11", "Mercedes", "KA01AB1235", "benz", "Red", 2015,"suresh Kumar", "Available");
//		 vehicleservice.addVehicle(v11);
//		 System.out.println("Added Successfully");
//		 System.out.println(v11); 
//		 
//		 List<Vehicle>	modified =vehicleservice.modifyVehicle(getall, 4, "Not Available")	; 
//		 System.out.println("Modified vehicle :");
//		for(Vehicle modify:modified) {
//			System.out.println(modify);
//		}
//		
//		List<Vehicle> deleted= vehicleservice.deleteVehicle(getall, 11);
//		if( !deleted.isEmpty() ){
//			
//		System.out.println("deleted vehicle :");
//		for(Vehicle delete:deleted) {
//		System.out.println(delete);
//		}
//		}else {
//			System.out.println("------id not matching------");
//		}
//		
//		 
//		 
			
		 
		 
	}

	public List<Vehicle> getvehicles() {

		 if (vehicle.isEmpty()) {
		        vehicle.add(new Vehicle(1, "Swift Dzire", "Maruti Suzuki", "KA01AB1234", "Sedan", "White", 2019, "Ramesh Kumar", "Available"));
		        vehicle.add(new Vehicle(2, "XUV500", "Mahindra", "MH12XY6789", "SUV", "Black", 2021, "Priya Sharma", "On Rent"));
		        vehicle.add(new Vehicle(3, "Activa 6G", "Honda", "TN10BC4567", "Scooter", "Red", 2020, "Ankit Verma", "Available"));
		        vehicle.add(new Vehicle(4, "Nexon EV Max", "Tata Motors", "DL4CN7890", "Electric SUV", "Blue", 2022, "SuSunita Joshi", "In Service"));
		        vehicle.add(new Vehicle(5, "Pulsar 220F", "Bajaj", "GJ06MN3456", "Bike", "Grey", 2018, "Vikas Patel", "Available"));
		        vehicle.add(new Vehicle(6, "Creta", "Hyundai", "AP09CD7890", "SUV", "White", 2020, "Sneha Reddy", "On Rent"));
		        vehicle.add(new Vehicle(7, "Eeco", "Maruti Suzuki", "UP14QR4567", "Van", "Silver", 2017, "Mohan Lal", "Available"));
		        vehicle.add(new Vehicle(8, "Fortuner", "Toyota", "RJ23UV6789", "SUV", "Black", 2023, "Rajesh Khurana", "Reserved"));
		        vehicle.add(new Vehicle(9, "Scorpio-N", "Mahindra", "WB19KL1234", "SUV", "Green", 2022, "Arjun Das", "In Service"));
		        vehicle.add(new Vehicle(10, "Splendor Plus", "Hero", "HR26OP3456", "Bike", "Blue", 2015, "Neha Gupta", "Available"));
		    }
		    return vehicle;
		
	}
	
	public Map<String,List<Vehicle>> groupByAvailability(List<Vehicle> Vehicle ){
		Map<String, List<Vehicle>> gbs= new HashMap<>();
		 for(Vehicle v:vehicle) {
			 String status= v.getStatus();
			 gbs.putIfAbsent(status, new ArrayList<>());
			 gbs.get(status).add(v);
			
			 
			}return gbs;
			
	}
	
	public void addVehicle(Vehicle addvehicle ){
		if(addvehicle != null) {
			vehicle.add(addvehicle);
		}
	}
		public Vehicle modifyVehicle(List<Vehicle>vehicle,int id, String Status){
			
			for(Vehicle iterate:vehicle ) {
				if(iterate.getId()==id) {
					iterate.setStatus(Status);
					return iterate;
				}
			}return null;
		}
		public Vehicle updatetype(List<Vehicle> vehicle, int id,int year) {
			for(Vehicle v:vehicle) {
				if(v.getId()==id) {
					v.setYear(year);
					return v;
				}
			} return null;
		}
		
			
		
		
	public  Vehicle  deleteVehicle(List<Vehicle> vehicle, int id) {
		for (Vehicle v : vehicle) {
	        if (v.getId() == id) {
	            vehicle.remove(v);  
	            return v;  
	        }
	    }
	    return null;  
	}
	public Vehicle getById(List<Vehicle>vehicle, int id) {
		for(Vehicle vehi:vehicle)
			if(vehi.getId()==id) {
				return vehi;
				
				
			}return null;
		
			
	}
	public List<Vehicle> getbyAvailability(List<Vehicle> vehicle, String status){
		if (status == null || status.trim().isEmpty()) {
	        return new ArrayList<>(); 
	    }
		 status = status.trim().toLowerCase(); 
		List<Vehicle> available=new ArrayList<>();
		for(Vehicle v:vehicle) {
			String vehicleStatus = v.getStatus().trim().toLowerCase();

	      
	        if (vehicleStatus.equals(status)) {
	            available.add(v); // Add matching vehicle to the list
	        }
	    }

		return available;
	}
	
	public List<Vehicle> getLatestVehicles(List<Vehicle> vehicle , int year ){
		List<Vehicle> latest=new ArrayList<>();
		for(Vehicle v:vehicle) {
			if(v.getYear()>= year) {
				latest.add(v);
				
			}
			
		}return latest;
	}

}
