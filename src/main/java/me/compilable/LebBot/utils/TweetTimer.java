package me.compilable.LebBot.utils;

import me.compilable.LebBot.politicians.PoliticiansEnum;
import twitter4j.AsyncTwitter;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.TimerTask;

public class TweetTimer extends TimerTask {

    private AsyncTwitter asyncTwitter;
    private TwitterHandler twitterHandler;

    public TweetTimer(AsyncTwitter asyncTwitter, TwitterHandler twitterHandler) {
        this.asyncTwitter = asyncTwitter;
        this.twitterHandler = twitterHandler;
    }

    @Override
    public void run() {
        Collections.shuffle(twitterHandler.getPoliticians());
        PoliticiansEnum pickedPolitician = twitterHandler.getPoliticians().get(0);

        String updateMessage = pickedPolitician.getName() + " is a " + pickedPolitician.getType().build() + " that belongs to " + pickedPolitician.getGroup().build();
        File politicianFile = new File("C:\\Users\\Lenovo\\Desktop\\bot\\images\\" + pickedPolitician.name() + ".png");

        StatusUpdate status = new StatusUpdate(updateMessage);

        if(politicianFile.exists()) status.setMedia(politicianFile);

        asyncTwitter.updateStatus(status);

        twitterHandler.getPoliticians().remove(pickedPolitician);

        if(twitterHandler.getPoliticians().size() <= 0) twitterHandler.populate();
    }

}
