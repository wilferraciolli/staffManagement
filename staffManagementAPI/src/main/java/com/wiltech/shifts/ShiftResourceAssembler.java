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
                .name(payload.getName())
                .description(payload.getDescription())
                .shiftType(payload.getShiftType())
                .supervisorOnly(payload.getSupervisorOnly())
                .startTime(payload.getStartTime())
                .endTime(payload.getEndTime())
                .build();
    }


    public ShiftResource convertToDTO(final Shift entity) {

        ShiftResource resource = ShiftResource.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .shiftType(entity.getShiftType())
                .supervisorOnly(entity.getSupervisorOnly())
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
