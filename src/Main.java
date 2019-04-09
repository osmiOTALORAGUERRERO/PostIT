import controller.PostIt;
import views.PostItGUI;

public class Main {

	public static void main(String[] args) {
		PostItGUI piGui = new PostItGUI();
		PostIt postIt = new PostIt(piGui);
	}

}
	