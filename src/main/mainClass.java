package main;

import view.centralFormView;
import view.loginView;

import com.lowagie.text.pdf.codec.PngImage;

import controller.centralFormController;
import controller.loginController;
import model.loginModel;


public class mainClass {

	public static void main(String[] args) 
	{
		/*centralFormView theView = new centralFormView();
		centralFormController theControler = new centralFormController(theView);
		theView.setVisible(true);*/
		loginView view = new loginView();
		loginModel model = new loginModel();
		loginController controller = new loginController(view, model);
		view.setVisible(true);
	}

}


