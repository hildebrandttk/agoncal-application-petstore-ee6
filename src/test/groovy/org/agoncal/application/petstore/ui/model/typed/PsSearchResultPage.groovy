package org.agoncal.application.petstore.ui.model.typed

import geb.Page

class PsSearchResultPage extends Page {
   static url = "http://localhost:8181/petstoreee6"

   static at = {
      title.startsWith("Search for")
   }

   static content = {
      _search {module PsSearchModule}
      _results {moduleList PsSearchResultModule, $("div.media") }
   }

   def PsSearchResultPage searchFor(String query){
      _search.searchFor(query)
   }

   def List<PsSearchResultModule> getResults(){
      return _results
   }


}
