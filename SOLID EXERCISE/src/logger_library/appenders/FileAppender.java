package logger_library.appenders;

import logger_library.helpers.FileStorage;
import logger_library.layouts.interfaces.Layout;


public class FileAppender extends AppenderImpl {
    private FileStorage fileHelpers;

    public FileAppender(Layout layout, FileStorage fileStorage) {
        super(layout);
        this.fileHelpers = fileStorage;
    }

    @Override
    public void append(String date, String reportLevel, String message) {
        this.incrementMessages();
        this.fileHelpers.write(this.getLayout().format(date, reportLevel, message));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
