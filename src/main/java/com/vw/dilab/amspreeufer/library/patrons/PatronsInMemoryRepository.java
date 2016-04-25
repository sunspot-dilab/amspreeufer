package com.vw.dilab.amspreeufer.library.patrons;

import java.util.*;

public class PatronsInMemoryRepository implements PatronsRepositoryInterface {

    private List patronsInMemory = new ArrayList<>();

    @Override
    public List<Patron> fetchAll() {
        return patronsInMemory;
    }


    @Override
    public void storePatron(Patron newPatron) {
        patronsInMemory.add(newPatron);
    }

////why is getEmail() red ? lombok ?
//    public Patron fetchByEmail(String email) {
//
////
////        return patronsInMemory
////                .stream()
////                .filter(
////                        p -> p.getEmail().equals(email)
////                )
////                .findFirst().orElse(null);
////    }

}
