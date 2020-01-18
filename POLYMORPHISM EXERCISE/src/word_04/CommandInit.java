package word_04;


import java.util.List;

public class CommandInit extends CommandImpl {


    public CommandInit(StringBuilder text) {
        super(text);
    }

    @Override
    protected List<Command> initCommands() {
        List<Command> commands = super.initCommands();
        CutTransformation cutTransformation = new CutTransformation();
        commands.add(new Command("cut", cutTransformation));
        commands.add(new Command("paste", new PasteTransformation(cutTransformation)));
        return commands;
    }

}

