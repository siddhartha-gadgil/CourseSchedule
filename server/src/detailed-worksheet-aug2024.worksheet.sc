
import courses._
import BestChoice._

best 
// res0: Set[Schedule] = HashSet(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Topics in Probability and Stochastic Processes", code = "MA 368", instructor = "Arvind Ayyer") -> TuTh(
//         times = "2:00 - 3:30"
//       ),
//       Course(name = "Topology", code = "MA 231", instructor = "Subhojoy Gupta") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen") -> MWF(times = "3:00 - 4:00"),
//       Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Purvi Gupta") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Algebra I", code = "MA 212", instructor = "Soumya Das") -> MWF(times = "12:00 - 1:00"),
//       Course(
//         name = "Applied Data Science and Artificial Intelligence",
//         code = "UMC 301",
//         instructor = "Deepak Subramani"
//       ) -> MWF(times = "10:00 - 11:00"),
//       Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Topics in Non-linear functional analysis", code = "MA 388", instructor = "Arka Mallick") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Riemann Surfaces", code = "MA 307", instructor = "Ved Datar") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Functional Analysis", code = "MA 223", instructor = "Swarnendu Sil") -> MWF(times = "3:00 - 4:00"),
//       Course(name = "Multivariable Calculus", code = "MA 200", instructor = "Muna Naik") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Commutative Algebra", code = "MA 312", instructor = "Abhishek Banerjee") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Lie Algebras and their Representations", code = "MA 315", instructor = "Souvik Pal/Apoorva Khare") -> TuTh(
//         times = "2:00 - 3:30"
//       ),
//       Course(
//         name = "Introduction to Modular Forms",
//         code = "MA 215",
//         instructor = "Ravitheja Vangala & Rishabh Agnihotri/Bharathwaj Palvannan"
//       ) -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Mahesh Kakde") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Partial Differential Equations", code = "MA 242", instructor = "Harish Seshadri") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Introduction to Algebraic Topology", code = "MA 232", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Riemannian Geometry", code = "MA 333", instructor = "Vamsi Pingali") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Introduction to Several Complex Variables", code = "MA 328", instructor = "Gautam Bharali") -> TuTh(
//         times = "2:00 - 3:30"
//       ),
//       Course(name = "Probability Theory", code = "MA 361", instructor = "Manjunath Krishnapur") -> TuTh(times = "11:30 - 1:00")
// ...
// Trying worst choice 1, occuring 20 times
// Trying worst choice 2, occuring 1 times
// Trying worst choice 2, occuring 2 times
// Trying worst choice 2, occuring 3 times
best.size
// res1: Int = 16

