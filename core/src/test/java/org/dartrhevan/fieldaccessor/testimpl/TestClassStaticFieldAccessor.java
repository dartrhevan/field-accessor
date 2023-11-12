package org.dartrhevan.fieldaccessor.testimpl;

import org.dartrhevan.fieldaccessor.TestClass;
import org.dartrhevan.fieldaccessor.api.FieldAccessor;
import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;


@SuppressWarnings("unchecked")
public class TestClassStaticFieldAccessor implements FieldAccessor<TestClass> {
    @Override
    public <V> V get(TestClass obj, @NotNull String fieldName) {
        switch (fieldName) {
            case "f1":
                return (V) ((Object) obj.getF1());
            case "f2":
                return (V) ((Object) obj.getF2());
            case "f3":
                return (V) ((Object) obj.getF3());
            case "f4":
                return (V) ((Object) obj.getF4());
            case "f5":
                return (V) ((Object) obj.getF5());
            case "f6":
                return (V) ((Object) obj.getF6());
            case "f7":
                return (V) ((Object) obj.getF7());
            case "f8":
                return (V) ((Object) obj.getF8());
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public <V> void set(TestClass obj, @NotNull String fieldName, V value) {
        switch (fieldName) {
            case "f1":
                obj.setF1((int) value);
                break;
            case "f2":
                obj.setF2((String) value);
                break;
            case "f3":
                obj.setF3((String) value);
                break;
            case "f4":
                obj.setF4((String) value);
                break;
            case "f5":
                obj.setF5((String) value);
                break;
            case "f6":
                obj.setF6((String) value);
                break;
            case "f7":
                obj.setF7((String) value);
                break;
            case "f8":
                obj.setF8((String) value);
                break;
            default:
                throw new IllegalArgumentException(MessageFormat.format("Class {} does not contain field {}", obj.getClass().getSimpleName(), fieldName));
        }
    }

    @NotNull
    @Override
    public Class<TestClass> getType() {
        return TestClass.class;
    }
}
