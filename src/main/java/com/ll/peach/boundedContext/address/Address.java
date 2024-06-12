package com.ll.peach.boundedContext.address;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;


@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {


    @Column(length = 10)
    private String sido;

    @Column(length = 25)
    private String roadAddress;

    @Column(length = 5)
    private String zonecode;

    public Address(String sido, String roadAddress, String zonecode) {
        this.sido = sido;
        this.roadAddress = roadAddress;
        this.zonecode = zonecode;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getSido(), address.getSido()) && Objects.equals(getRoadAddress(), address.getRoadAddress()) && Objects.equals(getZonecode(), address.getZonecode());
    }

}