bestSW
// res2: Set[Schedule] = HashSet(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Topics in Probability and Stochastic Processes", code = "MA 368", instructor = "Arvind Ayyer") -> TuTh(
//         times = "2:00 - 3:30"
//       ),
//       Course(name = "Topology", code = "MA 231", instructor = "Subhojoy Gupta") -> MWF(times = "3:00 - 4:00"),
//       Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Purvi Gupta") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Algebra I", code = "MA 212", instructor = "Soumya Das") -> MWF(times = "12:00 - 1:00"),
//       Course(
//         name = "Applied Data Science and Artificial Intelligence",
//         code = "UMC 301",
//         instructor = "Deepak Subramani"
//       ) -> MWF(times = "10:00 - 11:00"),
//       Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Topics in Non-linear functional analysis", code = "MA 388", instructor = "Arka Mallick") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Riemann Surfaces", code = "MA 307", instructor = "Ved Datar") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Functional Analysis", code = "MA 223", instructor = "Swarnendu Sil") -> MWF(times = "3:00 - 4:00"),
//       Course(name = "Multivariable Calculus", code = "MA 200", instructor = "Muna Naik") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Commutative Algebra", code = "MA 312", instructor = "Abhishek Banerjee") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Lie Algebras and their Representations", code = "MA 315", instructor = "Souvik Pal/Apoorva Khare") -> TuTh(
//         times = "11:30 - 1:00"
//       ),
//       Course(
//         name = "Introduction to Modular Forms",
//         code = "MA 215",
//         instructor = "Ravitheja Vangala & Rishabh Agnihotri/Bharathwaj Palvannan"
//       ) -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Mahesh Kakde") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Partial Differential Equations", code = "MA 242", instructor = "Harish Seshadri") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Introduction to Algebraic Topology", code = "MA 232", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Riemannian Geometry", code = "MA 333", instructor = "Vamsi Pingali") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Introduction to Several Complex Variables", code = "MA 328", instructor = "Gautam Bharali") -> TuTh(
//         times = "2:00 - 3:30"
//       ),
//       Course(name = "Probability Theory", code = "MA 361", instructor = "Manjunath Krishnapur") -> TuTh(times = "11:30 -...
bestSW.size
// res3: Int = 4
bestSW.map(_.clashes.size)
// res4: Set[Int] = HashSet(12)
val commonClashes = bestSW.map(_.clashes).reduce(_ intersect _)
// commonClashes: Set[(Course, Course)] = HashSet(
//   (
//     Course(name = "Introduction to Several Complex Variables", code = "MA 328", instructor = "Gautam Bharali"),
//     Course(name = "Topics in Probability and Stochastic Processes", code = "MA 368", instructor = "Arvind Ayyer")
//   ),
//   (
//     Course(name = "Commutative Algebra", code = "MA 312", instructor = "Abhishek Banerjee"),
//     Course(name = "Introduction to Several Complex Variables", code = "MA 328", instructor = "Gautam Bharali")
//   ),
//   (
//     Course(name = "Lie Algebras and their Representations", code = "MA 315", instructor = "Souvik Pal/Apoorva Khare"),
//     Course(name = "Probability Theory", code = "MA 361", instructor = "Manjunath Krishnapur")
//   ),
//   (
//     Course(name = "Commutative Algebra", code = "MA 312", instructor = "Abhishek Banerjee"),
//     Course(name = "Topics in Probability and Stochastic Processes", code = "MA 368", instructor = "Arvind Ayyer")
//   ),
//   (
//     Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare"),
//     Course(name = "Topics in Non-linear functional analysis", code = "MA 388", instructor = "Arka Mallick")
//   ),
//   (
//     Course(name = "Introduction to Algebraic Topology", code = "MA 232", instructor = "Siddhartha Gadgil"),
//     Course(name = "Riemann Surfaces", code = "MA 307", instructor = "Ved Datar")
//   ),
//   (
//     Course(name = "Multivariable Calculus", code = "MA 200", instructor = "Muna Naik"),
//     Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Mahesh Kakde")
//   ),
//   (
//     Course(
//       name = "Introduction to Modular Forms",
//       code = "MA 215",
//       instructor = "Ravitheja Vangala & Rishabh Agnihotri/Bharathwaj Palvannan"
//     ),
//     Course(name = "Lie Algebras and their Representations", code = "MA 315", instructor = "Souvik Pal/Apoorva Khare")
//   ),
//   (
//     Course(
//       name = "Introduction to Modular Forms",
//       code = "MA 215",
//       instructor = "Ravitheja Vangala & Rishabh Agnihotri/Bharathwaj Palvannan"
//     ),
//     Course(name = "Probability Theory", code = "MA 361", instructor = "Manjunath Krishnapur")
//   )
// )
commonClashes.size
// res5: Int = 9
val minClashSize = bestSW.map(_.clashes.size).min
// minClashSize: Int = 12
val minClashes = bestSW.filter(_.clashes.size == minClashSize).toVector
// minClashes: Vector[Schedule] = Vector(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Topics in Probability and Stochastic Processes", code = "MA 368", instructor = "Arvind Ayyer") -> TuTh(
//         times = "2:00 - 3:30"
//       ),
//       Course(name = "Topology", code = "MA 231", instructor = "Subhojoy Gupta") -> MWF(times = "3:00 - 4:00"),
//       Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Purvi Gupta") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Algebra I", code = "MA 212", instructor = "Soumya Das") -> MWF(times = "12:00 - 1:00"),
//       Course(
//         name = "Applied Data Science and Artificial Intelligence",
//         code = "UMC 301",
//         instructor = "Deepak Subramani"
//       ) -> MWF(times = "10:00 - 11:00"),
//       Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Topics in Non-linear functional analysis", code = "MA 388", instructor = "Arka Mallick") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Riemann Surfaces", code = "MA 307", instructor = "Ved Datar") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Functional Analysis", code = "MA 223", instructor = "Swarnendu Sil") -> MWF(times = "3:00 - 4:00"),
//       Course(name = "Multivariable Calculus", code = "MA 200", instructor = "Muna Naik") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Commutative Algebra", code = "MA 312", instructor = "Abhishek Banerjee") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Lie Algebras and their Representations", code = "MA 315", instructor = "Souvik Pal/Apoorva Khare") -> TuTh(
//         times = "11:30 - 1:00"
//       ),
//       Course(
//         name = "Introduction to Modular Forms",
//         code = "MA 215",
//         instructor = "Ravitheja Vangala & Rishabh Agnihotri/Bharathwaj Palvannan"
//       ) -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Mahesh Kakde") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Partial Differential Equations", code = "MA 242", instructor = "Harish Seshadri") -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Introduction to Algebraic Topology", code = "MA 232", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Riemannian Geometry", code = "MA 333", instructor = "Vamsi Pingali") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Introduction to Several Complex Variables", code = "MA 328", instructor = "Gautam Bharali") -> TuTh(
//         times = "2:00 - 3:30"
//       ),
//       Course(name = "Probability Theory", code = "MA 361", instructor = "Manjunath Krishnapur") -> TuTh(times = "11:30 -...
minClashes.size
// res6: Int = 4
minClashes(0).diff(minClashes(1))
// res7: Map[Course, (Timing, Option[Timing])] = Map(
//   Course(name = "Functional Analysis", code = "MA 223", instructor = "Swarnendu Sil") -> (
//     MWF(times = "3:00 - 4:00"),
//     Some(value = MWF(times = "2:00 - 3:00"))
//   ),
//   Course(name = "Topology", code = "MA 231", instructor = "Subhojoy Gupta") -> (
//     MWF(times = "3:00 - 4:00"),
//     Some(value = TuTh(times = "3:30 - 5: 00"))
//   ),
//   Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen") -> (
//     TuTh(times = "3:30 - 5: 00"),
//     Some(value = MWF(times = "3:00 - 4:00"))
//   ),
//   Course(name = "Partial Differential Equations", code = "MA 242", instructor = "Harish Seshadri") -> (
//     MWF(times = "2:00 - 3:00"),
//     Some(value = MWF(times = "3:00 - 4:00"))
//   )
// )
val chosen = minClashes(0)
// chosen: Schedule = Schedule(
//   sch = HashMap(
//     Course(name = "Topics in Probability and Stochastic Processes", code = "MA 368", instructor = "Arvind Ayyer") -> TuTh(
//       times = "2:00 - 3:30"
//     ),
//     Course(name = "Topology", code = "MA 231", instructor = "Subhojoy Gupta") -> MWF(times = "3:00 - 4:00"),
//     Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen") -> TuTh(times = "3:30 - 5: 00"),
//     Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Purvi Gupta") -> MWF(times = "2:00 - 3:00"),
//     Course(name = "Algebra I", code = "MA 212", instructor = "Soumya Das") -> MWF(times = "12:00 - 1:00"),
//     Course(name = "Applied Data Science and Artificial Intelligence", code = "UMC 301", instructor = "Deepak Subramani") -> MWF(
//       times = "10:00 - 11:00"
//     ),
//     Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare") -> TuTh(times = "10:00 - 11:30"),
//     Course(name = "Topics in Non-linear functional analysis", code = "MA 388", instructor = "Arka Mallick") -> TuTh(times = "10:00 - 11:30"),
//     Course(name = "Riemann Surfaces", code = "MA 307", instructor = "Ved Datar") -> TuTh(times = "8:30 - 10:00"),
//     Course(name = "Functional Analysis", code = "MA 223", instructor = "Swarnendu Sil") -> MWF(times = "3:00 - 4:00"),
//     Course(name = "Multivariable Calculus", code = "MA 200", instructor = "Muna Naik") -> MWF(times = "11:00 - 12:00"),
//     Course(name = "Commutative Algebra", code = "MA 312", instructor = "Abhishek Banerjee") -> TuTh(times = "2:00 - 3:30"),
//     Course(name = "Lie Algebras and their Representations", code = "MA 315", instructor = "Souvik Pal/Apoorva Khare") -> TuTh(
//       times = "11:30 - 1:00"
//     ),
//     Course(
//       name = "Introduction to Modular Forms",
//       code = "MA 215",
//       instructor = "Ravitheja Vangala & Rishabh Agnihotri/Bharathwaj Palvannan"
//     ) -> TuTh(times = "11:30 - 1:00"),
//     Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Mahesh Kakde") -> MWF(times = "11:00 - 12:00"),
//     Course(name = "Partial Differential Equations", code = "MA 242", instructor = "Harish Seshadri") -> MWF(times = "2:00 - 3:00"),
//     Course(name = "Introduction to Algebraic Topology", code = "MA 232", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00"),
//     Course(name = "Riemannian Geometry", code = "MA 333", instructor = "Vamsi Pingali") -> TuTh(times = "3:30 - 5: 00"),
//     Course(name = "Introduction to Several Complex Variables", code = "MA 328", instructor = "Gautam Bharali") -> TuTh(
//       times = "2:00 - 3:30"
//     ),
//     Course(name = "Probability Theory", code = "MA 361", instructor = "Manjunath Krishnapur") -> TuTh(times = "11:30 - 1:00")
//   )
// )
chosen.sch.size
// res8: Int = 20

