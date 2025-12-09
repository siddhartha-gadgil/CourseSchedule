
import courses._
import BestChoice._

best 
// res0: Set[Schedule] = HashSet(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Radhika Ganapathy") -> TuTh(
//         times = "8:30 - 10:00"
//       ),
//       Course(name = "Functional Analysis", code = "MA 223", instructor = "Swarnendu Sil") -> MWF(times = "3:00 - 4:00"),
//       Course(name = "Riemannian Geometry", code = "MA 333", instructor = "Ved Datar") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Geometric Analysis", code = "MA 339", instructor = "Vamsi Pritham Pingali") -> TuTh(
//         times = "3:30 - 5: 00"
//       ),
//       Course(name = "Commutative Algebra", code = "MA 312", instructor = "Bharathwaj Palvannan") -> TuTh(
//         times = "11:30 - 1:00"
//       ),
//       Course(name = "Algebra I", code = "MA 212", instructor = "Shaunak Deo") -> MWF(times = "2:00 - 3:00"),
//       Course(
//         name = "Introduction to Algebraic Topology",
//         code = "MA 232",
//         instructor = "Harish Seshadri"
//       ) -> MWF(times = "2:00 - 3:00"),
//       Course(
//         name = "Applied Data Science and Artificial Intelligence",
//         code = "UMC 301",
//         instructor = "Deepak Subramani"
//       ) -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Probability Theory", code = "MA 361", instructor = "Srikanth K. Iyer") -> TuTh(
//         times = "10:00 - 11:30"
//       ),
//       Course(name = "Multivariable Calculus", code = "MA 200", instructor = "E. K. Narayanan") -> MWF(
//         times = "9:00 - 10:00"
//       ),
//       Course(name = "Topology", code = "MA 231", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Schubert Calculus", code = "MA 3xx", instructor = "Arvind Ayyer") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Probability Models", code = "MA 261", instructor = "Manjunath Krishnapur") -> MWF(
//         times = "12:00 - 1:00"
//       ),
//       Course(
//         name = "Introduction to Complex Dynamics",
//         code = "MA 380",
//         instructor = "Gautam Bharali"
//       ) -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Analysis I: Real Analysis", code = "MA 221", instructor = "Thirupathi Gudi") -> MWF(
//         times = "11:00 - 12:00"
//       ),
//       Course(
//         name = "Lie Algebras and their Representations",
//         code = "MA 315",
//         instructor = "R. Venkatesh / Shushma Rani"
//       ) -> TuTh(times = "2:00 - 3:30"),
// ...
best.size
// res1: Int = 12

