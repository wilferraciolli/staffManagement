package com.wiltech.shifts;

import com.wiltech.people.Person;
import com.wiltech.people.PersonRepository;
import com.wiltech.schedules.DaySchedule;
import com.wiltech.schedules.PersonSchedule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
        Map<LocalDate, List<DaySchedule>> datesToCreateScheduleMap = new HashMap<>();

        List<Person> people = personRepository.findAll();
        List<Shift> shifts = shiftRepository.findAll();
        Map<Long, List<Shift>> shiftsBySchedule = shiftRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Shift::getScheduleId));


        List<Person> allowedOnCalls = people.stream()
                .filter(Person::getAllowedOnCall)
                .collect(Collectors.toList());

        datesToCreateSchedules.forEach(d -> {
            List<PersonSchedule> personSchedules = new ArrayList<>();
            Map<Long, LocalDate> usedPeopleInDay = new HashMap<>();// need to be up

            createMorningShifts(d, people, shifts, usedPeopleInDay, personSchedules);

            //create all day shifts
//            personSchedules.add(null);

            //create closing shifts
//            personSchedules.add(null);

            DaySchedule daySchedule = DaySchedule.builder()
                    .day(d)
                    .personSchedules(personSchedules)
                    .build();

            datesToCreateScheduleMap.put(d, List.of(daySchedule));
        });
    }

    private void createMorningShifts(LocalDate day,
                                     List<Person> people,
                                     List<Shift> shifts,
                                     Map<Long, LocalDate> usedPeopleInDay,
                                     List<PersonSchedule> personSchedules) {


        //add a supervisor to open 7-1 and close 4-8
        Person personToOpenAndClose = getOnePersonToOpen(people, new ArrayList<>());
        usedPeopleInDay.put(personToOpenAndClose.getId(), day);
        personSchedules.add(PersonSchedule.builder()
                .personId(personToOpenAndClose.getId())
                .openShift(true)
                .shiftId(6000L)
                .build());
        personSchedules.add(PersonSchedule.builder()
                .personId(personToOpenAndClose.getId())
                .openShift(false)
                .shiftId(6001L)
                .build());

        // add the optional short shift
        Person personToShortShift = getOnePersonToShortShift(people, usedPeopleInDay.keySet());
        usedPeopleInDay.put(personToShortShift.getId(), day);
        personSchedules.add(PersonSchedule.builder()
                .personId(personToShortShift.getId())
                .openShift(true)
                .shiftId(6002L)
                .build());

        //add 2 shifts 12-8 (this could be 7-4/12-8)
        Person personToAllDayShift = getOnePersonToAllDayShift(people, usedPeopleInDay.keySet());
        usedPeopleInDay.put(personToAllDayShift.getId(), day);
        personSchedules.add(PersonSchedule.builder()
                .personId(personToAllDayShift.getId())
                .openShift(false)
                .shiftId(6005L)
                .build());

        personToAllDayShift = getOnePersonToAllDayShift(people, usedPeopleInDay.keySet());
        usedPeopleInDay.put(personToAllDayShift.getId(), day);
        personSchedules.add(PersonSchedule.builder()
                .personId(personToAllDayShift.getId())
                .openShift(false)
                .shiftId(6005L)
                .build());

        //add 1 shift 10-6
        Person personMidDayShift = getOnePersonToMidDayShift(people, usedPeopleInDay.keySet());
        usedPeopleInDay.put(personMidDayShift.getId(), day);
        personSchedules.add(PersonSchedule.builder()
                .personId(personMidDayShift.getId())
                .openShift(false)
                .shiftId(6004L)
                .build());


        //        List<Person> supervisors = people.stream()
//                .filter(Person::getFullyTrained)
//                .collect(Collectors.toList());
//
//        List<Shift> openShifts = shifts.stream()
//                .filter(Shift::getSupervisorOnly)
//                .collect(Collectors.toList());
//
//        // create one person on opening MUST
//        personSchedules.add(PersonSchedule.builder()
//                .personId(supervisors.get(0).getId()) //TODO this need to check for availability and not repeating
//                .shifts(List.of(
//                        openShifts.get(0))
//                )
//                .openShift(true)
//                .build());
//
//        // create second person on opening OPTIONAL
//        personSchedules.add(PersonSchedule.builder()
//                .personId(supervisors.get(1).getId()) //TODO this need to check for availability and not repeating
//                .shifts(List.of(
//                        openShifts.get(1))
//                )
//                .openShift(true)
//                .build());
    }

    private Person getOnePersonToMidDayShift(List<Person> people, Set<Long> skip) {

        Person person = people.stream()
                .filter(p -> !skip.contains(p.getId()))
                .findFirst()
                .orElse(null);

        return person;
    }

    private Person getOnePersonToAllDayShift(List<Person> people, Set<Long> skip) {

        Person person = people.stream()
                .filter(p -> !skip.contains(p.getId()))
                .findFirst()
                .orElse(null);

        return person;
    }

    private Person getOnePersonToOpen(List<Person> people, List<Long> skip) {

        // get a supervisor that is not on holiday
        Person supervisor = people.stream()
                .filter(p -> !skip.contains(p.getId()))
                .filter(Person::getFullyTrained)
                .findFirst()
                .orElse(null);

        return supervisor;
    }

    private Person getOnePersonToShortShift(List<Person> people, Set<Long> skip) {

        // get a person for short shift, any
        Person person = people.stream()
                .filter(p -> !skip.contains(p.getId()))
                .findFirst()
                .orElse(null);

        return person;
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
