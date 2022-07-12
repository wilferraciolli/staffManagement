package com.wiltech.schedules;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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

    private Boolean openShift;

    private Boolean allDayShift;

    private Boolean nightShift;

    private Long shiftId;

//    @ManyToOne()
}
