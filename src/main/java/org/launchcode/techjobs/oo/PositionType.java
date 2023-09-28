package org.launchcode.techjobs.oo;

import java.util.Objects;

public class PositionType extends JobField{
    public PositionType(String value) {
       super(value);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionType that)) return false;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
