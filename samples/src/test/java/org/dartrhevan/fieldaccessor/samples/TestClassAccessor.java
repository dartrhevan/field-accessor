package org.dartrhevan.fieldaccessor.samples;

import org.dartrhevan.fieldaccessor.api.FieldAccessorFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClassAccessor {

    private final TestClass testObj = new TestClass(1, "qer", LocalDate.now());

    @Test
    void testGetter() {
        var accessor = FieldAccessorFactory.INSTANCE.getFieldAccessorFor(TestClass.class);
        assertAll(() -> {
            //TODO: optimize primitives
            assertEquals(testObj.getF1(), (Integer) accessor.get(testObj, "f1"));
            assertEquals(testObj.getF2(), accessor.get(testObj, "f2"));
            assertEquals(testObj.getF3(), accessor.get(testObj, "f3"));
        });
    }
}
