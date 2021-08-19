package test2;

public class Employee {

	private String name;
	private double hourlyWage;
	private double weeklyPay;
	/*
	public Employee() {
		name = "N/A";
		hourlyWage = 0;
	}
	
	
	
	
	public Employee(String name, double hourlyWage) {
		super();
		System.out.println("super name:" + getName());
		System.out.println("super name:" + getHourlyWage());
		this.name = name;
		this.hourlyWage = hourlyWage;
	}*/




	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHourlyWage() {
		return hourlyWage;
	}
	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	public double getWeeklyPay() {
		return weeklyPay;
	}
	public void setWeeklyPay(double weeklyPay) {
		this.weeklyPay = weeklyPay;
	}

	
	
}
