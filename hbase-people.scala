
import scala.util.Random
import scala.io.Source


object PeopleDataset {

  def genNameSex():List[String] = {

    val boys = Source.fromFile("boynames.txt").getLines().toList
    val girls = Source.fromFile("girlnames.txt").getLines().toList

    val names = List(girls,boys)
    val sexes = List("Female","Male")
   
    // such as J.M.
    val lastName = Random.alphanumeric.filter(_.isLetter).take(2).map(_.toString + ".").mkString.toUpperCase

    // 0 for girl, 1 for boy
    val bet = Random.between(0,2)
    val size = names(bet).size
    val idx = Random.between(0,size)
    val firstName = names(bet)(idx)
    val sex = sexes(bet)
    
    List(s"$firstName $lastName",sex)
  }


  def genDate():String = {
    val year = Random.between(1970,2000)
    val mon = Random.between(1,13)
    val day = Random.between(1,29)
    s"$year-$mon-$day"
  }

  def genJobs():String = {
    val jobs = Source.fromFile("jobslist.txt").getLines().toList
    val id = Random.between(0,jobs.size)
    jobs(id)
  }

  def genCont():String = {
    val tel = Random.between(1000000,9999999)
    tel.toString
  }

  def main(args:Array[String]):Unit = {

    val count = args.size match {
      case 0 => 10
      case _ => args(0).toInt
    }


    for (x <- 1 to count) {
      val li = genNameSex()
      val name = li(0)
      val sex = li(1)
      val date = genDate()
      val cont = genCont()
      val jobs = genJobs()
  
      val feature = s"$x,$name,$date,$sex,$cont,$jobs"
      println(feature)
    }
  }
}
