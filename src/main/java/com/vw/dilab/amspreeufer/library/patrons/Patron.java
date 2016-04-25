package com.vw.dilab.amspreeufer.library.patrons;

import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude={"name"})
@Builder
public class Patron {

    private String name;

    @NonNull
    private String email;

}
