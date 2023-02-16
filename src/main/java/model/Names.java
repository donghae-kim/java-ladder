package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Names {
    private final List<Name> Names = new ArrayList<>();

    public Names(List<String> names) {
        for (String name : names) {
            Names.add(new Name(name));
        }
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(Names);
    }

}
