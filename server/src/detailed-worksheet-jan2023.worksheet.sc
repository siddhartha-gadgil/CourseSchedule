
import courses._
import BestChoice._

best 
// res0: Set[Schedule] = HashSet(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Algebra II", code = "MA 213", instructor = "Radhika Ganapathy") -> MWF(times = "8:00 - 9:00"),
//       Course(name = "Introduction to Stochastic Processes", code = "MA 262", instructor = "Srikanth Iyer") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Introduction to the Calculus of Variations", code = "MA 374", instructor = "Swarnendu Sil") -> TuTh(
//         times = "2:00 - 3:30"
//       ),
//       Course(
//         name = "Topics in function theoretic operator Theory",
//         code = "MA 348",
//         instructor = "Tirthankar Bhattacharyya"
//       ) -> MWF(times = "10:00 - 11:00"),
//       Course(
//         name = "Topics in Probability and Stochastic Processes",
//         code = "MA 368",
//         instructor = "Manjunath Krishnapur"
//       ) -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Elliptic Curves", code = "MA 353", instructor = "Shaunak Deo") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Introduction to Dynamical Systems Theory", code = "MA 278", instructor = "Janaki Balakrishnan") -> TuTh(
//         times = "11:30 - 1:00"
//       ),
//       Course(name = "Algebraic Geometry", code = "MA 308", instructor = "Abhishek Banerjee") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Combinatorics", code = "MA 318", instructor = "Arvind Ayyer") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Topics in Analytic Number Theory", code = "MA 350", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Introduction to Modular Forms", code = "MA 215", instructor = "Mahesh Kakde") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Introduction to Differentiable Manifolds", code = "MA 235", instructor = "Subhojoy Gupta") -> TuTh(
//         times = "3:30 - 5: 00"
//       ),
//       Course(name = "Ordinary Differential Equations", code = "MA 241", instructor = "Arka Mallick") -> MWF(times = "3:00 - 4:00"),
//       Course(name = "Measure & Integration", code = "MA 222", instructor = "Gautam Bharali") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Proofs and Programs", code = "MA 208", instructor = "Siddhartha Gadgil") -> MWF(times = "9:00 - 10:00"),
//       Course(name = "Complex Analysis", code = "MA 224", instructor = "Bharathwaj Palvannan") -> MWF(times = "10:00 - 11:00")
//     )
//   ),
//   Schedule(
//     sch = HashMap(
//       Course(name = "Algebra II", code = "MA 213", instructor = "Radhika Ganapathy") -> MWF(times = "8:00 - 9:00"),
//       Course(name = "Introduction to Stochastic Processes", code = "MA 262", instructor = "Srikanth Iyer") -> TuTh(times...
best.size
// res1: Int = 6

