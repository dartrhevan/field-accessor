package org.dartrhevan.fieldaccessor.samples;

import org.dartrhevan.fieldaccessor.api.FieldAccess;

import java.time.LocalDate;

@FieldAccess
public class TestClass {
    private int f1;
    private String f2;
    private LocalDate f3;

    public TestClass(int f1, String f2, LocalDate f3) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
    }

    public int getF1() {
        return f1;
    }

    public void setF1(int f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public LocalDate getF3() {
        return f3;
    }

    public void setF3(LocalDate f3) {
        this.f3 = f3;
    }
}
