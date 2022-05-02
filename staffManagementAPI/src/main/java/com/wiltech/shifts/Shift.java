package com.wiltech.shifts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

/**
 * The type Shift.
 */
@Entity
@Table(name = "shift")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long scheduleId;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @Enumerated(EnumType.STRING)
    private ShiftType shiftType;

    @NotNull
    private Boolean supervisorOnly;

    @NotNull
    private Boolean active;

    @NotNull
    private LocalTime startTime;

    @NotNull
    private LocalTime endTime;

    public void update(final String name, final String description, final ShiftType shiftType,
                       final boolean supervisorOnly, final LocalTime startTime, final LocalTime endTime) {
        this.title = name;
        this.description = description;
        this.shiftType = shiftType;
        this.supervisorOnly = supervisorOnly;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
