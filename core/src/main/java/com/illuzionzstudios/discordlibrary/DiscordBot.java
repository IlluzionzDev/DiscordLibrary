package com.illuzionzstudios.discordlibrary;

/**
 * Copyright © 2020 Property of Illuzionz Studios, LLC
 * All rights reserved. No part of this publication may be reproduced, distributed, or
 * transmitted in any form or by any means, including photocopying, recording, or other
 * electronic or mechanical methods, without the prior written permission of the publisher,
 * except in the case of brief quotations embodied in critical reviews and certain other
 * noncommercial uses permitted by copyright law. Any licensing of this software overrides
 * this statement.
 */

import com.illuzionzstudios.discordlibrary.command.CommandManager;
import com.illuzionzstudios.discordlibrary.command.type.Command;
import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

/**
 * Main class to extend to create a new discord bot
 */
public abstract class DiscordBot extends Launcher {

    /**
     * Token for the bot
     */
    @Getter
    public static String TOKEN;

    /**
     * Name of our discord bot
     */
    @Getter
    @Setter
    public String name;

    /**
     * The prefix to use for all commands, default is !
     */
    @Getter
    @Setter
    public static String commandPrefix = "!";

    /**
     * Default command manager for the bot
     */
    @Getter
    public CommandManager commandManager;

    /**
     * Instance of our builder to create the bot
     */
    @Getter
    public JDABuilder botBuilder;

    @Override
    public void initialize() {
        commandManager = new CommandManager();
        botBuilder = new JDABuilder();

        createBot();
        onBotStartup();
    }

    /**
     * Call if you want tp use commands
     */
    public void useCommands() {
        botBuilder.addEventListeners(commandManager);
    }

    /**
     * Set our bot token
     *
     * @param token Token to use
     */
    public void setToken(String token) {
        TOKEN = token;
        botBuilder.setToken(TOKEN);
    }

    /**
     * Shorthand to register a command
     */
    public void registerCommand(Command command) {
        this.commandManager.registerCommand(command);
    }

    /**
     * Create an instance of the bot
     */
    public abstract void createBot();

    /**
     * Called when the bot is created, then starts up
     */
    public abstract void onBotStartup();

}
