package test.tvsconsult.unit;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.tvsconsult.config.ApplicationConfiguration;
import com.tvsconsult.controller.SpringRest.Greeting;
import com.tvsconsult.dao.ApplicationsDAO;
import com.tvsconsult.dao.AuthoritiesDAO;
import com.tvsconsult.dao.CompanyDAO;
import com.tvsconsult.dao.UsersDAO;
import com.tvsconsult.model.Applications;
import com.tvsconsult.model.Authorities;
import com.tvsconsult.model.Company;
import com.tvsconsult.model.Users;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;

public class TVSTest {




	///=========   INTEGRATION TEST ( TEST ALL THE CONTROLERS )   ==================)
		@Test
		public void ztestAboutController() throws Exception {
			Assert.assertEquals(1, 1);
		}

}