chosen.tsv
// res9: String = """MA 200	Multivariable Calculus	Muna Naik	Mon, Wed, Fri	11:00 - 12:00
// MA 212	Algebra I	Soumya Das	Mon, Wed, Fri	12:00 - 1:00
// MA 215	Introduction to Modular Forms	Ravitheja Vangala & Rishabh Agnihotri/Bharathwaj Palvannan	Tue, Thu	11:30 - 1:00
// MA 219	Linear Algebra	Apoorva Khare	Tue, Thu	10:00 - 11:30
// MA 221	Analysis I: Real Anaysis	Purvi Gupta	Mon, Wed, Fri	2:00 - 3:00
// MA 223	Functional Analysis	Swarnendu Sil	Mon, Wed, Fri	3:00 - 4:00
// MA 231	Topology	Subhojoy Gupta	Mon, Wed, Fri	3:00 - 4:00
// MA 232	Introduction to Algebraic Topology	Siddhartha Gadgil	Tue, Thu	8:30 - 10:00
// MA 242	Partial Differential Equations	Harish Seshadri	Mon, Wed, Fri	2:00 - 3:00
// MA 261	Probability Models	Sanchayan Sen	Tue, Thu	3:30 - 5: 00
// MA 307	Riemann Surfaces	Ved Datar	Tue, Thu	8:30 - 10:00
// MA 312	Commutative Algebra	Abhishek Banerjee	Tue, Thu	2:00 - 3:30
// MA 313	Algebraic Number Theory	Mahesh Kakde	Mon, Wed, Fri	11:00 - 12:00
// MA 315	Lie Algebras and their Representations	Souvik Pal/Apoorva Khare	Tue, Thu	11:30 - 1:00
// MA 328	Introduction to Several Complex Variables	Gautam Bharali	Tue, Thu	2:00 - 3:30
// MA 333	Riemannian Geometry	Vamsi Pingali	Tue, Thu	3:30 - 5: 00
// MA 361	Probability Theory	Manjunath Krishnapur	Tue, Thu	11:30 - 1:00
// MA 368	Topics in Probability and Stochastic Processes	Arvind Ayyer	Tue, Thu	2:00 - 3:30
// MA 388	Topics in Non-linear functional analysis	Arka Mallick	Tue, Thu	10:00 - 11:30
// UMC 301	Applied Data Science and Artificial Intelligence	Deepak Subramani	Mon, Wed, Fri	10:00 - 11:00
// """
chosen.clashes.mkString("\n")
// res10: String = """(Course(Introduction to Several Complex Variables,MA 328,Gautam Bharali),Course(Topics in Probability and Stochastic Processes,MA 368,Arvind Ayyer))
// (Course(Commutative Algebra,MA 312,Abhishek Banerjee),Course(Introduction to Several Complex Variables,MA 328,Gautam Bharali))
// (Course(Lie Algebras and their Representations,MA 315,Souvik Pal/Apoorva Khare),Course(Probability Theory,MA 361,Manjunath Krishnapur))
// (Course(Analysis I: Real Anaysis,MA 221,Purvi Gupta),Course(Partial Differential Equations,MA 242,Harish Seshadri))
// (Course(Probability Models,MA 261,Sanchayan Sen),Course(Riemannian Geometry,MA 333,Vamsi Pingali))
// (Course(Commutative Algebra,MA 312,Abhishek Banerjee),Course(Topics in Probability and Stochastic Processes,MA 368,Arvind Ayyer))
// (Course(Linear Algebra,MA 219,Apoorva Khare),Course(Topics in Non-linear functional analysis,MA 388,Arka Mallick))
// (Course(Functional Analysis,MA 223,Swarnendu Sil),Course(Topology,MA 231,Subhojoy Gupta))
// (Course(Introduction to Algebraic Topology,MA 232,Siddhartha Gadgil),Course(Riemann Surfaces,MA 307,Ved Datar))
// (Course(Multivariable Calculus,MA 200,Muna Naik),Course(Algebraic Number Theory,MA 313,Mahesh Kakde))
// (Course(Introduction to Modular Forms,MA 215,Ravitheja Vangala & Rishabh Agnihotri/Bharathwaj Palvannan),Course(Lie Algebras and their Representations,MA 315,Souvik Pal/Apoorva Khare))
// (Course(Introduction to Modular Forms,MA 215,Ravitheja Vangala & Rishabh Agnihotri/Bharathwaj Palvannan),Course(Probability Theory,MA 361,Manjunath Krishnapur))"""
StudentChoices
  .strongClashes(chosen)
  .toVector
  .map {
    case (c, v) => (c._1.name, c._2.name) -> v.map(_.name).mkString(", ")
  }
  .filter(_._2.nonEmpty)
