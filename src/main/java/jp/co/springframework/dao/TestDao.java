package jp.co.springframework.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

public interface TestDao<T> extends Serializable {

	public void setSessionFactory(SessionFactory sessionFactory);

	public List<T> getAll();
	public void add(Test test);
}
