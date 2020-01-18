package logger_library.appenders;

import logger_library.appenders.interfaces.Appender;
import logger_library.layouts.interfaces.Layout;
import logger_library.loggers.ReportLevel;

public abstract class AppenderImpl implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;
    private int appendedMessages;

    protected AppenderImpl(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO;
        this.appendedMessages = 0;
    }

    protected Layout getLayout() {
        return this.layout;
    }

    protected void incrementMessages() {
        this.appendedMessages++;
    }

    @Override
    public abstract void append(String date, String reportLevel, String message);

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    @Override
    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d", this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.reportLevel,
                this.appendedMessages);

    }
}
