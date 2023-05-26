import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {
    private Pane pane;

	@Override
	public void start(Stage stage) {
	    // Create a Pane to hold the rectangles, text, lines, and branches
	    pane = new Pane();

	    // Get the list of blocks and create a rectangle and text for each one
	    ArrayList<Block> blocks = XMLParser.blocks;
	    ArrayList<Line> lines = XMLParser.lines;

	    for (Block block : blocks) {
	        int x = Math.min(block.getX1(), block.getX2());
	        int y = Math.min(block.getY1(), block.getY2());
	        int width = Math.abs(block.getX1() - block.getX2());
	        int height = Math.abs(block.getY1() - block.getY2());

	        Rectangle rectangle = new Rectangle(x, y, width, height);
	        rectangle.setFill(null);
	        rectangle.setStroke(Color.BLUE);
	        GaussianBlur blur = new GaussianBlur(2);
	        rectangle.setEffect(blur);

	        Text text = new Text(block.getName());
	        text.setX(x);
	        text.setY(y +height + 15);
	        text.setFont(new Font(10));

	        // Add the rectangle and text to the Pane
	        pane.getChildren().addAll(rectangle, text);
	        // Loop over the lines for the block and create a javafx.scene.shape.Line for each one
	        for (Line line :lines) {
	            if (line.getBranches()!=null )
	            {		
		            	for(Branch branch : line.getBranches()) 
		            	{
		                
		            		int X1=	branch.getX1();
		            		int Y1= branch.getY1();
		            		int X2= branch.getX2();
		            		int Y2= branch.getY2();
		            		drawLine(X1, Y1, X2,Y2);
		            		if(branch.xtemp!=0)
		            		{
		            			drawLineWOArrow(branch.xtemp,branch.ytemp,X1,Y1);
		            		}
		            	}
	            }

		        	int X1= line.getX1();
	                int Y1= line.getY1();
	                int X2= line.getX2();
	                int Y2= line.getY2();
		            if (line.branches.size() >1 ) {
		            	drawLineWOArrow(X1, Y1, X2,Y2);
		            }	
		            else {
		            	drawLine(X1, Y1, X2,Y2);
		            }

		           
		            
	            }
	        }


	    // Create a single Scene with the Pane as its root node
	    Scene scene = new Scene(pane, 800, 600);
	    stage.setScene(scene);
	    stage.show();
}

    
	public void drawLine(int startX, int startY, int endX, int endY) {
	    // Create a new javafx.scene.shape.Line object with the specified coordinates
	    javafx.scene.shape.Line line = new javafx.scene.shape.Line(startX, startY, endX, endY);
	    line.setStroke(Color.BLACK);

	    // Add the line to the Pane
	    pane.getChildren().add(line);
	    
	    // Create a new Arrow object and add it to the end of the line
	    Arrow arrow = new Arrow(startX, startY, endX, endY);
	    pane.getChildren().addAll(arrow);
	}
	
	public void drawLineWOArrow(int startX, int startY, int endX, int endY) {
		javafx.scene.shape.Line line = new javafx.scene.shape.Line(startX, startY, endX, endY);
	    line.setStroke(Color.BLACK);

	    // Add the line to the Pane
	    pane.getChildren().add(line);
	}
	 

    public static void main(String[] args) {
    	XMLParser XMLParser = new XMLParser();

        launch(args);

    }

}


