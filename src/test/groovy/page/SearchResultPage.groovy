package page

import geb.Page

class SearchResultPage extends Page {
  static at = { title.endsWith("| スタンバイ") }

  static content = {
    // 検索キーワードのテキストボックス
    searchKeyword { $('#jsi-keyword') }
    // 勤務地のテキストボックス
    searchLocation { $('#jsi-location')}
  }
}
