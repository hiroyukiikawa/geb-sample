import geb.report.CompositeReporter
import geb.report.ScreenshotReporter

import org.openqa.selenium.chrome.ChromeDriver

reportsDir = "./report"

reporter = new CompositeReporter(
        new ScreenshotReporter(){
            @Override
            protected escapeFileName(String name) {
                name.replaceAll('[\\\\/:\\*?\\"&lt;>\\|]', '_')
            }
        },
        new ScreenshotReporter(){
            @Override
            protected escapeFileName(String name) {
                name.replaceAll('[\\\\/:\\*?\\"&lt;>\\|]', '_')
            }
        }
)
