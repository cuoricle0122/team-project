package org.teamproject.hotelreservation.models.member;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.teamproject.hotelreservation.commons.constants.Role;
import org.teamproject.hotelreservation.controllers.member.JoinForm;
import org.teamproject.hotelreservation.entities.Member;
import org.teamproject.hotelreservation.repositories.MemberRepository;

@Service
@RequiredArgsConstructor
public class UserSaveService {
    private final MemberRepository repository;
    private final PasswordEncoder encoder;

    public void save(JoinForm joinForm, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        Member member = new ModelMapper().map(joinForm, Member.class);
        member.setRole(Role.USER);
        save(member);
    }

    public void save(Member member) {
        String userPw = member.getUserPw();
        if (userPw != null && !userPw.isBlank()) {
            member.setUserPw(encoder.encode(userPw));
        }

        repository.saveAndFlush(member);
    }
}
