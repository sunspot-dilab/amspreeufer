package com.vw.dilab.amspreeufer.library.patrons;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatronDBMapper implements RowMapper<Patron> {

    @Override
    public Patron mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        return new Patron(resultSet.getString(1), resultSet.getString(2));
    }
}
