public class Interface {

    //PWEASSE ADD THIS FUNCTION TO INTERFASE MISTER BAROTZS BIRALyo
    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    //CONSIDER ADDING THIS FUNCTION OR SOMETHING SIMILAR TO INTERFASE MISTER BAROTZS BIRALyo
    public static void loadingScreen() {
        System.out.println("\n");
        System.out.print("||");
        Interface.wait(500);
        System.out.print("==========");
        Interface.wait(500);
        System.out.print("==========");
        Interface.wait(500);
        System.out.print("==========");
        Interface.wait(500);
        System.out.print("==========");
        Interface.wait(500);
        System.out.print("||");
        System.out.println("\n");
    }
}
