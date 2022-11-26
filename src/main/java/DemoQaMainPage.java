import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DemoQaMainPage {
    private final Page page;
    private final Locator elementsLocator;

    public DemoQaMainPage(Page page) {
        this.page = page;
        this.elementsLocator = page.locator("//h5[contains(text(),'Elements')]");
    }

    public void navigate() {
        page.navigate("https://demoqa.com/");
    }

    public ElementsPage clickElements() {
        elementsLocator.click();
        return new ElementsPage(page);
    }
}
