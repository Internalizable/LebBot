package me.compilable.LebBot.utils;

import lombok.Getter;
import me.compilable.LebBot.politicians.PoliticiansEnum;
import twitter4j.*;
import twitter4j.auth.AccessToken;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TwitterHandler {

    @Getter public List<PoliticiansEnum> politicians = new ArrayList<PoliticiansEnum>();

    @Getter public static Timer timer;

    public void run() throws Exception {
        AsyncTwitterFactory factory = new AsyncTwitterFactory();
        AsyncTwitter asyncTwitter = factory.getInstance();

        asyncTwitter.setOAuthConsumer("JCQCl0X8KLabH9VL2iTJMHorS", "MpNSx4VES1iGRo7AIK1a0roHvmFSAbD8Lb7vWm7PBH7wTzot2S");
        AccessToken accessToken = new AccessToken("1187316505635164162-zXw41pCXGu4tzBYRguHJ2ep9q8RLJN", "LS87vgBlBFzZUwDhqXkGMLFash64fwLVnplouVMpXcxvT");
        asyncTwitter.setOAuthAccessToken(accessToken);

        TwitterListener listener = new TwitterAdapter() {
            @Override
            public void updatedStatus(Status status) {
                System.out.println("Successfully updated the status to [" +
                        status.getText() + "].");
            }
        };

        asyncTwitter.addListener(listener);

        populate();

        timer = new Timer();
        TimerTask task = new TweetTimer(asyncTwitter, this);

        timer.scheduleAtFixedRate(task, 0, TimeUnit.HOURS.toMillis(2));

    }

    public void populate() {
        Collections.addAll(politicians, PoliticiansEnum.values());
    }
}
