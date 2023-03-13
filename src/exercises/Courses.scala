package exercises

object Courses extends App {

  class Instructor (val id: Int, val name: String, val surname: String) {
    def fullName: String = s"${replaceFirst(this.name)} ${replaceFirst(this.surname)}"

    def replaceFirst(line: String): String = {
      val symbol: String = line.take(1);
      line.replace(symbol, symbol.toUpperCase())
    }
  }

  class Course (courseID: Int, title: String, val releaseYear: String, instructor: Instructor) {
    // - getID: возвращает id в формате courseID + instructor.id (например, если courseId = 1, а instructor.id = 2, то метод вернет 12)
    //- isTaughtBy(instructor): проверяет, является ли указанный человек инструктором курса
    //- copyCourse(newReleaseYear): возвращает новый экземпляр класса Course с обновленным значением поля releaseYear

    def getID: String = this.courseID.toString + this.instructor.id

    def isTaughtBy(instructor: Instructor): Boolean = this.instructor.equals(instructor)

    def copyCourse(newReleaseYear: String): Course = new Course(this.courseID, this.title, newReleaseYear, this.instructor)
  }

  val man: Instructor = new Instructor(1, "john", "snow")
  println(man.fullName)

  val course = new Course(1, "Scala", "2023", man)

  println(course.getID)
  println(course.isTaughtBy(man))
  println(course.isTaughtBy(new Instructor(2, "someName", "someSurname")))
}
