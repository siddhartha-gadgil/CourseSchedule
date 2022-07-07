
import courses._
import BestChoice._

best 
// res0: Set[Schedule] = HashSet(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Commutative Algebra", code = "MA 312", instructor = "Amalendu Krishna") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Introduction to Analytic Number Theory", code = "MA 317", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Topics in Several Complex Variables", code = "MA 329", instructor = "Gautam Bharali") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Partial Differential Equations", code = "MA 242", instructor = "Swarnendu Sil") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Bharathwaj Palvannan") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Functional Analysis", code = "MA 223", instructor = "Tirthankar Bhattacharyya") -> MWF(times = "10:00 - 11:00"),
//       Course(name = "Algebraic Graph Theory", code = "MA 375", instructor = "Shivani Goel/Arvind Ayyer") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Analysis III", code = "MA 321", instructor = "A.K.Nandakumaran") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Sunadaram Thangavelu/R. Venkatesh") -> MWF(
//         times = "10:00 - 11:00"
//       ),
//       Course(name = "Representation Theory of Finite Groups", code = "MA 220", instructor = "Radhika Ganapathy") -> TuTh(
//         times = "8:30 - 10:00"
//       ),
//       Course(name = "Algebra I", code = "MA 212", instructor = "Shaunak Deo") -> MWF(times = "3:00 - 4:00"),
//       Course(name = "Topics in Non-linear Functional Analysis", code = "MA 388", instructor = "Arka Mallick") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Multivariable Calculus", code = "MA 200", instructor = "Vamsi Pingali") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Operator Theory II", code = "MA 325", instructor = "E.K.Narayanan") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Topology", code = "MA 231", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Probability Theory", code = "MA 361", instructor = "Manjunath Krishnapur") -> TuTh(times = "2:00 - 3:30")
//     )
//   ),
//   Schedule(
//     sch = HashMap(
//       Course(name = "Commutative Algebra", code = "MA 312", instructor = "Amalendu Krishna") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Introduction to Analytic Number Theory", code = "MA 317", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Topics in Several Complex Variables", code = "MA 329", instructor = "Gautam Bharali") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Partial Differential Equations", code = "MA 242", instructor = "Swarnendu Sil") -> MWF(times = "2:0...
best.size
// res1: Int = 376

