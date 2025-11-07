package ca.shuckle.command;

import ca.shuckle.state.ModStateManager;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class OxidizeFasterCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("oxidizeFaster")
                        .executes(OxidizeFasterCommand::query)
                .then(CommandManager.argument("value", BoolArgumentType.bool())
                        .requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(2))
                        .executes(OxidizeFasterCommand::run)));
    }

    private static int query(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        boolean value = ModStateManager.getServerState(context.getSource().getServer()).getOxidizeFaster();
        context.getSource().sendFeedback(Text.literal("oxidizeFaster is currently set to: " + value), true);
        return 1;
    }

    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        boolean value = BoolArgumentType.getBool(context, "value");

        ModStateManager.getServerState(context.getSource().getServer()).setOxidizeFaster(value);

        if (value) {
            context.getSource().sendFeedback(Text.literal("Copper now oxidizes faster!"), true);
        } else {
            context.getSource().sendFeedback(Text.literal("Copper now oxidizes normally!"), true);
        }

        return 1;
    }
}
