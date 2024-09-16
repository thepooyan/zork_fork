package Schema;

import Enums.Mood;
import Game.Game;
import Objects.Abstraction.Properties.Harmful;

public class Person {
    private final String name;
    private final String description;
    private final String AiPrompt;
    private final String[] keyInfo;
    private Mood mood = Mood.NORMAL;

    public Person(String name, String description, String aiPrompt, String[] keyInfo) {
        this.name = name;
        this.description = description;
        AiPrompt = aiPrompt;
        this.keyInfo = keyInfo;
    }

    public void Talk(Game game) {
        System.out.println("Hi, how are you?");
    }
    public void Kill(Game game, Harmful murderWeapon) {
        System.out.println("You try to kill him but no luck");
    }
    public void fuck(Game game) {
        System.out.println("you try to fuck him, but he won't let you");
    }
    public void give(Game game, Object gift) {
        System.out.println("your gift is of no interest to him");
    }
}