bestSW
// res2: Set[Schedule] = HashSet(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Algebra II", code = "MA 213", instructor = "Radhika Ganapathy") -> MWF(times = "8:00 - 9:00"),
//       Course(name = "Introduction to Stochastic Processes", code = "MA 262", instructor = "Srikanth Iyer") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Introduction to the Calculus of Variations", code = "MA 374", instructor = "Swarnendu Sil") -> TuTh(
//         times = "2:00 - 3:30"
//       ),
//       Course(
//         name = "Topics in function theoretic operator Theory",
//         code = "MA 348",
//         instructor = "Tirthankar Bhattacharyya"
//       ) -> MWF(times = "10:00 - 11:00"),
//       Course(
//         name = "Topics in Probability and Stochastic Processes",
//         code = "MA 368",
//         instructor = "Manjunath Krishnapur"
//       ) -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Elliptic Curves", code = "MA 353", instructor = "Shaunak Deo") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Introduction to Dynamical Systems Theory", code = "MA 278", instructor = "Janaki Balakrishnan") -> TuTh(
//         times = "11:30 - 1:00"
//       ),
//       Course(name = "Algebraic Geometry", code = "MA 308", instructor = "Abhishek Banerjee") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Combinatorics", code = "MA 318", instructor = "Arvind Ayyer") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Topics in Analytic Number Theory", code = "MA 350", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Introduction to Modular Forms", code = "MA 215", instructor = "Mahesh Kakde") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Introduction to Differentiable Manifolds", code = "MA 235", instructor = "Subhojoy Gupta") -> TuTh(
//         times = "3:30 - 5: 00"
//       ),
//       Course(name = "Ordinary Differential Equations", code = "MA 241", instructor = "Arka Mallick") -> MWF(times = "3:00 - 4:00"),
//       Course(name = "Measure & Integration", code = "MA 222", instructor = "Gautam Bharali") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Proofs and Programs", code = "MA 208", instructor = "Siddhartha Gadgil") -> MWF(times = "9:00 - 10:00"),
//       Course(name = "Complex Analysis", code = "MA 224", instructor = "Bharathwaj Palvannan") -> MWF(times = "10:00 - 11:00")
//     )
//   ),
//   Schedule(
//     sch = HashMap(
//       Course(name = "Algebra II", code = "MA 213", instructor = "Radhika Ganapathy") -> MWF(times = "8:00 - 9:00"),
//       Course(name = "Introduction to Stochastic Processes", code = "MA 262", instructor = "Srikanth Iyer") -> TuTh(times...
bestSW.size
// res3: Int = 2
bestSW.map(_.clashes.size)
// res4: Set[Int] = HashSet(13, 11)
val commonClashes = bestSW.map(_.clashes).reduce(_ intersect _)
// commonClashes: Set[(Course, Course)] = HashSet(
//   (
//     Course(name = "Combinatorics", code = "MA 318", instructor = "Arvind Ayyer"),
//     Course(
//       name = "Topics in Probability and Stochastic Processes",
//       code = "MA 368",
//       instructor = "Manjunath Krishnapur"
//     )
//   ),
//   (
//     Course(name = "Complex Analysis", code = "MA 224", instructor = "Bharathwaj Palvannan"),
//     Course(
//       name = "Topics in function theoretic operator Theory",
//       code = "MA 348",
//       instructor = "Tirthankar Bhattacharyya"
//     )
//   ),
//   (
//     Course(name = "Introduction to Stochastic Processes", code = "MA 262", instructor = "Srikanth Iyer"),
//     Course(name = "Topics in Analytic Number Theory", code = "MA 350", instructor = "Soumya Das")
//   ),
//   (
//     Course(name = "Elliptic Curves", code = "MA 353", instructor = "Shaunak Deo"),
//     Course(
//       name = "Topics in Probability and Stochastic Processes",
//       code = "MA 368",
//       instructor = "Manjunath Krishnapur"
//     )
//   ),
//   (
//     Course(
//       name = "Topics in Probability and Stochastic Processes",
//       code = "MA 368",
//       instructor = "Manjunath Krishnapur"
//     ),
//     Course(name = "Introduction to the Calculus of Variations", code = "MA 374", instructor = "Swarnendu Sil")
//   ),
//   (
//     Course(name = "Elliptic Curves", code = "MA 353", instructor = "Shaunak Deo"),
//     Course(name = "Introduction to the Calculus of Variations", code = "MA 374", instructor = "Swarnendu Sil")
//   ),
//   (
//     Course(name = "Combinatorics", code = "MA 318", instructor = "Arvind Ayyer"),
//     Course(name = "Introduction to the Calculus of Variations", code = "MA 374", instructor = "Swarnendu Sil")
//   ),
//   (
//     Course(name = "Introduction to Dynamical Systems Theory", code = "MA 278", instructor = "Janaki Balakrishnan"),
//     Course(name = "Topics in Analytic Number Theory", code = "MA 350", instructor = "Soumya Das")
//   ),
// ...
commonClashes.size
// res5: Int = 10
val minClashSize = bestSW.map(_.clashes.size).min
// minClashSize: Int = 11
val minClashes = bestSW.filter(_.clashes.size == minClashSize).toVector
// minClashes: Vector[Schedule] = Vector(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Algebra II", code = "MA 213", instructor = "Radhika Ganapathy") -> MWF(times = "8:00 - 9:00"),
//       Course(name = "Introduction to Stochastic Processes", code = "MA 262", instructor = "Srikanth Iyer") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Introduction to the Calculus of Variations", code = "MA 374", instructor = "Swarnendu Sil") -> TuTh(
//         times = "2:00 - 3:30"
//       ),
//       Course(
//         name = "Topics in function theoretic operator Theory",
//         code = "MA 348",
//         instructor = "Tirthankar Bhattacharyya"
//       ) -> MWF(times = "10:00 - 11:00"),
//       Course(
//         name = "Topics in Probability and Stochastic Processes",
//         code = "MA 368",
//         instructor = "Manjunath Krishnapur"
//       ) -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Elliptic Curves", code = "MA 353", instructor = "Shaunak Deo") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Introduction to Dynamical Systems Theory", code = "MA 278", instructor = "Janaki Balakrishnan") -> TuTh(
//         times = "11:30 - 1:00"
//       ),
//       Course(name = "Algebraic Geometry", code = "MA 308", instructor = "Abhishek Banerjee") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Combinatorics", code = "MA 318", instructor = "Arvind Ayyer") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Topics in Analytic Number Theory", code = "MA 350", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Introduction to Modular Forms", code = "MA 215", instructor = "Mahesh Kakde") -> TuTh(times = "8:30 - 10:00"),
//       Course(name = "Introduction to Differentiable Manifolds", code = "MA 235", instructor = "Subhojoy Gupta") -> TuTh(
//         times = "3:30 - 5: 00"
//       ),
//       Course(name = "Ordinary Differential Equations", code = "MA 241", instructor = "Arka Mallick") -> MWF(times = "3:00 - 4:00"),
//       Course(name = "Measure & Integration", code = "MA 222", instructor = "Gautam Bharali") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Proofs and Programs", code = "MA 208", instructor = "Siddhartha Gadgil") -> MWF(times = "9:00 - 10:00"),
//       Course(name = "Complex Analysis", code = "MA 224", instructor = "Bharathwaj Palvannan") -> MWF(times = "10:00 - 11:00")
//     )
//   )
// )
minClashes.size
// res6: Int = 1
// minClashes(0).diff(minClashes(1))
val chosen = minClashes(0)
// chosen: Schedule = Schedule(
//   sch = HashMap(
//     Course(name = "Algebra II", code = "MA 213", instructor = "Radhika Ganapathy") -> MWF(times = "8:00 - 9:00"),
//     Course(name = "Introduction to Stochastic Processes", code = "MA 262", instructor = "Srikanth Iyer") -> TuTh(times = "11:30 - 1:00"),
//     Course(name = "Introduction to the Calculus of Variations", code = "MA 374", instructor = "Swarnendu Sil") -> TuTh(
//       times = "2:00 - 3:30"
//     ),
//     Course(
//       name = "Topics in function theoretic operator Theory",
//       code = "MA 348",
//       instructor = "Tirthankar Bhattacharyya"
//     ) -> MWF(times = "10:00 - 11:00"),
//     Course(
//       name = "Topics in Probability and Stochastic Processes",
//       code = "MA 368",
//       instructor = "Manjunath Krishnapur"
//     ) -> TuTh(times = "2:00 - 3:30"),
//     Course(name = "Elliptic Curves", code = "MA 353", instructor = "Shaunak Deo") -> TuTh(times = "2:00 - 3:30"),
//     Course(name = "Introduction to Dynamical Systems Theory", code = "MA 278", instructor = "Janaki Balakrishnan") -> TuTh(
//       times = "11:30 - 1:00"
//     ),
//     Course(name = "Algebraic Geometry", code = "MA 308", instructor = "Abhishek Banerjee") -> TuTh(times = "3:30 - 5: 00"),
//     Course(name = "Combinatorics", code = "MA 318", instructor = "Arvind Ayyer") -> TuTh(times = "2:00 - 3:30"),
//     Course(name = "Topics in Analytic Number Theory", code = "MA 350", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//     Course(name = "Introduction to Modular Forms", code = "MA 215", instructor = "Mahesh Kakde") -> TuTh(times = "8:30 - 10:00"),
//     Course(name = "Introduction to Differentiable Manifolds", code = "MA 235", instructor = "Subhojoy Gupta") -> TuTh(
//       times = "3:30 - 5: 00"
//     ),
//     Course(name = "Ordinary Differential Equations", code = "MA 241", instructor = "Arka Mallick") -> MWF(times = "3:00 - 4:00"),
//     Course(name = "Measure & Integration", code = "MA 222", instructor = "Gautam Bharali") -> MWF(times = "11:00 - 12:00"),
//     Course(name = "Proofs and Programs", code = "MA 208", instructor = "Siddhartha Gadgil") -> MWF(times = "9:00 - 10:00"),
//     Course(name = "Complex Analysis", code = "MA 224", instructor = "Bharathwaj Palvannan") -> MWF(times = "10:00 - 11:00")
//   )
// )
chosen.sch.size
// res7: Int = 16

