package seedu.quickcontacts.model;

import java.nio.file.Path;

import seedu.quickcontacts.commons.core.GuiSettings;

/**
 * Unmodifiable view of user prefs.
 */
public interface ReadOnlyUserPrefs {

    GuiSettings getGuiSettings();

    Path getQuickBookFilePath();

}
