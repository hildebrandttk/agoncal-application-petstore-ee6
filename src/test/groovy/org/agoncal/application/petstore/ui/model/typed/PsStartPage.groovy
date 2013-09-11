package org.agoncal.application.petstore.ui.model.typed

import geb.Page

class PsStartPage extends Page {
   static url = "http://localhost:8181/petstoreee6"

   static at = {
      title == "YAPS PetStore"
   }

   static content = {
      search {module PsSearchModule}
   }

   def PsSearchResultPage searchFor(String query){
      search.searchFor(query)
   }

}
