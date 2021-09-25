package hu.ekcu.java.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
class ArraySlices implements ArraySliceValidator, Cloneable {
    List<ArraySlice> slices;

    @Override
    public boolean validate() {
        return slices.stream()
                .map(ArraySlice::validate)
                .reduce(true, (subtotal, element) -> subtotal && element);
    }

    @Override
    public ArraySlices clone() throws CloneNotSupportedException {
        ArraySlices clone = new ArraySlices();
        slices.forEach(slice -> {
            try {
                clone.slices.add(slice.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        });
        return clone;
    }
}

@AllArgsConstructor
class ArraySlice implements ArraySliceValidator, Cloneable {
    String[] segment;

    @Override
    public boolean validate() {
        return segment.length > 0 && segment[0].equals(segment[segment.length - 1]);
    }

    @Override
    public ArraySlice clone() throws CloneNotSupportedException {
        return new ArraySlice(segment);
    }
}
