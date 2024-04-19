package uk.ac.cf.cm6123.blackjack;

public class BlackjackPlayer {

    private String name;
    private BlackjackHand hand;
    private Boolean stand;

    public BlackjackPlayer(String aName) {
        name = aName;
        stand = Boolean.FALSE;
        clearHand();
    }

    public String getName() {
        return name;
    }

    public BlackjackHand getHand() {
        return hand;
    }

    public boolean canHit() {
        return !stand;
    }

    public void clearHand() {
        hand = new BlackjackHand();
        stand = Boolean.FALSE;
    }

    public void stand() {
        stand = Boolean.TRUE;
    }

    public Boolean isActive() {
        return !stand && hand.canHit();
    }
}
