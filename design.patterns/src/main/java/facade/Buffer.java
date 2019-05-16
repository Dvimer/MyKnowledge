package facade;

import java.util.ArrayList;
import java.util.List;

public class Buffer {
    private char[] characters;
    private int lineWidth;

    public Buffer(int lineHight, int lineWidth) {
        this.characters = new char[lineHight * lineWidth];
        this.lineWidth = lineWidth;
    }

    public char charArt(int x, int y) {
        return characters[y * lineWidth + x];
    }

}

class Viewport {
    private final Buffer buffer;
    private final int width;
    private final int height;
    private final int offsetY;
    private final int offsetX;

    public Viewport(Buffer buffer, int width, int height, int offsetY, int offsetX) {
        this.buffer = buffer;
        this.width = width;
        this.height = height;
        this.offsetY = offsetY;
        this.offsetX = offsetX;
    }

    public char charAt(int x, int y) {
        return buffer.charArt(x + offsetX, y + offsetY);
    }
}

class Console {
    private List<Viewport> viewports = new ArrayList<>();
    int width, height;

    public Console(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addViewport(Viewport viewport) {
        viewports.add(viewport);
    }

    public static Console newConsole(int width, int height) {
        Buffer buffer = new Buffer(width, height);
        Viewport viewport = new Viewport(buffer, width, height, 0, 0);
        Console console = new Console(width, height);
        console.addViewport(viewport);
        return console;
    }

    public void render() {
        for (int x = 0; x < height; ++x) {
            for (int y = 0; y < width; ++y) {
                for (Viewport viewport : viewports) {
                    System.out.print(viewport.charAt(x, y));
                }
                System.out.println();
            }
        }
    }
}

class Demo {
    public static void main(String[] args) {
//        Buffer buffer = new Buffer(20, 30);
//        Viewport viewport = new Viewport(buffer, 30, 20, 0, 0);
//        Console console = new Console(30, 20);
//        console.addViewport(viewport);
//        console.render();

        Console console = Console.newConsole(222, 30);
        console.render();
    }
}
