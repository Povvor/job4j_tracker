package ru.job4j.pojo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        assertThat(first).isEqualTo(second);
    }

    @Test
    public void eqName2() {
        License first = new License();
        first.setCode("audio");
        first.setOwner("Boris");
        License second = new License();
        second.setCode("audio");
        second.setOwner("Boris");
        assertThat(first).isEqualTo(second);
    }

    @Test
    public void eqName3() {
        License first = new License();
        first.setCode("audio");
        first.setOwner("Boris");
        first.setModel("Subaru");
        License second = new License();
        second.setCode("audio");
        second.setOwner("Boris");
        second.setOwner("Toyota");
        assertThat(first).isNotEqualTo(second);
    }
}