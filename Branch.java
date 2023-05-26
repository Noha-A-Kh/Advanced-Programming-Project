
import java.util.ArrayList;




public class Branch {

     String points = null;
    private String dst = null;
    int x1;
    int y1;
    int x2;
    int y2;
    int xtemp=0;
    int ytemp=0;
    void update_parameters(int x,int y,ArrayList<Block> blocks)
    {
        if(points==null)
        {
            this.x1=x;
            this.y1=y;
            this.y2=y;
            String[] arrOfStr = dst.split("#", -2);
            this.x2 =blocks.get(Integer.parseInt(arrOfStr[0])).x1;
        }else {
            this.x1=x;
            String[] arrOfStr = points.substring(1).split(",", -2);
            this.y1=y+(Integer.parseInt(arrOfStr[1].split("]",-2)[0].substring(1)));
           xtemp=x;
           ytemp=y;
            this.y2=y1;
            arrOfStr = dst.split("#", -2);
            this.x2 =blocks.get(Integer.parseInt(arrOfStr[0])).x1;
        }
    }
    public Branch(String dst){
        this.dst = dst;

    }
    /*public void setZOrder(int zOrder) {
        this.zOrder = zOrder;
    }

   public int getZOrder() {
        return zOrder;
    }*/

    public void setPoints(String points) {
        this.points = points;
    }

    public String getPoints() {
        return points;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public String getDst() {
        return dst;
    }
    
    public int getX1() {
		return x1;
	}
	public int getY1() {
		return y1;
	}
	public int getX2() {
		return x2;
	}
	public int getY2() {
		return y2;
	}
	public void print() {
        System.out.println("    Branch:");
        //System.out.println("      ZOrder: " + zOrder);
        if (points != null) {
            System.out.println("      Points: " + points);
        }
        System.out.println("      Dst: " + dst);
        
        System.out.println("x1 for branch: "+ this.x1);
        System.out.println("x2 for branch: "+ this.x2);
        System.out.println("y1 for branch: "+ this.y1);
        System.out.println("y2 for branch: "+ this.y2);

        
    }
	
}

