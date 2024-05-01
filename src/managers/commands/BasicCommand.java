package managers.commands;

public interface BasicCommand {
    public void execute(String[] args) throws Exception;

    public String getDescription();

    public String getName();
}
