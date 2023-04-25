package com.jdbc.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Scanner;

import com.jdbc.model.Employee;

public class EmployeeMain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		int choice = -1;
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		File file = new File("employee.txt");
		ArrayList<Employee> al = new ArrayList<Employee>();
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		ListIterator<Employee> li = null;

		if (file.isFile()) {
			ois = new ObjectInputStream(new FileInputStream(file));
			al = (ArrayList<Employee>) ois.readObject();
			ois.close();
		}

		do {
			System.out.println("1.Insert");
			System.out.println("2.Display");
			System.out.println("3.Search");
			System.out.println("4.Delete");
			System.out.println("5.Update");
			System.out.println("6.Sort By Emp No.");
			System.out.println("7.Sort By Emp No. in File");
			System.out.println("8.Sort By Emp Name");
			System.out.println("9.Sort By Emp Name in File");
			System.out.println("3.Exit");

			System.out.println("Enter your Choice");

			choice = sc.nextInt();

			switch (choice) {
			case 1:

				System.out.println("How many Employees Need tp Add");
				int n = sc.nextInt();

				for (int i = 0; i < n; i++) {

					System.out.println("Enter Emp No.");
					int empno = sc.nextInt();

					System.out.println("Enter Emp Name");
					String empName = sc1.nextLine();

					System.out.println("Enter Emp Salary");
					int empSal = sc.nextInt();

					al.add(new Employee(empno, empName, empSal));

				}
				oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(al);
				oos.close();
				break;
			case 2:

				if (file.isFile()) {
					ois = new ObjectInputStream(new FileInputStream(file));
					al = (ArrayList<Employee>) ois.readObject();
					ois.close();

					System.out.println("***********************************");
					li = al.listIterator();
					while (li.hasNext()) {
						System.out.println(li.next());
					}
					System.out.println("***********************************");

				}
				break;

			case 3:
				if (file.isFile()) {

					ois = new ObjectInputStream(new FileInputStream(file));
					al = (ArrayList<Employee>) ois.readObject();
					ois.close();

					boolean found = false;
					System.out.println("Enter Employee No to Search");
					int empnoSearch = sc.nextInt();
					System.out.println("***********************************");
					li = al.listIterator();
					while (li.hasNext()) {
						Employee e = (Employee) li.next();
						if (e.getEmpNo() == empnoSearch) {
							System.out.println(e);
							found = true;
						}
					}

					System.out.println("***********************************");

				} else {
					System.out.println("File Doesn't Exist......!");
				}

				break;
			case 4:
				if (file.isFile()) {
					ois = new ObjectInputStream(new FileInputStream(file));
					al = (ArrayList<Employee>) ois.readObject();
					ois.close();

					boolean found = false;
					System.out.println("Enter the Employee No to Delete");
					int empnoDelete = sc.nextInt();
					System.out.println("******************************");
					li = al.listIterator();
					while (li.hasNext()) {
						Employee e1 = (Employee) li.next();
						if (e1.getEmpNo() == empnoDelete) {
							li.remove();
							found = true;
						}

					}
					if (found) {
						oos = new ObjectOutputStream(new FileOutputStream(file));
						oos.writeObject(al);
						oos.close();
						System.out.println("Record Deleted Successfully.....!");
					} else {
						System.out.println("Record Not Found");
					}
				} else {
					System.out.println("File Doesnt Exist...!");
				}
				break;

			case 5:
				if (file.isFile()) {
					ois = new ObjectInputStream(new FileInputStream(file));
					al = (ArrayList<Employee>) ois.readObject();
					ois.close();

					boolean found = false;
					System.out.println("Enter Employee No To Update");
					int empNoUpdate = sc.nextInt();

					System.out.println("***********************");

					li = al.listIterator();
					while (li.hasNext()) {
						Employee e2 = (Employee) li.next();
						if (e2.getEmpNo() == empNoUpdate) {

							System.out.println("Enter Employee Name To Update");
							String name = sc1.nextLine();

							System.out.println("Enter Emplyee Salary to Update");
							int sal = sc.nextInt();

							li.set(new Employee(empNoUpdate, name, sal));

							found = true;
						}
					}

					if (found) {
						oos = new ObjectOutputStream(new FileOutputStream(file));
						oos.writeObject(al);
						oos.close();

						System.out.println("Record Updated Successfully.....!");

					} else {
						System.out.println("Record Not Found");
					}
				} else {
					System.out.println("File Does not Exist....!");
				}
				break;

			case 6:
				if (file.isFile()) {
					ois = new ObjectInputStream(new FileInputStream(file));
					al = (ArrayList<Employee>) ois.readObject();
					ois.close();

					System.out.println("Sort the Employee by Emp No.");

					Collections.sort(al, new Comparator<Employee>() {

						@Override
						public int compare(Employee e1, Employee e2) {

							return e1.getEmpNo() - e2.getEmpNo();
						}

					});
					
					System.out.println("************************************");
					li = al.listIterator();
					while (li.hasNext()) {
						System.out.println(li.next());
					
					}System.out.println("************************************");
				}else
				{
					System.out.println("File Doesnt Exists......!");
				}
				break;
				
			case 7:
				if(file.isFile()) {
					ois=new ObjectInputStream(new FileInputStream(file));
					al=(ArrayList<Employee>) ois.readObject();
					ois.close();
					
					System.out.println("Sort the Employee by EmpNo in File .");
					
					Collections.sort(al,new Comparator<Employee>() {

						@Override
						public int compare(Employee e1, Employee e2) {
							// TODO Auto-generated method stub
							return e1.getEmpNo()-e2.getEmpNo();
						}
					});
					
					oos=new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(al);
					oos.close();
					
					System.out.println("************************************");
					li=al.listIterator();
					while(li.hasNext()) {
						System.out.println(li.next());
					}
					System.out.println("************************************");
				}
				else
				{
					System.out.println("File Doesn't Exists");
				}
				break;
				
				
			case 8:
				
				if(file.isFile()) {
					ois=new ObjectInputStream(new FileInputStream(file));
					al=(ArrayList<Employee>) ois.readObject();
					ois.close();
					
					Collections.sort(al,new Comparator<Employee>() {

						@Override
						public int compare(Employee e1, Employee e2) {
							
							return e1.getEmpName().compareTo(e2.getEmpName());
						}
						
					});
					li=al.listIterator();
					while(li.hasNext()) {
						System.out.println(li.next());
					}
					
				}else
				{
					System.out.println("File Doesn't Exists");
				}
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}

		} while (choice != 0);

	}

}