bestSW
// res2: Set[Schedule] = HashSet(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Commutative Algebra", code = "MA 312", instructor = "Amalendu Krishna") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Introduction to Analytic Number Theory", code = "MA 317", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Topics in Several Complex Variables", code = "MA 329", instructor = "Gautam Bharali") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Partial Differential Equations", code = "MA 242", instructor = "Swarnendu Sil") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Bharathwaj Palvannan") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Functional Analysis", code = "MA 223", instructor = "Tirthankar Bhattacharyya") -> MWF(times = "10:00 - 11:00"),
//       Course(name = "Algebraic Graph Theory", code = "MA 375", instructor = "Shivani Goel/Arvind Ayyer") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Analysis III", code = "MA 321", instructor = "A.K.Nandakumaran") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Sunadaram Thangavelu/R. Venkatesh") -> MWF(
//         times = "10:00 - 11:00"
//       ),
//       Course(name = "Representation Theory of Finite Groups", code = "MA 220", instructor = "Radhika Ganapathy") -> TuTh(
//         times = "8:30 - 10:00"
//       ),
//       Course(name = "Algebra I", code = "MA 212", instructor = "Shaunak Deo") -> MWF(times = "3:00 - 4:00"),
//       Course(name = "Topics in Non-linear Functional Analysis", code = "MA 388", instructor = "Arka Mallick") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Multivariable Calculus", code = "MA 200", instructor = "Vamsi Pingali") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Operator Theory II", code = "MA 325", instructor = "E.K.Narayanan") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Topology", code = "MA 231", instructor = "Siddhartha Gadgil") -> MWF(times = "9:00 - 10:00"),
//       Course(name = "Probability Theory", code = "MA 361", instructor = "Manjunath Krishnapur") -> TuTh(times = "3:30 - 5: 00")
//     )
//   ),
//   Schedule(
//     sch = HashMap(
//       Course(name = "Commutative Algebra", code = "MA 312", instructor = "Amalendu Krishna") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Introduction to Analytic Number Theory", code = "MA 317", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Topics in Several Complex Variables", code = "MA 329", instructor = "Gautam Bharali") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Partial Differential Equations", code = "MA 242", instructor = "Swarnendu Sil") -> MWF(times = "2:0...
bestSW.size
// res3: Int = 6
bestSW.map(_.clashes.size)
// res4: Set[Int] = HashSet(10, 9, 12, 11)
val commonClashes = bestSW.map(_.clashes).reduce(_ intersect _)
// commonClashes: Set[(Course, Course)] = HashSet(
//   (
//     Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Sunadaram Thangavelu/R. Venkatesh"),
//     Course(name = "Functional Analysis", code = "MA 223", instructor = "Tirthankar Bhattacharyya")
//   ),
//   (
//     Course(name = "Multivariable Calculus", code = "MA 200", instructor = "Vamsi Pingali"),
//     Course(name = "Probability Theory", code = "MA 361", instructor = "Manjunath Krishnapur")
//   ),
//   (
//     Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Bharathwaj Palvannan"),
//     Course(name = "Analysis III", code = "MA 321", instructor = "A.K.Nandakumaran")
//   ),
//   (
//     Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare"),
//     Course(name = "Analysis III", code = "MA 321", instructor = "A.K.Nandakumaran")
//   ),
//   (
//     Course(name = "Commutative Algebra", code = "MA 312", instructor = "Amalendu Krishna"),
//     Course(name = "Introduction to Analytic Number Theory", code = "MA 317", instructor = "Soumya Das")
//   ),
//   (
//     Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare"),
//     Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Bharathwaj Palvannan")
//   )
// )
commonClashes.size
// res5: Int = 6
val minClashSize = bestSW.map(_.clashes.size).min
// minClashSize: Int = 9
val minClashes = bestSW.filter(_.clashes.size == minClashSize).toVector
// minClashes: Vector[Schedule] = Vector(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Commutative Algebra", code = "MA 312", instructor = "Amalendu Krishna") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Introduction to Analytic Number Theory", code = "MA 317", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Topics in Several Complex Variables", code = "MA 329", instructor = "Gautam Bharali") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Partial Differential Equations", code = "MA 242", instructor = "Swarnendu Sil") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Bharathwaj Palvannan") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Functional Analysis", code = "MA 223", instructor = "Tirthankar Bhattacharyya") -> MWF(times = "10:00 - 11:00"),
//       Course(name = "Algebraic Graph Theory", code = "MA 375", instructor = "Shivani Goel/Arvind Ayyer") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Analysis III", code = "MA 321", instructor = "A.K.Nandakumaran") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Sunadaram Thangavelu/R. Venkatesh") -> MWF(
//         times = "10:00 - 11:00"
//       ),
//       Course(name = "Representation Theory of Finite Groups", code = "MA 220", instructor = "Radhika Ganapathy") -> TuTh(
//         times = "8:30 - 10:00"
//       ),
//       Course(name = "Algebra I", code = "MA 212", instructor = "Shaunak Deo") -> MWF(times = "3:00 - 4:00"),
//       Course(name = "Topics in Non-linear Functional Analysis", code = "MA 388", instructor = "Arka Mallick") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Multivariable Calculus", code = "MA 200", instructor = "Vamsi Pingali") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Operator Theory II", code = "MA 325", instructor = "E.K.Narayanan") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Topology", code = "MA 231", instructor = "Siddhartha Gadgil") -> MWF(times = "9:00 - 10:00"),
//       Course(name = "Probability Theory", code = "MA 361", instructor = "Manjunath Krishnapur") -> TuTh(times = "2:00 - 3:30")
//     )
//   )
// )
minClashes.size
// res6: Int = 1
// minClashes(0).diff(minClashes(1))
val chosen = minClashes(0)
// chosen: Schedule = Schedule(
//   sch = HashMap(
//     Course(name = "Commutative Algebra", code = "MA 312", instructor = "Amalendu Krishna") -> TuTh(times = "11:30 - 1:00"),
//     Course(name = "Introduction to Analytic Number Theory", code = "MA 317", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//     Course(name = "Topics in Several Complex Variables", code = "MA 329", instructor = "Gautam Bharali") -> MWF(times = "2:00 - 3:00"),
//     Course(name = "Partial Differential Equations", code = "MA 242", instructor = "Swarnendu Sil") -> MWF(times = "2:00 - 3:00"),
//     Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen") -> TuTh(times = "3:30 - 5: 00"),
//     Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Bharathwaj Palvannan") -> TuTh(times = "10:00 - 11:30"),
//     Course(name = "Functional Analysis", code = "MA 223", instructor = "Tirthankar Bhattacharyya") -> MWF(times = "10:00 - 11:00"),
//     Course(name = "Algebraic Graph Theory", code = "MA 375", instructor = "Shivani Goel/Arvind Ayyer") -> MWF(times = "11:00 - 12:00"),
//     Course(name = "Analysis III", code = "MA 321", instructor = "A.K.Nandakumaran") -> TuTh(times = "10:00 - 11:30"),
//     Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Sunadaram Thangavelu/R. Venkatesh") -> MWF(
//       times = "10:00 - 11:00"
//     ),
//     Course(name = "Representation Theory of Finite Groups", code = "MA 220", instructor = "Radhika Ganapathy") -> TuTh(
//       times = "8:30 - 10:00"
//     ),
//     Course(name = "Algebra I", code = "MA 212", instructor = "Shaunak Deo") -> MWF(times = "3:00 - 4:00"),
//     Course(name = "Topics in Non-linear Functional Analysis", code = "MA 388", instructor = "Arka Mallick") -> TuTh(times = "3:30 - 5: 00"),
//     Course(name = "Multivariable Calculus", code = "MA 200", instructor = "Vamsi Pingali") -> TuTh(times = "2:00 - 3:30"),
//     Course(name = "Operator Theory II", code = "MA 325", instructor = "E.K.Narayanan") -> TuTh(times = "8:30 - 10:00"),
//     Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare") -> TuTh(times = "10:00 - 11:30"),
//     Course(name = "Topology", code = "MA 231", instructor = "Siddhartha Gadgil") -> MWF(times = "9:00 - 10:00"),
//     Course(name = "Probability Theory", code = "MA 361", instructor = "Manjunath Krishnapur") -> TuTh(times = "2:00 - 3:30")
//   )
// )
chosen.sch.size
// res7: Int = 18

