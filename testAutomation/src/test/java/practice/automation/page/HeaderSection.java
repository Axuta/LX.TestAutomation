package practice.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderSection extends MainPage {
    protected WebDriver driver;

    @FindBy(xpath = "//*[@id='app']/header/div/div[1]/div/button")
    private WebElement revisionMenuButton;

    @FindBy(xpath = "//*[@id='app']/header/div/div[1]/div/div/div/button")
    private WebElement newRevisionButton;

    @FindBy(xpath = "//*[@id='modal-root']/div/div/footer/div/button[1]")
    private WebElement discardChangesPopUpButton;

    @FindBy(xpath = "//*[@id='modal-root']/div/div/footer/div/button[2]")
    private WebElement saveChangesPopUpButton;

    @FindBy(xpath = "//input[contains(@placeholder, 'Name')]")
    private WebElement newRevisionName;

    @FindBy(xpath = "//*[@id='modal-root']/div/div/main/div/div[2]/div/button")
    private WebElement revisionContentIsFromButton;

    @FindBy(xpath = "//*[@id='modal-root']/div/div/main/div/div[2]/div/div//button")
    private List<WebElement> revisionContentIsFromButtonList;

    @FindBy(xpath = "//*[@id=modal-root]/div/div/footer/div/button[1]")
    private WebElement cancelCreatingRevisionButton;

    @FindBy(xpath = "//*[@id=modal-root]/div/div/footer/div/button[2]")
    private WebElement createRevisionButton;

    @FindBy(xpath = "//*[@id='app']/header/div/div[2]/button")
    private WebElement translateMenuButton;

    @FindBy(xpath = "//*[@id='app']/header/div/div[2]/div/div/div/div[1]/div/button")
    private WebElement translateFromButton;

    @FindBy(xpath = "//*[@id='app']/header/div/div[2]/div/div/div/div[2]/div/button")
    private WebElement translateToButton;

    @FindBy(xpath = "//*[@id='app']/header/div/div[2]/div/div/div/button")
    private WebElement translateSwapButton;

    @FindBy(xpath = "//*[@id='app']/header/div/div[2]/div/div/footer/button")
    private List<WebElement> translateOptionsButton;//cancel, save

    @FindBy(xpath = "//*[@id='app']/header/div/div[5]/button")
    private WebElement uploadButton;

    @FindBy(xpath = "//*[@id='app']/header/div/div[4]/div/button")
    private WebElement templateMenuButton;

    @FindBy(xpath = "//*[@id='app']/header/div/div[4]/div/div/button")
    private List<WebElement> templateList;

    @FindBy(xpath = "//*[@id='app']/header/div/div[5]/button")
    private WebElement openShareNDownloadMenu;

    @FindBy(xpath = "//*[@id='modal-root']/div/div/main/div/div[1]/div[1]/div/div/button")
    private WebElement shareTemplateButton;

    @FindBy(xpath = "//*[@id=modal-root]/div/div/main/div/div[1]/div[1]/div/div/div/div/button")
    private List<WebElement> shareMenuTemplateList;

    @FindBy(xpath = "//*[@id='modal-root']/div/div/main/div/div[1]/div[2]/div/button")
    private WebElement fileExtensionButtons;

    @FindBy(xpath = "//*[@id='modal-root']/div/div/main/div/div[2]/span")
    private List<WebElement> optionsSwitchList;

    @FindBy(xpath = "//*[@id='modal-root']/div/div/footer/div//input")
    private WebElement linkText;

    @FindBy(xpath = "//*[@id='modal-root']/div/div/footer/div/button")
    private WebElement linkOptions;

    @FindBy(xpath = "//*[@id='modal-root']/div/div/header/button")
    private WebElement closeShareNDownloadMenu;

    @FindBy(xpath = "//*[@id='app']/header/div/div[6]/button[1]")
    private WebElement discardChangesButton;

    @FindBy(xpath = "//*[@id='app']/header/div/div[6]/button[2]")
    private WebElement saveChangesButton;

    public HeaderSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createNewRevision(String changesOption, String revisionName, String parentRevision) {
        revisionMenuButton.click();
        newRevisionButton.click();

        switch (changesOption) {
            case "Discard" -> discardChangesPopUpButton.click();
            case "Save" -> saveChangesPopUpButton.click();
            default -> throw new IllegalArgumentException("Invalid changes option: " + changesOption);
        }

        newRevisionName.sendKeys(revisionName);

        for (WebElement webElement : revisionContentIsFromButtonList) {
            String option = webElement
                    .getText();
            if (option.equals(parentRevision)) {
                webElement.click();
            }
        }

        createRevisionButton.click();
    }

//    public void translate(String from, String to) {
//        switch (from) {
//            case "EN": {
//                translateMenuButton.click();
//
//            }
//            case "RU": {
//                n
//            }
//            case "DE": {
//                cy
//            }
//        }
//    }


}
