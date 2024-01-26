package game;

import Actions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SyntaxAnalyzer {
    Dictionary dictionary = new Dictionary();
    public Action analyzeResponse(String response) {
       String[] chunks = response.split(" ");

       Integer actionID = dictionary.maps.get(chunks[0]);
       String actionLabel = dictionary.actions.get(actionID);

        switch (actionLabel) {
            default -> {
                return new Idol();
            }
            case "move" -> {
                Direction direction = switch (chunks[1]) {
                    case "up", "north" -> Direction.north;
                    case "down", "south" -> Direction.south;
                    case "left", "west" -> Direction.west;
                    case "right", "east" -> Direction.east;
                    default -> null;
                };
                return new Move(direction);
            }
            case "describe" -> {
                return new DescribeView();
            }
        }
    }
}