chosen.tsv
// res8: String = """MA 200	Multivariable Calculus	Vamsi Pingali	Tue, Thu	2:00 - 3:30
// MA 212	Algebra I	Shaunak Deo	Mon, Wed, Fri	3:00 - 4:00
// MA 219	Linear Algebra	Apoorva Khare	Tue, Thu	10:00 - 11:30
// MA 220	Representation Theory of Finite Groups	Radhika Ganapathy	Tue, Thu	8:30 - 10:00
// MA 221	Analysis I: Real Anaysis	Sunadaram Thangavelu/R. Venkatesh	Mon, Wed, Fri	10:00 - 11:00
// MA 223	Functional Analysis	Tirthankar Bhattacharyya	Mon, Wed, Fri	10:00 - 11:00
// MA 231	Topology	Siddhartha Gadgil	Mon, Wed, Fri	9:00 - 10:00
// MA 242	Partial Differential Equations	Swarnendu Sil	Mon, Wed, Fri	2:00 - 3:00
// MA 261	Probability Models	Sanchayan Sen	Tue, Thu	3:30 - 5: 00
// MA 312	Commutative Algebra	Amalendu Krishna	Tue, Thu	11:30 - 1:00
// MA 313	Algebraic Number Theory	Bharathwaj Palvannan	Tue, Thu	10:00 - 11:30
// MA 317	Introduction to Analytic Number Theory	Soumya Das	Tue, Thu	11:30 - 1:00
// MA 321	Analysis III	A.K.Nandakumaran	Tue, Thu	10:00 - 11:30
// MA 325	Operator Theory II	E.K.Narayanan	Tue, Thu	8:30 - 10:00
// MA 329	Topics in Several Complex Variables	Gautam Bharali	Mon, Wed, Fri	2:00 - 3:00
// MA 361	Probability Theory	Manjunath Krishnapur	Tue, Thu	2:00 - 3:30
// MA 375	Algebraic Graph Theory	Shivani Goel/Arvind Ayyer	Mon, Wed, Fri	11:00 - 12:00
// MA 388	Topics in Non-linear Functional Analysis	Arka Mallick	Tue, Thu	3:30 - 5: 00
// """
chosen.clashes.mkString("\n")
// res9: String = """(Course(Analysis I: Real Anaysis,MA 221,Sunadaram Thangavelu/R. Venkatesh),Course(Functional Analysis,MA 223,Tirthankar Bhattacharyya))
// (Course(Multivariable Calculus,MA 200,Vamsi Pingali),Course(Probability Theory,MA 361,Manjunath Krishnapur))
// (Course(Algebraic Number Theory,MA 313,Bharathwaj Palvannan),Course(Analysis III,MA 321,A.K.Nandakumaran))
// (Course(Linear Algebra,MA 219,Apoorva Khare),Course(Analysis III,MA 321,A.K.Nandakumaran))
// (Course(Commutative Algebra,MA 312,Amalendu Krishna),Course(Introduction to Analytic Number Theory,MA 317,Soumya Das))
// (Course(Probability Models,MA 261,Sanchayan Sen),Course(Topics in Non-linear Functional Analysis,MA 388,Arka Mallick))
// (Course(Partial Differential Equations,MA 242,Swarnendu Sil),Course(Topics in Several Complex Variables,MA 329,Gautam Bharali))
// (Course(Representation Theory of Finite Groups,MA 220,Radhika Ganapathy),Course(Operator Theory II,MA 325,E.K.Narayanan))
// (Course(Linear Algebra,MA 219,Apoorva Khare),Course(Algebraic Number Theory,MA 313,Bharathwaj Palvannan))"""
StudentChoices
  .strongClashes(chosen)
  .toVector
  .map {
    case (c, v) => (c._1.name, c._2.name) -> v.map(_.name).mkString(", ")
  }
  .filter(_._2.nonEmpty)
