
import scala.util.Random
import scala.io.Source


object PeopleDataset {

  def genNameSex:(String,String) = {

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
    
    (s"$firstName $lastName",sex)
  }

  def genDate:String = {
    val year = Random.between(1970,2000)
    val mon = Random.between(1,13)
    val day = Random.between(1,29)
    s"$year-$mon-$day"
  }

  def genJob:String = {
    val jobs = Source.fromFile("jobslist.txt").getLines().toList
    val id = Random.between(0,jobs.size)
    jobs(id)
  }

  def genZip:Int = {
    Random.between(10000,99999)
  }

  def genEmail:String = {
    val domains = Source.fromFile("domains.txt").getLines().toList
    val id = Random.between(0,domains.size)
    val domain = domains(id)
    val user = Random.alphanumeric.filter(_.isLetter).take(5).mkString
    user + "@" + domain
  }

  def genSalary:Double = {
    Random.between(5000,30000).toDouble
  }

  // main function
  def main(args:Array[String]):Unit = {

    val count = args.size match {
      case 0 => 10
      case _ => args(0).toInt
    }

    println("NAME,SEX,BORN,ZIP,EMAIL,JOB,SALARY")

    for (x <- 1 to count) {
      val (name,sex) = genNameSex
      val date = genDate
      val zip = genZip
      val email = genEmail
      val job = genJob
      val salary = genSalary
  
      val feature = s"$name,$sex,$date,$zip,$email,$job,$salary"
      println(feature)
    }
  }
}
