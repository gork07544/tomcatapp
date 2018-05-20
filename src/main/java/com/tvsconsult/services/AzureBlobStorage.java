package com.tvsconsult.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;

@Service("AzureBlobStorage")
public class AzureBlobStorage{

	@Autowired
	public CloudBlobClient cloudBlobClient;
		
	private final String appPath = System.getenv("OPENSHIFT_DATA_DIR");

	@Async
	public Future<String> listAllFiles() {
		// Retrieve storage account from connection-string.
		String stt = "";
		try {
			// Retrieve reference to a previously created container.
			CloudBlobContainer container = cloudBlobClient.getContainerReference("tvsconsult");

			// Loop over blobs within the container and output the URI to each
			// of them.
			for (ListBlobItem blobItem : container.listBlobs()) {
				stt = stt + blobItem.getUri() + " \n ";
			}
		} catch (Exception e) {
			// Output the stack trace.
			e.printStackTrace();
		}
		
		return new AsyncResult<String>(stt);
	}

	@Async
	public Future<String> uploadFileAzureBlob(String containerName, MultipartFile file) {
		try {
			// Retrieve reference to a previously created container.
			CloudBlobContainer container = cloudBlobClient.getContainerReference(containerName);
			// Create or overwrite the "myimage.jpg" blob with contents from a
			// local file.
			CloudBlockBlob blob = container.getBlockBlobReference(file.getOriginalFilename());
			blob.upload(file.getInputStream(), file.getSize());
		} catch (Exception e) {
			// Output the stack trace.
			e.printStackTrace();
		}
		return new AsyncResult<String>("Done");
	}

	@Async
	public Future<String> uploadFileAzureBlobOpenShift(String containerName, String blobName) {
		try {
			// Retrieve reference to a previously created container.
			CloudBlobContainer container = cloudBlobClient.getContainerReference(containerName);
			// Define the path to a local file.
			final String filePath = appPath + blobName;
			// Create or overwrite the "myimage.jpg" blob with contents from a
			// local file.
			CloudBlockBlob blob = container.getBlockBlobReference(blobName);
			File source = new File(filePath);
			blob.upload(new FileInputStream(source), source.length());
		} catch (Exception e) {
			// Output the stack trace.
			e.printStackTrace();
		}

		return new AsyncResult<String>("Done");
	}
	
	@Async
	public Future<CloudBlob> downLoadFileAzureBlob(String containerName, String blobName)
			throws InvalidKeyException, URISyntaxException, StorageException {
		// Retrieve reference to a previously created container.
		CloudBlobContainer container = cloudBlobClient.getContainerReference(containerName);
		CloudBlockBlob blockBlob = container.getBlockBlobReference(blobName);
		return new AsyncResult<CloudBlob>(blockBlob);
	}

	@Async
	public Future<String> createFile() {
		BufferedWriter bufferedWriter = null;
		try {
			String strContent = "This example shows how to write string content to a file";
			File myFile = new File(appPath + "MyTestFile.txt");
			// check if file exist, otherwise create the file before writing
			if (!myFile.exists()) {
				myFile.createNewFile();
			}
			Writer writer = new FileWriter(myFile);
			bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(strContent);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedWriter != null)
					bufferedWriter.close();
			} catch (Exception ex) {

			}
		}
		return new AsyncResult<String>("Done");
	}

	@Async
	public Future<String> createFolder() {
		String appPath = System.getenv("OPENSHIFT_DATA_DIR");
		new File(appPath + "Directory1").mkdir();
		return new AsyncResult<String>("Done");
	}

}
