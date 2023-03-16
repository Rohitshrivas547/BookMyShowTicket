package com.example.BookMyShowTicket.Service;

import com.example.BookMyShowTicket.Convertors.UserConvertor;
import com.example.BookMyShowTicket.Dto.UserRequestDto;
import com.example.BookMyShowTicket.Dto.UserResponseDto;
import com.example.BookMyShowTicket.Models.UserEntity;
import com.example.BookMyShowTicket.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(UserRequestDto userRequestDto){

        try{
            UserEntity user = UserConvertor.UserDtoToEntity(userRequestDto);
            userRepository.save(user);
            return "User successfully added!";
        }
        catch(Exception e){
            return "User already exist! ";
        }

    }

    public List<UserEntity> findUserByName(String name ){
        try{
            return userRepository.findUserByName(name);
        }
        catch(Exception e){
            return null;
        }
    }

    public List<UserResponseDto> findAllUsers(){
        try {
            List<UserEntity> userEntityList = userRepository.findAll();
            return UserConvertor.getUserResponseList(userEntityList);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public UserEntity findUserById(int id){
        return userRepository.findById(id).get();
    }

    public UserResponseDto updateUser(int id, String mobileNo){
        try{
            UserEntity user = userRepository.findById(id).get();
            user.setMobileNo(mobileNo);
            userRepository.save(user);

            UserResponseDto userResponseDto = UserResponseDto.builder().id(user.getId()).name(user.getName()).mobileNo(user.getMobileNo()).build();
            return userResponseDto;
        }
        catch(Exception e){
            return null;
        }
    }

    public String deleteUser(int id){
        userRepository.deleteById(id);
        return "User deleted!";
    }

}
