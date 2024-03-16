package br.com.af2b.hibernum.domain.model;

import java.time.LocalDate;

import br.com.af2b.hibernum.domain.model.enums.Gender;
import br.com.af2b.hibernum.domain.model.enums.Permission;
import br.com.af2b.hibernum.infrastructure.web.dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    private String name;
    private String email;
    private String password;
    private LocalDate birthdayDate;
    private Gender gender;
    private String phone;
    private Address address;
    private Permission permission;

    public static UserDTO toDTO(User user) {
        return UserDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .birthdayDate(user.getBirthdayDate())
                .gender(user.getGender())
                .phone(user.getPhone())
                .address(user.getAddress())
                .build();
    }
}
