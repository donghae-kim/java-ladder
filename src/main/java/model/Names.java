package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Names {
    private static final String SPLIT_DELIMITER = ",";

    private final List<Name> names = new ArrayList<>();

    public Names(String names) {
        for (String name : splitNames(names)) {
            this.names.add(new Name(name));
        }
    }

    private List<String> splitNames(String names) {
        return Arrays.asList(names.split(SPLIT_DELIMITER));
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }

    public Name getName(int index){
        return this.names.get(index);
    }

    public int getNamesSize() {
        return names.size();
    }
}
