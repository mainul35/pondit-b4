package com.pondit.b4.class5.inheritance.scenario1;

public class Human extends Homininae{
    boolean hasStrongGrippingAbility = true;
    boolean canTalk = true;

    @Override
    public String toString() {
        return "Human{" +
                "areMammals=" + areMammals +
                ", canSmile=" + canSmile +
                ", haveFeelings=" + haveFeelings +
                ", haveFamily=" + haveFamily +
                ", hasStrongGrippingAbility=" + hasStrongGrippingAbility +
                ", canTalk=" + canTalk +
                '}';
    }
}
