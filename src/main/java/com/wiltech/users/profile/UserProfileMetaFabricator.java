package com.wiltech.users.profile;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wiltech.libraries.rest.Metadata;

@Service
public class UserProfileMetaFabricator {

    public Map<String, Metadata> createMeta() {

        return buildBasicMeta();
    }

    private Map<String, Metadata> buildBasicMeta() {
        Map<String, Metadata> metadata = new HashMap<>();

        metadata.put("id", Metadata.builder()
                .hidden(true)
                .readOnly(true)
                .build());

        metadata.put("personId", Metadata.builder()
                .hidden(true)
                .readOnly(true)
                .build());

        metadata.put("firstName", Metadata.builder()
                .hidden(true)
                .readOnly(true)
                .build());

        metadata.put("firstName", Metadata.builder()
                .hidden(true)
                .readOnly(true)
                .build());

        return metadata;
    }

}
