package org.teamproject.hotelreservation.controllers.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HotelSearchController {

    private final GradeRepository gradeRepo;

    @Autowired
    public HotelSearchController(GradeRepository gradeRepo) {
        this.gradeRepo = gradeRepo;
    }

    // 종합 검색 페이지
    @GetMapping("#")
    public String showSearchPage(Model model) {
        List<String> grades = Arrays.asList("1 star", "2 stars", "3 stars", "4 stars", "5 stars", "First class", "Special class");
        List<String> locations = Arrays.asList("Seoul", "Busan", "Jeju");
        List<String> bedTypes = Arrays.asList("Single bed", "Double bed", "Queen-size bed", "King-size bed", "Twin-size bed");
        List<Integer> guests = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        List<String> sortOptions = Arrays.asList("Recommended","Distance","Lowest Price","Highest Price");

        model.addAttribute("grades", grades);
        model.addAttribute("locations", locations);
        model.addAttribute("bedTypes", bedTypes);
        model.addAttribute("guests", guests);
        model.addAttribute("sortOptions", sortOptions);

        return "search";
    }

    // 등급별 호텔 검색
    @GetMapping("#")
    public String showGradeSearchPage(@RequestParam("grade") String grade, Model model) {
        return "search_grade";
    }

    // 지역/도시별 호텔 검색
    @GetMapping("#")
    public String showLocationSearchPage(@RequestParam("location") String location, Model model) {
        return "search_location";
    }

    // 테마별 호텔 검색
    @GetMapping("#")
    public String showThemeSearchPage(@RequestParam("theme") String theme, Model model) {
        return "search_theme";
    }

    // 특별할인 및 이벤트 페이지
    @GetMapping("#")
    public String showSpecialEventPage(Model model) {
        return "event_specials";
    }
}