package org.example.summerpracticesecondyear.mappers;

import org.example.summerpracticesecondyear.dto.MovieDto;
import org.example.summerpracticesecondyear.dto.TicketDto;
import org.example.summerpracticesecondyear.entities.BaseEntity;
import org.example.summerpracticesecondyear.entities.Movie;
import org.example.summerpracticesecondyear.entities.Ticket;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

import java.util.List;

public class MovieMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(org.modelmapper.convention.NamingConventions.JAVABEANS_MUTATOR);

        modelMapper.createTypeMap(Movie.class, MovieDto.class)
                .addMappings(mapper -> {
                    mapper.map(BaseEntity::getId, MovieDto::setId);
                    mapper.map(Movie::getTitle, MovieDto::setTitle);
                    mapper.map(Movie::getGenre, MovieDto::setGenre);
                    mapper.map(Movie::getDuration, MovieDto::setDuration);
                });
    }

    public static List<MovieDto> movieClassToMovieDto(List<Movie> movies) {
        return movies.stream()
                .map(movie -> modelMapper.map(movie, MovieDto.class))
                .toList();
    }
}
