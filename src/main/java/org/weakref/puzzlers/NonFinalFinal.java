package org.weakref.puzzlers;

public class NonFinalFinal
{
    private final int value;

    public NonFinalFinal()
    {
        invoke(this);
        value = 1;
        invoke(this);
    }

    public int getValue()
    {
        return value;
    }

    public static void invoke(NonFinalFinal instance)
    {
        System.out.println(instance.getValue());
    }

    public static void main(String[] args)
    {
        new NonFinalFinal();
    }
}
