package com.wiltech.shifts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShiftRepository extends JpaRepository<Shift, Long> {

    List<Shift> findAllByOrderByScheduleIdAscStartTimeAsc();
}
