package org.example.summerpracticesecondyear.mappers;

import org.example.summerpracticesecondyear.dto.TicketDto;
import org.example.summerpracticesecondyear.entities.Ticket;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

import java.util.List;

public class TicketMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(org.modelmapper.convention.NamingConventions.JAVABEANS_MUTATOR);

        modelMapper.createTypeMap(Ticket.class, TicketDto.class)
                .addMappings(mapper -> {
                    mapper.map(Ticket::getSeat, TicketDto::setSeat);
                    mapper.map(src -> src.getMovie().getTitle(), TicketDto::setTitle);
                    mapper.map(src -> src.getMovie().getGenre(), TicketDto::setGenre);
                });
    }

    public static List<TicketDto> ticketClassToTicketDto(List<Ticket> tickets) {
        return tickets.stream()
                .map(ticket -> modelMapper.map(ticket, TicketDto.class))
                .toList();
    }
}
