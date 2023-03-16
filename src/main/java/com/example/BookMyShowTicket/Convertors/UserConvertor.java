package com.example.BookMyShowTicket.Convertors;

import com.example.BookMyShowTicket.Dto.UserRequestDto;
import com.example.BookMyShowTicket.Dto.UserResponseDto;
import com.example.BookMyShowTicket.Models.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserConvertor {

    public static UserEntity UserDtoToEntity(UserRequestDto userRequestDto){
        UserEntity user = UserEntity.builder().name(userRequestDto.getName()).mobileNo(userRequestDto.getMobileNo()).build();
        return user;
    }

    public static List<UserResponseDto> getUserResponseList(List<UserEntity> userEntityList){
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();

        for(UserEntity user : userEntityList){
            UserResponseDto userResponseDto = UserResponseDto.builder().id(user.getId()).name(user.getName()).mobileNo(user.getMobileNo()).build();
            userResponseDtoList.add(userResponseDto);
        }

        return userResponseDtoList;
    }
}
