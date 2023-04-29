package by.pvt.predkel.utils.report;

import org.docx4j.dml.wordprocessingDrawing.Inline;
import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.BinaryPartAbstractImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Добавление изображений в docx
 */
public class ImageAdd {

    public void chartToReport(WordprocessingMLPackage wordMLPackage, String filepath) throws Exception {

        // The image to add
        File file = new File(filepath);

        // Our utility method wants that as a byte array
        InputStream is = new FileInputStream(file);
        long length = file.length();
        // You cannot create an array using a long type.
        // It needs to be an int type.
        if (length > Integer.MAX_VALUE) {
            System.out.println("File too large!!");
        }
        byte[] bytes = new byte[(int) length];
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            System.out.println("Could not completely read file " + file.getName());
        }
        is.close();

        String filenameHint = null;
        String altText = null;
        int id1 = 0;
        int id2 = 1;


        // Image 1: no width specified
        org.docx4j.wml.P p = newImage(wordMLPackage, bytes,
                filenameHint, altText,
                id1, id2);
        wordMLPackage.getMainDocumentPart().addObject(p);
        // Image 2: width 3000
   /*     org.docx4j.wml.P p2 = newImage( wordMLPackage, bytes,
                filenameHint, altText,
                id1, id2, 3000 );
        wordMLPackage.getMainDocumentPart().addObject(p2);

        // Image 3: width 6000
        org.docx4j.wml.P p3 = newImage( wordMLPackage, bytes,
                filenameHint, altText,
                id1, id2, 6000 );
        wordMLPackage.getMainDocumentPart().addObject(p3);*/


    }
    // public static void inputImage

    /**
     * Создание изображения без изменений размеров, в формате docx (масштаб)
     */
    public static org.docx4j.wml.P newImage(WordprocessingMLPackage wordMLPackage,
                                            byte[] bytes,
                                            String filenameHint, String altText,
                                            int id1, int id2) throws Exception {

        BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wordMLPackage, bytes);

        Inline inline = imagePart.createImageInline(filenameHint, altText,
                id1, id2, false);

        // Now add the inline in w:p/w:r/w:drawing
        org.docx4j.wml.ObjectFactory factory = Context.getWmlObjectFactory();
        org.docx4j.wml.P p = factory.createP();
        org.docx4j.wml.R run = factory.createR();
        p.getContent().add(run);
        org.docx4j.wml.Drawing drawing = factory.createDrawing();
        run.getContent().add(drawing);
        drawing.getAnchorOrInline().add(inline);

        return p;

    }

    /**
     * Создание изображения c изменениями размеров, в формате docx (масштаб)
     */
   /* public static org.docx4j.wml.P newImage( WordprocessingMLPackage wordMLPackage,
                                             byte[] bytes,
                                             String filenameHint, String altText,
                                             int id1, int id2, long cx) throws Exception {

        BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wordMLPackage, bytes);

        Inline inline = imagePart.createImageInline( filenameHint, altText,
                id1, id2, cx, false);

        // Now add the inline in w:p/w:r/w:drawing
        org.docx4j.wml.MyEntityObjectFactory factory = Context.getWmlObjectFactory();
        org.docx4j.wml.P  p = factory.createP();
        org.docx4j.wml.R  run = factory.createR();
        p.getContent().add(run);
        org.docx4j.wml.Drawing drawing = factory.createDrawing();
        run.getContent().add(drawing);
        drawing.getAnchorOrInline().add(inline);

        return p;

    }*/
}