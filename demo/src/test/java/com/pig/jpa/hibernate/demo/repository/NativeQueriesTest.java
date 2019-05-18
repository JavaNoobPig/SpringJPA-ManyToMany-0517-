package com.pig.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.pig.jpa.hibernate.demo.DemoApplication;
import com.pig.jpa.hibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class NativeQueriesTest {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	@Test
	public void native_query_basic() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE",Course.class);
		List resultlist = query.getResultList();
		logger.info("SELECT * FROM COURSE ->{}",resultlist);
	}
	@Test
	public void native_query_with_parameter() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE where id = ?",Course.class);
		query.setParameter(1, 10001L);  //setParameter(序號, 名稱)注意序號由1開始
		List resultlist = query.getResultList();
		logger.info("SELECT * FROM COURSE where id = ?->{}",resultlist);
	}
	
	@Test
	public void native_query_with_anmed_parameter() {
		Query query = em.createNativeQuery("SELECT * FROM COURSE where id = :id",Course.class);
		query.setParameter("id", 10001L); 
		List resultlist = query.getResultList();
		logger.info("SELECT * FROM COURSE where id = :id->{}",resultlist);
	}
	
	@Test
	@Transactional
	public void native_query_to_update() {
		Query query = em.createNativeQuery("Update Course set last_update_date=sysdate()",Course.class);
		int noOfRowUpdated = query.executeUpdate();
		logger.info("noOfRowUpdated->{}",noOfRowUpdated);
	}
	

}
