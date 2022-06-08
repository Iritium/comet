
<p align="center">
<img src="https://i.imgur.com/JpUxGBW.png" alt="meteor-client-logo" width="20%"/>
</p>

<p align="center">A custom fork of the popular Meteor Client.</p>


<h2 align="left">Commands Added</h2>

| Title | Description | Command | Arguments | 
| --- | --- | --- | --- |
| `Ram Buster Book` | Overload a servers ram usage via NBT tag overload (creative only) | `.bookcrash` | None | 
| `Coordinates` | Copy your current x, z coordinates to your clipboard or say in chat | `.coordinates` | clipboard / chat |

<h2 align="left">Modules Added</h2>

| Title | Description |
| --- | --- |
| `AutoLeave` | Automaticlly leave if a selected entity enters range |


<h2 align="left">Utils Added</h2>

#### Toast - Send a toast when doing a task

Function: sendToast( Title, Description )
```java
public class test extends Command {
    public BookCrashCommand() { super("test", "Shows a test toast!"); }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            sendToast("Test", "This is a test toast!");
            return SINGLE_SUCCESS;
        });
    }
}
```



## Credits
[Cabaletta](https://github.com/cabaletta) for [Baritone](https://github.com/cabaletta/baritone)  

The [Fabric Team](https://github.com/FabricMC) for [Fabric](https://github.com/FabricMC/fabric-loader) and [Yarn](https://github.com/FabricMC/yarn)

[Meteor Client](https://github.com/MeteorDevelopment/meteor-client) for the base of this client.

## Licensing
This project is licensed under the [GNU General Public License v3.0](https://www.gnu.org/licenses/gpl-3.0.en.html). 
