package logger_library.appenders.interfaces;

import logger_library.loggers.ReportLevel;

public interface Appender {
    void append(String date, String reportLevel, String message);

    void setReportLevel(ReportLevel reportLevel);

    ReportLevel getReportLevel();
}
