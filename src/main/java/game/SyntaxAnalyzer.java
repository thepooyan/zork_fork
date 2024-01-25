package game;

import Actions.Action;
import Actions.Direction;
import Actions.Idol;
import Actions.Move;

public class SyntaxAnalyzer {
    public Action analyzeResponse(String response) {
       String[] chunks = response.split(" ");
       switch (chunks[0]) {
           case "go":
               Direction direction = null;
               switch (chunks[1]) {
                   case "up":
                   case "north":
                       direction = Direction.north;
                       break;
                   case "down":
                   case "south":
                       direction = Direction.south;
                       break;
                   case "left":
                   case "west":
                       direction = Direction.west;
                       break;
                   case "right":
                   case "east":
                       direction = Direction.east;
                       break;
               }
               return new Move(direction);
           default:
               return new Idol();
       }
    }
}
