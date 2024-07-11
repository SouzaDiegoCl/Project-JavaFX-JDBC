package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Department;

public class DepartmentService {

	public List<Department> findAll(){
		//Mockagem dos dados (Retornar dados 'falsos')
		List<Department> list = new ArrayList<Department>();
		list.add(new Department(1, "Livros"));
		list.add(new Department(2, "Computadores"));
		list.add(new Department(3, "Eltrônicos"));
		return list;
	}
	
}
