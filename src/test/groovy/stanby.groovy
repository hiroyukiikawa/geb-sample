import geb.spock.GebReportingSpec
import org.openqa.selenium.Keys
import spock.lang.Unroll

class SampleTest extends GebReportingSpec {
  def "トップページを表示する"() {
    when: "スタンバイを表示"
    go "https://jp.stanby.com"

    then: "タイトルをチェック"
    title == "スタンバイ 地図で仕事が探せる求人サイト"

    and: "TVCM公開中!!の画像が表示されている"
    $('img.btn-badge-movie').isDisplayed()
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

    and: "検索フォームに「ビズリーチ」と入力されている"
    $("#jsi-keyword").value() == "ビズリーチ"
  }

  @Unroll("#keyword, locationで検索する")
  def "トップページでいろいろ検索してみる"(String keyword, String location) {
    when: "スタンバイを表示"
    go "https://jp.stanby.com"

    and: "キーワードと勤務地を入力"
    $("#jsi-input-keyword") << keyword
    $("#jsi-input-location") << location
    $("#jsi-input-keyword") << Keys.ENTER

    waitFor { $("h1", 0).isDisplayed() }

    then: "検索結果が表示され、検索フォームに検索条件が入力されている"
    $("#jsi-keyword").value()  == keyword
    $("#jsi-location").value() == location

    where :
    keyword  | location
    "飲食店" | "千葉県"
    "営業"   | "大阪府"
    "鹿"     | "奈良県"
  }

}
