package fr.maxlego08.essentials.commands.commands.worldedit;

import fr.maxlego08.essentials.api.EssentialsPlugin;
import fr.maxlego08.essentials.api.commands.CommandResultType;
import fr.maxlego08.essentials.api.commands.Permission;
import fr.maxlego08.essentials.api.messages.Message;
import fr.maxlego08.essentials.api.worldedit.MaterialPercent;

import java.util.List;

public class CommandWorldEditFill extends WorldeditCommand {

    public CommandWorldEditFill(EssentialsPlugin plugin) {
        super(plugin);
        this.setPermission(Permission.ESSENTIALS_WORLDEDIT_FILL);
        this.setDescription(Message.DESCRIPTION_WORLDEDIT_FILL);
        this.addSubCommand("fill");
    }

    @Override
    protected CommandResultType perform(EssentialsPlugin plugin) {

        var result = getMaterialPercents();
        if (result.commandResultType() != CommandResultType.SUCCESS) return CommandResultType.DEFAULT;

        List<MaterialPercent> materialPercents = result.materialPercents();
        if (materialPercents.isEmpty()) return CommandResultType.SYNTAX_ERROR;

        plugin.getWorldeditManager().fillBlocks(this.user, materialPercents);

        return CommandResultType.SUCCESS;
    }


}
