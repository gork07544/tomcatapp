package com.tvsconsult.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tvsconsult.services.AzureBlobStorage;

@Controller
public class HomeController {

	/*
	
	@Autowired
	AzureBlobStorage abs;
	
	@RequestMapping("/aboutus")
	public ModelAndView aboutUsF(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		return new ModelAndView("aboutus", "message", "");
	}
		
	@RequestMapping("/contacts")
	public ModelAndView contactGet(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		String s = "";
		return new ModelAndView("contacts", "message", s);
	}

	@RequestMapping("/projects")
	public ModelAndView projF(Device device, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		String str = "";
		//Device device = DeviceUtils.getCurrentDevice(request);
		if (device.isMobile()) {
			str = "Hello mobile client!";
        } else if (device.isTablet()) {
        	str = "Hello tablet client!";
        } else {
        	str = "Hello desktop client!";         
        }
		return new ModelAndView("projects", "message", str);
	}

	@RequestMapping(value = "/fileupload", method = RequestMethod.GET)
	public ModelAndView handleFileUploadGet() {
		return new ModelAndView("fileupload", "message", "You can upload a file by click the botton");
	}

	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	public ModelAndView handleFileUploadPost(@RequestParam("file") MultipartFile file) throws InterruptedException, ExecutionException {
		String str = "The file was uploaded and it has size: " + file.getSize() + " and original file name: "
				+ file.getOriginalFilename();
		abs.uploadFileAzureBlob("tvsconsult", file).get();
		return new ModelAndView("fileupload", "message", str );
	}
	
	@RequestMapping(value = "/sendemil", method = RequestMethod.POST)
	public WebAsyncTask<ModelAndView> SendEmailForm(@RequestParam("inputEmail") String inputEmail,
			@RequestParam("inputName") String inputName, 
			@RequestParam("inputTitle") String inputTitle,
			@RequestParam("comment") String comment) throws AddressException, MessagingException{
		final String str = "The function do not work.";
		//ZohoSMTP zo = new ZohoSMTP();
		//zo.sendEmail(comment, inputName, inputTitle, inputEmail);
		
		Callable<ModelAndView> callable = new Callable<ModelAndView>() {
			@Override
			public ModelAndView call() throws Exception {
				
				return new ModelAndView("contacts", "message", str);
			}
		};
		return new WebAsyncTask<ModelAndView>(1000, callable);
	}
	
	
	*/
}
