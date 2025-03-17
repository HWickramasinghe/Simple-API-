package com.SpringBootAcademy.pos1.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
//configurtion EKA mema dnnna nathuwa main claz ekee @Bean annotaion eka laga idala dnnmth hriynwa