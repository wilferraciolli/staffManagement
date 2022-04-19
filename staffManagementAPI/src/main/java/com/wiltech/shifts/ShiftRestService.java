package com.wiltech.shifts;

import com.wiltech.libraries.rest.BaseRestService;
import com.wiltech.libraries.rest.Metadata;
import com.wiltech.users.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.noContent;


@RestController
@RequestMapping(value = "/admin/shifts", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShiftRestService extends BaseRestService {

    @Autowired
    private ShiftAppService appService;

    @Autowired
    private ShiftMetaFabricator metaFabricator;

    @GetMapping("/template")
    public ResponseEntity<ShiftResource> template() {

        final ShiftResource resource = appService.createTemplate();

        return buildResponseOk(getJsonRootName(ShiftResource.class), resource, metaFabricator.createMetaForSingleResource());
    }

    @PostMapping("")
    public ResponseEntity<ShiftResource> create(@RequestBody @Valid final ShiftResource payload) {
        final ShiftResource createdResource = this.appService.create(payload);

        Map<String, Metadata> metadata = metaFabricator.createMetaForSingleResource(createdResource.getShiftType().name());

        return buildResponseCreated(getJsonRootName(ShiftResource.class), createdResource, metadata);
    }

    @GetMapping("")
    public ResponseEntity<ShiftResource> findAll() {

        final List<ShiftResource> resources = appService.findAll();

        Map<String, Metadata> metaForCollectionResource = metaFabricator.createMetaForCollectionResource(
                appService.resolveShiftTypeIds(resources));
        List<Link> metaLinks = appService.generateCollectionLinks();

        return buildResponseOk(getJsonRootName(ShiftResource.class), resources, metaForCollectionResource, metaLinks);
    }


    @GetMapping("/{id}")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public ResponseEntity<ShiftResource> findById(@PathVariable final Long id) {

        final ShiftResource resource = appService.findById(id);

        Map<String, Metadata> metadata = metaFabricator.createMetaForSingleResource(resource.getShiftType().name());

        return buildResponseOk(getJsonRootName(ShiftResource.class), resource, metadata);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ShiftResource> update(@PathVariable("id") final Long id,
                                                @RequestBody @Valid final ShiftResource personFromRequest) {
        final ShiftResource updatedResource = appService.update(id, personFromRequest);

        Map<String, Metadata> metadata = metaFabricator.createMetaForSingleResource(updatedResource.getShiftType().name());

        return buildResponseOk(getJsonRootName(UserResource.class), updatedResource, metadata);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable("id") final Long id) {
        appService.deleteById(id);

        return noContent().build();
    }
}
