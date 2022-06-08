package com.wiltech.schedules;

import com.wiltech.shifts.Shift;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person_schedule")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long personId;


//    private LocalDate day;

//    private LocalDateTime startTime;
//
//    private LocalDateTime endTime;

    private Boolean openScheduled;

    private Boolean allDayScheduled;

    private Boolean nightScheduled;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Person> people = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Shift> shifts = new ArrayList<>();


}
