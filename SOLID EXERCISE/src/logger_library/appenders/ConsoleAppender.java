package logger_library.appenders;

import logger_library.layouts.interfaces.Layout;


public class ConsoleAppender extends AppenderImpl {


    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String date, String reportLevel, String message) {
        this.incrementMessages();
        System.out.println(this.getLayout().format(date, reportLevel, message));
    }


}
