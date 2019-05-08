package bridge.googleguice;

import bridge.simplebridge.render.Renderer;
import bridge.simplebridge.render.VectorRender;
import com.google.inject.AbstractModule;

public class ShapeModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Renderer.class).to(VectorRender.class);
    }
}
