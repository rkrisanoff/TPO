package com.ts.ts.domain;

import lombok.Data;

@Data
public class Engine {

    private TypeOfVolume sound = TypeOfVolume.WHISTLE;

    // Увеличение уровня шума
    public void increaseSound() throws Exception{
        if (sound.ordinal() + 1 >= TypeOfVolume.values().length) throw new Exception("Incorrect level of volume");
        this.sound = TypeOfVolume.values()[sound.ordinal() + 1];
    }

    // Уменьшение уровня шума
    public void decreaseSound() throws Exception{
        if (sound.ordinal() - 1 < 0) throw new Exception("Incorrect level of volume");
        this.sound = TypeOfVolume.values()[sound.ordinal() - 1];
    }

}
