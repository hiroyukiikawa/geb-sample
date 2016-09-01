package page

import geb.Page
import org.openqa.selenium.Keys

class IndexPage extends Page {
  static at = { title == "スタンバイ 地図で仕事が探せる求人サイト" }

  static content = {
    // 検索キーワードのテキストボックス
    searchKeyword { $('#jsi-input-keyword') }
    // 勤務地のテキストボックス
    searchLocation { $('#jsi-input-location')}
    // 検索ボタン
    searchButton { $('#jsi-top-search-form').$('div', class: "pg-top-content-btnarea").$('button', class: "sg-button secondary") }
    // TVCM公開中!!の画像が表示されている
    movieButton { $('img.btn-badge-movie') }
  }

  // 検索条件を入力する
  void setQuery(keyword, location) {
    searchKeyword = keyword
    searchLocation = location
  }

  // 検索ボタンを押して、検索を実行する
  void search() {
    searchButton.click()
  }
}
