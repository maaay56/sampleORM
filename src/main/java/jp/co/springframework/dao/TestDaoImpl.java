package jp.co.springframework.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.transaction.annotation.Transactional;

public class TestDaoImpl implements TestDao<Test> {

	public SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Test> getAll() {
		Session sess = sessionFactory.openSession();
		Query q = sess.getNamedQuery("getAll");

		List tests = q.list();
		return tests;
	}

	@Override
	@Transactional
	public void add(Test test) {
		Session sess = sessionFactory.openSession();
		Query q = sess.getNamedQuery("insert");
		q.setParameter("id", test.getId());
		q.setParameter("name", test.getName());

		q.executeUpdate();
	}
}
