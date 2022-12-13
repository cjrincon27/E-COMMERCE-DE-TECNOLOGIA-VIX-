package ChallengeFinal.utils;

public final class Utils {

    public static int getActivationCode() {
        return (int) ((Math.random()* (99999 - 10000))+ 10000);
    }

}
