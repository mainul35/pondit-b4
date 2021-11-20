package com.pondit.b4.class5.inheritance.scenario1;

public class Chimpanzee extends Homininae{
    boolean hasLongLeg = true;
    boolean hasLongHair = true;

    @Override
    public String toString() {
        return "Chimpanzee{" +
                "hasLongLeg=" + hasLongLeg +
                ", hasLongHair=" + hasLongHair +
                ", areMammals=" + areMammals +
                ", canSmile=" + canSmile +
                ", haveFeelings=" + haveFeelings +
                ", haveFamily=" + haveFamily +
                '}';
    }
}
