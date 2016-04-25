package com.vw.dilab.amspreeufer.library;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@WebIntegrationTest(randomPort = true)
public class DashboardControllerTest extends DatabaseCleaningTest{
    MockMvc mockDashboardController;

    @Autowired
    WebApplicationContext wac;

    @Before
    public void setUp() throws Exception {

        //why not stand alone
//        mockDashboardController = standaloneSetup(DashboardController.class).build();
        MockitoAnnotations.initMocks(this);
        mockDashboardController = MockMvcBuilders.webAppContextSetup(wac).dispatchOptions(true).build();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void itShouldBuildDashboard() throws Exception {
        mockDashboardController.perform(get("/"))
                .andExpect(
                        status().is2xxSuccessful()
                );
    }
}