chosen.tsv
// res8: String = """MA 208	Proofs and Programs	Siddhartha Gadgil	Mon, Wed, Fri	9:00 - 10:00
// MA 213	Algebra II	Radhika Ganapathy	Mon, Wed, Fri	8:00 - 9:00
// MA 215	Introduction to Modular Forms	Mahesh Kakde	Tue, Thu	8:30 - 10:00
// MA 222	Measure & Integration	Gautam Bharali	Mon, Wed, Fri	11:00 - 12:00
// MA 224	Complex Analysis	Bharathwaj Palvannan	Mon, Wed, Fri	10:00 - 11:00
// MA 235	Introduction to Differentiable Manifolds	Subhojoy Gupta	Tue, Thu	3:30 - 5: 00
// MA 241	Ordinary Differential Equations	Arka Mallick	Mon, Wed, Fri	3:00 - 4:00
// MA 262	Introduction to Stochastic Processes	Srikanth Iyer	Tue, Thu	11:30 - 1:00
// MA 278	Introduction to Dynamical Systems Theory	Janaki Balakrishnan	Tue, Thu	11:30 - 1:00
// MA 308	Algebraic Geometry	Abhishek Banerjee	Tue, Thu	3:30 - 5: 00
// MA 318	Combinatorics	Arvind Ayyer	Tue, Thu	2:00 - 3:30
// MA 348	Topics in function theoretic operator Theory	Tirthankar Bhattacharyya	Mon, Wed, Fri	10:00 - 11:00
// MA 350	Topics in Analytic Number Theory	Soumya Das	Tue, Thu	11:30 - 1:00
// MA 353	Elliptic Curves	Shaunak Deo	Tue, Thu	2:00 - 3:30
// MA 368	Topics in Probability and Stochastic Processes	Manjunath Krishnapur	Tue, Thu	2:00 - 3:30
// MA 374	Introduction to the Calculus of Variations	Swarnendu Sil	Tue, Thu	2:00 - 3:30
// """
chosen.clashes.mkString("\n")
// res9: String = """(Course(Combinatorics,MA 318,Arvind Ayyer),Course(Topics in Probability and Stochastic Processes,MA 368,Manjunath Krishnapur))
// (Course(Complex Analysis,MA 224,Bharathwaj Palvannan),Course(Topics in function theoretic operator Theory,MA 348,Tirthankar Bhattacharyya))
// (Course(Elliptic Curves,MA 353,Shaunak Deo),Course(Topics in Probability and Stochastic Processes,MA 368,Manjunath Krishnapur))
// (Course(Topics in Probability and Stochastic Processes,MA 368,Manjunath Krishnapur),Course(Introduction to the Calculus of Variations,MA 374,Swarnendu Sil))
// (Course(Elliptic Curves,MA 353,Shaunak Deo),Course(Introduction to the Calculus of Variations,MA 374,Swarnendu Sil))
// (Course(Combinatorics,MA 318,Arvind Ayyer),Course(Introduction to the Calculus of Variations,MA 374,Swarnendu Sil))
// (Course(Introduction to Dynamical Systems Theory,MA 278,Janaki Balakrishnan),Course(Topics in Analytic Number Theory,MA 350,Soumya Das))
// (Course(Combinatorics,MA 318,Arvind Ayyer),Course(Elliptic Curves,MA 353,Shaunak Deo))
// (Course(Introduction to Stochastic Processes,MA 262,Srikanth Iyer),Course(Introduction to Dynamical Systems Theory,MA 278,Janaki Balakrishnan))
// (Course(Introduction to Stochastic Processes,MA 262,Srikanth Iyer),Course(Topics in Analytic Number Theory,MA 350,Soumya Das))
// (Course(Introduction to Differentiable Manifolds,MA 235,Subhojoy Gupta),Course(Algebraic Geometry,MA 308,Abhishek Banerjee))"""
StudentChoices
  .strongClashes(chosen)
  .toVector
  .map {
    case (c, v) => (c._1.name, c._2.name) -> v.map(_.name).mkString(", ")
  }
  .filter(_._2.nonEmpty)
