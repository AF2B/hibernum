package br.com.af2b.hibernum.infrastructure.web.dtos;

import java.time.LocalDate;

import br.com.af2b.hibernum.domain.model.Address;
import br.com.af2b.hibernum.domain.model.User;
import br.com.af2b.hibernum.domain.model.enums.Gender;
import br.com.af2b.hibernum.domain.model.enums.Permission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String name;
    private String email;
    private String password;
    private LocalDate birthdayDate;
    private Gender gender;
    private String phone;
    private Address address;

    public static User toUser(UserDTO user, Permission permission) {
        return User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .birthdayDate(user.getBirthdayDate())
                .gender(user.getGender())
                .phone(user.getPhone())
                .address(user.getAddress())
                .permission(permission)
                .build();
    }
}
