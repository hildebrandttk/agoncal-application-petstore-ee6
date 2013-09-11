package org.agoncal.application.petstore.ui

import geb.junit4.GebReportingTest
import org.agoncal.application.petstore.ui.model.typed.PsSearchResultModule
import org.agoncal.application.petstore.ui.model.typed.PsSearchResultPage
import org.agoncal.application.petstore.ui.model.typed.PsStartPage
import org.jboss.arquillian.container.test.api.Deployment
import org.jboss.arquillian.junit.Arquillian
import org.jboss.shrinkwrap.api.ArchivePaths
import org.jboss.shrinkwrap.api.ShrinkWrap
import org.jboss.shrinkwrap.api.asset.EmptyAsset
import org.jboss.shrinkwrap.api.importer.ExplodedImporter
import org.jboss.shrinkwrap.api.spec.WebArchive
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(Arquillian.class)
class SearchWithTypedModelIT extends GebReportingTest {

   @Deployment
   public static WebArchive createTestArchive() {
      WebArchive archive = ShrinkWrap.create(WebArchive.class, "petstoreee6.war")
         .addPackages(true, "org.agoncal.application.petstore")
         .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
         .addAsWebInfResource("META-INF/persistence.xml", ArchivePaths.create("classes/META-INF/persistence.xml"))
         .as(ExplodedImporter.class)
         .importDirectory(new File("src/main/webapp"))
         .as(WebArchive.class);
      return archive;
   }

   @Test
   public void testSearch() {
      final PsSearchResultPage resultPage = to(PsStartPage)
         .searchFor("Angelfish")
      final List<PsSearchResultModule> results = resultPage.getResults()
      assert 2 == results.size()
      for (PsSearchResultModule result : results) {
         assert "http://localhost:8181/petstoreee6/resources/images/fish1.jpg" == result.imageUrl
         assert "Thootless" == result.linkText || "Large" == result.linkText
      }
   }
}