// res10: Vector[((String, String), String)] = Vector(
//   (("Multivariable Calculus", "Probability Theory"), "Suryansh Shrivastava , Aditya Priya"),
//   (
//     ("Commutative Algebra", "Introduction to Analytic Number Theory"),
//     "Sai Sanjeev Balakrishnan, Souptik Mudi, Irish Debbarma, Sarvagya Jain , Spandan Ghosh"
//   ),
//   (("Linear Algebra", "Algebraic Number Theory"), "Suryansh Shrivastava ")
// )
StudentChoices
  .weakClashes(chosen)
  .toVector
  .map {
    case (c, v) => (c._1.name, c._2.name) -> v.map(_.name).mkString(", ")
  }
  .filter(_._2.nonEmpty)
// res11: Vector[((String, String), String)] = Vector(
//   (("Analysis I: Real Anaysis", "Functional Analysis"), "Suryansh Shrivastava , Raghuram Sundararajan"),
//   (("Multivariable Calculus", "Probability Theory"), "Suryansh Shrivastava , Aditya Priya"),
//   (("Linear Algebra", "Analysis III"), "Raghuram Sundararajan"),
//   (
//     ("Commutative Algebra", "Introduction to Analytic Number Theory"),
//     "Sai Sanjeev Balakrishnan, Souptik Mudi, Suryansh Shrivastava , Upamanyu Yaddanapudi , Irish Debbarma, Sarvagya Jain , M Nikhesh Kumar , Spandan Ghosh, Raghuram Sundararajan"
//   ),
//   (
//     ("Partial Differential Equations", "Topics in Several Complex Variables"),
//     "Arghan Dutta, Raghuram Sundararajan, Mohith Raju"
//   ),
//   (("Representation Theory of Finite Groups", "Operator Theory II"), "Umang Bhat "),
//   (("Linear Algebra", "Algebraic Number Theory"), "Suryansh Shrivastava , Sudharshan K V, Sakjit Das, Atharva Ghugare")
// )
chosen.sorted.groupMap(_._2)(_._1)
// res12: Map[Timing, Vector[Course]] = HashMap(
//   TuTh(times = "11:30 - 1:00") -> Vector(
//     Course(name = "Commutative Algebra", code = "MA 312", instructor = "Amalendu Krishna"),
//     Course(name = "Introduction to Analytic Number Theory", code = "MA 317", instructor = "Soumya Das")
//   ),
//   MWF(times = "11:00 - 12:00") -> Vector(
//     Course(name = "Algebraic Graph Theory", code = "MA 375", instructor = "Shivani Goel/Arvind Ayyer")
//   ),
//   TuTh(times = "10:00 - 11:30") -> Vector(
//     Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare"),
//     Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Bharathwaj Palvannan"),
//     Course(name = "Analysis III", code = "MA 321", instructor = "A.K.Nandakumaran")
//   ),
//   TuTh(times = "2:00 - 3:30") -> Vector(
//     Course(name = "Multivariable Calculus", code = "MA 200", instructor = "Vamsi Pingali"),
//     Course(name = "Probability Theory", code = "MA 361", instructor = "Manjunath Krishnapur")
//   ),
//   TuTh(times = "8:30 - 10:00") -> Vector(
//     Course(name = "Representation Theory of Finite Groups", code = "MA 220", instructor = "Radhika Ganapathy"),
//     Course(name = "Operator Theory II", code = "MA 325", instructor = "E.K.Narayanan")
//   ),
//   MWF(times = "10:00 - 11:00") -> Vector(
//     Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Sunadaram Thangavelu/R. Venkatesh"),
//     Course(name = "Functional Analysis", code = "MA 223", instructor = "Tirthankar Bhattacharyya")
//   ),
//   MWF(times = "3:00 - 4:00") -> Vector(Course(name = "Algebra I", code = "MA 212", instructor = "Shaunak Deo")),
//   TuTh(times = "3:30 - 5: 00") -> Vector(
//     Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen"),
//     Course(name = "Topics in Non-linear Functional Analysis", code = "MA 388", instructor = "Arka Mallick")
//   ),
//   MWF(times = "9:00 - 10:00") -> Vector(Course(name = "Topology", code = "MA 231", instructor = "Siddhartha Gadgil")),
//   MWF(times = "2:00 - 3:00") -> Vector(
//     Course(name = "Partial Differential Equations", code = "MA 242", instructor = "Swarnendu Sil"),
//     Course(name = "Topics in Several Complex Variables", code = "MA 329", instructor = "Gautam Bharali")
//   )
// )
os.write.over(SavedData.dat / "schedule.tsv", chosen.tsv)