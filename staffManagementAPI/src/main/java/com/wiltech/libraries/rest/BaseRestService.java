package com.wiltech.libraries.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * The type Base rest service.
 */
public class BaseRestService {

    /**
     * Build location header uri.
     * @param id the id
     * @return the uri
     */
    protected URI buildLocationHeader(final Long id) {

        return MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(id).toUri();
    }

    /**
     * Build self link link.
     * @return the link
     */
    private Link buildSelfLink() {
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();

        return new Link(uriString, "self");
    }

    /**
     * Build response ok response entity.
     * @param rootName the root name
     * @param resource the resource
     * @return the response entity
     */
    public ResponseEntity buildResponseOk(final String rootName, final BaseDTO resource) {

        final BaseResponse response = new BaseResponse();
        response.setData(rootName, resource);
        response.setMessages("Template Message");
        response.addMetaLink(buildSelfLink());

        return ResponseEntity.ok().body(response);
    }

    /**
     * Build response ok response entity.
     * @param rootName the root name
     * @param resource the resource
     * @param metadata the metadata
     * @return the response entity
     */
    public ResponseEntity buildResponseOk(final String rootName, final BaseDTO resource, final Map<String, Metadata> metadata) {

        final BaseResponse response = new BaseResponse();
        response.setData(rootName, resource);
        response.setMetadata(metadata);
        response.addMetaLink(buildSelfLink());

        return ResponseEntity.ok().body(response);
    }


    public ResponseEntity buildResponseCreated(String rootName, BaseDTO createdResource, Map<String, Metadata> metadata) {

        final BaseResponse response = new BaseResponse();
        response.setData(rootName, createdResource);
        response.setMetadata(metadata);
        response.addMetaLink(buildSelfLink());

        return ResponseEntity
                .created(buildLocationHeader(1L))
                .body(response);

//        return ResponseEntity
//                .created(buildLocationHeader(createdResource.getId()))
//                .body(createdResource);

    }


    /**
     * Build response ok response entity. For a collection.
     * @param rootName the root name
     * @param resources the resources
     * @return the response entity
     */
    public ResponseEntity buildResponseOk(final String rootName, final List<? extends BaseDTO> resources) {
        final BaseResponse response = new BaseResponse();
        response.setData(rootName, resources);
        response.addMetaLink(buildSelfLink());

        return ResponseEntity.ok().body(response);
    }

    /**
     * Build response ok response entity. For a collection.
     * @param rootName the root name
     * @param resources the resources
     * @param metadata the metadata
     * @return the response entity
     */
    public ResponseEntity buildResponseOk(final String rootName, final List<? extends BaseDTO> resources, final Map<String, Metadata> metadata) {
        final BaseResponse response = new BaseResponse();
        response.setData(rootName, resources);
        response.setMetadata(metadata);
        response.addMetaLink(buildSelfLink());

        return ResponseEntity.ok().body(response);
    }

    /**
     * Build response ok response entity. For a collection.
     * @param rootName the root name
     * @param resources the resources
     * @param metadata the metadata
     * @param metaLinks the meta links
     * @return the response entity
     */
    public ResponseEntity buildResponseOk(final String rootName, final List<? extends BaseDTO> resources, final Map<String, Metadata> metadata,
            final List<Link> metaLinks) {

        // add the self link to the collection of links
        List<Link> metaLinksToAdd = generateMetaLinks(metaLinks);

        final BaseResponse response = new BaseResponse();
        response.setData(rootName, resources);
        response.setMetadata(metadata);
        response.addMetaLinks(metaLinksToAdd);

        return ResponseEntity.ok().body(response);
    }

    /**
     * Gets json root name.
     * @param clazz the clazz
     * @return the json root name
     */
    public String getJsonRootName(final Class<? extends BaseDTO> clazz) {

        if (clazz.isAnnotationPresent(JsonRootName.class)) {
            return clazz.getAnnotation(JsonRootName.class).value();
        } else {
            return clazz.getSimpleName();
        }
    }

    private List<Link> generateMetaLinks(final List<Link> metaLinks) {
        List<Link> metaLinksToAdd = new ArrayList<>();
        metaLinksToAdd.add(buildSelfLink());
        metaLinksToAdd.addAll(metaLinks);

        return metaLinksToAdd;
    }
}
