package org.teamproject.hotelreservation.controllers.member;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class JoinForm {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(min=8)
    private String userPw;
    @NotBlank
    private String userPwRe;
    @NotBlank
    private String userNm;
    @NotBlank
    private String mobile;
    @NotBlank
    private String zonecode;
    @NotBlank
    private String address;
    @NotBlank
    private String addressSub;
    @AssertTrue
    private boolean agree;
}
