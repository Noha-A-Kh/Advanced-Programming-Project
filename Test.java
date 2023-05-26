
public class Test {

	public static void main(String[] args) {
        XMLParser XMLParser = new XMLParser();
       
       for(Block a: XMLParser.blocks){
           a.print();
       }
       for(Line l: XMLParser.lines){
           l.print();
       }
       
    }
}

