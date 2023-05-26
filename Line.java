import java.util.ArrayList;

class Line {

    private int zOrder ;
    private String src =null;
    private String dst =null;
    private String points =null;
    ArrayList<Branch> branches;
    int x1;
    int y1;
    int x2;
    int y2;
   

    void update_parameters(ArrayList<Block> blocks)
    {
        String[] arrOfStr = src.split("#", -2);
        this.x1 =blocks.get(Integer.parseInt(arrOfStr[0])).x2;
        this.y1 =blocks.get(Integer.parseInt(arrOfStr[0])).y2-((blocks.get(Integer.parseInt(arrOfStr[0])).y2-blocks.get(Integer.parseInt(arrOfStr[0])).y1)/2);
        if(points == null)
        {
            arrOfStr = dst.split("#", -2);
            this.x2 =blocks.get(Integer.parseInt(arrOfStr[0])).x1;
            this.y2 =blocks.get(Integer.parseInt(arrOfStr[0])).y1+((blocks.get(Integer.parseInt(arrOfStr[0])).y2-blocks.get(Integer.parseInt(arrOfStr[0])).y1)/2);

        }
        else
        {
            arrOfStr = points.substring(1).split(",", -2);
            this.x2=this.x1+(Integer.parseInt(arrOfStr[0]));
            this.y2=this.y1;
            if(branches.size()>0){
                for(Branch x :branches)
            {
                x.update_parameters(this.x2,this.y2, blocks);
            }
            }
            
        }
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getPoints() {
        return points;
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

	public Line() {
        branches = new ArrayList<>();
    }

    public void setZOrder(int zOrder) {
        this.zOrder = zOrder;
    }

    public int getZOrder() {
        return zOrder;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getSrc() {
        return src;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public String getDst() {
        return dst;
    }

    public void addBranch(Branch branch) {
        branches.add(branch);
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void print() {
        System.out.println("Line:");
        // System.out.println("  ZOrder: " + zOrder);
        System.out.println("  Src: " + src);
        System.out.println("  Dst: " + dst);
        System.out.println("Points: "+ this.points);
        System.out.println("  Branches:");

        for(Branch a: this.branches){
            a.print();
        }
        
        System.out.println("x1 for line: "+ this.x1);
        System.out.println("x2 for line: "+ this.x2);
        System.out.println("y1 for line: "+ this.y1);
        System.out.println("y2 for line: "+ this.y2);
        

    }
}

