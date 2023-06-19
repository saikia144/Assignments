package com.user.crud;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.user.model.Patient;

public class CrudUser {
	private static List<Patient> uList = null;
	
	public static List<Patient> selectAllUser() {
		DataSource ds = null; 
		JdbcTemplate jt = null;
		try{
			ds = SpringJdbcConfig.mysqlDataSource();
			jt = new JdbcTemplate(ds);
			uList = jt.query("select * from patients", BeanPropertyRowMapper.newInstance(Patient.class));

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (jt != null) {
				try {
					jt.getDataSource().getConnection().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (ds != null) {
				try {
					ds.getConnection().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}
		return uList;
	}

	public static void updateUserDb(Patient patient) {
		//"UPDATE user SET uname=?, email=?, country=? where id = ? "
		DataSource ds = null; 
		JdbcTemplate jt = null;
		try{
			ds = SpringJdbcConfig.mysqlDataSource();
			jt = new JdbcTemplate(ds);
			
			String name = patient.getPname();
			String bgroup = patient.getBgroup();
			String disease = patient.getDisease();
			int id = patient.getId();
			
			int result = jt.update("UPDATE patients SET pname=?, bgroup=?, disease=? where id = ? ", new Object[] {name,bgroup,disease,id});
			System.out.println("Updated row: "+result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void deleteUserDb(int id) {
		DataSource ds = null; 
		JdbcTemplate jt = null;
		try{
			ds = SpringJdbcConfig.mysqlDataSource();
			jt = new JdbcTemplate(ds);
			int result = jt.update("delete from patients where id=?", new Object[] {id});
			System.out.println("Deleted row: "+result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void insertUserDb(Patient patient) {
		DataSource ds = null; 
		JdbcTemplate jt = null;
		try {
			ds = SpringJdbcConfig.mysqlDataSource();
			jt = new JdbcTemplate(ds);
			
			String name = patient.getPname();
			String bgroup = patient.getBgroup();
			String disease = patient.getDisease();
			
			int result = jt.update("insert into patients (pname,bgroup,disease) values(?,?,?)", new Object[] {name, bgroup, disease});
			
			System.out.println("Number of rows affected: "+result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
