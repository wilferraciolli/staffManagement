package com.wiltech.shifts;

import com.wiltech.libraries.rest.Metadata;
import com.wiltech.libraries.rest.MetadataEmnbedded;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ShiftMetaFabricator {

    public Map<String, Metadata> createMetaForSingleResource() {

        Map<String, Metadata> metadata = buildBasicMeta();

        metadata.put("shiftType", Metadata.builder()
                .mandatory(true)
                .values(generateShiftTypeEmbedded())
                .build());

        return metadata;
    }

    public Map<String, Metadata> createMetaForSingleResource(String shiftTypeId) {
        Map<String, Metadata> metadata = buildBasicMeta();
        metadata.put("shiftType", Metadata.builder()
                .mandatory(true)
                .values(generateFilteredShiftTypeEmbedded(Set.of(shiftTypeId)))
                .build());

        return metadata;
    }

    public Map<String, Metadata> createMetaForCollectionResource(Set<String> shiftTypeIds) {

        Map<String, Metadata> metadata = buildBasicMeta();

        metadata.put("shiftType", Metadata.builder()
                .mandatory(true)
                .values(generateFilteredShiftTypeEmbedded(shiftTypeIds))
                .build());

        return metadata;
    }

    private Map<String, Metadata> buildBasicMeta() {

        Map<String, Metadata> metadata = new HashMap<>();

        metadata.put("id", Metadata.builder()
                .hidden(true)
                .readOnly(true)
                .build());

        metadata.put("name", Metadata.builder()
                .mandatory(true)
                .build());

        metadata.put("description", Metadata.builder()
                .mandatory(true)
                .build());

        metadata.put("supervisorOnly", Metadata.builder()
                .mandatory(true)
                .build());

        metadata.put("startTime", Metadata.builder()
                .mandatory(true)
                .build());

        metadata.put("endTime", Metadata.builder()
                .mandatory(true)
                .build());

        return metadata;
    }

    private List<MetadataEmnbedded> generateShiftTypeEmbedded() {

        return ShiftType.stream()
                .map(value -> new MetadataEmnbedded(value.name(), value.getName()))
                .collect(Collectors.toList());
    }

    private List<MetadataEmnbedded> generateFilteredShiftTypeEmbedded(Set<String> shiftTypeIds) {

        return shiftTypeIds.stream()
                .map(shiftId -> new MetadataEmnbedded(ShiftType.valueOf(shiftId).name(),
                        ShiftType.valueOf(shiftId).getName()))
                .collect(Collectors.toList());
    }
}
