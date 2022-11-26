import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.Page;

public class ElementsPage {
    private final Page page;
    private final Locator mainHeader;
    public LeftPanel leftPanel;

    public ElementsPage(Page page) {
        this.page = page;
        this.mainHeader = page.locator(".main-header");
        leftPanel = new LeftPanel(page);
    }

    public void isLoaded() {
        PlaywrightAssertions.assertThat(mainHeader).hasText("Elements");
    }
}
