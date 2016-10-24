package org.az.app.confRoomBook.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.az.app.confRoomBook.dto.MeetingEntryDetailsDto;
import org.az.app.confRoomBook.model.Employee;
import org.az.app.confRoomBook.model.EmployeeConferenceRoomMeetingEntryDetails;

/**
 * @author Logeswaran Murugesan
 *
 */
public interface SuperConverter<A, B> extends Function<A, B> {
    default List<B> convertToList(final List<A> input) {
        return input.stream().map(this::apply).collect(Collectors.toList());
    }
    default List<B> convert(final List<A> input) {
        return input.stream().map(this::apply).collect(Collectors.toList());
    }
  
}
