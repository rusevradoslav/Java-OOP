package logger_library.layouts;

import logger_library.layouts.interfaces.Layout;

public class XmlLayout implements Layout {
    @Override
    public String format(String date, String reportLevel, String message) {
        return String.format("<log>%n" +
                " <date>%s</date>%n" +
                " <level>%s</level>%n" +
                " <message>%s</message>%n" +
                "</log>%n", date, reportLevel, message);
    }
}
