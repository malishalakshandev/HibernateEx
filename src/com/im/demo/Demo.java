package com.im.demo;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.im.model.Address;
import com.im.model.Guardian;
import com.im.model.Member;
import com.im.model.Patient;

public class Demo {

	public static void main(String[] args) {
		
		Member member = new Member();
		
		//SET VALUES
//		member.setId(1);
		member.setName("Malisha Lakshan");
		member.setAddress("Negombo, Sri Lanka");
		member.setAge(21);
		member.setCount(100);
		member.setBirthDay(new Date(1996-10-02));
		member.setJoinDate(new Date());
		member.setTelephone("0771234567");
		
		
		Guardian guardian = new Guardian();
		guardian.setName("Mr. Suneth");
		guardian.setContact("0778945632");
		
		
		Address address = new Address();
		address.setStreet("Main Street");
		address.setCity("Nuwara Eliya");
		address.setCountry("Sri Lanka");
		
		Patient patient = new Patient();
		patient.setName("Kamal Perera");
		patient.setTp("0774512320");
		patient.setAddress(address); //add above entered all address variables to patient table BUT not created Addredd Table
		patient.setGuardian(guardian); //add above entered all guardian variables to patient table AND created Guardian Table with its data
		
		
		//gua
		// pat
		
		
		
		
		/*CREATE SETTIGS FOR TRANSACTION TO TO WORK WITH ABOVE MENTIONED OBJECTS 
		EACH PACKAGE MUST BE COME FROM .hibernate PACKAGE*/
		Configuration config = new Configuration();  
		SessionFactory sf = config.configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction transaction = null;
		try {
			
			transaction = session.beginTransaction();
			
			session.save(guardian);
			session.save(patient);
			session.save(member);
			
//			session.save(new Member());
			transaction.commit();
			
		} catch (Exception e) {
		
			if (transaction != null) {
				transaction.rollback();
			}
			
		}
//		finally {
//			session.close();
//		}
		
		Member m3 = (Member)session.get(Member.class,3);
		System.out.println(m3.getName());
		
		List<Member> list = session.createCriteria(Member.class).list();
		
		for(Member mem : list) {
			System.out.println("name 1 = "+ mem.getName());
			
		}
		
		List<Member> list1 = session.createQuery("from  Member m WHERE m.id <= 3").list();
		
		for(Member mem : list1) {
			System.out.println("name 2 = "+ mem.getName());
			
		}
		
	}
}
