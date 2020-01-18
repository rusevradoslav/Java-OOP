package logger_library.loggers;

import logger_library.appenders.interfaces.Appender;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MessageLogger implements Logger {

    private Set<Appender> appenders;


    public MessageLogger(Appender... appenders) {
        setAppenders(appenders);

    }


    public void setAppenders(Appender[] appenders) {
        this.appenders = new HashSet<>();
        if (appenders != null) {
            this.appenders.addAll(Arrays.asList(appenders));
        }
    }

    @Override
    public void logError(String date, String message) {
        this.log(date, ReportLevel.ERROR, message);
    }

    @Override
    public void logInfo(String date, String message) {
        this.log(date, ReportLevel.INFO, message);
    }


    @Override
    public void logWarning(String date, String message) {
        this.log(date, ReportLevel.WARNING, message);
    }

    @Override
    public void logCritical(String date, String message) {
        this.log(date, ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String date, String message) {
        this.log(date, ReportLevel.FATAL, message);
    }

    @Override
    public void addAppender(Appender appender) {
        this.appenders.add(appender);
    }

    private void log(String date, ReportLevel reportLevel, String message) {
        for (Appender appender : appenders) {
            if (appender.getReportLevel().ordinal() <= reportLevel.ordinal()) {
                appender.append(date, reportLevel.toString(), message);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(System.lineSeparator());

        for (Appender appender : appenders) {
            builder.append(appender.toString()).append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
