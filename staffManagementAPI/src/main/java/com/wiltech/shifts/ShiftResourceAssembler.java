package com.wiltech.shifts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ShiftResourceAssembler {

    @Autowired
    private ShiftLinkProvider linkProvider;

    public Shift convertToEntity(final ShiftResource payload) {
        return Shift.builder()
                .title(payload.getTitle())
                .scheduleId(payload.getScheduleId())
                .description(payload.getDescription())
                .shiftType(payload.getShiftType())
                .supervisorOnly(payload.getSupervisorOnly())
                .active(payload.getActive())
                .startTime(payload.getStartTime())
                .endTime(payload.getEndTime())
                .build();
    }


    public ShiftResource convertToDTO(final Shift entity) {

        ShiftResource resource = ShiftResource.builder()
                .id(entity.getId())
                .scheduleId(entity.getScheduleId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .shiftType(entity.getShiftType())
                .supervisorOnly(entity.getSupervisorOnly())
                .active((entity.getActive()))
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .build();

        List<Link> linksToAdd = Arrays.asList(
                linkProvider.generateSelfLink(resource.getId()),
                linkProvider.generateGetAllLink(),
                linkProvider.generateUpdateLink(resource.getId()),
                linkProvider.generateDeleteLink(resource.getId()));
        resource.addLinks(linksToAdd);

        return resource;
    }
}
