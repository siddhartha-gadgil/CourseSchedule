
import courses._
import BestChoice._

best 
// res0: Set[Schedule] = Set(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Topology", code = "MA 231", instructor = "Harish Seshadri") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Commutative Algebra", code = "MA 312", instructor = "Radhika Ganapathy") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Partial Differential Equations", code = "MA 242", instructor = "A. K. Nandakumaran") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Probability Theory", code = "MA 361", instructor = "Srikanth Iyer") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Linear Algebraic Groups", code = "MA 379", instructor = "Mihir Sheth") -> MWF(times = "8:00 - 9:00"),
//       Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Tirthankar Bhattacharyya") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Mahesh Kakde") -> MWF(times = "9:00 - 10:00"),
//       Course(name = "Introduction to Algebraic Topology", code = "MA 232", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Topics in Non-linear functional analysis", code = "MA 388", instructor = "Arka Mallick") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Introduction to Analytic Number Theory", code = "MA 317", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Functional Analysis", code = "MA 223", instructor = "Swarnendu Sil") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Topics in Number Theory 1 (Galois representations)", code = "MA 354", instructor = "Shaunak Deo") -> TuTh(
//         times = "2:00 - 3:30"
//       ),
//       Course(name = "Riemannian Geometry", code = "MA 333", instructor = "Ved Datar") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Algebra I", code = "MA 212", instructor = "Bharathwaj Palvannan") -> MWF(times = "10:00 - 11:00"),
//       Course(name = "Multivariable Calculus", code = "MA 200", instructor = "Vamsi Pingali") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Matrix Analysis and Positivity", code = "MA 341", instructor = "Apoorva Khare") -> TuTh(times = "2:00 - 3:30")
//     )
//   ),
//   Schedule(
//     sch = HashMap(
//       Course(name = "Topology", code = "MA 231", instructor = "Harish Seshadri") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Commutative Algebra", code = "MA 312", instructor = "Radhika Ganapathy") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Partial Differential Equations", code = "MA 242", instructor = "A. K. Nandakumaran") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Probability Theory", code = "MA 361", instructor = "Srikanth Iyer") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Linear Algebraic Groups", code = "MA 379", instructor = "Mihir Sheth") -> MWF(times = "8:00 - 9:00"),
//       Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Tirthankar Bhattacharyya") -> MWF(times = ...
best.size
// res1: Int = 4

