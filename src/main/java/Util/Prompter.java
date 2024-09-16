package Util;

import java.util.Scanner;

public class Prompter {
    Scanner scn = new Scanner(System.in);

    public String get(String msg) {
        System.out.print(msg);
        return scn.nextLine();
    }
}
