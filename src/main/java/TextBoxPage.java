import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class TextBoxPage {
    private Page page;
    public TextBoxOutputPage textBoxOutput;

    public TextBoxPage(Page page) {
        this.page = page;
    }

    public void fillName(String name) {
        page.locator("#userName").fill(name);
    }

    public void fillEmail(String email) {
        page.locator("#userEmail").fill(email);
    }

    public void fillAddress(String address) {
        page.locator("#currentAddress").fill(address);
    }

    public void submit() {
        page.locator("#submit").click();
        textBoxOutput = new TextBoxOutputPage(page);
    }
}
