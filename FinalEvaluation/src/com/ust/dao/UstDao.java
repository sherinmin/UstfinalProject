package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.beans.ContactVendor;
import com.ust.beans.Login;

public class UstDao {
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	//UST LOGIN
	
	public Login login(String username, String password) {
		String sql = "select userid from login where username='"
				+ username
				+ "' and password='" + password + "'";
		return jdbcTemplate.queryForObject(sql, new Object[]{},
				new BeanPropertyRowMapper<Login>(Login.class));
	}
	
	//get all vendors
	
	public List<ContactVendor> getVendor() {
		return jdbcTemplate
				.query("select vid,vname,vaddr,vlocation,vservice,vpincode from vendor where isActive=1",
						new RowMapper<ContactVendor>() {
							public ContactVendor mapRow(ResultSet rs, int row)
									throws SQLException {
								ContactVendor vc = new ContactVendor();
								vc.setVid(rs.getInt(1));
								vc.setVname(rs.getString(2));
								vc.setVaddr(rs.getString(3));
								vc.setVlocation(rs.getString(4));
								vc.setVservice(rs.getString(5));
								vc.setVpincode(rs.getLong(6));
								return vc;
							}
						});
	}
	
		
	//get vendor details by id
		public ContactVendor getVendorById(int vid) {
			String sql ="select vc.vid,vc.vname,vc.vaddr,vc.vlocation,vc.vservice,vc.vpincode,cd.name,cd.department,cd.email,cd.phone,cd.cid from vendor vc join contact cd on vc.vid=cd.vid where vc.isActive=1 and vc.vid="+ vid + "";
			return jdbcTemplate.queryForObject(sql,new Object[]{},
					new BeanPropertyRowMapper<ContactVendor>(ContactVendor.class));
		}
					
	
	//Add vendors
	
	public int saveVendor(ContactVendor vc) {

		String sql1 = "insert into vendor(vname,vaddr,vlocation,vservice,vpincode,isActive) values "
				+ "('"
				+ vc.getVname()
				+ "','"
				+ vc.getVaddr()
				+ "','"
				+ vc.getVlocation()
				+ "','"
				+ vc.getVservice()
				+ "','"
				+ vc.getVpincode()
				+ "',1)";

		 jdbcTemplate.update(sql1);
		 
		 Integer maxId = getSequence();
		 String sql2="insert into contact(vid,name,department,email,phone) values ("
				 + maxId
					+ ",'"
					+ vc.getName()
					+ "','"
					+ vc.getDepartment()
					+ "','"
					+ vc.getEmail()
					+ "','" + vc.getPhone() + "')";
		 return jdbcTemplate.update(sql2);

				 
		 
	}
	
	// to get vendor id
	private Integer getSequence() {
		Integer seq;
		String sql = "select MAX(vid)from vendor";
		seq = jdbcTemplate.queryForObject(sql, new Object[] {}, Integer.class);
		return seq;
	}
	
	//update vendor
	public int updateVendor(int vid, ContactVendor vc) {

		String sql = "update vendor set vname='" + vc.getVname()
				+ "' ,vaddr='" + vc.getVaddr() + "' ,vlocation='"
				+ vc.getVlocation() + "',vservice='" + vc.getVservice() + "',vpincode='" + vc.getVpincode() + "',isActive=1 "
				+ "where vid =" + vid;
		jdbcTemplate.update(sql);

		
		String sql1 = "update contact set vid=" + vid + ",name='"
				+ vc.getName() + "',department='"
				+ vc.getDepartment() + "',email='"
				+ vc.getEmail() + "',phone='" + vc.getPhone() + "'where cid = " + vc.getCid();

		return jdbcTemplate.update(sql1);
	}
	
	//get contact details by id

	public List<ContactVendor> getContactDetailsByVid(int vid) {
	return jdbcTemplate.query("select cid,name,department,vid,email,phone from contact where vid="+vid+"", new RowMapper<ContactVendor>() {
		public ContactVendor mapRow(ResultSet rs, int row)
				throws SQLException {
			ContactVendor vc = new ContactVendor();
			vc.setCid(rs.getInt(1));
			vc.setName(rs.getString(2));
			vc.setDepartment(rs.getString(3));
			vc.setVid(rs.getInt(4));
			vc.setEmail(rs.getString(5));
			vc.setPhone(rs.getLong(6));
			return vc;
		}
	});
	}
	
	//to disable vendor
	public int disableVendor(int vid) {

	String sql = "update vendor set isActive=0 where vid=" + vid
	+ "";

	return jdbcTemplate.update(sql);
	}


}
