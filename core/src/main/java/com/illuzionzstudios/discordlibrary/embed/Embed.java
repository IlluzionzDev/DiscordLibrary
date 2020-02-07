package com.illuzionzstudios.discordlibrary.embed;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

/**
 * Copyright © 2020 Property of Illuzionz Studios, LLC
 * All rights reserved. No part of this publication may be reproduced, distributed, or
 * transmitted in any form or by any means, including photocopying, recording, or other
 * electronic or mechanical methods, without the prior written permission of the publisher,
 * except in the case of brief quotations embodied in critical reviews and certain other
 * noncommercial uses permitted by copyright law. Any licensing of this software overrides
 * this statement.
 */

/**
 * Custom made embed that we can reuse
 */
public abstract class Embed {

    /**
     * Instance of embed builder to use
     */
    protected EmbedBuilder embed = new EmbedBuilder();

    /**
     * Create the embed and return as a message embed
     */
    public abstract MessageEmbed createEmbed();

}
