package org.agoncal.application.petstore.ui.model.typed

import geb.Module

class PsSearchModule extends Module{
   static content = {
      queryField {$("input.search-query")}
      queryButton (to: PsSearchResultPage) {$("input", type: 'submit')}
   }

   def PsSearchResultPage searchFor(String query){
      queryField.value(query)
      queryButton.click()
      browser.page as PsSearchResultPage
   }
}
