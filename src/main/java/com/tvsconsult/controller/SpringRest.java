package com.tvsconsult.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import com.tvsconsult.services.ZohoSMTP;

@RestController
public class SpringRest {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

    @Autowired
    ZohoSMTP zoho;
    
	@RequestMapping(value = "/springrest" , method = RequestMethod.GET, produces="application/json")
	public WebAsyncTask<Greeting> greeting(@RequestParam(value = "name", defaultValue = "World", required = false) final String name) throws InterruptedException, AddressException, MessagingException {
		
		//zoho.sendEmail("jorko", "zxczxczxcz", "zxczxcczc", "georgi.antonov.andonov@gmail.com");
		
			Callable<Greeting> callable = new Callable<Greeting>() {
				@Override
				public Greeting call() throws Exception {
					return new Greeting(counter.incrementAndGet(), String.format(template, name));
				}
			};
			return new WebAsyncTask<Greeting>(1000, callable);
	}
	
	public class Greeting {
		private final long id;
		private final String content;

		public Greeting(long id, String content) {
			this.id = id;
			this.content = content;
		}

		public long getId() {
			return id;
		}

		public String getContent() {
			return content;
		}
	}
}
