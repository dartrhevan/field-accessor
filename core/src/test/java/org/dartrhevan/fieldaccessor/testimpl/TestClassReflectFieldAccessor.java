package org.dartrhevan.fieldaccessor.testimpl;

import org.dartrhevan.fieldaccessor.TestClass;
import org.dartrhevan.fieldaccessor.api.FieldAccessor;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unchecked")
public class TestClassReflectFieldAccessor implements FieldAccessor<TestClass> {
    @Override
    public <V> V get(TestClass obj, @NotNull String fieldName) {
        try {
            var field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return (V) field.get(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <V> void set(TestClass obj, @NotNull String fieldName, V value) {
        try {
            var field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    @Override
    public Class<TestClass> getType() {
        return TestClass.class;
    }
}
