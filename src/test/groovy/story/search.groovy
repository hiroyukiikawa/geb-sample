import geb.spock.GebReportingSpec
import org.openqa.selenium.Keys
import spock.lang.Unroll
import page.IndexPage
import page.SearchResultPage

class SampleTest extends GebReportingSpec {
  def "トップページを表示する"() {
    given: "スタンバイを表示"
    to IndexPage
    at IndexPage

    when: "特に何もしなければ"

    then: "TVCM公開中!!の画像が表示されている"
    movieButton.isDisplayed()
  }

  def "トップページを表示して検索する"() {
    given: "スタンバイを表示"
    to IndexPage
    at IndexPage

    when: "「ビズリーチ」で検索"
    setQuery("ビズリーチ", "")
    search()

    then: "検索結果画面が表示される"
    at SearchResultPage

    and: "検索フォームに「ビズリーチ」と入力されている"
    searchKeyword.value() == "ビズリーチ"
  }

  @Unroll
  def "トップページでいろいろ検索してみる"(String keyword, String location) {
    given: "スタンバイを表示"
    to IndexPage
    at IndexPage

    when: "キーワードと勤務地を入力"
    setQuery(keyword, location)
    search()

    then: "検索結果が表示され、"
    at SearchResultPage

    and: "検索フォームに検索条件が入力されている"
    searchKeyword == keyword
    searchLocation == location

    where :
    keyword  | location
    "飲食店" | "千葉県"
    "営業"   | "大阪府"
    "鹿"     | "奈良県"
  }

}
