package logger_library.loggers;

import logger_library.appenders.interfaces.Appender;

public interface Logger {
    void logError(String date, String message);

    void logInfo(String date, String message);

    void logWarning(String date, String message);

    void logCritical(String date, String message);

    void logFatal(String date, String message);

    void addAppender(Appender appender);
}
