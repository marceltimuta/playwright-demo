import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class TextBoxOutputPage {
    private final Page page;

    public TextBoxOutputPage(Page page) {
        this.page = page;
    }
    public void verifySubmit(String name, String email, String address) {
        Locator outputName = page.locator("p#name");
        Locator outputEmail = page.locator("p#email");
        Locator outputAddress = page.locator("p#currentAddress");
        PlaywrightAssertions.assertThat(outputName).hasText("Name:" + name);
        PlaywrightAssertions.assertThat(outputEmail).hasText("Email:" + email);
        PlaywrightAssertions.assertThat(outputAddress).hasText("Current Address :" + address);
    }
}
