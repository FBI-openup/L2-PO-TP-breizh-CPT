package machine
import org.junit.Test
import org.junit.Assert._

class TestTolerance {

  // initialisation des objets sous test
  val t = Tolerance

  // tests
  @Test
  def test_accents_1 {
    assertEquals('a',t.accents('à'))
    assertEquals('a',t.accents('ä'))
    assertEquals('a',t.accents('â'))
  }

  @Test
  def test_accents_2 {
    assertEquals('e',t.accents('é'))
    assertEquals('e',t.accents('ë'))
  }

  @Test
  def test_accents_3 {
    assertEquals('l',t.accents('l'))
  }



  @Test
  def test_leven_1 {
    val s1:String = ""
    val s2:String = ""
    assertEquals(0,t.levenshteinDistance(s1,s2))
  }
  @Test
  def test_leven_2 {
    val s1:String = "aaa"
    val s2:String = "aaa"
    assertEquals(0,t.levenshteinDistance(s1,s2))
  }

  @Test
  def test_leven_3 {
    val s1:String = "h"
    val s2:String = ""
    assertEquals(1,t.levenshteinDistance(s1,s2))
  }

  @Test
  def test_leven_4 {
    val s1:String = "aaa"
    val s2:String = "aa"
    assertEquals(1,t.levenshteinDistance(s1,s2))
  }

  @Test
  def test_leven_5 {
    val s1:String = "aaa"
    val s2:String = "aab"
    assertEquals(1,t.levenshteinDistance(s1,s2))
  }
  @Test
  def test_leven_6 {
    val s1:String = "hôtel"
    val s2:String = "hôtel"
    assertEquals(0,t.levenshteinDistance(s1,s2))
  }

  @Test
  def test_leven_7 {
    val s1:String = ""
    val s2:String = "h"
    assertEquals(1,t.levenshteinDistance(s1,s2))
  }

  @Test
  def test_leven_8 {
    val s1:String = "hàéöê"
    val s2:String = "àé"
    assertEquals(3,t.levenshteinDistance(s1,s2))
  }

  @Test
  def test_corrigerMot_1 {
    val mot: String = ""
    assertEquals(
      "",
      t.corrigerMot(mot)
    )
  }

  
  
  @Test
  def test_corrigerMot_2 {
    val mot: String =
      "hôtel"
    assertEquals(
      mot,
      t.corrigerMot(mot)
    )
  }

  @Test
  def test_corrigerMot_3 {
    val mot: String =
      "hotl"
    assertEquals(
      "hôtel",
      t.corrigerMot(mot)
    )
  }

  @Test
  def test_corrigerMot_4 {
    val mot: String =
      "htl"
    assertEquals(
      "htl",
      t.corrigerMot(mot)
    )
  }

  @Test
  def test_corriger_1 {
    val mots: List[String] =
      List()
    assertEquals(
      List(),
      t.corriger(mots)
    )
  }

  @Test
  def test_corriger_2 {
    val mots: List[String] =
      List("hôtel")
    assertEquals(
      mots,
      t.corriger(mots)
    )
  }

  @Test
  def test_corriger_3 {
    val mots: List[String] =
      List("hotl")
    assertEquals(
      List("hôtel"),
      t.corriger(mots)
    )
  }

  @Test
  def test_corriger_4 {
    val mots: List[String] =
      List("htl")
    assertEquals(
      List("htl"),
      t.corriger(mots)
    )
  }

  @Test
  def test_corriger_5 {
    val mots: List[String] =
      List()
    assertEquals(
      List(),
      t.corriger(mots)
    )
  }

  @Test
  def test_corriger_6 {
    val mots: List[String] =
      List("Thétre","aaaaa","Miri")
    assertEquals(
      List("Théâtre","aaaaa","Miri"),
      t.corriger(mots)
    )
  }

  @Test
  def test_corriger_7 {
    val mots: List[String] =
      List("Thétré","aaaaa","Màiri")
    assertEquals(
      List("Théâtre","aaaaa","Mairie"),
      t.corriger(mots)
    )
  }
}
