package org.dartrhevan.fieldaccessor.testimpl;

import org.dartrhevan.fieldaccessor.TestClass;
import org.dartrhevan.fieldaccessor.api.FieldAccessor;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

@SuppressWarnings("unchecked")
public class TestClassMapFieldAccessor implements FieldAccessor<TestClass> {
    private final Map<String, Function<TestClass, ?>> getters = Map.of(
            "f1", TestClass::getF1,
            "f2", TestClass::getF2,
            "f3", TestClass::getF3,
            "f4", TestClass::getF4,
            "f5", TestClass::getF5,
            "f6", TestClass::getF6,
            "f7", TestClass::getF7,
            "f8", TestClass::getF8
    );
    private final Map<String, BiConsumer<TestClass, Object>> setters = Map.of(
            "f1", (t, v) -> t.setF1((int) v),
            "f2", (t, v) -> t.setF2((String) v),
            "f3", (t, v) -> t.setF3((String) v),
            "f4", (t, v) -> t.setF4((String) v),
            "f5", (t, v) -> t.setF5((String) v),
            "f6", (t, v) -> t.setF6((String) v),
            "f7", (t, v) -> t.setF7((String) v),
            "f8", (t, v) -> t.setF8((String) v)
    );

    @Override
    public <V> V get(TestClass obj, @NotNull String fieldName) {
        return (V) getters.get(fieldName).apply(obj);
    }

    @Override
    public <V> void set(TestClass obj, @NotNull String fieldName, V value) {
        setters.get(fieldName).accept(obj, value);
    }
}