// res11: Vector[((String, String), String)] = Vector(
//   (("Lie Algebras and their Representations", "Probability Theory"), "Raj Aniketh Reddy V S"),
//   (("Commutative Algebra", "Topics in Probability and Stochastic Processes"), "Saham Sil"),
//   (("Introduction to Algebraic Topology", "Riemann Surfaces"), "Anmol "),
//   (
//     ("Introduction to Modular Forms", "Lie Algebras and their Representations"),
//     "Anantha Krishna B, Adhavan S V, Kazi Aryan Amin"
//   )
// )
StudentChoices
  .weakClashes(chosen)
  .toVector
  .map {
    case (c, v) => (c._1.name, c._2.name) -> v.map(_.name).mkString(", ")
  }
  .filter(_._2.nonEmpty)
// res12: Vector[((String, String), String)] = Vector(
//   (
//     ("Commutative Algebra", "Introduction to Several Complex Variables"),
//     "Anant Narayanan, Anmol Kumar, Raj Aniketh Reddy V S"
//   ),
//   (
//     ("Lie Algebras and their Representations", "Probability Theory"),
//     "Kumar Satyadarshi, Adhavan S V, Sanidhya Kaushik , Raj Aniketh Reddy V S, Naman Mishra"
//   ),
//   (
//     ("Commutative Algebra", "Topics in Probability and Stochastic Processes"),
//     "Shreya Mukherjee , Saham Sil, Mousam Biswas , Aatman Supkar "
//   ),
//   (("Introduction to Algebraic Topology", "Riemann Surfaces"), "Kumar Satyadarshi, Anmol , Adhavan S V"),
//   (
//     ("Introduction to Modular Forms", "Lie Algebras and their Representations"),
//     "Anantha Krishna B, Amrit Mahendra Joseph, Adhavan S V, Anmol Kumar, Kazi Aryan Amin"
//   ),
//   (("Introduction to Modular Forms", "Probability Theory"), "Adhavan S V")
// )
chosen.sorted.groupMap(_._2)(_._1)
// res13: Map[Timing, Vector[Course]] = HashMap(
//   MWF(times = "12:00 - 1:00") -> Vector(Course(name = "Algebra I", code = "MA 212", instructor = "Soumya Das")),
//   TuTh(times = "11:30 - 1:00") -> Vector(
//     Course(
//       name = "Introduction to Modular Forms",
//       code = "MA 215",
//       instructor = "Ravitheja Vangala & Rishabh Agnihotri/Bharathwaj Palvannan"
//     ),
//     Course(name = "Lie Algebras and their Representations", code = "MA 315", instructor = "Souvik Pal/Apoorva Khare"),
//     Course(name = "Probability Theory", code = "MA 361", instructor = "Manjunath Krishnapur")
//   ),
//   MWF(times = "11:00 - 12:00") -> Vector(
//     Course(name = "Multivariable Calculus", code = "MA 200", instructor = "Muna Naik"),
//     Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Mahesh Kakde")
//   ),
//   TuTh(times = "10:00 - 11:30") -> Vector(
//     Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare"),
//     Course(name = "Topics in Non-linear functional analysis", code = "MA 388", instructor = "Arka Mallick")
//   ),
//   TuTh(times = "2:00 - 3:30") -> Vector(
//     Course(name = "Commutative Algebra", code = "MA 312", instructor = "Abhishek Banerjee"),
//     Course(name = "Introduction to Several Complex Variables", code = "MA 328", instructor = "Gautam Bharali"),
//     Course(name = "Topics in Probability and Stochastic Processes", code = "MA 368", instructor = "Arvind Ayyer")
//   ),
//   TuTh(times = "8:30 - 10:00") -> Vector(
//     Course(name = "Introduction to Algebraic Topology", code = "MA 232", instructor = "Siddhartha Gadgil"),
//     Course(name = "Riemann Surfaces", code = "MA 307", instructor = "Ved Datar")
//   ),
//   MWF(times = "10:00 - 11:00") -> Vector(
//     Course(name = "Applied Data Science and Artificial Intelligence", code = "UMC 301", instructor = "Deepak Subramani")
//   ),
//   MWF(times = "3:00 - 4:00") -> Vector(
//     Course(name = "Functional Analysis", code = "MA 223", instructor = "Swarnendu Sil"),
//     Course(name = "Topology", code = "MA 231", instructor = "Subhojoy Gupta")
//   ),
//   TuTh(times = "3:30 - 5: 00") -> Vector(
//     Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen"),
//     Course(name = "Riemannian Geometry", code = "MA 333", instructor = "Vamsi Pingali")
//   ),
//   MWF(times = "2:00 - 3:00") -> Vector(
//     Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Purvi Gupta"),
//     Course(name = "Partial Differential Equations", code = "MA 242", instructor = "Harish Seshadri")
//   )
// )
os.write.over(SavedData.dat / "schedule.tsv", chosen.tsv)
chosen.core1TuTh
// res15: Int = 2
CourseData.core1
// res16: Vector[Course] = Vector(
//   Course(name = "Multivariable Calculus", code = "MA 200", instructor = "Muna Naik"),
//   Course(name = "Algebra I", code = "MA 212", instructor = "Soumya Das"),
//   Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare"),
//   Course(name = "Analysis I: Real Anaysis", code = "MA 221", instructor = "Purvi Gupta"),
//   Course(name = "Topology", code = "MA 231", instructor = "Subhojoy Gupta"),
//   Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen")
// )
chosen.sch.filter{case (c, t) => CourseData.core1.contains(c) && t.isTuTh}
// res17: Map[Course, Timing] = HashMap(
//   Course(name = "Probability Models", code = "MA 261", instructor = "Sanchayan Sen") -> TuTh(times = "3:30 - 5: 00"),
//   Course(name = "Linear Algebra", code = "MA 219", instructor = "Apoorva Khare") -> TuTh(times = "10:00 - 11:30")
// )
chosen.sch.filter{case (c, t) => CourseData.core2.contains(c) && t.isTuTh}
// res18: Map[Course, Timing] = HashMap(
//   Course(name = "Introduction to Algebraic Topology", code = "MA 232", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00")
// )