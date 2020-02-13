package com.illuzionzstudios.discordlibrary.embed;

import com.illuzionzstudios.discordlibrary.DiscordBot;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;

/**
 * Copyright © 2020 Property of Illuzionz Studios, LLC
 * All rights reserved. No part of this publication may be reproduced, distributed, or
 * transmitted in any form or by any means, including photocopying, recording, or other
 * electronic or mechanical methods, without the prior written permission of the publisher,
 * except in the case of brief quotations embodied in critical reviews and certain other
 * noncommercial uses permitted by copyright law. Any licensing of this software overrides
 * this statement.
 */

public class NoPermissionEmbed extends Embed {

    @Override
    public MessageEmbed createEmbed() {
        embed.setTitle(DiscordBot.getName());

        embed.setColor(Color.RED);

        embed.addField("ERROR", "You don't have permission", false);

        return embed.build();
    }
}
