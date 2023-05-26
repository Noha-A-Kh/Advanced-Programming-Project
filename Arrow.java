import javafx.scene.shape.Polygon;

class Arrow extends Polygon {
	    private final double arrowLength = 10;
	    private final double arrowWidth = 5;

	    public Arrow(double startX, double startY, double endX, double endY) {
	        // Calculate the angle and length of the line segment
	        double angle = Math.atan2((endY - startY), (endX - startX));
	        double length = Math.sqrt(Math.pow((endY - startY), 2) + Math.pow((endX - startX), 2));

	        // Calculate the points of the arrow polygon
	        double x1 = endX - arrowLength * Math.cos(angle) - arrowWidth * Math.sin(angle);
	        double y1 = endY - arrowLength * Math.sin(angle) + arrowWidth * Math.cos(angle);
	        double x2 = endX - arrowLength * Math.cos(angle) + arrowWidth * Math.sin(angle);
	        double y2 = endY - arrowLength * Math.sin(angle) - arrowWidth * Math.cos(angle);

	        // Add the points to the polygon
	        getPoints().addAll(endX, endY, x1, y1, x2, y2);

	        // Rotate the arrow to match the angle of the line segment
	        setRotate(Math.toDegrees(angle));
	    }
	}