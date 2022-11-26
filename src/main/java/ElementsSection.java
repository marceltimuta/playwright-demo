import com.microsoft.playwright.Page;

public class ElementsSection {
    private Page page;

    public ElementsSection(Page page) {
        this.page = page;
    }

    public void click() {
        page.click("#item-0");
    }
}
