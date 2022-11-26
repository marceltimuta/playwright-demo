import com.microsoft.playwright.Page;

public class LeftPanel {
   private Page page;
    public ElementsSection elementsSection;

    public LeftPanel(Page page) {
        this.page = page;
        this.elementsSection = new ElementsSection(page);
    }
}
