import com.github.ityeri.comshop.argument.PaperTypes
import com.github.ityeri.comshop.argument.PrimitiveTypes
import com.github.ityeri.comshop.command
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.entity.Player


val newCommand = command("new") {
    arguments {
        "name" to PrimitiveTypes.string()
        "color" to PaperTypes.hexColor()
    }


    executes { source, sender ->
        val teamName = "name" to String::class
        val color = "color" to TextColor::class

        if (teamName !in teams) {
            teams[teamName] = Team(teamName, color)

            sender.sendMessage(
                Component.text("New team ")
                    .append(Component.text(teamName, color))
                    .append(Component.text(" is added"))
            )
        } else {
            sender.sendMessage("Team \"$teamName\" is already exists")
        }
    }
}

val addCommand = command("add") {
    arguments {
        "name" to PrimitiveTypes.string()
        "player" to PaperTypes.player()
    }

    executes { source, sender ->
        val teamName = "name" to String::class
        val team = teams[teamName]

        if (team != null) {
            val player = "player" to Player::class

            team.members.add(
                player
            )

            sender.sendMessage(
                Component.text("Player ${player.name} is added to ")
                    .append(Component.text(teamName, team.color))
            )
        } else {
            sender.sendMessage("Team \"$teamName\" not found")
        }
    }
}

val teamCommand = command("myteam") {
    requires { source -> source.sender.isOp }

    executes { source, sender ->
        sender.sendMessage("There are ${teams.size} teams:")

        teams.values.forEach { team ->
            sender.sendMessage(
                Component.text(" |  ")
                    .append(Component.text(team.name + "\n", team.color))
                    .append(Component.text(" |   |  members: "))
                    .append(Component.text(
                        team.members.joinToString(", ") { it.name }
                    ))
            )
        }
    }

    then(newCommand)
    then(addCommand)
}

val teams: MutableMap<String, Team> = mutableMapOf()

class Team(val name: String, val color: TextColor) {
    val members: MutableList<Player> = mutableListOf()
}