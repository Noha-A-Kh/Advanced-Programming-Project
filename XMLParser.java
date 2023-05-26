import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class XMLParser {

    public static ArrayList<Block> blocks = new ArrayList<>();
    public static ArrayList<Line> lines = new ArrayList<>();

    public XMLParser() {
 
        try {
            File xmlFile = new File("ProjectFile2.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList blockList = doc.getElementsByTagName("Block");

     
            for (int i = 0; i < blockList.getLength(); i++) {

                Element blockElement = (Element) blockList.item(i);
                String blockName = blockElement.getAttribute("Name");
                String blockType = blockElement.getAttribute("BlockType");
                String blockSID = blockElement.getAttribute("SID");

                Block block = new Block(blockName, blockType, blockSID);

                blocks.add(block);
              

                NodeList parameterList = blockElement.getElementsByTagName("P");
                for (int j = 0; j < parameterList.getLength(); j++) {
                    Element parameterElement = (Element) parameterList.item(j);

                    String paramName = parameterElement.getAttribute("Name");
                    String paramValue = parameterElement.getTextContent();

                    Parameter parameter = new Parameter(paramName, paramValue);
                    block.parametersList.add(parameter);
         
                }
            }
            for (Block a : blocks) {
                a.update_parameters();
            }

            /////////////////////////////////////////////////////////////////////
            NodeList lineList = doc.getElementsByTagName("Line");
            boolean hasPointsParam = false;
            String pointsParamValue = null;

            for (int temp = 0; temp < lineList.getLength(); temp++) {

                Element lineElement = (Element) lineList.item(temp);
                Line line = new Line();
                line.setSrc(lineElement.getElementsByTagName("P").item(1).getTextContent());

                NodeList branchNodes = lineElement.getElementsByTagName("Branch");
                NodeList lineParamNodes = lineElement.getElementsByTagName("P");

                    for (int s = 0; s < lineParamNodes.getLength(); s++) {
                        Element paramElement = (Element) lineParamNodes.item(s);
                        String paramName = paramElement.getAttribute("Name");
                        if (paramName.equals("Points")) {
                            hasPointsParam = true;
                            pointsParamValue = paramElement.getTextContent();
                            line.setPoints(pointsParamValue);
                            break;
                        }
                    }

                if (branchNodes.getLength() == 0) {

                    

              
                    NodeList branchParamNodes = lineElement.getElementsByTagName("P");
                    Element lastParamElement = (Element) branchParamNodes.item(branchParamNodes.getLength() - 1);
                    String lastParamValue = lastParamElement.getTextContent();
                    line.setDst(lastParamValue);
                } else {

                    for (int j = 0; j < branchNodes.getLength(); j++) {

                        Element branchElement = (Element) branchNodes.item(j);
                        NodeList branchParamNodes = branchElement.getElementsByTagName("P");

                        Element branchLastParamElement = (Element) branchParamNodes.item(branchParamNodes.getLength() - 1);
                        String branchLastParamValue = branchLastParamElement.getTextContent();
                        Branch branch = new Branch(branchLastParamValue);

                        for (int w = 0; w < branchParamNodes.getLength(); w++) {
                            Element paramElement = (Element) branchParamNodes.item(w);
                            String paramName = paramElement.getAttribute("Name");
                            if (paramName.equals("Points")) {
                                hasPointsParam = true;
                                pointsParamValue = paramElement.getTextContent();
                                branch.setPoints(pointsParamValue);
                                break;
                            }
                        }

                        line.addBranch(branch);
                    }

                }
                lines.add(line);
            }
            ArrayList<Block> sortedBlocks = new ArrayList<>();
            
            for(int r = 0; r<9; r++){
                sortedBlocks.add(blocks.get(0)); 
            }
            for(Block x: blocks){
                sortedBlocks.set(Integer.parseInt(x.getSID()), x);
            }
        
            for(Line x:lines){
                x.update_parameters(sortedBlocks);
            }
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }

       
    }
}