bestSW
// res2: Set[Schedule] = HashSet(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Radhika Ganapathy") -> TuTh(
//         times = "8:30 - 10:00"
//       ),
//       Course(name = "Functional Analysis", code = "MA 223", instructor = "Swarnendu Sil") -> MWF(times = "3:00 - 4:00"),
//       Course(name = "Riemannian Geometry", code = "MA 333", instructor = "Ved Datar") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Geometric Analysis", code = "MA 339", instructor = "Vamsi Pritham Pingali") -> TuTh(
//         times = "3:30 - 5: 00"
//       ),
//       Course(name = "Commutative Algebra", code = "MA 312", instructor = "Bharathwaj Palvannan") -> TuTh(
//         times = "11:30 - 1:00"
//       ),
//       Course(name = "Algebra I", code = "MA 212", instructor = "Shaunak Deo") -> MWF(times = "2:00 - 3:00"),
//       Course(
//         name = "Introduction to Algebraic Topology",
//         code = "MA 232",
//         instructor = "Harish Seshadri"
//       ) -> MWF(times = "2:00 - 3:00"),
//       Course(
//         name = "Applied Data Science and Artificial Intelligence",
//         code = "UMC 301",
//         instructor = "Deepak Subramani"
//       ) -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Probability Theory", code = "MA 361", instructor = "Srikanth K. Iyer") -> TuTh(
//         times = "10:00 - 11:30"
//       ),
//       Course(name = "Multivariable Calculus", code = "MA 200", instructor = "E. K. Narayanan") -> MWF(
//         times = "9:00 - 10:00"
//       ),
//       Course(name = "Topology", code = "MA 231", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Schubert Calculus", code = "MA 3xx", instructor = "Arvind Ayyer") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Probability Models", code = "MA 261", instructor = "Manjunath Krishnapur") -> MWF(
//         times = "12:00 - 1:00"
//       ),
//       Course(
//         name = "Introduction to Complex Dynamics",
//         code = "MA 380",
//         instructor = "Gautam Bharali"
//       ) -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Analysis I: Real Analysis", code = "MA 221", instructor = "Thirupathi Gudi") -> MWF(
//         times = "11:00 - 12:00"
//       ),
//       Course(
//         name = "Lie Algebras and their Representations",
//         code = "MA 315",
//         instructor = "R. Venkatesh / Shushma Rani"
//       ) -> TuTh(times = "2:00 - 3:30"),
// ...
bestSW.size
// res3: Int = 1
bestSW.map(_.clashes.size)
// res4: Set[Int] = HashSet(10)
val commonClashes = bestSW.map(_.clashes).reduce(_ intersect _)
// commonClashes: Set[(Course, Course)] = HashSet(
//   (
//     Course(name = "Commutative Algebra", code = "MA 312", instructor = "Bharathwaj Palvannan"),
//     Course(
//       name = "Applied Data Science and Artificial Intelligence",
//       code = "UMC 301",
//       instructor = "Deepak Subramani"
//     )
//   ),
//   (
//     Course(name = "Algebra I", code = "MA 212", instructor = "Shaunak Deo"),
//     Course(
//       name = "Introduction to Algebraic Topology",
//       code = "MA 232",
//       instructor = "Harish Seshadri"
//     )
//   ),
//   (
//     Course(name = "Geometric Analysis", code = "MA 339", instructor = "Vamsi Pritham Pingali"),
//     Course(name = "Schubert Calculus", code = "MA 3xx", instructor = "Arvind Ayyer")
//   ),
//   (
//     Course(
//       name = "Lie Algebras and their Representations",
//       code = "MA 315",
//       instructor = "R. Venkatesh / Shushma Rani"
//     ),
//     Course(
//       name = "Introduction to Complex Dynamics",
//       code = "MA 380",
//       instructor = "Gautam Bharali"
//     )
//   ),
//   (
//     Course(name = "Matrix Analysis and Positivity", code = "MA 341", instructor = "Apoorva Khare"),
//     Course(
//       name = "Applied Data Science and Artificial Intelligence",
//       code = "UMC 301",
//       instructor = "Deepak Subramani"
//     )
//   ),
//   (
//     Course(name = "Topology", code = "MA 231", instructor = "Siddhartha Gadgil"),
//     Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Radhika Ganapathy")
//   ),
//   (
//     Course(name = "Commutative Algebra", code = "MA 312", instructor = "Bharathwaj Palvannan"),
//     Course(name = "Matrix Analysis and Positivity", code = "MA 341", instructor = "Apoorva Khare")
//   ),
// ...
commonClashes.size
// res5: Int = 10
val minClashSize = bestSW.map(_.clashes.size).min
// minClashSize: Int = 10
val minClashes = bestSW.filter(_.clashes.size == minClashSize).toVector
// minClashes: Vector[Schedule] = Vector(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Radhika Ganapathy") -> TuTh(
//         times = "8:30 - 10:00"
//       ),
//       Course(name = "Functional Analysis", code = "MA 223", instructor = "Swarnendu Sil") -> MWF(times = "3:00 - 4:00"),
//       Course(name = "Riemannian Geometry", code = "MA 333", instructor = "Ved Datar") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Geometric Analysis", code = "MA 339", instructor = "Vamsi Pritham Pingali") -> TuTh(
//         times = "3:30 - 5: 00"
//       ),
//       Course(name = "Commutative Algebra", code = "MA 312", instructor = "Bharathwaj Palvannan") -> TuTh(
//         times = "11:30 - 1:00"
//       ),
//       Course(name = "Algebra I", code = "MA 212", instructor = "Shaunak Deo") -> MWF(times = "2:00 - 3:00"),
//       Course(
//         name = "Introduction to Algebraic Topology",
//         code = "MA 232",
//         instructor = "Harish Seshadri"
//       ) -> MWF(times = "2:00 - 3:00"),
//       Course(
//         name = "Applied Data Science and Artificial Intelligence",
//         code = "UMC 301",
//         instructor = "Deepak Subramani"
//       ) -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Probability Theory", code = "MA 361", instructor = "Srikanth K. Iyer") -> TuTh(
//         times = "10:00 - 11:30"
//       ),
//       Course(name = "Multivariable Calculus", code = "MA 200", instructor = "E. K. Narayanan") -> MWF(
//         times = "9:00 - 10:00"
//       ),
//       Course(name = "Topology", code = "MA 231", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Schubert Calculus", code = "MA 3xx", instructor = "Arvind Ayyer") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Probability Models", code = "MA 261", instructor = "Manjunath Krishnapur") -> MWF(
//         times = "12:00 - 1:00"
//       ),
//       Course(
//         name = "Introduction to Complex Dynamics",
//         code = "MA 380",
//         instructor = "Gautam Bharali"
//       ) -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Analysis I: Real Analysis", code = "MA 221", instructor = "Thirupathi Gudi") -> MWF(
//         times = "11:00 - 12:00"
//       ),
//       Course(
//         name = "Lie Algebras and their Representations",
//         code = "MA 315",
//         instructor = "R. Venkatesh / Shushma Rani"
//       ) -> TuTh(times = "2:00 - 3:30"),
// ...
minClashes.size
// res6: Int = 1
// minClashes(0).diff(minClashes(1))
val chosen = minClashes(0)
// chosen: Schedule = Schedule(
//   sch = HashMap(
//     Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Radhika Ganapathy") -> TuTh(
//       times = "8:30 - 10:00"
//     ),
//     Course(name = "Functional Analysis", code = "MA 223", instructor = "Swarnendu Sil") -> MWF(times = "3:00 - 4:00"),
//     Course(name = "Riemannian Geometry", code = "MA 333", instructor = "Ved Datar") -> TuTh(times = "10:00 - 11:30"),
//     Course(name = "Geometric Analysis", code = "MA 339", instructor = "Vamsi Pritham Pingali") -> TuTh(
//       times = "3:30 - 5: 00"
//     ),
//     Course(name = "Commutative Algebra", code = "MA 312", instructor = "Bharathwaj Palvannan") -> TuTh(
//       times = "11:30 - 1:00"
//     ),
//     Course(name = "Algebra I", code = "MA 212", instructor = "Shaunak Deo") -> MWF(times = "2:00 - 3:00"),
//     Course(
//       name = "Introduction to Algebraic Topology",
//       code = "MA 232",
//       instructor = "Harish Seshadri"
//     ) -> MWF(times = "2:00 - 3:00"),
//     Course(
//       name = "Applied Data Science and Artificial Intelligence",
//       code = "UMC 301",
//       instructor = "Deepak Subramani"
//     ) -> TuTh(times = "11:30 - 1:00"),
//     Course(name = "Probability Theory", code = "MA 361", instructor = "Srikanth K. Iyer") -> TuTh(
//       times = "10:00 - 11:30"
//     ),
//     Course(name = "Multivariable Calculus", code = "MA 200", instructor = "E. K. Narayanan") -> MWF(
//       times = "9:00 - 10:00"
//     ),
//     Course(name = "Topology", code = "MA 231", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00"),
//     Course(name = "Schubert Calculus", code = "MA 3xx", instructor = "Arvind Ayyer") -> TuTh(times = "3:30 - 5: 00"),
//     Course(name = "Probability Models", code = "MA 261", instructor = "Manjunath Krishnapur") -> MWF(
//       times = "12:00 - 1:00"
//     ),
//     Course(
//       name = "Introduction to Complex Dynamics",
//       code = "MA 380",
//       instructor = "Gautam Bharali"
//     ) -> TuTh(times = "2:00 - 3:30"),
//     Course(name = "Analysis I: Real Analysis", code = "MA 221", instructor = "Thirupathi Gudi") -> MWF(
//       times = "11:00 - 12:00"
//     ),
//     Course(
//       name = "Lie Algebras and their Representations",
//       code = "MA 315",
//       instructor = "R. Venkatesh / Shushma Rani"
//     ) -> TuTh(times = "2:00 - 3:30"),
//     Course(name = "Partial Differential Equations", code = "MA 242", instructor = "Arka Mallick") -> MWF(
// ...
chosen.sch.size
// res7: Int = 19

