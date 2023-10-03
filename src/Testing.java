public class Testing {
    public static void main(String[] args) {
        TestSubA s1 = new TestSubA();
        TestSubB s2 = new TestSubB();

        s1.printA();
        s2.printA();
        TestSubA.printA();
        TestSubB.printA();
        s1.printA();
        s2.printA();
        TestSubA.printA();
        TestSubB.printA();
    }
}
