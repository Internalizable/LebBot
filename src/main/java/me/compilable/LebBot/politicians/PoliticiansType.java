package me.compilable.LebBot.politicians;

import org.apache.commons.text.WordUtils;

public enum PoliticiansType {
    PARLIAMENT_MEMBER, GOVERNMENT_MEMBER, POLITICAL_LEADER, OLD_POLITICIAN;

    public String build() {
        return WordUtils.capitalizeFully(this.name().replaceAll("_", " "));
    }
}
