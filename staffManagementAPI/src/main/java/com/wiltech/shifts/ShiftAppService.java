package com.wiltech.shifts;

import com.wiltech.exceptions.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional
@Slf4j
public class ShiftAppService {

    @Autowired
    private ShiftRepository repository;

    @Autowired
    private ShiftResourceAssembler assembler;

    @Autowired
    private ShiftLinkProvider linkProvider;

    public ShiftResource createTemplate() {

        return ShiftResource.builder()
                .name("")
                .description("")
                .shiftType(ShiftType.HALF_DAY)
                .supervisorOnly(false)
                .startTime(null)
                .endTime(null)
                .build();
    }

    public ShiftResource create(final ShiftResource payload) {
        Shift created = assembler.convertToEntity(payload);

        repository.save(created);

        return assembler.convertToDTO(created);
    }

    public List<ShiftResource> findAll() {

        return repository.findAll().stream()
                .map(assembler::convertToDTO)
                .collect(Collectors.toList());
    }

    public ShiftResource findById(final Long id) {
        final Shift person = repository.findById(id)
                .orElseThrow(()  -> new EntityNotFoundException("Could not find entity for given id"));

        return assembler.convertToDTO(person);
    }


    public ShiftResource update(final Long id, @Valid final ShiftResource shiftResource) {
        final Shift person = repository.findById(id)
                .orElseThrow(()  -> new EntityNotFoundException("Could not find entity for given id"));

        person.update(shiftResource.getName(), shiftResource.getDescription(), shiftResource.getShiftType(), shiftResource.getSupervisorOnly(), shiftResource.getStartTime(), shiftResource.getEndTime());
        repository.save(person);

        return assembler.convertToDTO(person);
    }

    public void deleteById(final Long id) {
        final Shift person = repository.findById(id)
                .orElseThrow(()  -> new EntityNotFoundException("Could not find entity for given id"));

        repository.delete(person);
    }


    public Set<String> resolveShiftTypeIds(final List<ShiftResource> resources) {

        return resources.stream()
                .filter(p -> Objects.nonNull(p.getShiftType()))
                .map(p -> p.getShiftType().name())
                .collect(Collectors.toSet());
    }

    public List<Link> generateCollectionLinks() {
        List<Link> links = new ArrayList<>();
        links.add(linkProvider.generateTemplateLink());

        return links;
    }
}
