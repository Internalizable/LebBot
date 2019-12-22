package me.compilable.LebBot.frame;

import me.compilable.LebBot.Core;
import me.compilable.LebBot.utils.TwitterHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameBuilder {

    public void build() {
        final JFrame frame = new JFrame();

        frame.setTitle("Lebanese Politicians Handler");

        frame.setSize(600, 400);
        frame.setLocation(200, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        final JButton startStopBot = new JButton();
        startStopBot.setBounds(100,100,140, 40);
        editRunButton(startStopBot);

        frame.add(startStopBot);

        startStopBot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Core.isOnline = !Core.isOnline;
                editRunButton(startStopBot);
            }
        });
    }

    public void editRunButton(JButton startStopBot) {

        if(Core.isOnline) {
            startStopBot.setText("Stop bot");

            TwitterHandler twitterHandler = new TwitterHandler();

            try {
                twitterHandler.run();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            startStopBot.setText("Start bot");

            if(TwitterHandler.getTimer() != null) TwitterHandler.getTimer().cancel();
        }
    }

}
