package com.wiltech.shifts;

import com.wiltech.people.Person;
import com.wiltech.people.PersonRepository;
import com.wiltech.schedules.PersonSchedule;
import com.wiltech.schedules.Schedule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ShiftService {

    @Autowired
    private ShiftRepository shiftRepository;

    @Autowired
    private PersonRepository personRepository;

    public void createSchedule() {

        List<LocalDate> datesToCreateSchedules = getDates();
        Map<LocalDate, List<Schedule>> datesToCreateScheduleMap = new HashMap<>();

        List<Person> people = personRepository.findAll();
        List<Person> supervisors = people.stream()
                .filter(Person::getFullyTrained)
                .collect(Collectors.toList());

        List<Person> allowedOnCalls = people.stream()
                .filter(Person::getAllowedOnCall)
                .collect(Collectors.toList());

        datesToCreateSchedules.forEach(d -> {
            // create shift for date
//            List<Schedule> dateSchedules = new ArrayList<>();

            List<PersonSchedule> personSchedules = new ArrayList<>();
            // create morning shifts
            personSchedules.add(null);

            //create all day shifts
            personSchedules.add(null);

            //create closing shifts
            personSchedules.add(null);

            Schedule.builder()
                    .day(d)
                    .personSchedules(personSchedules)
                    .build();
        });


        List<Shift> shifts = shiftRepository.findAll();


        people.stream().forEach(p -> {

            System.out.println(p.getAllowedOnCall());
        });


    }

    private List<LocalDate> getDates() {

//        LocalDate today = LocalDate.now();
//        // Go backward to get Monday
//        LocalDate monday = today;
//        while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
//            monday = monday.minusDays(1);
//        }
//
//        // Go forward to get Sunday
//        LocalDate sunday = today;
//        while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
//            sunday = sunday.plusDays(1);
//        }

        LocalDate day = LocalDate.of(2022, 01, 01);

        return List.of(
                day,
                day.plusDays(1),
                day.plusDays(2),
                day.plusDays(3),
                day.plusDays(4),
                day.plusDays(5),
                day.plusDays(6)
        );
    }
}
