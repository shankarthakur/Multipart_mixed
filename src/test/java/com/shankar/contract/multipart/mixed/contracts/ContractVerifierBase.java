package com.shankar.contract.multipart.mixed.contracts;

import com.shankar.contract.multipart.mixed.controller.ApplicationController;
import com.shankar.contract.multipart.mixed.service.ApplicationService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplicationController.class)
public class ContractVerifierBase {


    @MockBean
    ApplicationService applicationService;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
        RestAssuredMockMvc.standaloneSetup(ApplicationController.class);
    }
}