bestSW
// res2: Set[Schedule] = Set(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Topology", code = "MA 231", instructor = "Harish Seshadri") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Commutative Algebra", code = "MA 312", instructor = "Radhika Ganapathy") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Partial Differential Equations", code = "MA 242", instructor = "A. K. Nandakumaran") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Probability Theory", code = "MA 361", instructor = "Srikanth Iyer") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Linear Algebraic Groups", code = "MA 379", instructor = "Mihir Sheth") -> MWF(times = "8:00 - 9:00"),
//       Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Tirthankar Bhattacharyya") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Mahesh Kakde") -> MWF(times = "9:00 - 10:00"),
//       Course(name = "Introduction to Algebraic Topology", code = "MA 232", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Topics in Non-linear functional analysis", code = "MA 388", instructor = "Arka Mallick") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Introduction to Analytic Number Theory", code = "MA 317", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Functional Analysis", code = "MA 223", instructor = "Swarnendu Sil") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Topics in Number Theory 1 (Galois representations)", code = "MA 354", instructor = "Shaunak Deo") -> TuTh(
//         times = "2:00 - 3:30"
//       ),
//       Course(name = "Riemannian Geometry", code = "MA 333", instructor = "Ved Datar") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Algebra I", code = "MA 212", instructor = "Bharathwaj Palvannan") -> MWF(times = "10:00 - 11:00"),
//       Course(name = "Multivariable Calculus", code = "MA 200", instructor = "Vamsi Pingali") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Matrix Analysis and Positivity", code = "MA 341", instructor = "Apoorva Khare") -> TuTh(times = "2:00 - 3:30")
//     )
//   ),
//   Schedule(
//     sch = HashMap(
//       Course(name = "Topology", code = "MA 231", instructor = "Harish Seshadri") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Commutative Algebra", code = "MA 312", instructor = "Radhika Ganapathy") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Partial Differential Equations", code = "MA 242", instructor = "A. K. Nandakumaran") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Probability Theory", code = "MA 361", instructor = "Srikanth Iyer") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Linear Algebraic Groups", code = "MA 379", instructor = "Mihir Sheth") -> MWF(times = "8:00 - 9:00"),
//       Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Tirthankar Bhattacharyya") -> MWF(times = ...
bestSW.size
// res3: Int = 2
bestSW.map(_.clashes.size)
// res4: Set[Int] = Set(12)
val commonClashes = bestSW.map(_.clashes).reduce(_ intersect _)
// commonClashes: Set[(Course, Course)] = HashSet(
//   (
//     Course(name = "Matrix Analysis and Positivity", code = "MA 341", instructor = "Apoorva Khare"),
//     Course(name = "Topics in Non-linear functional analysis", code = "MA 388", instructor = "Arka Mallick")
//   ),
//   (
//     Course(name = "Functional Analysis", code = "MA 223", instructor = "Swarnendu Sil"),
//     Course(name = "Topology", code = "MA 231", instructor = "Harish Seshadri")
//   ),
//   (
//     Course(name = "Introduction to Algebraic Topology", code = "MA 232", instructor = "Siddhartha Gadgil"),
//     Course(name = "Commutative Algebra", code = "MA 312", instructor = "Radhika Ganapathy")
//   ),
//   (
//     Course(name = "Partial Differential Equations", code = "MA 242", instructor = "A. K. Nandakumaran"),
//     Course(name = "Introduction to Analytic Number Theory", code = "MA 317", instructor = "Soumya Das")
//   ),
//   (
//     Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen"),
//     Course(name = "Topics in Non-linear functional analysis", code = "MA 388", instructor = "Arka Mallick")
//   ),
//   (
//     Course(name = "Introduction to Analytic Number Theory", code = "MA 317", instructor = "Soumya Das"),
//     Course(name = "Probability Theory", code = "MA 361", instructor = "Srikanth Iyer")
//   ),
//   (
//     Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen"),
//     Course(name = "Matrix Analysis and Positivity", code = "MA 341", instructor = "Apoorva Khare")
//   ),
//   (
//     Course(name = "Partial Differential Equations", code = "MA 242", instructor = "A. K. Nandakumaran"),
//     Course(name = "Probability Theory", code = "MA 361", instructor = "Srikanth Iyer")
//   ),
//   (
//     Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare"),
//     Course(name = "Riemannian Geometry", code = "MA 333", instructor = "Ved Datar")
//   ),
//   (
//     Course(name = "Topics in Number Theory 1 (Galois representations)", code = "MA 354", instructor = "Shaunak Deo"),
//     Course(name = "Topics in Non-linear functional analysis", code = "MA 388", instructor = "Arka Mallick")
//   ),
//   (
//     Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen"),
//     Course(name = "Topics in Number Theory 1 (Galois representations)", code = "MA 354", instructor = "Shaunak Deo")
//   ),
//   (
//     Course(name = "Matrix Analysis and Positivity", code = "MA 341", instructor = "Apoorva Khare"),
//     Course(name = "Topics in Number Theory 1 (Galois representations)", code = "MA 354", instructor = "Shaunak Deo")
//   )
// )
commonClashes.size
// res5: Int = 12
val minClashSize = bestSW.map(_.clashes.size).min
// minClashSize: Int = 12
val minClashes = bestSW.filter(_.clashes.size == minClashSize).toVector
// minClashes: Vector[Schedule] = Vector(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Topology", code = "MA 231", instructor = "Harish Seshadri") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Commutative Algebra", code = "MA 312", instructor = "Radhika Ganapathy") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Partial Differential Equations", code = "MA 242", instructor = "A. K. Nandakumaran") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Probability Theory", code = "MA 361", instructor = "Srikanth Iyer") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Linear Algebraic Groups", code = "MA 379", instructor = "Mihir Sheth") -> MWF(times = "8:00 - 9:00"),
//       Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Tirthankar Bhattacharyya") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Mahesh Kakde") -> MWF(times = "9:00 - 10:00"),
//       Course(name = "Introduction to Algebraic Topology", code = "MA 232", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Topics in Non-linear functional analysis", code = "MA 388", instructor = "Arka Mallick") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Introduction to Analytic Number Theory", code = "MA 317", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Functional Analysis", code = "MA 223", instructor = "Swarnendu Sil") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Topics in Number Theory 1 (Galois representations)", code = "MA 354", instructor = "Shaunak Deo") -> TuTh(
//         times = "2:00 - 3:30"
//       ),
//       Course(name = "Riemannian Geometry", code = "MA 333", instructor = "Ved Datar") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Algebra I", code = "MA 212", instructor = "Bharathwaj Palvannan") -> MWF(times = "10:00 - 11:00"),
//       Course(name = "Multivariable Calculus", code = "MA 200", instructor = "Vamsi Pingali") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Matrix Analysis and Positivity", code = "MA 341", instructor = "Apoorva Khare") -> TuTh(times = "2:00 - 3:30")
//     )
//   ),
//   Schedule(
//     sch = HashMap(
//       Course(name = "Topology", code = "MA 231", instructor = "Harish Seshadri") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Commutative Algebra", code = "MA 312", instructor = "Radhika Ganapathy") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Partial Differential Equations", code = "MA 242", instructor = "A. K. Nandakumaran") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Probability Theory", code = "MA 361", instructor = "Srikanth Iyer") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Linear Algebraic Groups", code = "MA 379", instructor = "Mihir Sheth") -> MWF(times = "8:00 - 9:00"),
//       Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Tirthankar Bhattacharyya") -> MWF(times = ...
minClashes.size
// res6: Int = 2
// minClashes(0).diff(minClashes(1))
val chosen = minClashes(0)
// chosen: Schedule = Schedule(
//   sch = HashMap(
//     Course(name = "Topology", code = "MA 231", instructor = "Harish Seshadri") -> MWF(times = "2:00 - 3:00"),
//     Course(name = "Commutative Algebra", code = "MA 312", instructor = "Radhika Ganapathy") -> TuTh(times = "8:30 - 10:00"),
//     Course(name = "Partial Differential Equations", code = "MA 242", instructor = "A. K. Nandakumaran") -> TuTh(times = "11:30 - 1:00"),
//     Course(name = "Probability Theory", code = "MA 361", instructor = "Srikanth Iyer") -> TuTh(times = "11:30 - 1:00"),
//     Course(name = "Linear Algebraic Groups", code = "MA 379", instructor = "Mihir Sheth") -> MWF(times = "8:00 - 9:00"),
//     Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Tirthankar Bhattacharyya") -> MWF(times = "11:00 - 12:00"),
//     Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Mahesh Kakde") -> MWF(times = "9:00 - 10:00"),
//     Course(name = "Introduction to Algebraic Topology", code = "MA 232", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00"),
//     Course(name = "Topics in Non-linear functional analysis", code = "MA 388", instructor = "Arka Mallick") -> TuTh(times = "2:00 - 3:30"),
//     Course(name = "Introduction to Analytic Number Theory", code = "MA 317", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//     Course(name = "Functional Analysis", code = "MA 223", instructor = "Swarnendu Sil") -> MWF(times = "2:00 - 3:00"),
//     Course(name = "Topics in Number Theory 1 (Galois representations)", code = "MA 354", instructor = "Shaunak Deo") -> TuTh(
//       times = "2:00 - 3:30"
//     ),
//     Course(name = "Riemannian Geometry", code = "MA 333", instructor = "Ved Datar") -> TuTh(times = "10:00 - 11:30"),
//     Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen") -> TuTh(times = "2:00 - 3:30"),
//     Course(name = "Algebra I", code = "MA 212", instructor = "Bharathwaj Palvannan") -> MWF(times = "10:00 - 11:00"),
//     Course(name = "Multivariable Calculus", code = "MA 200", instructor = "Vamsi Pingali") -> TuTh(times = "3:30 - 5: 00"),
//     Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare") -> TuTh(times = "10:00 - 11:30"),
//     Course(name = "Matrix Analysis and Positivity", code = "MA 341", instructor = "Apoorva Khare") -> TuTh(times = "2:00 - 3:30")
//   )
// )
chosen.sch.size
// res7: Int = 18

