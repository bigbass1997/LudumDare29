package tm.info.bigbass1997.ld29.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import tm.info.bigbass1997.ld29.GraphicsMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Ocean Extinction";
		config.resizable = false;
		config.width = 780;
		config.height = 640;
		new LwjglApplication(new GraphicsMain(), config);
	}
}
