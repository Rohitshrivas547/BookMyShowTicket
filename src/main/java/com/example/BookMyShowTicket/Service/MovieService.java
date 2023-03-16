package com.example.BookMyShowTicket.Service;

import com.example.BookMyShowTicket.Dto.MovieRequestDto;
import com.example.BookMyShowTicket.Dto.MovieResponseDto;
import com.example.BookMyShowTicket.Models.MovieEntity;
import com.example.BookMyShowTicket.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieRequestDto movieRequestDto){
        try {

            if(movieRepository.findMovieByName(movieRequestDto.getName())!=null) throw new Exception();

            MovieEntity movie = MovieEntity.builder().name(movieRequestDto.getName()).duration(movieRequestDto.getDuration()).releaseDate(movieRequestDto.getReleaseDate()).build();
            movieRepository.save(movie);
            return "Movie added !";
        }
        catch (Exception e){
            return "Movie already exist!";
        }
    }

    public MovieResponseDto getMovieById(int id){
        MovieEntity movie= movieRepository.findById(id).get();
        MovieResponseDto movieResponse = MovieResponseDto.builder().id(movie.getId()).name(movie.getName()).duration(movie.getDuration()).releaseDate(movie.getReleaseDate()).build();
        return movieResponse;
    }

    public MovieResponseDto getMovieByName(String name){
        MovieEntity movie= movieRepository.findMovieByName(name);
        MovieResponseDto movieResponse = MovieResponseDto.builder().id(movie.getId()).name(movie.getName()).duration(movie.getDuration()).releaseDate(movie.getReleaseDate()).build();
        return movieResponse;
    }

    public List<MovieResponseDto> getAll(){
        List<MovieEntity> movieEntityList = movieRepository.findAll();

        List<MovieResponseDto> movieResponseDtoList = new ArrayList<>();

        for(MovieEntity movie: movieEntityList){
            MovieResponseDto movieResponseDto = MovieResponseDto.builder().id(movie.getId()).name(movie.getName()).duration(movie.getDuration()).releaseDate(movie.getReleaseDate()).build();
            movieResponseDtoList.add(movieResponseDto);
        }

        return movieResponseDtoList;
    }

    public String deleteMovie(int id){
        MovieEntity movie = movieRepository.findById(id).get();
        movieRepository.deleteById(id);
        return "Movie "+movie.getName()+" is deleted ";
    }
}