chosen.tsv
// res8: String = """MA 200	Multivariable Calculus	Vamsi Pingali	Tue, Thu	3:30 - 5: 00
// MA 212	Algebra I	Bharathwaj Palvannan	Mon, Wed, Fri	10:00 - 11:00
// MA 219	Linear Algebra	Apoorva Khare	Tue, Thu	10:00 - 11:30
// MA 221	Analysis I: Real Anaysis	Tirthankar Bhattacharyya	Mon, Wed, Fri	11:00 - 12:00
// MA 223	Functional Analysis	Swarnendu Sil	Mon, Wed, Fri	2:00 - 3:00
// MA 231	Topology	Harish Seshadri	Mon, Wed, Fri	2:00 - 3:00
// MA 232	Introduction to Algebraic Topology	Siddhartha Gadgil	Tue, Thu	8:30 - 10:00
// MA 242	Partial Differential Equations	A. K. Nandakumaran	Tue, Thu	11:30 - 1:00
// MA 261	Probability Models	Sanchayan Sen	Tue, Thu	2:00 - 3:30
// MA 312	Commutative Algebra	Radhika Ganapathy	Tue, Thu	8:30 - 10:00
// MA 313	Algebraic Number Theory	Mahesh Kakde	Mon, Wed, Fri	9:00 - 10:00
// MA 317	Introduction to Analytic Number Theory	Soumya Das	Tue, Thu	11:30 - 1:00
// MA 333	Riemannian Geometry	Ved Datar	Tue, Thu	10:00 - 11:30
// MA 341	Matrix Analysis and Positivity	Apoorva Khare	Tue, Thu	2:00 - 3:30
// MA 354	Topics in Number Theory 1 (Galois representations)	Shaunak Deo	Tue, Thu	2:00 - 3:30
// MA 361	Probability Theory	Srikanth Iyer	Tue, Thu	11:30 - 1:00
// MA 379	Linear Algebraic Groups	Mihir Sheth	Mon, Wed, Fri	8:00 - 9:00
// MA 388	Topics in Non-linear functional analysis	Arka Mallick	Tue, Thu	2:00 - 3:30
// """
chosen.clashes.mkString("\n")
// res9: String = """(Course(Matrix Analysis and Positivity,MA 341,Apoorva Khare),Course(Topics in Non-linear functional analysis,MA 388,Arka Mallick))
// (Course(Functional Analysis,MA 223,Swarnendu Sil),Course(Topology,MA 231,Harish Seshadri))
// (Course(Introduction to Algebraic Topology,MA 232,Siddhartha Gadgil),Course(Commutative Algebra,MA 312,Radhika Ganapathy))
// (Course(Partial Differential Equations,MA 242,A. K. Nandakumaran),Course(Introduction to Analytic Number Theory,MA 317,Soumya Das))
// (Course(Probability Models,MA 261,Sanchayan Sen),Course(Topics in Non-linear functional analysis,MA 388,Arka Mallick))
// (Course(Introduction to Analytic Number Theory,MA 317,Soumya Das),Course(Probability Theory,MA 361,Srikanth Iyer))
// (Course(Probability Models,MA 261,Sanchayan Sen),Course(Matrix Analysis and Positivity,MA 341,Apoorva Khare))
// (Course(Partial Differential Equations,MA 242,A. K. Nandakumaran),Course(Probability Theory,MA 361,Srikanth Iyer))
// (Course(Linear Algebra,MA 219,Apoorva Khare),Course(Riemannian Geometry,MA 333,Ved Datar))
// (Course(Topics in Number Theory 1 (Galois representations),MA 354,Shaunak Deo),Course(Topics in Non-linear functional analysis,MA 388,Arka Mallick))
// (Course(Probability Models,MA 261,Sanchayan Sen),Course(Topics in Number Theory 1 (Galois representations),MA 354,Shaunak Deo))
// (Course(Matrix Analysis and Positivity,MA 341,Apoorva Khare),Course(Topics in Number Theory 1 (Galois representations),MA 354,Shaunak Deo))"""
StudentChoices
  .strongClashes(chosen)
  .toVector
  .map {
    case (c, v) => (c._1.name, c._2.name) -> v.map(_.name).mkString(", ")
  }
  .filter(_._2.nonEmpty)
