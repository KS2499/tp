package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.FindMeetingCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.meeting.MeetingContainsNamesPredicate;

/**
 * Parses input arguments and creates a new FindMeetingCommand object
 */
public class FindMeetingCommandParser implements Parser<FindMeetingCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindMeetingCommand
     * @param args input arguments
     * @return FindMeetingCommand object
     */
    @Override
    public FindMeetingCommand parse(String args) throws ParseException {
        // If used without arguments, return all meetings
        if (args.isEmpty()) {
            return new FindMeetingCommand(new MeetingContainsNamesPredicate());
        }
        // If used with trailing whitespace throw error on expected usage
        if (args.isBlank()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindMeetingCommand.MESSAGE_USAGE));
        }
        String trimmedArgs = args.trim();
        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new FindMeetingCommand(new MeetingContainsNamesPredicate(Arrays.asList(nameKeywords)));
    }
}
