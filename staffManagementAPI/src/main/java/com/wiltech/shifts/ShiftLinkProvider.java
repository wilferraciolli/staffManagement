package com.wiltech.shifts;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ShiftLinkProvider {

    public Link generateTemplateLink() {
        return linkTo(methodOn(ShiftRestService.class).template()).withRel("createShift");
    }

    public Link generateGetAllLink() {
        return linkTo(methodOn(ShiftRestService.class).findAll()).withRel("shifts");
    }

    public Link generateSelfLink(final Long id) {
        if (Objects.nonNull(id)) {
            return linkTo(methodOn(ShiftRestService.class).findById(id)).withSelfRel();
        }

        return null;
    }

    public Link generateUpdateLink(final Long id) {
        if (Objects.nonNull(id)) {
            return linkTo(methodOn(ShiftRestService.class).findById(id)).withRel("updateShift");
        }

        return null;
    }

    public Link generateDeleteLink(final Long id) {
        if (Objects.nonNull(id)) {
            return linkTo(methodOn(ShiftRestService.class).deleteById(id)).withRel("deleteShift");
        }

        return null;
    }
}
