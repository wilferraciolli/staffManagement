package com.wiltech.shifts;

import com.wiltech.people.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift, Long> {
}
