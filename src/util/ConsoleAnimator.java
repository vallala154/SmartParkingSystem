package util;

public class ConsoleAnimator {

    public static void startup(){

        try{

            System.out.println("Loading system...");
            Thread.sleep(800);

            System.out.println("Initializing modules...");
            Thread.sleep(800);

            System.out.println("Preparing parking slots...");
            Thread.sleep(800);

        }catch(Exception e){}

        System.out.println(
        		"                __..-======-------..__\n" +
        		"            . '    ______    ___________`.\n" +
        		"          .' .--. '.-----.`. `.-----.-----`.\n" +
        		"         / .'   | ||      `.` \\\\     \\     \\\\            _\n" +
        		"       .' /     | ||        \\\\ \\\\_____\\_____\\\\__________[_]\n" +
        		"      /   `-----' |'---------`\\  .'                       \\\n" +
        		"     /============|============\\'-------------------.._____|\n" +
        		"  .-`---.         |-==.        |'.__________________  =====|-._\n" +
        		".'        `.      |            |      .--------.    _` ====|  _ .\n" +
        		"/     __     \\     |            |   .'           `. [_] `.==| [_] \\\n" +
        		"[   .`    `.  |     |            | .'     .---.     \\      \\=|     |\n" +
        		"|  | / .-. '  |_____\\___________/_/     .'---. `.    |     | |     |\n" +
        		"`-'| | O |'..`------------------'.....'/ .-. \\ |    |       ___.--'\n" +
        		"   \\ `-' / /   `._.'                 | | O | |'___...----''___.--'\n" +
        		"    `._.'.'                           \\ `-' / [___...----''_.'\n" +
        		"                                       `._.'.'\n"
        		);

        System.out.println("\n🚗 SMART CAR PARKING MANAGEMENT SYSTEM 🚗\n");
    }
}