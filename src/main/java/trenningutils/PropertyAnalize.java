package trenningutils;

import org.openqa.selenium.WebElement;

public class PropertyAnalize {
    protected PropertyParcer propertyParcer;

    public PropertyAnalize(){
        propertyParcer = new PropertyParcer();
    }

    public boolean IsFontCrossed(WebElement fontCrossed){
        if (!fontCrossed.getCssValue("text-decoration").contains("line-through"))
            return false;
        return true;
    }

    public boolean IsFontGray (WebElement fontGray) {
        if(!propertyParcer.isColorGray(fontGray.getCssValue("text-decoration-color")))
            return false;
        return true;
    }

    public boolean IsFontGrayAndGrossed (WebElement fontGray) {
        if(!IsFontGray(fontGray))
            return false;

        if(!IsFontCrossed(fontGray))
            return false;

        return true;
    }

    public boolean IsFontRedAndStrong(WebElement fontRed) {

        if(!IsFontStrong(fontRed))
            return false;

        if(!iFontRed(fontRed))
            return false;

        return true;
    }

    private boolean iFontRed(WebElement fontRed) {
        if(!propertyParcer.isColorRed(fontRed.getCssValue("text-decoration-color")))
            return false;
        return true;
    }

    private boolean IsFontStrong(WebElement fontStrong) {
        if(!fontStrong.getTagName().contains("strong"))
            return false;

        return true;
    }

    public boolean IsRegularFontLessCampaign(WebElement regularPrice, WebElement campaingPrice) {
        if(propertyParcer.GetDigitalFontSize(regularPrice.getCssValue("font-size"))
                >= propertyParcer.GetDigitalFontSize(campaingPrice.getCssValue("font-size")))
            return false;
        return true;
    }
}
