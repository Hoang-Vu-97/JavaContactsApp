
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Myfunc {
    
    public ImageIcon resizePic(String picPath, byte[] BLOBpic, int wdth, int hgt) {
        
        ImageIcon myImg;
        
        if(picPath != null)
        {
           myImg = new ImageIcon(picPath);
        }else {
           myImg = new ImageIcon(BLOBpic);
        }
        
       
        Image img = myImg.getImage().getScaledInstance(wdth, hgt, Image.SCALE_SMOOTH);
        ImageIcon myPicture = new ImageIcon(img);
        return myPicture;
    }
    
    public String browseImage(JLabel lb1) {
        
        String path = "";
        JFileChooser filec = new JFileChooser();
        filec.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        
        // file extension
        
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("*.Image","png","jpg","gif");
        filec.addChoosableFileFilter(fileFilter);
        
        int fileState = filec.showSaveDialog(null);
        
        // if the user select a file
        
        if(fileState == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = filec.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            
            
            // display the image in jlabel using resize image
            lb1.setIcon(resizePic(path, null, lb1.getWidth(), lb1.getHeight()));
            
            //jLabelPic.setIcon(new ImageIcon(path));
            
        } 
        // if the user cancel
        else if  (fileState == JFileChooser.CANCEL_OPTION)
        {
            System.out.println("No image selected");
        }
        
        return path;
    }
}
