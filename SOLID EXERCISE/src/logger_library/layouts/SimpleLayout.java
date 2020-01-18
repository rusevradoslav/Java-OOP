package logger_library.layouts;

import logger_library.layouts.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String format(String date, String reportLevel, String message) {
      return   String.format("%s - %s - %s", date, reportLevel, message);
    }
}
