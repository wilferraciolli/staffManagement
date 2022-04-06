package com.wiltech.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Bean Providers.
 */
@Component
public class BeanProvider {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // This bean is used to configure jackson serializer
    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();

        // Response Serializer, uncomment to add root value to response
        // builder.featuresToEnable(SerializationFeature.WRAP_ROOT_VALUE);

        // Request deserializer, uncomment to expect payload with root value
        //  builder.featuresToEnable(DeserializationFeature.UNWRAP_ROOT_VALUE);

        builder.failOnUnknownProperties(false);

        return builder;
    }
}
