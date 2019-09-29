package com.ust.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.beans.ContactVendor;
import com.ust.beans.Login;
import com.ust.dao.UstDao;


@RestController
public class UstController {
	@Autowired
	UstDao udao;
	
	// verify login
	@ResponseBody
	@RequestMapping(value = "/api/{username}/{password}", method = RequestMethod.GET)
	public Login login(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		return udao.login(username, password);
	}

	// view vendor list
	@ResponseBody
	@RequestMapping(value="/api/findvendor", method= RequestMethod.GET)
	public List<ContactVendor> findAllVendor(){
		List<ContactVendor> List = udao.getVendor();
		return List;
	}
	//Find By vendor Id
	
	@RequestMapping(value = "/api/vendors/{vid}", method = RequestMethod.GET)
	@ResponseBody
	public ContactVendor getvendors(Model m, @PathVariable("vid") int vid) {
	
		return udao.getVendorById(vid);
	
	}

	// Inserting vendor details
	@ResponseBody
	@RequestMapping(value="/api/insertvendor", method={RequestMethod.POST, RequestMethod.GET})
	public void insertvendor(@RequestBody ContactVendor v){
		udao.saveVendor(v);	
	}
	//Updating vendor details
	@ResponseBody
	@RequestMapping(value = "/api/updatevendor", method = RequestMethod.PUT)
	public void updateVendor(@RequestBody ContactVendor vc) throws ParseException {
		int vid = vc.getVid();
		int cid = vc.getCid();
		udao.updateVendor(vid, vc);
	}


	//Disable by Vendor ID
	@ResponseBody
	@RequestMapping(value="/api/disable/{vid}", method=RequestMethod.PUT)
	public void disable(@PathVariable("vid") int vid){
		udao.disableVendor(vid);	
	}
	
	
	// view contact list
	@RequestMapping(value = "/api/contactDetails/{vid}", method = RequestMethod.GET)
	@ResponseBody
	public List getContactDetails(Model m,@PathVariable("vid") int vid) {
		List list;
	list=udao.getContactDetailsByVid(vid);
	return list;

	}

	
	

}
