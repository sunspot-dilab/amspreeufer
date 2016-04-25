package com.vw.dilab.amspreeufer.library.patrons;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatronsDBRepository implements PatronsRepositoryInterface {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PatronsDBRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Patron> fetchAll() {
        String sqlSelectAll = "SELECT patron_name, patron_email FROM patrons ORDER BY id ";
        return jdbcTemplate.query(sqlSelectAll, new PatronDBMapper());
    }

    @Override
    public void storePatron(Patron newPatron) {
        String sqlInsert = "insert into patrons(patron_name, patron_email) values (?,?) ";
        jdbcTemplate.update(
                sqlInsert,
                new Object[]{newPatron.getName(), newPatron.getEmail()});
    }
}
