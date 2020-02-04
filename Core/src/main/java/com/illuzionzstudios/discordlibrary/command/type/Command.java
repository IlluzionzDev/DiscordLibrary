package com.illuzionzstudios.discordlibrary.command.type;

import lombok.Getter;
import net.dv8tion.jda.api.entities.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright © 2020 Property of Illuzionz Studios, LLC
 * All rights reserved. No part of this publication may be reproduced, distributed, or
 * transmitted in any form or by any means, including photocopying, recording, or other
 * electronic or mechanical methods, without the prior written permission of the publisher,
 * except in the case of brief quotations embodied in critical reviews and certain other
 * noncommercial uses permitted by copyright law. Any licensing of this software overrides
 * this statement.
 */

public abstract class Command {

    public Command(String name, String... aliases) {
        this.name = name;
        List<String> newAliases = Arrays.asList(aliases);
        this.aliases.addAll(newAliases);
    }

    /**
     * Name of command
     */
    @Getter
    public String name;

    /**
     * Alternate names for command
     */
    @Getter
    public List<String> aliases = new ArrayList<String>();

    /**
     * Run when command is called
     *
     * @param message The message object that was sent to call command
     * @param args Arguments following command
     */
    public abstract void execute(Message message, List<String> args);

    public void addAlias(String alias) {
        this.aliases.add(alias);
    }

}
