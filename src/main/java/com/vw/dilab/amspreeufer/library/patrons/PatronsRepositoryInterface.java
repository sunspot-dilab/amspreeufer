package com.vw.dilab.amspreeufer.library.patrons;

import java.util.List;

public interface PatronsRepositoryInterface {
    List<Patron> fetchAll();

    void storePatron(Patron newPatron);
}
