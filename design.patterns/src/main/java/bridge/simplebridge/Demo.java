package bridge.simplebridge;

import bridge.simplebridge.render.RasterRenderer;
import bridge.simplebridge.render.VectorRender;

public class Demo {
    public static void main(String[] args) {
        RasterRenderer raster = new RasterRenderer();
        VectorRender vector = new VectorRender();
        Circle circle = new Circle(vector, 5);
        Circle circleRas = new Circle(raster, 5);
        circle.draw();
        circle.resize(5);
        circle.draw();
        circleRas.draw();
    }


}
