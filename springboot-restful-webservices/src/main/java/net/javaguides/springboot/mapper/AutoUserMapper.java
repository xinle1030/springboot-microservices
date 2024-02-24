package net.javaguides.springboot.mapper;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

// Use mapstruct to convert between dto and JPA entity and vice versa

@Mapper
public interface AutoUserMapper {

    // create this mapper instance to use the methods below
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);
}
