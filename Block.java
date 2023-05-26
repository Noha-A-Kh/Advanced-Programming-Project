import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;
import java.util.ArrayList;


class Block {
    private String name;
    private String type;
    private String sid;

    int x1;
    int y1;
    int x2;
    int y2;
    int input_num=1;
    ArrayList<String> inputs[];
    int output;
    ArrayList<Parameter> parametersList = new ArrayList<>();
    
    public Block() {
	}
	public void update_parameters()
    {
    
        for(Parameter a:this.parametersList){

            if(a.getName().equals("Position"))
            {
                String data=a.getValue().substring(1);
                String[] arrOfStr = data.split(",", -2);
                x1 = Integer.parseInt(arrOfStr[0]);
                y1 =Integer.parseInt(arrOfStr[1].substring(1));
                x2=Integer.parseInt(arrOfStr[2].substring(1));
                y2=Integer.parseInt(arrOfStr[3].substring(1).split("]", -2)[0]);
           
          }

        }
    }
    public Block(String name, String type, String sid ) {
        this.name = name;
        this.type = type;
        this.sid = sid;


    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSID() {
        return sid;
    }
	public int getX1() {
		update_parameters();
		return x1;
	}
	public int getY1() {
		update_parameters();
		return y1;
	}
	public int getX2() {
		update_parameters();
		return x2;
	}
	public int getY2() {
		update_parameters();
		return y2;
	}  
        
        
         
        public void print(){
            System.out.println("block name: " + this.name);
            System.out.println("block type: " + this.type);
            System.out.println("block id: "+ this.sid);
            
            System.out.println("x1 : "+ this.x1);
            System.out.println("x2 : "+ this.x2);
            System.out.println("y1 : "+ this.y1);
            System.out.println("y2 : "+ this.y2);
            
            System.out.println("number of input ports: " + this.input_num );
            
            
            for(Parameter a:this.parametersList){
                a.print();
            }
            
            
            //call print parameter
        }
} 

/*public class Block {
        private String name;
        private String type;
        private String sid;
        
        
         ArrayList<Parameter> parametersList = new ArrayList<>();
        
        public Block(String name, String type, String sid ) {
            this.name = name;
            this.type = type;
            this.sid = sid;
           
           
        }
        
        public String getName() {
            return name;
        }
        
        public String getType() {
            return type;
        }
        
        public String getSID() {
            return sid;
        }
        
        
        
        public void print(){
            System.out.println("block name: " + this.name);
            System.out.println("block type: " + this.type);
            System.out.println("block id: "+ this.sid);
            
            for(Parameter a:this.parametersList){
                a.print();
            }
            
            
            //call print parameter
        }

    
    }
*/
