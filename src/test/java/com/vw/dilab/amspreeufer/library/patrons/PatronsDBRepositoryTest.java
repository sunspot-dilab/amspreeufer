package com.vw.dilab.amspreeufer.library.patrons;

import com.vw.dilab.amspreeufer.library.LibApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

public class PatronsDBRepositoryTest extends PatronsRepositoryTest {

    @Autowired
    PatronsDBRepository patronsRepo;


    @Before
    public void setUp() {
        repo = patronsRepo;
    }

}