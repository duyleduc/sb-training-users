package com.example.DemoSpringBoot.Mappings;

import java.util.List;

// import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.DemoSpringBoot.Beans.Users;
import com.example.DemoSpringBoot.Beans.dtos.RegisterUserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // @Mapping(source = "Users", target = "RegisterUserDTO")O
    RegisterUserDTO user2DTO(Users user);

    List<RegisterUserDTO> users2DTOs(List<Users> users);

    // @InheritInverseConfiguration
    // Users user(RegisterUserDTO userDTO);

    
}
