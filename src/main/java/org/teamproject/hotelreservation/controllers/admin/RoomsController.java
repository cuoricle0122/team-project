package org.teamproject.hotelreservation.controllers.admin;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teamproject.hotelreservation.commons.CommonProcess;
import org.teamproject.hotelreservation.commons.ScriptExceptionProcess;
import org.teamproject.hotelreservation.commons.Utils;

@Controller
@RequestMapping("/admin/rooms")
@RequiredArgsConstructor
public class RoomsController implements CommonProcess, ScriptExceptionProcess {


    @GetMapping
    public String index(Model model) {
        commonProcess("list", model);

        return "admin/rooms/index";
    }

    public void commonProcess(String mode, Model model) {
        String pageTitle = "객실 관리";

        CommonProcess.super.commonProcess(model, pageTitle);
    }
}
