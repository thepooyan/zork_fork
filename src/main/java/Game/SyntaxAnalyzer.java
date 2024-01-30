package Game;

import Actions.*;
import Enums.Direction;
import Actions.Read;
import Schema.Action;

public class SyntaxAnalyzer {
    Dictionary dictionary = new Dictionary();
    public Action analyzeResponse(String response) {
       response = response.toLowerCase();
       String[] chunks = response.split(" ");

       String actionLabel = dictionary.getActionLabel(chunks[0]);

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
            case "exit" -> {
                return new Exit();
            }
            case "read" -> {
               return new Read(chunks[1]);
            }
            case "pick" -> {
                return new Pick(chunks[1]);
            }
            case "open" -> {
                return new Open(chunks[1]);
            }
        }
    }
}