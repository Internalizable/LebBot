package me.compilable.LebBot.politicians;

import org.apache.commons.text.WordUtils;

public enum PoliticiansGroup {
    FPM, LEBANESE_DEMOCRATIC_PARTY, MARADA, TASHNAG, SOLIDARITY_MOUVEMENT, AMAL, HEZBOLLAH, SSNP, BAATH,
    PROGRESSIVE_SOCIALIST_PARTY, GLORY_MOUVEMENT, FUTURE, LEBANESE_FORCES, KATAEB, MURR_BLOCK, HUNCHAKIAN, ISLAMIC_GROUP, ARMENIAN_DEMOCRATIC,
    AZM, INDEPENDENCE_MOUVEMENT, NASSERITE, NATIONAL_LIBERAL_PARTY, INDEPENDENT;

    public String build() {
        return WordUtils.capitalizeFully(this.name().replaceAll("_", " "));
    }
}
