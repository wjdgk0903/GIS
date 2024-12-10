package com.practice.p1012_2.board.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Data
@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class Address {

    @NotBlank(message = "주소를 입력해주세요")
    private String zipcode;
    private String address;
    private String detailAddr;


    @Builder
    public Address(String zipcode, String address, String detailAddr) {
        this.zipcode = zipcode;
        this.address = address;
        this.detailAddr = detailAddr;
    }

}
