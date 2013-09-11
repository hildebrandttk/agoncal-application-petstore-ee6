package org.agoncal.application.petstore.ui.model.typed

import geb.Module

class PsSearchResultModule extends Module {
   static content = {
      _image { $('img') }
      _link { $('a') }
      _imageUrl { _image.@src }
      _linkUrl { _link.@href }
      _linkText { _link.text() }
   }

   def getImageUrl(){
      _imageUrl
   }

   def getLinkText(){
      _linkText
   }
}