// res10: Vector[((String, String), String)] = Vector(
//   (("Combinatorics", "Introduction to the Calculus of Variations"), "Prayas Rautray "),
//   (("Introduction to Stochastic Processes", "Introduction to Dynamical Systems Theory"), "Sundararajan Srinivasan")
// )
StudentChoices
  .weakClashes(chosen)
  .toVector
  .map {
    case (c, v) => (c._1.name, c._2.name) -> v.map(_.name).mkString(", ")
  }
  .filter(_._2.nonEmpty)
// res11: Vector[((String, String), String)] = Vector(
//   (("Combinatorics", "Topics in Probability and Stochastic Processes"), "Shreepranav Varma Enugandla, Dhanus M Lal "),
//   (("Elliptic Curves", "Topics in Probability and Stochastic Processes"), "Shreepranav Varma Enugandla"),
//   (("Topics in Probability and Stochastic Processes", "Introduction to the Calculus of Variations"), "Sai Niranjan "),
//   (("Elliptic Curves", "Introduction to the Calculus of Variations"), "Souptik Mudi, Pratik Jadhav, Raghuram"),
//   (("Combinatorics", "Introduction to the Calculus of Variations"), "Prayas Rautray , Raghuram"),
//   (("Introduction to Dynamical Systems Theory", "Topics in Analytic Number Theory"), "Souptik Mudi, Sai Sanjeev"),
//   (
//     ("Combinatorics", "Elliptic Curves"),
//     "Shreepranav Varma Enugandla, Sai Sanjeev, irishd@iisc.ac.in, Sudharshan K V, Raghuram"
//   ),
//   (
//     ("Introduction to Stochastic Processes", "Introduction to Dynamical Systems Theory"),
//     "Umang Bhat , Sai Niranjan , Vedant Sharma , Karthik Dulam, Sundararajan Srinivasan, Dhruv Meduri, Prathik, M Nikhesh Kumar "
//   )
// )
chosen.sorted.groupMap(_._2)(_._1)
// res12: Map[Timing, Vector[Course]] = HashMap(
//   TuTh(times = "11:30 - 1:00") -> Vector(
//     Course(name = "Introduction to Stochastic Processes", code = "MA 262", instructor = "Srikanth Iyer"),
//     Course(name = "Introduction to Dynamical Systems Theory", code = "MA 278", instructor = "Janaki Balakrishnan"),
//     Course(name = "Topics in Analytic Number Theory", code = "MA 350", instructor = "Soumya Das")
//   ),
//   MWF(times = "11:00 - 12:00") -> Vector(Course(name = "Measure & Integration", code = "MA 222", instructor = "Gautam Bharali")),
//   TuTh(times = "2:00 - 3:30") -> Vector(
//     Course(name = "Combinatorics", code = "MA 318", instructor = "Arvind Ayyer"),
//     Course(name = "Elliptic Curves", code = "MA 353", instructor = "Shaunak Deo"),
//     Course(
//       name = "Topics in Probability and Stochastic Processes",
//       code = "MA 368",
//       instructor = "Manjunath Krishnapur"
//     ),
//     Course(name = "Introduction to the Calculus of Variations", code = "MA 374", instructor = "Swarnendu Sil")
//   ),
//   TuTh(times = "8:30 - 10:00") -> Vector(
//     Course(name = "Introduction to Modular Forms", code = "MA 215", instructor = "Mahesh Kakde")
//   ),
//   MWF(times = "10:00 - 11:00") -> Vector(
//     Course(name = "Complex Analysis", code = "MA 224", instructor = "Bharathwaj Palvannan"),
//     Course(
//       name = "Topics in function theoretic operator Theory",
//       code = "MA 348",
//       instructor = "Tirthankar Bhattacharyya"
//     )
//   ),
//   MWF(times = "3:00 - 4:00") -> Vector(
//     Course(name = "Ordinary Differential Equations", code = "MA 241", instructor = "Arka Mallick")
//   ),
//   TuTh(times = "3:30 - 5: 00") -> Vector(
//     Course(name = "Introduction to Differentiable Manifolds", code = "MA 235", instructor = "Subhojoy Gupta"),
//     Course(name = "Algebraic Geometry", code = "MA 308", instructor = "Abhishek Banerjee")
//   ),
//   MWF(times = "8:00 - 9:00") -> Vector(Course(name = "Algebra II", code = "MA 213", instructor = "Radhika Ganapathy")),
//   MWF(times = "9:00 - 10:00") -> Vector(Course(name = "Proofs and Programs", code = "MA 208", instructor = "Siddhartha Gadgil"))
// )
os.write.over(SavedData.dat / "schedule.tsv", chosen.tsv)