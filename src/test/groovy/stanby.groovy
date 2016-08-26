import geb.spock.GebReportingSpec
import org.openqa.selenium.Keys

class SampleTest extends GebReportingSpec {
  def "トップページを表示する"() {
    when: "スタンバイを表示"
    go "https://jp.stanby.com"

    then: "h2要素をチェック"
    $('h2.pg-top-content-heading', 0).isDisplayed()
    $('h2.pg-top-content-heading', 0).text() == "スタンバイは、インターネット中の仕事を地図で探せる仕事検索アプリです"
  }

  def "トップページを表示して検索する"() {
    when: "スタンバイを表示"
    go "https://jp.stanby.com"

    and: "「ビズリーチ」で検索"
    $("#jsi-input-keyword") << "ビズリーチ"
    $("#jsi-input-keyword") << Keys.ENTER

    waitFor { $("h1", 0).isDisplayed() }

    then: "検索結果画面が表示される"
    title == "ビズリーチの求人 | スタンバイ"
  }

}