chosen.tsv
// res8: String = """MA 200	Multivariable Calculus	E. K. Narayanan	Mon, Wed, Fri	9:00 - 10:00
// MA 212	Algebra I	Shaunak Deo	Mon, Wed, Fri	2:00 - 3:00
// MA 219	Linear Algebra	Apoorva Khare	Tue, Thu	2:00 - 3:30
// MA 221	Analysis I: Real Analysis	Thirupathi Gudi	Mon, Wed, Fri	11:00 - 12:00
// MA 223	Functional Analysis	Swarnendu Sil	Mon, Wed, Fri	3:00 - 4:00
// MA 231	Topology	Siddhartha Gadgil	Tue, Thu	8:30 - 10:00
// MA 232	Introduction to Algebraic Topology	Harish Seshadri	Mon, Wed, Fri	2:00 - 3:00
// MA 242	Partial Differential Equations	Arka Mallick	Mon, Wed, Fri	10:00 - 11:00
// MA 261	Probability Models	Manjunath Krishnapur	Mon, Wed, Fri	12:00 - 1:00
// MA 312	Commutative Algebra	Bharathwaj Palvannan	Tue, Thu	11:30 - 1:00
// MA 313	Algebraic Number Theory	Radhika Ganapathy	Tue, Thu	8:30 - 10:00
// MA 315	Lie Algebras and their Representations	R. Venkatesh / Shushma Rani	Tue, Thu	2:00 - 3:30
// MA 333	Riemannian Geometry	Ved Datar	Tue, Thu	10:00 - 11:30
// MA 339	Geometric Analysis	Vamsi Pritham Pingali	Tue, Thu	3:30 - 5: 00
// MA 341	Matrix Analysis and Positivity	Apoorva Khare	Tue, Thu	11:30 - 1:00
// MA 361	Probability Theory	Srikanth K. Iyer	Tue, Thu	10:00 - 11:30
// MA 380	Introduction to Complex Dynamics	Gautam Bharali	Tue, Thu	2:00 - 3:30
// MA 3xx	Schubert Calculus	Arvind Ayyer	Tue, Thu	3:30 - 5: 00
// UMC 301	Applied Data Science and Artificial Intelligence	Deepak Subramani	Tue, Thu	11:30 - 1:00
// """
chosen.clashes.mkString("\n")
// res9: String = """(Course(Commutative Algebra,MA 312,Bharathwaj Palvannan),Course(Applied Data Science and Artificial Intelligence,UMC 301,Deepak Subramani))
// (Course(Algebra I,MA 212,Shaunak Deo),Course(Introduction to Algebraic Topology,MA 232,Harish Seshadri))
// (Course(Geometric Analysis,MA 339,Vamsi Pritham Pingali),Course(Schubert Calculus,MA 3xx,Arvind Ayyer))
// (Course(Lie Algebras and their Representations,MA 315,R. Venkatesh / Shushma Rani),Course(Introduction to Complex Dynamics,MA 380,Gautam Bharali))
// (Course(Matrix Analysis and Positivity,MA 341,Apoorva Khare),Course(Applied Data Science and Artificial Intelligence,UMC 301,Deepak Subramani))
// (Course(Topology,MA 231,Siddhartha Gadgil),Course(Algebraic Number Theory,MA 313,Radhika Ganapathy))
// (Course(Commutative Algebra,MA 312,Bharathwaj Palvannan),Course(Matrix Analysis and Positivity,MA 341,Apoorva Khare))
// (Course(Linear Algebra,MA 219,Apoorva Khare),Course(Lie Algebras and their Representations,MA 315,R. Venkatesh / Shushma Rani))
// (Course(Riemannian Geometry,MA 333,Ved Datar),Course(Probability Theory,MA 361,Srikanth K. Iyer))
// (Course(Linear Algebra,MA 219,Apoorva Khare),Course(Introduction to Complex Dynamics,MA 380,Gautam Bharali))"""
StudentChoices
  .strongClashes(chosen)
  .toVector
  .map {
    case (c, v) => (c._1.name, c._2.name) -> v.map(_.name).mkString(", ")
  }
  .filter(_._2.nonEmpty)
