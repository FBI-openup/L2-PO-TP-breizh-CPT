package machine

trait TraitTolerance {

  /** Corrige les mots de la liste avec une marge d'erreur relative si ce n'est
    * pas possible, on ne le change pas.
    *
    * @param liste
    *   une liste de mot
    * @return
    *   une liste de mot corrigé
    */
  def corriger(liste: List[String]): List[String]

  /** Corrige le mot avec une marge d'erreur sinon ""
    *
    * @param mot
    *   le mot à corriger
    * @return
    *   le mot corrigé
    */
  def corrigerMot(mot: String): String
}

object Tolerance extends TraitTolerance {

  val dicKeys =
    BaseDeDonnees
      .getMap()
      .keys
      .toList // Une liste des clés de la map de la base de donnée des mots
  /** Renvoie le charactère sans accent et s'il n'en a pas, le renvoie tel quel
    * .
    *
    * @param lettre
    *   la lettre dont on enlève l'accent si possible.
    * @return
    *   la lettre sans accent.
    */
  def accents(lettre: Char): Char = {
    lettre match {
      case 'é' | 'è' | 'ê' | 'ë' => 'e'
      case 'á' | 'à' | 'â' | 'ä' => 'a'
      case 'ú' | 'ù' | 'û' | 'ü' => 'u'
      case 'ó' | 'ò' | 'ô' | 'ö' => 'o'
      case 'í' | 'ì' | 'î' | 'ï' => 'i'
      case 'ç'                   => 'c'
      case _                     => lettre
    }
  }

  /** Renvoie la distance de Levenshtein entre deux mots.
    *
    * @param s1
    *   un mot
    * @param s2
    *   un mot
    * @return
    *   la distance de Levenshtein
    */
  def levenshteinDistance(s1: String, s2: String): Int = {
    if (s1.isEmpty) s2.length
    else if (s2.isEmpty) s1.length
    else {
      val cost =
        if (accents(s1.head) == accents(s2.head))
          0 // ignorer les accents avec accents()
        else 1
      val min1 = levenshteinDistance(s1.tail, s2) + 1
      val min2 = levenshteinDistance(s1, s2.tail) + 1
      val min3 = levenshteinDistance(s1.tail, s2.tail) + cost
      math.min(math.min(min1, min2), min3)
    }
  }

  /** Renvoie une liste de mot corrigé.
    *
    * @param liste
    *   la liste de mot à corriger.
    * @return
    *   la liste corrigée.
    */
  def corriger(liste: List[String]): List[String] = {
    liste.map(corrigerMot(_))
  }

  /** Corrige le mot.
    *
    * @param mot
    *   le mot à corriger si possible
    * @return
    *   renvoie le mot corrigé si possible
    */
  def corrigerMot(mot: String): String = {
    corrigerMotRec(mot, dicKeys)
  }

  /** Renvoie un mot corrigé si possible. La correction se base sur un
    * dictionnaire.
    *
    * @param mot
    *   le mot à corriger.
    * @param dico
    *   la liste de string de mot bien orthographié.
    * @return
    *   le mot corrigé si possible.
    */
  def corrigerMotRec(mot: String, dico: List[String]): String = {
    dico match {
      case Nil => mot
      case cle :: reste => {
        levenshteinDistance(mot, cle) match {
          case 0 => mot
          case 1 => cle
          case _ => corrigerMotRec(mot, reste)
        }
      }
    }
  }

}
