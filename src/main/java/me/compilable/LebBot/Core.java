package me.compilable.LebBot;

import me.compilable.LebBot.frame.FrameBuilder;

public class Core {

    public static boolean isOnline = false;

    public static void main(String args[]) {
        FrameBuilder frameBuilder = new FrameBuilder();
        frameBuilder.build();
    }

}
