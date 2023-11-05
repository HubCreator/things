package thigns.domain;

import lombok.Getter;

@Getter
public class Proto {
    private int count = 0;

    public void add() {
        this.count++;
    }
}
