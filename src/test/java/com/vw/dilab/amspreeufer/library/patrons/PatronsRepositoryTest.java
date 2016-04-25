package com.vw.dilab.amspreeufer.library.patrons;

import com.vw.dilab.amspreeufer.library.DatabaseCleaningTest;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;


public abstract class PatronsRepositoryTest extends DatabaseCleaningTest {


    protected PatronsRepositoryInterface repo;

    @Test
    public void itShouldShowAllPatronsFromDataBase() {
        List<Patron> allPatrons = repo.fetchAll();
        assertThat(allPatrons.size(), notNullValue());
    }

    @Test
    public void itSchouldStorePatron() {
        Patron patron = Patron.builder().name("Mikaaaaa").email("mika@f1.com").build();

        repo.storePatron(patron);
        Patron storedPatron = repo.fetchAll().get(0);


        assertThat(repo.fetchAll(), hasSize(1));
        assertThat(storedPatron.getEmail(), Matchers.notNullValue());
        assertThat(storedPatron.getEmail(), equalTo("mika@f1.com"));
        assertThat(storedPatron.getName(), equalTo(patron.getName()));
    }


}