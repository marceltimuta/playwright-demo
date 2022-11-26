import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DemoQaTest extends BaseTest {
    // New instance for each test method.
    BrowserContext context;
    Page page;
    ElementsPage elementsPage;
    TextBoxPage textBoxPage;

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://demoqa.com/elements");
        elementsPage = new ElementsPage(page);
        textBoxPage = new TextBoxPage(page);
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    private static Stream<Arguments> formData() {
        return Stream.of(
                Arguments.of("Markus", "markus@example.com", "Bucuresti, Aviatorilor, 155"),
                Arguments.of("John Smith", "john.smith@google.com", "New York, First street, 99"),
                Arguments.of("Alan Anderson", "anderson@yahoo.com", "Washington, Last street 69")
        );
    }

    @DisplayName("Should submit form")
    @ParameterizedTest(name = "{index} => name={0}, email={1}, address={2}")
    @MethodSource("formData")
    public void testAddressFormSubmission(String name, String email, String address) {
    elementsPage.leftPanel.elementsSection.click();
    textBoxPage.fillName(name);
    textBoxPage.fillEmail(email);
    textBoxPage.fillAddress(address);
    textBoxPage.submit();
    textBoxPage.textBoxOutput.verifySubmit(name, email, address);
    }
}
