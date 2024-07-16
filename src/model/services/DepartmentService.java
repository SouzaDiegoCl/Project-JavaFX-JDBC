package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {

	private DepartmentDao dao = DaoFactory.createDepartmentDao();
	
	public List<Department> findAll(){
		//Mockagem dos dados (Retornar dados 'falsos')
		/*List<Department> list = new ArrayList<Department>();
		list.add(new Department(1, "Livros"));
		list.add(new Department(2, "Computadores"));
		list.add(new Department(3, "Eltrônicos"));
		return list;
		*/
		return dao.findAll();
	}
	
	public void SaveOrUpdate(Department obj) {
		if(obj.getId() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
	
}
