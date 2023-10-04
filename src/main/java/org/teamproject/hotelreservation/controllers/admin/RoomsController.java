package org.teamproject.hotelreservation.controllers.admin;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teamproject.hotelreservation.commons.CommonProcess;
import org.teamproject.hotelreservation.commons.Menu;
import org.teamproject.hotelreservation.commons.ScriptExceptionProcess;
import org.teamproject.hotelreservation.commons.Utils;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/rooms")
@RequiredArgsConstructor
public class RoomsController implements CommonProcess, ScriptExceptionProcess {

    private final HttpServletRequest request;

    @GetMapping
    public String index(Model model) {
        commonProcess("list", model);

        return "admin/rooms/index";
    }

    @GetMapping("/add")
    public String register(Model model) {
        commonProcess("add", model);

        return "admin/rooms/add";
    }

    @GetMapping("/edit/{roomNo}")
    public String update(@PathVariable Long roomNo, Model model) {
        commonProcess("edit", model);
        
        return "admin/rooms/edit";
    }

    @PostMapping("/save")
    public String saveRoom(Model model) {

        return "redirect:/admin/rooms";
    }

    public void commonProcess(String mode, Model model) {
        String pageTitle = "객실 관리";
        if (mode.equals("add")) pageTitle = "객실 등록";
        else if (mode.equals("edit")) pageTitle = "객실 수정";

        CommonProcess.super.commonProcess(model, pageTitle);

        /* 서브 메뉴 처리 S */
        String subMenuCode = Menu.getSubMenuCode(request);

        model.addAttribute("submenus", Menu.gets("rooms"));
        model.addAttribute("subMenuCode", subMenuCode);

        /* 서브 메뉴 처리 E */

        List<String> addCommonScript = new ArrayList<>();
        List<String> addScript = new ArrayList<>();
        if (mode.equals("add") || mode.equals("edit")) {
            addCommonScript.add("ckeditor5/ckeditor5");
            addScript.add("rooms/form");
        }

        model.addAttribute("addCommonScript", addCommonScript);
        model.addAttribute("addScript", addScript);
    }
}
