package com.warmup.libraryapp.controller.date;

import com.warmup.libraryapp.dto.date.DayOfWeekResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

@RestController
public class DateController {
    @GetMapping("/api/v1/day-of-the-week")
    public DayOfWeekResponse getDayOfWeek(@RequestParam String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        String dayOfWeek = localDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();
        DayOfWeekResponse response = new DayOfWeekResponse();
        response.setDayOfTheWeek(dayOfWeek);
        return response;
    }
}