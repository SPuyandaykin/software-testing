package trenningutils;

import org.junit.Assert;

public class PropertyParcer {

    public boolean isColorGray(String colorRGB) {
        int [] rgbArray =  GetCleanRGBdata(colorRGB);
        if (rgbArray[0] != rgbArray[1] | rgbArray[0] != rgbArray[2])
            return false;

        return true;
    }

    public boolean isColorRed(String colorRGB) {
        int [] rgbArray =  GetCleanRGBdata(colorRGB);
        if (rgbArray[1] != rgbArray[2])
            return false;

        return true;
    }

    public int [] GetCleanRGBdata(String sourceRGB){
        System.out.println("color is"+sourceRGB);
        String delims = "\\(";
        String[] tokens = sourceRGB.split(delims);
        String s_new = tokens[1].replace(")","");
        String[] tokens2 = s_new.split(", ");
        System.out.println("size is: "+tokens2.length);

        Assert.assertTrue(tokens2.length == 3);

        int [] rgbData = {0,0,0};

        for (int i = 0; i < 3; i++ ) {
            tokens2[i].replaceAll(" ", "");
            rgbData[i] = Integer.parseInt(tokens2[i]);
        }

        return rgbData;
    }

    public float GetDigitalFontSize(String stringSize) {
        float fontSize = 0;

        String s = stringSize.replaceAll("px", "");
        fontSize = Float.parseFloat(s);
        return fontSize;
    }
}
