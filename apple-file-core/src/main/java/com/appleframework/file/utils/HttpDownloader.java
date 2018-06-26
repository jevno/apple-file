/**
 * 
 */
package com.appleframework.file.utils;

import java.io.IOException;

import com.appleframework.file.UploadObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class HttpDownloader {

	private static OkHttpClient httpClient = new OkHttpClient();
	
	public static UploadObject read(String url) throws IOException{
		
		Request.Builder requestBuilder = new Request.Builder().url(url);
		Response response = httpClient.newCall(requestBuilder.build()).execute();
		
		UploadObject item = new UploadObject(FilePathHelper.parseFileName(url), response.body().bytes());
		return item;
	}
	
	
}
