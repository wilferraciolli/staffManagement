package com.wiltech.shifts;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wiltech.libraries.rest.BaseDTO;
import com.wiltech.libraries.rest.BaseRestService;
import com.wiltech.libraries.rest.CustomNullSerializer;
import com.wiltech.libraries.rest.Metadata;
import com.wiltech.people.PersonAppService;
import com.wiltech.people.PersonMetaFabricator;
import com.wiltech.users.UserResource;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.noContent;

@JsonRootName("shift")
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public class ShiftResource extends BaseDTO {

    private Long id;

    private Long scheduleId;

    @NotEmpty(message = "title cannot be blank")
    @Size(max = 80, message = "Title cannot have more than {max} characters")
    private String title;

    @NotNull
    @Size(max = 255, message = "Description cannot have more than {max} characters")
    private String description;

    @NotNull
    private ShiftType shiftType;

    @NotNull
    private Boolean supervisorOnly;

    private Boolean active;

    @NotNull
    @JsonFormat(pattern = "HH:mm")
    @JsonSerialize(nullsUsing = CustomNullSerializer.class)
    private LocalTime startTime;

    @NotNull
    @JsonFormat(pattern = "HH:mm")
    @JsonSerialize(nullsUsing = CustomNullSerializer.class)
    private LocalTime endTime;
}
