public abstract class Util {
    
    public static double random(double a, double b) {
        return Math.random() * (b-a) + a;
    }
    
    public static float random(float a, float b) {
        return (float) (Math.random() * (b-a) + a);
    }
}
