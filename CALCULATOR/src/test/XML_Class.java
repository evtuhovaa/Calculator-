
    package test;

    import java.io.File;
    import javax.swing.*;
    import javax.xml.parsers.DocumentBuilder;
    import javax.xml.parsers.DocumentBuilderFactory;
    import javax.xml.transform.Transformer;
    import javax.xml.transform.TransformerFactory;
    import javax.xml.transform.dom.DOMSource;
    import javax.xml.transform.stream.StreamResult;

    import org.w3c.dom.*;

    /**
     * @author Allex
     */
    public class XML_Class {

        NodeList reading_tree;
        Node read_tree_parent;
        Document doc;
        public boolean InitReadingTree(String path){
            File xml = new File(path);
            try {
                DocumentBuilderFactory dbFactory
                        = DocumentBuilderFactory.newInstance();
                dbFactory.setValidating(false);
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document docc = dBuilder.parse(xml);
                Node root = docc.getDocumentElement();
                Node getmdreply = root.getChildNodes().item(1);
                Node entity = getmdreply.getChildNodes().item(1);
                Node metadata = entity.getChildNodes().item(1);
                NodeList md_list = metadata.getChildNodes();
                reading_tree=md_list;
                read_tree_parent=metadata;
                doc=docc;
                return true;
            } catch (Exception ex) {JOptionPane.showMessageDialog(null, "Ошибка в функции open tree : "+ex.toString()); return false;
            }
        }

        public String get_value(String name){
            String outt = "";


            try {

                NodeList md_list = reading_tree;
                for (int i=0;i<md_list.getLength();i=i+1){
                    try{
                        Node curent= md_list.item(i);
                        NamedNodeMap map=curent.getAttributes();
                        if(map.item(1).getNodeValue().equals(name)){
                            outt=curent.getTextContent();break;}}catch(Exception exx){}
                }

            } catch (Exception ex) {JOptionPane.showMessageDialog(null, "Ошибка в функции get_value : "+ex.toString());
            }

            return outt;
        }

        public static String ReaD(String path, String name) {
            String outt = "";
            File xml = new File(path);

            try {
                DocumentBuilderFactory dbFactory
                        = DocumentBuilderFactory.newInstance();
                dbFactory.setValidating(false);
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(xml);
                Node root = doc.getDocumentElement();
                Node getmdreply = root.getChildNodes().item(1);
                Node entity = getmdreply.getChildNodes().item(1);
                Node metadata = entity.getChildNodes().item(1);
                NodeList md_list = metadata.getChildNodes();

                for (int i=1;i<md_list.getLength();i=i+2){
                    Node curent= md_list.item(i);
                    NamedNodeMap map=curent.getAttributes();
                    if(map.item(1).getNodeValue().equals(name)){
                        outt=curent.getTextContent();break;}
                }

            } catch (Exception ex) {JOptionPane.showMessageDialog(null, "Ошибка в функции get_value : "+ex.toString());
            }

            return outt;
        }

        public static void set_value_old(String path, String name,String type, String new_set) {

            File xml = new File(path);

            try {
                DocumentBuilderFactory dbFactory
                        = DocumentBuilderFactory.newInstance();
                dbFactory.setValidating(false);
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(xml);
                Node root = doc.getDocumentElement();
                Node getmdreply = root.getChildNodes().item(1);
                Node entity = getmdreply.getChildNodes().item(1);
                Node metadata = entity.getChildNodes().item(1);
                NodeList md_list = metadata.getChildNodes();
                boolean found=false;
                for (int i=1;i<md_list.getLength();i=i+2){
                    Node curent= md_list.item(i);
                    NamedNodeMap map=curent.getAttributes();
                    if(map.item(1).getNodeValue().equals(name)){
                        found=true; curent.setTextContent(new_set);break;}
                }

                if(!found&& !(new_set.equals("")||new_set.equals("--"))){
                    Element new_node = doc.createElement("mdValue");
                    new_node.setAttribute("dataType",type);
                    new_node.setAttribute("fieldName",name);
                    //new_node.setNodeValue(new_set);
                    new_node.setTextContent(new_set);
                    metadata.appendChild(new_node);
                }






                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(path));
                transformer.transform(source, result);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ошибка в функции set_value : "+ex.toString());
            }


        }

        public  void set_value( String path,String name,String type, String new_set) {


            try {

                NodeList md_list = reading_tree;
                boolean found=false;
                for (int i=0;i<md_list.getLength();i=i+1) {
                    try {
                        Node curent = md_list.item(i);
                        NamedNodeMap map = curent.getAttributes();
                        if (map.item(1).getNodeValue().equals(name)) {
                            found = true;
                            curent.setTextContent(new_set);
                            break;
                        }

                    } catch (Exception exx) {
                    }
                }
                if(!found&& !(new_set.equals("")||new_set.equals("--"))){
                    Element new_node = doc.createElement("mdValue");
                    new_node.setAttribute("dataType",type);
                    new_node.setAttribute("fieldName",name);
                    //new_node.setNodeValue(new_set);
                    new_node.setTextContent(new_set);
                    read_tree_parent.appendChild(new_node);
                }




                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(path));
                transformer.transform(source, result);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ошибка в функции set_value : "+ex.toString());
            }


        }

    }

