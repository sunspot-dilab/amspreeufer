package com.vw.dilab.amspreeufer.library.patrons;

import org.junit.Before;

public class PatronsInMemoryRepositoryTest extends PatronsRepositoryTest{

    @Before
    public void setUp() {
        repo = new PatronsInMemoryRepository();
    }

}