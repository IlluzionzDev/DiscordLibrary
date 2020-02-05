package com.illuzionzstudios.discordlibrary.command;

/**
 * Copyright © 2020 Property of Illuzionz Studios, LLC
 * All rights reserved. No part of this publication may be reproduced, distributed, or
 * transmitted in any form or by any means, including photocopying, recording, or other
 * electronic or mechanical methods, without the prior written permission of the publisher,
 * except in the case of brief quotations embodied in critical reviews and certain other
 * noncommercial uses permitted by copyright law. Any licensing of this software overrides
 * this statement.
 */

import com.illuzionzstudios.discordlibrary.DiscordBot;
import com.illuzionzstudios.discordlibrary.command.type.Command;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Handles execution of commands
 */
public class CommandManager extends ListenerAdapter {

    /**
     * Registered commands
     */
    private Set<Command> commands = new HashSet<Command>();

    public void registerCommand(Command command) {
        System.out.println("Registered command " + command.getName());
        this.commands.add(command);
    }

    /**
     * Find a command from name or alias
     */
    public Command getCommand(String name) {
        System.out.println(this.commands);
        for (Command com : this.commands) {
            if (com.getName().equalsIgnoreCase(name)) return com;
            for (String alias : com.aliases) {
                if (alias.equalsIgnoreCase(name)) return com;
            }
        }

        return null;
    }

    /**
     * Chat event to execute commands
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getAuthor().isBot()) return;
        Message message = event.getMessage();

        // Has requested to execute command
        if (message.getContentRaw().startsWith(DiscordBot.getCommandPrefix())) {
            String[] args = message.getContentRaw().split(" ");
            String[] newArgs = Arrays.copyOfRange(args, 1, args.length);
            Command command = getCommand(args[0]);

            if (command != null) {
                command.execute(message, newArgs);
            }
        }

    }

}
