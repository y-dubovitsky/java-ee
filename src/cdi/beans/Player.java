package cdi.beans;

import javax.enterprise.inject.Alternative;

@Alternative
public class Player implements Humanable {

    @Override
    public String getName() {
        return "Player";
    }
}
