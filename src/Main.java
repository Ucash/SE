import gui.GameExpertFrame;

public class Main {

    public static void main(String[] args) {
        String path = String.format("%s/%s", System.getProperty("user.dir").replace('\\', '/'), "projekt1");
        GameExpertFrame.getInstance().open(path);
    }
}
