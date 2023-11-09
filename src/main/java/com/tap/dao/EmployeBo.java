package com.tap.dao;

import com.tap.model.Employe;

public interface EmployeBo {

	public int save(Employe e);
	public int update(Employe e);
	public int delete(int id);
	public int delete(Employe e);
	Employe get(int id);
	
}
