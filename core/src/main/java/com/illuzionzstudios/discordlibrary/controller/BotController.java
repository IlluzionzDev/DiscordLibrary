package com.illuzionzstudios.discordlibrary.controller;

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

/**
 * A controller class for the bot
 */
public interface BotController {

    /**
     * Start the controller
     *
     * @param bot Main bot class
     */
    void initialise(DiscordBot bot);

}