// res10: Vector[((String, String), String)] = Vector(
//   (
//     ("Introduction to Algebraic Topology", "Commutative Algebra"),
//     "Sakjit Das , Daksh Sultania , Sudharshan K V, Supriya Saha"
//   ),
//   (("Partial Differential Equations", "Introduction to Analytic Number Theory"), "Sourav Ghosh "),
//   (("Introduction to Analytic Number Theory", "Probability Theory"), "Sourav Ghosh "),
//   (("Partial Differential Equations", "Probability Theory"), "Sakjit Das, Sourav Ghosh , Kapil")
// )
StudentChoices
  .weakClashes(chosen)
  .toVector
  .map {
    case (c, v) => (c._1.name, c._2.name) -> v.map(_.name).mkString(", ")
  }
  .filter(_._2.nonEmpty)
// res11: Vector[((String, String), String)] = Vector(
//   (
//     ("Introduction to Algebraic Topology", "Commutative Algebra"),
//     "Adhavan. S V, Sakjit Das , Irish Debbarma, Daksh Sultania , Sudharshan K V, Supriya Saha, Prayas Rautray , Karthik Dulam, Vinayaka M"
//   ),
//   (("Partial Differential Equations", "Introduction to Analytic Number Theory"), "Daksh Sultania , Sourav Ghosh "),
//   (("Introduction to Analytic Number Theory", "Probability Theory"), "Sourav Ghosh , Aatman Supkar"),
//   (("Probability Models", "Matrix Analysis and Positivity"), "Amrit Mahendra Joseph"),
//   (
//     ("Partial Differential Equations", "Probability Theory"),
//     "Vasisht Vasudevan, Sakjit Das, Barkur Anvesh Shetty, Sourav Ghosh , Sabyasachi Pramanik , Anant Narayanan, Kapil"
//   ),
//   (("Linear Algebra", "Riemannian Geometry"), "Samanway"),
//   (
//     ("Matrix Analysis and Positivity", "Topics in Number Theory 1 (Galois representations)"),
//     "Upamanyu Yaddanapudi , Irish Debbarma, Aatman Supkar"
//   )
// )
chosen.sorted.groupMap(_._2)(_._1)
// res12: Map[Timing, Vector[Course]] = HashMap(
//   TuTh(times = "11:30 - 1:00") -> Vector(
//     Course(name = "Partial Differential Equations", code = "MA 242", instructor = "A. K. Nandakumaran"),
//     Course(name = "Introduction to Analytic Number Theory", code = "MA 317", instructor = "Soumya Das"),
//     Course(name = "Probability Theory", code = "MA 361", instructor = "Srikanth Iyer")
//   ),
//   MWF(times = "11:00 - 12:00") -> Vector(
//     Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Tirthankar Bhattacharyya")
//   ),
//   TuTh(times = "10:00 - 11:30") -> Vector(
//     Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare"),
//     Course(name = "Riemannian Geometry", code = "MA 333", instructor = "Ved Datar")
//   ),
//   TuTh(times = "2:00 - 3:30") -> Vector(
//     Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen"),
//     Course(name = "Matrix Analysis and Positivity", code = "MA 341", instructor = "Apoorva Khare"),
//     Course(name = "Topics in Number Theory 1 (Galois representations)", code = "MA 354", instructor = "Shaunak Deo"),
//     Course(name = "Topics in Non-linear functional analysis", code = "MA 388", instructor = "Arka Mallick")
//   ),
//   TuTh(times = "8:30 - 10:00") -> Vector(
//     Course(name = "Introduction to Algebraic Topology", code = "MA 232", instructor = "Siddhartha Gadgil"),
//     Course(name = "Commutative Algebra", code = "MA 312", instructor = "Radhika Ganapathy")
//   ),
//   MWF(times = "10:00 - 11:00") -> Vector(Course(name = "Algebra I", code = "MA 212", instructor = "Bharathwaj Palvannan")),
//   TuTh(times = "3:30 - 5: 00") -> Vector(Course(name = "Multivariable Calculus", code = "MA 200", instructor = "Vamsi Pingali")),
//   MWF(times = "8:00 - 9:00") -> Vector(Course(name = "Linear Algebraic Groups", code = "MA 379", instructor = "Mihir Sheth")),
//   MWF(times = "9:00 - 10:00") -> Vector(Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Mahesh Kakde")),
//   MWF(times = "2:00 - 3:00") -> Vector(
//     Course(name = "Functional Analysis", code = "MA 223", instructor = "Swarnendu Sil"),
//     Course(name = "Topology", code = "MA 231", instructor = "Harish Seshadri")
//   )
// )
os.write.over(SavedData.dat / "schedule.tsv", chosen.tsv)