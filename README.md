# DiscordLibrary

DiscordLibrary is a prebuilt library to make Discord Bots with JDA very easy. It includes helper methods and libraries and an easy way to create a new bot.

## Adding to project

To add this to your project you can currently only use maven

```xml
<repository>
    <id>maven</id>
    <url>http://118.82.196.98:8081/repository/maven-releases/</url>
</repository>

<dependency>
    <groupId>com.illuzionzstudios</groupId>
    <artifactId>discord-library</artifactId>
    <version>1.0</version>
</dependency>
```

## Usage
To use this library, first you should extend the DiscordBot class and implement DiscordApplication like so. Must implemented methods along with docs are shown

```java
public class MyDiscordBot extends DiscordBot implements DiscordApplication {

    public MyDiscordBot() {
        // Must call super here to init
        super();
        
        // Must register the new application here
        registerApplication(this);
    }

    /**
     * Entry point of bot
     */
    public static void main(String[] args) {
        new IlluzionzServicesBot();
    }

    // Called when the application starts up
    @Override
    public void start() {

    }

    // Use to build your app, actually building is done automatically
    // just config here
    @Override
    public void buildApplication() {
        // Allow the bot to use the command library
        useCommands();

        // Set bot token
        setToken("myToken");
        botBuilder.setActivity(Activity.playing("$help"));
    }

    // Called when everything is loaded
    @Override
    public void loaded() {
        // Set the global command prefix
        setCommandPrefix("$");
    }
}
```

## More
More will be added to README when more docs are available