// res10: Vector[((String, String), String)] = Vector(
//   (("Topology", "Algebraic Number Theory"), "Mohit jasoliya"),
//   (("Linear Algebra", "Lie Algebras and their Representations"), "Ninaad Khanna")
// )
StudentChoices
  .weakClashes(chosen)
  .toVector
  .map {
    case (c, v) => (c._1.name, c._2.name) -> v.map(_.name).mkString(", ")
  }
  .filter(_._2.nonEmpty)
// res11: Vector[((String, String), String)] = Vector(
//   (("Algebra I", "Introduction to Algebraic Topology"), "Omar Muhammad , Ninaad Khanna"),
//   (
//     ("Geometric Analysis", "Schubert Calculus"),
//     "Pradyun, Muhammed Faheem A T , Naveen Maurya, Akash"
//   ),
//   (("Topology", "Algebraic Number Theory"), "Mohit jasoliya, Jahin Sadat Mollah, Ninaad Khanna"),
//   (
//     ("Commutative Algebra", "Matrix Analysis and Positivity"),
//     "Mohit jasoliya, Jahin Sadat Mollah, Ayon Chowdhury, Anurag Sarkar, Saham Sil"
//   ),
//   (
//     ("Linear Algebra", "Lie Algebras and their Representations"),
//     "Jahin Sadat Mollah, Ninaad Khanna, Rashik Das, Anurag Sarkar"
//   ),
//   (("Riemannian Geometry", "Probability Theory"), "Arpan Pal, Vinayaka M, Naveen Maurya")
// )
chosen.sorted.groupMap(_._2)(_._1)
// res12: Map[Timing, Vector[Course]] = HashMap(
//   MWF(times = "12:00 - 1:00") -> Vector(
//     Course(name = "Probability Models", code = "MA 261", instructor = "Manjunath Krishnapur")
//   ),
//   TuTh(times = "11:30 - 1:00") -> Vector(
//     Course(name = "Commutative Algebra", code = "MA 312", instructor = "Bharathwaj Palvannan"),
//     Course(name = "Matrix Analysis and Positivity", code = "MA 341", instructor = "Apoorva Khare"),
//     Course(
//       name = "Applied Data Science and Artificial Intelligence",
//       code = "UMC 301",
//       instructor = "Deepak Subramani"
//     )
//   ),
//   MWF(times = "11:00 - 12:00") -> Vector(
//     Course(name = "Analysis I: Real Analysis", code = "MA 221", instructor = "Thirupathi Gudi")
//   ),
//   TuTh(times = "10:00 - 11:30") -> Vector(
//     Course(name = "Riemannian Geometry", code = "MA 333", instructor = "Ved Datar"),
//     Course(name = "Probability Theory", code = "MA 361", instructor = "Srikanth K. Iyer")
//   ),
//   TuTh(times = "2:00 - 3:30") -> Vector(
//     Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare"),
//     Course(
//       name = "Lie Algebras and their Representations",
//       code = "MA 315",
//       instructor = "R. Venkatesh / Shushma Rani"
//     ),
//     Course(
//       name = "Introduction to Complex Dynamics",
//       code = "MA 380",
//       instructor = "Gautam Bharali"
//     )
//   ),
//   TuTh(times = "8:30 - 10:00") -> Vector(
//     Course(name = "Topology", code = "MA 231", instructor = "Siddhartha Gadgil"),
//     Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Radhika Ganapathy")
//   ),
//   MWF(times = "10:00 - 11:00") -> Vector(
//     Course(name = "Partial Differential Equations", code = "MA 242", instructor = "Arka Mallick")
//   ),
//   MWF(times = "3:00 - 4:00") -> Vector(
//     Course(name = "Functional Analysis", code = "MA 223", instructor = "Swarnendu Sil")
//   ),
//   TuTh(times = "3:30 - 5: 00") -> Vector(
//     Course(name = "Geometric Analysis", code = "MA 339", instructor = "Vamsi Pritham Pingali"),
//     Course(name = "Schubert Calculus", code = "MA 3xx", instructor = "Arvind Ayyer")
//   ),
//   MWF(times = "9:00 - 10:00") -> Vector(
//     Course(name = "Multivariable Calculus", code = "MA 200", instructor = "E. K. Narayanan")
// ...
os.write.over(SavedData.dat / "schedule.tsv", chosen.tsv)
chosen.core1TuTh
// res14: Int = 2
CourseData.core1
// res15: Vector[Course] = Vector(
//   Course(name = "Algebra I", code = "MA 212", instructor = "Shaunak Deo"),
//   Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare"),
//   Course(name = "Topology", code = "MA 231", instructor = "Siddhartha Gadgil")
// )
chosen.sch.filter{case (c, t) => (CourseData.core1 ++ CourseData.coreUG).contains(c) && t.isTuTh}
// res16: Map[Course, Timing] = HashMap(
//   Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare") -> TuTh(times = "2:00 - 3:30"),
//   Course(name = "Topology", code = "MA 231", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00")
// )
chosen.sch.filter{case (c, t) => CourseData.core2.contains(c) && t.isTuTh}
// res17: Map[Course, Timing] = HashMap()
chosen.sch.filter{case (c, t) => (CourseData.core1 ++ CourseData.coreIntPhD).contains(c) && t.isTuTh}
// res18: Map[Course, Timing] = HashMap(
//   Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare") -> TuTh(times = "2:00 - 3:30"),
//   Course(name = "Topology", code = "MA 231", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00")
// )
BestChoice.sch.worst
// res19: Int = 2
BestChoice.sch.numWorst
// res20: Int = 4