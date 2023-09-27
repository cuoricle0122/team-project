package org.teamproject.hotelreservation.commons;

import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    /**
     * 주어진 코드에 따라 메뉴 목록을 반환.
     *
     * @param code 메뉴 코드
     * @return 주어진 메뉴 코드에 따른 메뉴 목록
     */
    public static List<MenuDetail> gets(String code) {
        List<MenuDetail> menus = new ArrayList<>();

        // 회원 하위 메뉴
        if (code.equals("member")) {
            menus.add(new MenuDetail("member", "회원 목록", "/admin/member"));
        } else if (code.equals("rooms")) { // 객실 관리 하위 메뉴
            menus.add(new MenuDetail("rooms", "객실 현황", "/admin/rooms"));
            menus.add(new MenuDetail("add", "객실 등록", "/admin/rooms/add"));
            menus.add(new MenuDetail("category", "객실 분류", "/admin/rooms/category"));
        }
        return menus;
    }

    /**
     * 주어진 요청에 대한 하위 메뉴 코드를 반환.
     *
     * @param request HttpServletRequest 객체
     * @return 요청에 대한 하위 메뉴 코드
     */
    public static String getSubMenuCode(HttpServletRequest request) {
        String URI = request.getRequestURI();

        return URI.substring(URI.lastIndexOf('/') + 1);
    }
}
