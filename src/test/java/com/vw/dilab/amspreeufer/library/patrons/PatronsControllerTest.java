package com.vw.dilab.amspreeufer.library.patrons;

import com.vw.dilab.amspreeufer.library.DatabaseCleaningTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class PatronsControllerTest extends DatabaseCleaningTest {

    private MockMvc patronsControllerMock;

    @Mock
    PatronsRepositoryInterface patronsRepo;

    private PatronsController subject;

    @Before
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        subject = new PatronsController(patronsRepo);

        patronsControllerMock = MockMvcBuilders.standaloneSetup(subject).build();
    }

    @Test
    public void itSchouldShowThePatronsPage() throws Exception {
        patronsControllerMock.perform(get("/patrons"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void itSchouldAddPatron() throws Exception {
        patronsControllerMock.perform(
                post("/patrons/add")
                        .param("patron_name", "Me")
                        .param("patron_email", "me@example.com")
        )
                .andExpect(status().isOk());

        Patron expectedPatron = Patron.builder().name("Me").email("me@example.com").build();
        verify(patronsRepo).storePatron(expectedPatron);
    }

    @Test
    public void itShouldReturnCSVFile() throws Exception {
        patronsControllerMock.perform(
                get("/patrons/csv")
        ).andExpect(status().isOk())
                .andExpect(content().contentType("text/csv"))
                .andExpect(header().string("Content-disposition", "attachment; filename=patrons.csv"));
    }
}