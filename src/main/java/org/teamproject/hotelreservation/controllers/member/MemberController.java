package org.teamproject.hotelreservation.controllers.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.teamproject.hotelreservation.commons.CommonProcess;
import org.teamproject.hotelreservation.commons.Utils;
import org.teamproject.hotelreservation.models.member.UserSaveService;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController implements CommonProcess {

    private final UserSaveService saveService;
    private final Utils utils;

    @GetMapping("/join")
    public String join(@ModelAttribute JoinForm form, Model model) {
        commonProcess(model, "회원가입");
        return utils.tpl("member/join");
    }

    @PostMapping("/join")
    public String joinPs(@Valid JoinForm form, Errors errors, Model model) {
        commonProcess(model, "회원가입");

        saveService.save(form, errors);

        if (errors.hasErrors()) {
            return utils.tpl("member/join");
        }

        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        commonProcess(model, "로그인");

        return utils.tpl("member/login");
    }

}
