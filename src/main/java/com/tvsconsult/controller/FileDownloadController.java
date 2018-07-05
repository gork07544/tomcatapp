package com.tvsconsult.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.tvsconsult.services.AzureBlobStorage;

@Controller
@RequestMapping("/download")
public class FileDownloadController {

	/*
    @Autowired
    AzureBlobStorage abs;
	
	@RequestMapping(method = RequestMethod.GET)
	public void doDownload(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "containerName", required = true) String containerName,
			@RequestParam(value = "filename", required = true) String filename)
			throws IOException, InvalidKeyException, URISyntaxException, StorageException, InterruptedException, ExecutionException {

		CloudBlob blob = abs.downLoadFileAzureBlob(containerName, filename).get();
		InputStream instr = blob.openInputStream();

		String fileExt = filename.substring(filename.lastIndexOf(".") + 1);
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		if(fileExt.equals("txt"))
			response.setContentType("text/plain");
		if(fileExt.equals("jpg"))
			response.setContentType("image/jpeg");
		if(fileExt.equals("pdf"))
			response.setContentType("application/pdf");
		if(fileExt.equals("docx")){
			response.setContentType("application/octet-stream");
			String headerValue = String.format("attachment; filename=\"%s\"", filename);
			response.setHeader("Content-Disposition", headerValue);
		}

		ServletOutputStream ostream = response.getOutputStream();
		IOUtils.copy(instr, ostream);
		ostream.flush();
		ostream.close();
		instr.close();
		
	}
	
	*/
}
